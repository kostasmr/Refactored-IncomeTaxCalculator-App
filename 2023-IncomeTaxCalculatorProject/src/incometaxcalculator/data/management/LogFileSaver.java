package incometaxcalculator.data.management;

import java.io.IOException;

import incometaxcalculator.data.io.TXTLogWriter;
import incometaxcalculator.data.io.XMLLogWriter;
import incometaxcalculator.exceptions.WrongFileFormatException;

public class LogFileSaver {
  public void saveLogFile(int taxRegistrationNumber, String fileFormat)
      throws IOException, WrongFileFormatException {
    if (fileFormat.equals("txt")) {
      new TXTLogWriter().generateFile(taxRegistrationNumber);
    } else if (fileFormat.equals("xml")) {
      new XMLLogWriter().generateFile(taxRegistrationNumber);
    } else {
      throw new WrongFileFormatException();
    }
  }
}
