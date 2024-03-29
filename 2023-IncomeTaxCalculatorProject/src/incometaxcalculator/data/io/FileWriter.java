package incometaxcalculator.data.io;

import incometaxcalculator.data.management.Receipt;

//MAKE FileWriter INTERFACE
public interface  FileWriter{

  public int getReceiptId(Receipt receipt);
  public String getReceiptIssueDate(Receipt receipt);
  public String getReceiptKind(Receipt receipt);
  public float getReceiptAmount(Receipt receipt);
  public String getCompanyName(Receipt receipt);
  public String getCompanyCountry(Receipt receipt);
  public String getCompanyCity(Receipt receipt);
  public String getCompanyStreet(Receipt receipt);
  public int getCompanyNumber(Receipt receipt);
  
  //REMOVE THE DELEGATING METHODS AND PUSH DOWN SOME METHODS
  //public abstract void generateFile(int taxRegistrationNumber) throws IOException;

  /*
  public Taxpayer getTaxpayer(int taxRegistrationNumber) {
    
    return manager.getTaxpayer(taxRegistrationNumber);
  }

  public String getTaxpayerName(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerName(taxRegistrationNumber);
  }

  public String getTaxpayerIncome(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerIncome(taxRegistrationNumber);
  }

  public String getTaxpayerStatus(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerStatus(taxRegistrationNumber);
  }

  public double getTaxpayerVariationTaxOnReceipts(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber);
  }

  public int getTaxpayerTotalReceiptsGathered(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber);
  }

  public float getTaxpayerAmountOfReceiptKind(int taxRegistrationNumber, short kind) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, kind);
  }

  public double getTaxpayerTotalTax(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerTotalTax(taxRegistrationNumber);
  }

  public double getTaxpayerBasicTax(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getTaxpayerBasicTax(taxRegistrationNumber);
  }

  public HashMap<Integer, Receipt> getReceiptHashMap(int taxRegistrationNumber) {
    TaxpayerManager manager = new TaxpayerManager();
    return manager.getReceiptHashMap(taxRegistrationNumber);
  }

  public int getReceiptId(Receipt receipt) {
    return receipt.getId();
  }

  public String getReceiptIssueDate(Receipt receipt) {
    return receipt.getIssueDate();
  }

  public String getReceiptKind(Receipt receipt) {
    return receipt.getKind();
  }

  public float getReceiptAmount(Receipt receipt) {
    return receipt.getAmount();
  }

  public String getCompanyName(Receipt receipt) {
    return receipt.getCompany().getName();
  }

  public String getCompanyCountry(Receipt receipt) {
    return receipt.getCompany().getCountry();
  }

  public String getCompanyCity(Receipt receipt) {
    return receipt.getCompany().getCity();
  }

  public String getCompanyStreet(Receipt receipt) {
    return receipt.getCompany().getStreet();
  }

  public int getCompanyNumber(Receipt receipt) {
    return receipt.getCompany().getNumber();
  }
*/
}