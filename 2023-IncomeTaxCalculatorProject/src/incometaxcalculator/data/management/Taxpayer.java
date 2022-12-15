package incometaxcalculator.data.management;

import java.util.HashMap;

import incometaxcalculator.exceptions.WrongReceiptKindException;

public abstract class Taxpayer {

  protected final String fullname;
  protected final int taxRegistrationNumber;
  protected final float income;
  private float amountPerReceiptsKind[] = new float[5];
  private int totalReceiptsGathered = 0;
  private HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);
  protected int status;
  private double[][] constants = {
    {24680,0.0535,81080,1320.38,0.0705,24680,90000,5296.58,0.0785,81080,152540,5996.80,0.0785,90000,10906.19,0.0985,152540},
    {36080,0.0535,90000,1930.28,0.0705,36080,143350,5731.64,0.0705,90000,254240,9492.82,0.0785,143350,18197.69,0.0985,254240},
    {18040,0.0535,71680,965.14,0.0705,18040,90000,4746.76,0.0785,71680,127120,6184.88,0.0785,90000,9098.80,0.0985,127120},
    {30390,0.0535,90000,1625.87,0.0705,30390,122110,5828.38,0.0705,90000,203390,8092.13,0.0785,122110,14472.61,0.0985,203390}
  };
  //public abstract double calculateBasicTax();

  protected Taxpayer(String fullname, int taxRegistrationNumber, float income) {
    this.fullname = fullname;
    this.taxRegistrationNumber = taxRegistrationNumber;
    this.income = income;
  }

  public double calculateBasicTax()
  {
    if (income < constants[status][0]) {
      return constants[status][1] * income;
    } else if (income < constants[status][2]) {
      return constants[status][3] + constants[status][4] * (income - constants[status][5]);
    } else if (income < constants[status][6]) {
      return constants[status][7] + constants[status][8] * (income - constants[status][9]);
    } else if (income < constants[status][10]) {
      return constants[status][11] + constants[status][12] * (income - constants[status][13]);
    } else {
      return constants[status][14] + constants[status][15] * (income - constants[status][16]);
    }
  }
  
  public void addReceipt(Receipt receipt) throws WrongReceiptKindException {
    /* SIMPLIFY THIS METHOD
    if (receipt.getKind().equals("Entertainment")) {
      amountPerReceiptsKind[ENTERTAINMENT] += receipt.getAmount();
    } else if (receipt.getKind().equals("Basic")) {
      amountPerReceiptsKind[BASIC] += receipt.getAmount();
    } else if (receipt.getKind().equals("Travel")) {
      amountPerReceiptsKind[TRAVEL] += receipt.getAmount();
    } else if (receipt.getKind().equals("Health")) {
      amountPerReceiptsKind[HEALTH] += receipt.getAmount();
    } else if (receipt.getKind().equals("Other")) {
      amountPerReceiptsKind[OTHER] += receipt.getAmount();
    } else {
      throw new WrongReceiptKindException();
    }
    */
    String[] receiptKind = {"Entertainment","Basic","Travel","Health","Other"};
    int flag = 0;
    for(int i=0;i<receiptKind.length;i++)
    {
      if (receipt.getKind().equals(receiptKind[i]))
      {
        amountPerReceiptsKind[i] += receipt.getAmount();
        flag=1;
      }
    }
    if(flag==0)
    {
      throw new WrongReceiptKindException();
    }
    receiptHashMap.put(receipt.getId(), receipt);
    totalReceiptsGathered++;
  }

  public void removeReceipt(int receiptId) throws WrongReceiptKindException {
    Receipt receipt = receiptHashMap.get(receiptId);
    /* SIMPLIFY THIS METHOD
    if (receipt.getKind().equals("Entertainment")) {
      amountPerReceiptsKind[ENTERTAINMENT] -= receipt.getAmount();
    } else if (receipt.getKind().equals("Basic")) {
      amountPerReceiptsKind[BASIC] -= receipt.getAmount();
    } else if (receipt.getKind().equals("Travel")) {
      amountPerReceiptsKind[TRAVEL] -= receipt.getAmount();
    } else if (receipt.getKind().equals("Health")) {
      amountPerReceiptsKind[HEALTH] -= receipt.getAmount();
    } else if (receipt.getKind().equals("Other")) {
      amountPerReceiptsKind[OTHER] -= receipt.getAmount();
    } else {
      throw new WrongReceiptKindException();
    }
    */
    String[] receiptKind = {"Entertainment","Basic","Travel","Health","Other"};
    int flag = 0;
    for(int i=0;i<receiptKind.length;i++)
    {
      if (receipt.getKind().equals(receiptKind[i]))
      {
        amountPerReceiptsKind[i] -= receipt.getAmount();
        flag=1;
      }
    }
    if(flag==0)
    {
      throw new WrongReceiptKindException();
    }
    totalReceiptsGathered--;
    receiptHashMap.remove(receiptId);
  }

  public String getFullname() {
    return fullname;
  }

  public int getTaxRegistrationNumber() {
    return taxRegistrationNumber;
  }

  public float getIncome() {
    return income;
  }

  public HashMap<Integer, Receipt> getReceiptHashMap() {
    return receiptHashMap;
  }

  public double getVariationTaxOnReceipts() {
    float totalAmountOfReceipts = getTotalAmountOfReceipts();
    /* SIMPLIFY THIS METHOD
    if (totalAmountOfReceipts < 0.2 * income) {
      return calculateBasicTax() * 0.08;
    } else if (totalAmountOfReceipts < 0.4 * income) {
      return calculateBasicTax() * 0.04;
    } else if (totalAmountOfReceipts < 0.6 * income) {
      return -calculateBasicTax() * 0.15;
    } else {
      return -calculateBasicTax() * 0.3;
    }
    */
    double[] percentages = {0.2,0.4,0.6};
    double[] tax = {0.08,0.04,-0.15};
    for(int i=0;i<percentages.length;i++)
    {
      if (totalAmountOfReceipts < percentages[i] * income)
      {
        return calculateBasicTax() * tax[i];
      }
    }
    return -calculateBasicTax() * 0.3;
  }

  private float getTotalAmountOfReceipts() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += amountPerReceiptsKind[i];
    }
    return sum;
  }

  public int getTotalReceiptsGathered() {
    return totalReceiptsGathered;
  }

  public float getAmountOfReceiptKind(short kind) {
    return amountPerReceiptsKind[kind];
  }

  public double getTotalTax() {
    return calculateBasicTax() + getVariationTaxOnReceipts();
  }

  public double getBasicTax() {
    return calculateBasicTax();
  }

}