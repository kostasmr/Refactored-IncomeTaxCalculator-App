package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class TaxpayerManagerTests {

  private TaxpayerManager manager = new TaxpayerManager();
  
  @Test
  void testCreateReceipt() throws WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException, IOException {
    //test1
    //before
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
    String name = "kostasmr";
    float income = 100;
    
    //then 
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);
    manager.createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    boolean receiptCreated = manager.containsReceipt(1);
    
    //after
    assertEquals(true,receiptCreated); 
    
    //test2
    //before
    String wrongKind = "Sport";
    
    //after
    assertThrows(WrongReceiptKindException.class,()->{
      manager.createReceipt(receiptId, issueDate, amount, wrongKind, companyName, country, city, street, number, taxRegistrationNumber);
    });
    
    //test3
    //before
    String wrongDate = "1-1-2000";
    
    //after
    assertThrows(WrongReceiptDateException.class,()->{
      manager.createReceipt(receiptId, wrongDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    });
    
    manager.removeReceipt(receiptId);
    manager.removeTaxpayer(taxRegistrationNumber);
  }
  
  @Test
  void testRemoveTaxpayer() throws WrongTaxpayerStatusException {
    //before
    int taxRegistrationNumber = 123123123;
    String status = "Married Filing Jointly";
    String name = "kostasmr";
    float income = 100;
    
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);
    
    //then 
    manager.removeTaxpayer(taxRegistrationNumber);
    boolean taxpayerExist = manager.containsTaxpayer(taxRegistrationNumber);
    
    //after
    assertEquals(false,taxpayerExist); 
  }
  
  @Test
  void testAddReceipt() throws WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException, IOException, ReceiptAlreadyExistsException {
    //test1
    //before
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
    String name = "kostasmr";
    float income = 100;
    
    //then 
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);
    manager.addReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    boolean receiptAdded = manager.containsReceipt(1);
    
    //after
    assertEquals(true,receiptAdded); 
    
    //test2
    //before
    int receiptId2 = 2;
    String wrongKind = "Sport";
    
    //after
    assertThrows(WrongReceiptKindException.class,()->{
      manager.addReceipt(receiptId2, issueDate, amount, wrongKind, companyName, country, city, street, number, taxRegistrationNumber);
    });
    
    //test3
    //before
    int receiptId3 = 3;
    String wrongDate = "1-1-2000";
    
    //after
    assertThrows(WrongReceiptDateException.class,()->{
      manager.addReceipt(receiptId3, wrongDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    });
    
    //test4
    //before
    int receiptIdExist = 1;
    
    //after
    assertThrows(ReceiptAlreadyExistsException.class,()->{
      manager.addReceipt(receiptIdExist, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    });
    
    manager.removeReceipt(receiptId);
    manager.removeTaxpayer(taxRegistrationNumber);
  }
  
  @Test
  void testRemoveReceipt() throws WrongTaxpayerStatusException, IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
    //before
    int receiptId = 2;
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
    String name = "kostasmr";
    float income = 100;
     
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);
    manager.addReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    
    //then
    manager.removeReceipt(receiptId);
    boolean receiptExist = manager.containsReceipt(receiptId);
    
    //after
    assertEquals(false,receiptExist); 
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }
  
  @Test
  void testContainsTaxpayer() throws WrongTaxpayerStatusException {
    //before
    int taxRegistrationNumber = 123123123;
    String status = "Married Filing Jointly";
    String name = "kostasmr";
    float income = 100;
    int taxRegistrationNumberNotExist = 100100100;
    
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);

    //then
    boolean taxpayerExist = manager.containsTaxpayer(taxRegistrationNumber);
    boolean taxpayerExist2 = manager.containsTaxpayer(taxRegistrationNumberNotExist);

    //after
    assertEquals(true,taxpayerExist);
    assertEquals(false,taxpayerExist2);
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }
  
  @Test
  void testContainsTaxpayer2() throws WrongTaxpayerStatusException {
    //test1
    //before
    int taxRegistrationNumber = 123123123;
    String status = "Married Filing Jointly";
    String name = "kostasmr";
    float income = 100;
    
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);

    //then
    boolean containsTaxpayer = manager.containsTaxpayer();

    //after
    assertEquals(true,containsTaxpayer);
    
    //test2
    //before
    manager.removeTaxpayer(taxRegistrationNumber);

    //then
    containsTaxpayer = manager.containsTaxpayer();

    //after
    assertEquals(false,containsTaxpayer);
    
  }
  
  @Test
  void testContainsReceipt() throws WrongTaxpayerStatusException, IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
    //test1
    //before
    int receiptId = 3;
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
    String name = "kostasmr";
    float income = 100;
     
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);
    manager.addReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    
    //then
    boolean containsReceipt = manager.containsReceipt(receiptId);
    
    //after
    assertEquals(true,containsReceipt);
    
    //test2
    //before
    manager.removeReceipt(receiptId);

    //then
    containsReceipt = manager.containsReceipt(receiptId);

    //after
    assertEquals(false,containsReceipt);
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }
  
  @Test
  void testGetTaxpayerStatus() throws WrongTaxpayerStatusException {
    //before
    int taxRegistrationNumber = 123123123;
    String status = "Married Filing Jointly";
    String name = "kostasmr";
    float income = 100;
    
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);
    
    //then 
    String result = manager.getTaxpayerStatus(taxRegistrationNumber);
    
    //after
    assertEquals(status,result); 
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }

}
