package ui.medicines;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MedAdd extends JFrame implements ActionListener {
   JTextField nameField;
   JTextField quantityField;
   JTextField priceField;
   JPanel panel;
   JLabel l;
   JLabel l1;
   JLabel l2;
   JLabel l3;

   public MedAdd() {
      this.setTitle("Add Medcines");
      this.setSize(1000, 1500);
      this.setVisible(true);
      this.panel = new JPanel();
      this.panel.setLayout((LayoutManager)null);
      this.panel.setVisible(true);
      this.panel.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.panel.setBounds(500, 300, 500, 400);
      this.l = new JLabel("Add Medcine Details:");
      this.l.setBounds(200, 30, 1200, 100);
      this.l.setFont(new Font("Algerian", 1, 40));
      this.l.setForeground(Color.blue);
      this.panel.add(this.l);
      this.l1 = new JLabel("Enter Medicine Name:");
      this.nameField = new JTextField();
      this.panel.add(this.l1);
      this.panel.add(this.nameField);
      this.l2 = new JLabel("Enter Quantity:");
      this.quantityField = new JTextField();
      this.panel.add(this.l2);
      this.panel.add(this.quantityField);
      this.l3 = new JLabel("Enter Price:");
      this.priceField = new JTextField();
      this.panel.add(this.l3);
      this.panel.add(this.priceField);
      this.add(this.panel);
      JButton var1 = new JButton("Add Medicine");
      this.panel.add(var1);
      var1.addActionListener(this);
      this.l1.setBounds(18, 200, 300, 50);
      this.l1.setFont(new Font("Serif", 1, 28));
      this.l1.setForeground(Color.blue);
      this.nameField.setBounds(320, 210, 200, 30);
      this.l2.setBounds(18, 300, 200, 50);
      this.l2.setFont(new Font("Serif", 1, 28));
      this.l2.setForeground(Color.blue);
      this.quantityField.setBounds(320, 310, 200, 30);
      this.l3.setBounds(18, 400, 300, 50);
      this.l3.setFont(new Font("Serif", 1, 28));
      this.l3.setForeground(Color.blue);
      this.priceField.setBounds(320, 410, 200, 30);
      var1.setBounds(250, 500, 300, 50);
      var1.setBackground(Color.blue);
      var1.setForeground(Color.white);
      var1.setFont(new Font("Serif", 1, 28));
   }

   public void actionPerformed(ActionEvent var1) {
      try {
         String var2 = this.nameField.getText();
         int var3 = Integer.parseInt(this.quantityField.getText());
         double var4 = Double.parseDouble(this.priceField.getText());
         Connection var6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store?serverTimezone=UTC", "root", "root");
         PreparedStatement var7 = var6.prepareStatement("insert into medicines (name, quantity, price) values (?, ?, ?)");
         var7.setString(1, var2);
         var7.setInt(2, var3);
         var7.setDouble(3, var4);
         var7.executeUpdate();
         String var8 = "Medicine added successfully.";
         JOptionPane.showMessageDialog((Component)null, var8);
      } catch (Exception var9) {
         System.err.println(var9);
      }

   }
}

