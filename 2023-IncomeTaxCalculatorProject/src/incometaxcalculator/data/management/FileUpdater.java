package incometaxcalculator.data.management;

import java.io.File;
import java.io.IOException;

import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.io.XMLInfoWriter;

public class FileUpdater {
  protected void updateFiles(int taxRegistrationNumber) throws IOException {
    if (new File(taxRegistrationNumber + "_INFO.xml").exists()) {
      new XMLInfoWriter().generateFile(taxRegistrationNumber);
    }
    if (new File(taxRegistrationNumber + "_INFO.txt").exists()) {
      new TXTInfoWriter().generateFile(taxRegistrationNumber);
    }
  }
}
