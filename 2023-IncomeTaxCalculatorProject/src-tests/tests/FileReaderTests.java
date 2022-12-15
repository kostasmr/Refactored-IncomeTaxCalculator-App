package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.io.FileReader;
import incometaxcalculator.data.io.TXTFileReader;
import incometaxcalculator.data.io.XMLFileReader;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class FileReaderTests {

  private FileReader txtReader = new TXTFileReader();
  private FileReader xmlRreader = new XMLFileReader();
  private TaxpayerManager manager = new TaxpayerManager();
  
  @Test
  void testReadFile() throws NumberFormatException, IOException, WrongTaxpayerStatusException, WrongFileFormatException, WrongReceiptKindException, WrongReceiptDateException {
    //before
    String txt = "123456789_INFO.txt";
    String xml = "123456789_INFO.xml";
    
    //then
    txtReader.readFile(txt);
    xmlRreader.readFile(xml);
    
    manager.removeTaxpayer(123456789);
  }
  
  @Test
  void testCheckForReceipt() throws NumberFormatException, IOException{
    //before
    String fileName = "123456789_INFO.txt";
    BufferedReader inputStream = new BufferedReader(new java.io.FileReader(fileName));
    int correctId = 1;
    int correctId2 = 2;
    
    //then
    int receiptId = txtReader.checkForReceipt(inputStream);
    int receiptId2 = txtReader.checkForReceipt(inputStream);
    
    //after
    assertEquals(correctId,receiptId);
    assertEquals(correctId2,receiptId2);
  }

}
