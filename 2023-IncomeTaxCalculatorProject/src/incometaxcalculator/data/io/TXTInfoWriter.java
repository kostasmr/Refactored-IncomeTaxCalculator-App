package incometaxcalculator.data.io;

public class TXTInfoWriter extends InfoWriter{
  
  public TXTInfoWriter() {
    super.type = "txt";
  }
  /* 3RD DUPLICATE CODE
  public void generateFile(int taxRegistrationNumber) throws IOException {

    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + "_INFO.txt"));
    outputStream.println("Name: " + manager.getTaxpayerName(taxRegistrationNumber));
    outputStream.println("AFM: " + taxRegistrationNumber);
    outputStream.println("Status: " + manager.getTaxpayerStatus(taxRegistrationNumber));
    outputStream.println("Income: " + manager.getTaxpayerIncome(taxRegistrationNumber));
    outputStream.println();// den mas emfanize to \n se aplo notepad
    outputStream.println("Receipts:");
    outputStream.println();
    generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
    outputStream.close();
  }

  private void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {
    
    TaxpayerManager manager = new TaxpayerManager();
    HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
    Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      HashMap.Entry<Integer, Receipt> entry = iterator.next();
      Receipt receipt = entry.getValue();
      outputStream.println("Receipt ID: " + receipt.getReceiptId(receipt));
      outputStream.println("Date: " + receipt.getReceiptIssueDate(receipt));
      outputStream.println("Kind: " + receipt.getReceiptKind(receipt));
      outputStream.println("Amount: " + receipt.getReceiptAmount(receipt));
      outputStream.println("Company: " + receipt.getCompanyName(receipt));
      outputStream.println("Country: " + receipt.getCompanyCountry(receipt));
      outputStream.println("City: " + receipt.getCompanyCity(receipt));
      outputStream.println("Street: " + receipt.getCompanyStreet(receipt));
      outputStream.println("Number: " + receipt.getCompanyNumber(receipt));
      outputStream.println();
    }
  }
  */
}