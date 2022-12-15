package incometaxcalculator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongReceiptKindException;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewReceiptFrame extends JFrame {

  private JPanel contentPane;
  private JTextField receiptId;
  private JTextField date;
  private JTextField kind;
  private JTextField amount;
  private JTextField company;
  private JTextField country;
  private JTextField city;
  private JTextField street;
  private JTextField number;

  public ViewReceiptFrame(Receipt receipt,DefaultListModel<Integer> receiptsModel,TaxpayerManager taxpayerManager) {
    setTitle("Receipt Details");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 420, 366);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Receipt ID :");
    lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel.setBounds(38, 11, 129, 54);
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Date :");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_1.setBounds(88, 60, 79, 21);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("Kind :");
    lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_2.setBounds(110, 85, 57, 14);
    contentPane.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("Amount :");
    lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_3.setBounds(110, 110, 57, 14);
    contentPane.add(lblNewLabel_3);
    
    JLabel lblNewLabel_4 = new JLabel("Company :");
    lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_4.setBounds(83, 135, 84, 14);
    contentPane.add(lblNewLabel_4);
    
    JLabel lblNewLabel_5 = new JLabel("Country :");
    lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_5.setBounds(70, 160, 97, 14);
    contentPane.add(lblNewLabel_5);
    
    JLabel lblNewLabel_6 = new JLabel("Street :");
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_6.setBounds(88, 210, 79, 14);
    contentPane.add(lblNewLabel_6);
    
    JLabel lblNewLabel_7 = new JLabel("Number :");
    lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_7.setBounds(97, 235, 70, 14);
    contentPane.add(lblNewLabel_7);
    
    JLabel lblNewLabel_8 = new JLabel("City :");
    lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
    lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
    lblNewLabel_8.setBounds(121, 185, 46, 14);
    contentPane.add(lblNewLabel_8);
    
    JButton btnNewButton = new JButton("OK");
    getRootPane().setDefaultButton(btnNewButton);
    btnNewButton.requestFocus();
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });
    btnNewButton.setBounds(305, 293, 89, 23);
    contentPane.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Delete Receipt");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // yes option
            try {
              taxpayerManager.removeReceipt(receipt.getId());
            } catch (IOException | WrongReceiptKindException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
            receiptsModel.removeElement(receipt.getId());
            setVisible(false);
        } else {
            // no option
        }
      }
    });
    btnNewButton_1.setBounds(10, 293, 103, 23);
    contentPane.add(btnNewButton_1);
    
    receiptId = new JTextField();
    receiptId.setEditable(false);
    receiptId.setBounds(177, 30, 46, 20);
    contentPane.add(receiptId);
    receiptId.setColumns(10);
    String id =Integer.toString(receipt.getId());
    receiptId.setText(id);
    
    date = new JTextField();
    date.setEditable(false);
    date.setBounds(177, 61, 120, 20);
    contentPane.add(date);
    date.setColumns(10);
    date.setText(receipt.getIssueDate());
    
    kind = new JTextField();
    kind.setEditable(false);
    kind.setBounds(177, 83, 120, 20);
    contentPane.add(kind);
    kind.setColumns(10);
    kind.setText(receipt.getKind());
    
    amount = new JTextField();
    amount.setEditable(false);
    amount.setBounds(177, 108, 120, 20);
    contentPane.add(amount);
    amount.setColumns(10);
    String amountStr =Float.toString(receipt.getAmount());
    amount.setText(amountStr);
    
    company = new JTextField();
    company.setEditable(false);
    company.setBounds(177, 133, 120, 20);
    contentPane.add(company);
    company.setColumns(10);
    company.setText(receipt.getCompanyName(receipt));
    
    country = new JTextField();
    country.setEditable(false);
    country.setBounds(177, 158, 120, 20);
    contentPane.add(country);
    country.setColumns(10);
    country.setText(receipt.getCompanyCountry(receipt));
    
    city = new JTextField();
    city.setEditable(false);
    city.setBounds(177, 183, 120, 20);
    contentPane.add(city);
    city.setColumns(10);
    city.setText(receipt.getCompanyCity(receipt));
    
    street = new JTextField();
    street.setEditable(false);
    street.setBounds(177, 208, 120, 20);
    contentPane.add(street);
    street.setColumns(10);
    street.setText(receipt.getCompanyStreet(receipt));
    
    number = new JTextField();
    number.setEditable(false);
    number.setBounds(177, 233, 46, 20);
    contentPane.add(number);
    number.setColumns(10);
    String numberStr =Integer.toString(receipt.getCompanyNumber(receipt));
    number.setText(numberStr);
  }
}
