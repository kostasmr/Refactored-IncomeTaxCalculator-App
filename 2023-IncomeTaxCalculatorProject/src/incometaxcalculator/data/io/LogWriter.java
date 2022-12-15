package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.data.management.TaxpayerManager;

//ADD A SUPER CLASS FOR 4TH DUPLICATE CODE
public abstract class LogWriter {
  
  protected String type;
  
  private static final short ENTERTAINMENT = 0;
  private static final short BASIC = 1;
  private static final short TRAVEL = 2;
  private static final short HEALTH = 3;
  private static final short OTHER = 4;
  
  public void generateFile(int taxRegistrationNumber) throws IOException {
    
    String logType = logType(type);
    String[] fileInfo = fileInfo(type);
    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + logType));
    outputStream.println(fileInfo[0] + manager.getTaxpayerName(taxRegistrationNumber) + fileInfo[13]);
    outputStream.println(fileInfo[1] + taxRegistrationNumber + fileInfo[14]);
    outputStream.println(fileInfo[2] + manager.getTaxpayerIncome(taxRegistrationNumber) + fileInfo[15]);
    outputStream
        .println(fileInfo[3] + manager.getTaxpayerBasicTax(taxRegistrationNumber) + fileInfo[16]);
    if (manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0) {
      outputStream.println(fileInfo[4]
          + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + fileInfo[17]);
    } else {
      outputStream.println(fileInfo[5]
          + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + fileInfo[18]);
    }
    outputStream
        .println(fileInfo[6] + manager.getTaxpayerTotalTax(taxRegistrationNumber) + fileInfo[19]);
    outputStream.println(
        fileInfo[7] + manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber) + fileInfo[20]);
    outputStream.println(
        fileInfo[8] + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT)
            + fileInfo[21]);
    outputStream.println(
        fileInfo[9] + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC) + fileInfo[22]);
    outputStream.println(
        fileInfo[10] + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL) + fileInfo[23]);
    outputStream.println(
        fileInfo[11] + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH) + fileInfo[24]);
    outputStream.println(
        fileInfo[12] + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER) + fileInfo[25]);
    outputStream.close();
  }
  
  public String logType(String type) {
    String[] logType = {"_LOG.txt","_LOG.xml"};
    if(type.equals("txt"))
    {
      return logType[0];
    }
    else
    {
      return logType[1];
    }
  }
  
  public String[] fileInfo(String type) {
    String[] txtFileInfo = {"Name: ","AFM: ","Income: ","Basic Tax: ","Tax Increase: ","Tax Decrease: ","Total Tax: ","TotalReceiptsGathered: ","Entertainment: ",
        "Basic: ","Travel: ","Health: ","Other: ","","","","","","","","","","","","",""};
    String[] xmlFileInfo = {"<Name> ","<AFM> ","<Income> ","<BasicTax> ","<TaxIncrease> ","<TaxDecrease> ","<TotalTax> ","<Receipts> ",
        "<Entertainment> ","<Basic> ","<Travel> ","<Health> ","<Other> ",
        " </Name>"," </AFM>"," </Income>"," </BasicTax>"," </TaxIncrease>"," </TaxDecrease>"," </TotalTax>"," </Receipts>",
        " </Entertainment>"," </Basic>"," </Travel>"," </Health>"," </Other>"};
    if(type.equals("txt"))
    {
      return txtFileInfo;
    }
    else
    {
      return xmlFileInfo;
    }
  }
}
