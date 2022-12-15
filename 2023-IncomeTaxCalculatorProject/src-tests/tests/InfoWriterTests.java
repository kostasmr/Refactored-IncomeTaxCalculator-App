package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.io.InfoWriter;
import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.io.XMLInfoWriter;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileEndingException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class InfoWriterTests {

  private InfoWriter xmlWriter = new XMLInfoWriter();
  private InfoWriter txtWriter = new TXTInfoWriter();
  private TaxpayerManager manager = new TaxpayerManager();
  
  @Test
  void testGenerateFile() throws IOException, NumberFormatException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
    //before
    int taxRegistrationNumber = 123456789;
    String file = "123456789_INFO.txt";
    manager.loadTaxpayer(file);
    
    //then 
    txtWriter.generateFile(taxRegistrationNumber);
    
    manager.removeTaxpayer(taxRegistrationNumber);
  }

  @Test
  void testInfoType() {
    //before
    String type1 = "txt";
    String type2 = "xml";
    String expected1 = "_INFO.txt";
    String expected2 = "_INFO.xml";
    
    //then
    String output1 = txtWriter.infoType(type1);
    String output2 = xmlWriter.infoType(type2);
    
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
    String[] output1 = txtWriter.fileInfo(type1);
    String[] output2 = xmlWriter.fileInfo(type2);
    
    //after
    assertEquals(expected1,output1[0]);
    assertEquals(expected2,output2[0]);
  }
  
  @Test
  void testTaxpayerReceiptsInfo() {
    //before
    String type1 = "txt";
    String type2 = "xml";
    String expected1 = "Receipt ID: ";
    String expected2 = "<ReceiptID> ";
    
    //then
    String[] output1 = txtWriter.taxpayerReceiptsInfo(type1);
    String[] output2 = xmlWriter.taxpayerReceiptsInfo(type2);
    
    //after
    assertEquals(expected1,output1[0]);
    assertEquals(expected2,output2[0]);
  }
}
