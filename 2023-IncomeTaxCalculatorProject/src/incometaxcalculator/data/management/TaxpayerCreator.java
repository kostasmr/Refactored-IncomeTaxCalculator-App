package incometaxcalculator.data.management;

import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

public class TaxpayerCreator extends TaxpayerManager{
  public void createTaxpayer(String fullname, int taxRegistrationNumber, String status,
      float income) throws WrongTaxpayerStatusException {
     if (status.equals("Married Filing Jointly")) {
       taxpayerHashMap.put(taxRegistrationNumber,
           new MarriedFilingJointlyTaxpayer(fullname, taxRegistrationNumber, income));
     } else if (status.equals("Married Filing Separately")) {
       taxpayerHashMap.put(taxRegistrationNumber,
           new MarriedFilingSeparatelyTaxpayer(fullname, taxRegistrationNumber, income));
     } else if (status.equals("Single")) {
       taxpayerHashMap.put(taxRegistrationNumber,
           new SingleTaxpayer(fullname, taxRegistrationNumber, income));
     } else if (status.equals("Head of Household")) {
       taxpayerHashMap.put(taxRegistrationNumber,
           new HeadOfHouseholdTaxpayer(fullname, taxRegistrationNumber, income));
     } else {
       throw new WrongTaxpayerStatusException();
     }
   }
}
