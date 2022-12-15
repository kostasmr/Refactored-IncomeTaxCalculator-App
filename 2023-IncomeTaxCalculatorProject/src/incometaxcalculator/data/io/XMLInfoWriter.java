package incometaxcalculator.data.io;

public class XMLInfoWriter extends InfoWriter{

  public XMLInfoWriter() {
    super.type = "xml";
  }
  
  /* 3RD DUPLICATE CODE
  public void generateFile(int taxRegistrationNumber) throws IOException {
    
    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + "_INFO.xml"));
    outputStream.println("<Name> " + manager.getTaxpayerName(taxRegistrationNumber) + " </Name>");
    outputStream.println("<AFM> " + taxRegistrationNumber + " </AFM>");
    outputStream.println("<Status> " + manager.getTaxpayerStatus(taxRegistrationNumber) + " </Status>");
    outputStream.println("<Income> " + manager.getTaxpayerIncome(taxRegistrationNumber) + " </Income>");
    outputStream.println();// den mas emfanize to \n se aplo notepad
    outputStream.println("<Receipts>");
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
      outputStream.println("<ReceiptID> " + receipt.getReceiptId(receipt) + " </ReceiptID>");
      outputStream.println("<Date> " + receipt.getReceiptIssueDate(receipt) + " </Date>");
      outputStream.println("<Kind> " + receipt.getReceiptKind(receipt) + " </Kind>");
      outputStream.println("<Amount> " + receipt.getReceiptAmount(receipt) + " </Amount>");
      outputStream.println("<Company> " + receipt.getCompanyName(receipt) + " </Company>");
      outputStream.println("<Country> " + receipt.getCompanyCountry(receipt) + " </Country>");
      outputStream.println("<City> " + receipt.getCompanyCity(receipt) + " </City>");
      outputStream.println("<Street> " + receipt.getCompanyStreet(receipt) + " </Street>");
      outputStream.println("<Number> " + receipt.getCompanyNumber(receipt) + " </Number>");
      outputStream.println();
    }
  }
  */
}