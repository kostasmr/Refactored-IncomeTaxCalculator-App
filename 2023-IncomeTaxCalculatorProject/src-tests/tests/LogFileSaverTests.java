package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class LogFileSaverTests {

  private TaxpayerManager manager = new TaxpayerManager();
  
  @Test
  void testSaveLogFile() throws WrongTaxpayerStatusException {
    //before
    int taxRegistrationNumber = 123123123;
    String status = "Married Filing Jointly";
    String name = "kostasmr";
    float income = 100;
    String wrongFileFormat = "pdf";
    
    manager.createTaxpayer(name, taxRegistrationNumber, status, income);

    //after
    assertThrows(WrongFileFormatException.class,()->{
      manager.saveLogFile(taxRegistrationNumber, wrongFileFormat);
    });
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }

}
