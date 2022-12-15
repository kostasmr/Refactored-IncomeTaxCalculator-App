package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileEndingException;

class TaxpayerLoaderTests {

  private TaxpayerManager manager = new TaxpayerManager();
  
  @Test
  void testLoadTaxpayer() {
    //before
    String wrongFileName = "123123123_INFO.pdf";
    
    //after
    assertThrows(WrongFileEndingException.class,()->{
      manager.loadTaxpayer(wrongFileName);
    }); 
  }

}
