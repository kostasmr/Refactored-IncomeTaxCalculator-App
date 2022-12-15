package incometaxcalculator.gui;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;

import incometaxcalculator.data.management.TaxpayerManager;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteTaxFrame extends JFrame {

  private JPanel contentPane;
  private JTextField textField;

  public DeleteTaxFrame(JList<String> list,TaxpayerManager taxpayerManager,DefaultListModel<String> taxRegisterNumberModel) {
    setAlwaysOnTop(true);
    setTitle("Delete Taxpayer\r\n");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 412, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    textField = new JTextField();
    textField.setBounds(10, 51, 376, 20);
    contentPane.add(textField);
    textField.setColumns(10);
    
    JTextPane txtpnGiveTheTax = new JTextPane();
    txtpnGiveTheTax.setEditable(false);
    txtpnGiveTheTax.setBackground(UIManager.getColor("Button.background"));
    txtpnGiveTheTax.setText("Give the tax registration number that you want to delete: ");
    txtpnGiveTheTax.setBounds(10, 22, 311, 20);
    contentPane.add(txtpnGiveTheTax);
    
    JButton btnNewButton = new JButton("Delete");
    getRootPane().setDefaultButton(btnNewButton);
    btnNewButton.requestFocus();
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int taxRegistrationNumber;
        boolean textFilled = !textField.getText().equals("");
        boolean taxRegistrationNumberCorrectFormat = (textField.getText().length()==9);
        if(textFilled && taxRegistrationNumberCorrectFormat) {
          try {
            taxRegistrationNumber = Integer.parseInt(textField.getText());
            if (taxpayerManager.containsTaxpayer(taxRegistrationNumber)) {
              taxpayerManager.removeTaxpayer(taxRegistrationNumber);
              taxRegisterNumberModel.removeElement(textField.getText());
              setVisible(false);
            }else {
              JOptionPane.showMessageDialog(null,
                  "Wrong tax registration number. Please try again.");
            }
          } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null,
                "The tax registration number must have only digits.");
          }
        }else {
          JOptionPane.showMessageDialog(null,
              "The tax  registration number must have 9 digit.\n" + " Try again.");
        }
      }
    });
    btnNewButton.setBounds(206, 227, 89, 23);
    contentPane.add(btnNewButton);
    
    JLabel lblNewLabel = new JLabel("Tax Registration Numbers");
    lblNewLabel.setBounds(10, 142, 144, 14);
    contentPane.add(lblNewLabel);
    
    int sizeList = list.getModel().getSize();
    String[] taxesListStr= new String[sizeList];
    for(int i=0;i<sizeList;i++)
    {
      taxesListStr[i] = list.getModel().getElementAt(i);
    }
    
    DefaultListModel<String> taxesModel = new DefaultListModel<String>();
    for(int i=0;i<sizeList;i++)
    {
      taxesModel.addElement(taxesListStr[i]);
    }
    JList<String> taxesList = new JList<String>(taxesModel);
    taxesList.setBounds(160, 82, 226, 134);
    contentPane.add(taxesList);
    
    JButton btnNewButton_1 = new JButton("Cancel");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });
    btnNewButton_1.setBounds(88, 227, 89, 23);
    contentPane.add(btnNewButton_1);
    
    taxesList.addMouseListener(new MouseListener()
    {
      @Override
      public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        String trn = taxesList.getSelectedValue();
        if (trn != null) {
          textField.setText(trn);
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }
    });
  }
}
