package incometaxcalculator.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;


public class AddReceiptFrame extends JFrame {

  private JPanel contentPane;
  private JTextField receiptID;
  private JTextField amount;
  private JTextField company;
  private JTextField country;
  private JTextField city;
  private JTextField street;
  private JTextField number;

  public AddReceiptFrame(int taxRegistrationNumber,TaxpayerManager taxpayerManager,DefaultListModel<Integer> receiptsModel) {
    setTitle("Add Receipt");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 532, 406);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Receipt ID :");
    lblNewLabel.setBounds(65, 32, 108, 14);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Kind :");
    lblNewLabel_1.setBounds(127, 82, 46, 14);
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("Amount :");
    lblNewLabel_2.setBounds(81, 135, 92, 14);
    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("Date :");
    lblNewLabel_3.setBounds(127, 57, 46, 14);
    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_3);
    
    JLabel lblNewLabel_4 = new JLabel("Company :");
    lblNewLabel_4.setBounds(87, 160, 86, 27);
    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_4);
    
    JLabel lblNewLabel_5 = new JLabel("Country :");
    lblNewLabel_5.setBounds(65, 191, 108, 27);
    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_5);
    
    JLabel lblNewLabel_6 = new JLabel("City :");
    lblNewLabel_6.setBounds(127, 221, 46, 35);
    lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_6);
    
    JLabel lblNewLabel_7 = new JLabel("Street :");
    lblNewLabel_7.setBounds(81, 262, 92, 14);
    lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_7);
    
    JLabel lblNewLabel_8 = new JLabel("Number :");
    lblNewLabel_8.setBounds(81, 293, 92, 14);
    lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
    contentPane.add(lblNewLabel_8);
    
    receiptID = new JTextField();
    receiptID.setBounds(183, 31, 46, 20);
    contentPane.add(receiptID);
    receiptID.setColumns(10);
    
    amount = new JTextField();
    amount.setBounds(183, 134, 125, 20);
    contentPane.add(amount);
    amount.setColumns(10);
    
    company = new JTextField();
    company.setBounds(183, 165, 125, 20);
    contentPane.add(company);
    company.setColumns(10);
    
    country = new JTextField();
    country.setBounds(183, 196, 125, 20);
    contentPane.add(country);
    country.setColumns(10);
    
    city = new JTextField();
    city.setBounds(183, 230, 125, 20);
    contentPane.add(city);
    city.setColumns(10);
    
    street = new JTextField();
    street.setBounds(183, 261, 125, 20);
    contentPane.add(street);
    street.setColumns(10);
    
    number = new JTextField();
    number.setBounds(183, 292, 46, 20);
    contentPane.add(number);
    number.setColumns(10);
    
    JDateChooser dateChooser = new JDateChooser();
    dateChooser.setDateFormatString("dd/MM/yyyy");
    dateChooser.setBounds(183, 57, 126, 20);
    contentPane.add(dateChooser);
    
    JRadioButton basic = new JRadioButton("Basic");
    basic.setBounds(183, 80, 67, 23);
    contentPane.add(basic);
    
    JRadioButton other = new JRadioButton("Other");
    other.setBounds(183, 106, 79, 23);
    contentPane.add(other);
    
    JRadioButton travel = new JRadioButton("Travel");
    travel.setBounds(252, 80, 67, 23);
    contentPane.add(travel);
    
    JRadioButton health = new JRadioButton("Health");
    health.setBounds(321, 80, 67, 23);
    contentPane.add(health);
    
    JRadioButton entertainment = new JRadioButton("Entertaiment");
    entertainment.setBounds(395, 80, 109, 23);
    contentPane.add(entertainment);
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(basic);bg.add(other);bg.add(health);bg.add(entertainment);bg.add(travel);
    
    JButton btnNewButton = new JButton("Add");
    getRootPane().setDefaultButton(btnNewButton);
    btnNewButton.requestFocus();
    btnNewButton.setBounds(417, 333, 89, 23);
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int receiptIDValue, numberValue;
        float amountValue;
        String dateValue, kindValue, companyValue, countryValue;
        String cityValue, streetValue;

        if (basic.isSelected()) {
          kindValue = "Basic";
        }
        else if (other.isSelected()) {
          kindValue = "Other";
        }
        else if (travel.isSelected()) {
          kindValue = "Travel";
        }
        else if (health.isSelected()) {
          kindValue = "Health";
        }
        else if (entertainment.isSelected()) {
          kindValue = "Entertainment";
        }
        else {
          kindValue="";
        }
        boolean allTheTextFieldsIsFilled = (!kindValue.equals("") && !receiptID.getText().equals("") && !amount.getText().equals("") && !company.getText().equals("") && !country.getText().equals("") && !city.getText().equals("") && !street.getText().equals("") && !number.getText().equals(""));
        if(allTheTextFieldsIsFilled==true) {
          try {
            receiptIDValue = Integer.parseInt(receiptID.getText());
            amountValue = Float.parseFloat(amount.getText());
            companyValue = company.getText();
            countryValue = country.getText();
            cityValue = city.getText();
            streetValue = street.getText();
            numberValue = Integer.parseInt(number.getText());
            if(dateChooser.getDate()!=null) {
              java.util.Date date = dateChooser.getDate();
              String pattern = "dd/MM/yyyy";
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
              dateValue = simpleDateFormat.format(date);
            }
            else {
              dateValue="";
            }
            taxpayerManager.addReceipt(receiptIDValue, dateValue, amountValue, kindValue,
                companyValue, countryValue, cityValue, streetValue, numberValue,
                taxRegistrationNumber);
            receiptsModel.addElement(receiptIDValue);
            setVisible(false); 
          }catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null,
                "Receipt ID,amount and number must have only digits.");
          } catch (IOException e1) {
            // TODO Auto-generated catch block
          } catch (WrongReceiptKindException e1) {
            JOptionPane.showMessageDialog(null, "Please check receipts kind and try again.");
          } catch (WrongReceiptDateException e1) {
            JOptionPane.showMessageDialog(null,
                "Please make sure your date " + "is DD/MM/YYYY and try again.");
          } catch (ReceiptAlreadyExistsException e1) {
            JOptionPane.showMessageDialog(null, "Receipt ID already exists.");
          } 
        }else {
          JOptionPane.showMessageDialog(null, "You must filled all the fields.Please try again!");
        }
      }
    });
    contentPane.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Cancel");
    btnNewButton_1.setBounds(10, 333, 89, 23);
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });
    contentPane.add(btnNewButton_1);
  }
}
