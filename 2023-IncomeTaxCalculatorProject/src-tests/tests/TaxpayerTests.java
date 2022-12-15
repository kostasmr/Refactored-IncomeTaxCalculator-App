package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.management.Company;
import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.Taxpayer;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class TaxpayerTests {

  private TaxpayerManager manager = new TaxpayerManager();
  int receiptId = 1;
  String issueDate = "1/1/2000";
  float amount = 1000;
  String kind = "Basic";
  String companyName = "TeamViewer";
  String country = "Greece";
  String city = "Ioannina";
  String street = "iii";
  int number = 1;
  int taxRegistrationNumber = 123123123;
  String status = "Married Filing Jointly";
  String name = "kostas";
  float income = 100;
  
  @Test
  void testAddReceipt() throws WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException, IOException {
    //test1
    //before
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);

    Taxpayer taxpayer = manager.getTaxpayer(taxRegistrationNumber);
    Receipt receipt = new Receipt(receiptId, issueDate, amount, kind,
        new Company(companyName, country, city, street, number));
    
    float amountPerKind = taxpayer.getAmountOfReceiptKind((short) 1);
    
    //then
    taxpayer.addReceipt(receipt);
    
    //after
    float correctAmount = amountPerKind + 1000;
    float newAmounPerKind = taxpayer.getAmountOfReceiptKind((short) 1);

    assertEquals(correctAmount,newAmounPerKind);
    
    //test2 
    //before
    String wrongKind = "Sport";
    
    Receipt receipt2 = new Receipt(receiptId, issueDate, amount, wrongKind,
    new Company(companyName, country, city, street, number));
    
    //after
    assertThrows(WrongReceiptKindException.class,()->{
      taxpayer.addReceipt(receipt2);
    });
    
    taxpayer.removeReceipt(receiptId);
    manager.removeTaxpayer(taxRegistrationNumber);
  }
  
  @Test
  void testRemoveReceipt() throws WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
    //before
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);

    Taxpayer taxpayer = manager.getTaxpayer(taxRegistrationNumber);
    Receipt receipt = new Receipt(receiptId, issueDate, amount, kind,
        new Company(companyName, country, city, street, number));
    
    taxpayer.addReceipt(receipt);
    float amountPerKind = taxpayer.getAmountOfReceiptKind((short) 1);
    
    //then
    taxpayer.removeReceipt(1);
    
    //after
    float correctAmount = amountPerKind - 1000;
    float newAmounPerKind = taxpayer.getAmountOfReceiptKind((short) 1);

    assertEquals(correctAmount,newAmounPerKind);
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }

}

