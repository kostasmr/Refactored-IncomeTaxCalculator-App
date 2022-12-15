package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class TaxpayerCreatorTests {

  private TaxpayerManager manager = new TaxpayerManager();
  
  @Test
  void testCreateTaxpayer() throws WrongTaxpayerStatusException {
    //test1
    //before
    int taxRegistrationNumber = 123123123;
    String status = "Married Filing Jointly";
    String name = "kostasmr";
    float income = 100;
    
    //then
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);
    String taxpayerName = manager.getTaxpayerName(taxRegistrationNumber);
    
    //after
    assertEquals(name,taxpayerName); 
    
    //test2
    //before
    int taxRegistrationNumber2 = 456456456;
    String wrongStatus = "Married";
    String name2 = "giannis";
    
    //after
    assertThrows(WrongTaxpayerStatusException.class,()->{
      manager.createTaxpayer(name2, taxRegistrationNumber2, wrongStatus, income);
    });
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }

}
