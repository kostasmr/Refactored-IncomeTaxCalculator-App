package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

//ADD A SUPER CLASS FOR 3RD DUPLICATE CODE
public abstract class InfoWriter{
 
  protected String type;
  
  public void generateFile(int taxRegistrationNumber) throws IOException {

    String[] fileInfo =fileInfo(type);
    String infoType = infoType(type);
    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + infoType));
    outputStream.println(fileInfo[0] + manager.getTaxpayerName(taxRegistrationNumber)+fileInfo[5]);
    outputStream.println(fileInfo[1] + taxRegistrationNumber+fileInfo[6]);
    outputStream.println(fileInfo[2] + manager.getTaxpayerStatus(taxRegistrationNumber)+fileInfo[7]);
    outputStream.println(fileInfo[3] + manager.getTaxpayerIncome(taxRegistrationNumber)+fileInfo[8]);
    outputStream.println();// den mas emfanize to \n se aplo notepad
    outputStream.println(fileInfo[4]);
    outputStream.println();
    generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
    outputStream.close();
  }

  public void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {
    
    String[] taxpayerReceiptsInfo = taxpayerReceiptsInfo(type);
    TaxpayerManager manager = new TaxpayerManager();
    HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
    Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      HashMap.Entry<Integer, Receipt> entry = iterator.next();
      Receipt receipt = entry.getValue();
      outputStream.println(taxpayerReceiptsInfo[0] + receipt.getReceiptId(receipt)+taxpayerReceiptsInfo[9]);
      outputStream.println(taxpayerReceiptsInfo[1] + receipt.getReceiptIssueDate(receipt)+taxpayerReceiptsInfo[10]);
      outputStream.println(taxpayerReceiptsInfo[2] + receipt.getReceiptKind(receipt)+taxpayerReceiptsInfo[11]);
      outputStream.println(taxpayerReceiptsInfo[3] + receipt.getReceiptAmount(receipt)+taxpayerReceiptsInfo[12]);
      outputStream.println(taxpayerReceiptsInfo[4] + receipt.getCompanyName(receipt)+taxpayerReceiptsInfo[13]);
      outputStream.println(taxpayerReceiptsInfo[5] + receipt.getCompanyCountry(receipt)+taxpayerReceiptsInfo[14]);
      outputStream.println(taxpayerReceiptsInfo[6] + receipt.getCompanyCity(receipt)+taxpayerReceiptsInfo[15]);
      outputStream.println(taxpayerReceiptsInfo[7] + receipt.getCompanyStreet(receipt)+taxpayerReceiptsInfo[16]);
      outputStream.println(taxpayerReceiptsInfo[8] + receipt.getCompanyNumber(receipt)+taxpayerReceiptsInfo[17]);
      outputStream.println();
    }
  }
  
  public String infoType(String type) {
    String[] infoType = {"_INFO.txt","_INFO.xml"};
    if(type.equals("txt"))
    {
      return infoType[0];
    }
    else
    {
      return infoType[1];
    }
  }
  
  public String[] fileInfo(String type) {
    String[] txtFileInfo = {"Name: ","AFM: ","Status: ","Income: ","Receipts:","","","",""};
    String[] xmlFileInfo = {"<Name> ","<AFM> ","<Status> ","<Income> ","<Receipts>"," </Name>"," </AFM>"," </Status>"," </Income>"};
    if(type.equals("txt"))
    {
      return txtFileInfo;
    }
    else
    {
      return xmlFileInfo;
    }
  }
  
  public String[] taxpayerReceiptsInfo(String type) {
    String[] txtTaxpayerReceiptsInfo = {"Receipt ID: ","Date: ","Kind: ","Amount: ","Company: ","Country: ","City: ","Street: ","Number: ",
        "","","","","","","","",""};
    String[] xmlTaxpayerReceiptsInfo = {"<ReceiptID> ","<Date> ","<Kind> ","<Amount> ","<Company> ","<Country> ","<City> ","<Street> ","<Number> ",
        " </ReceiptID>"," </Date>"," </Kind>"," </Amount>"," </Company>"," </Country>"," </City>"," </Street>"," </Number>"};
    if(type.equals("txt"))
    {
      return txtTaxpayerReceiptsInfo;
    }
    else
    {
      return xmlTaxpayerReceiptsInfo;
    }
  }
}
