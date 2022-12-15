package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.io.LogWriter;
import incometaxcalculator.data.io.TXTLogWriter;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileEndingException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class LogWriterTests {

  private LogWriter writer = new TXTLogWriter();
  private TaxpayerManager manager = new TaxpayerManager();
  
  @Test
  void testGenerateFile() throws IOException, NumberFormatException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
    //before
    int taxRegistrationNumber = 123456789;
    String file = "123456789_INFO.txt";
    manager.loadTaxpayer(file);
    
    //then 
    writer.generateFile(taxRegistrationNumber);
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }
  
  @Test
  void testLogType() {
    //before
    String type1 = "txt";
    String type2 = "xml";
    String expected1 = "_LOG.txt";
    String expected2 = "_LOG.xml";
    
    //then
    String output1 = writer.logType(type1);
    String output2 = writer.logType(type2);
    
    //after
    assertEquals(expected1,output1);
    assertEquals(expected2,output2);
  }
  
  @Test
  void testFileInfo() {
    //before
    String type1 = "txt";
    String type2 = "xml";
    String expected1 = "Name: ";
    String expected2 = "<Name> ";
    
    //then
    String[] output1 = writer.fileInfo(type1);
    String[] output2 = writer.fileInfo(type2);
    
    //after
    assertEquals(expected1,output1[0]);
    assertEquals(expected2,output2[0]);
  }
}
