package ui.suppliers;

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

public class SupplierAdd extends JFrame implements ActionListener {
   JTextField nameField;
   JTextField emailField;
   JTextField ComNameField;
   JPanel panel;
   JButton saveButton;
   JLabel l;
   JLabel l1;
   JLabel l2;
   JLabel l3;

   public SupplierAdd() {
      this.setTitle("Add suppliers details");
      this.setSize(1000, 1500);
      this.setVisible(true);
      this.panel = new JPanel();
      this.panel.setLayout((LayoutManager)null);
      this.panel.setVisible(true);
      this.panel.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.panel.setBounds(500, 300, 400, 400);
      this.l = new JLabel("Add Supplier details");
      this.l.setBounds(200, 30, 1200, 100);
      this.l.setFont(new Font("Algerian", 1, 40));
      this.l.setForeground(Color.blue);
      this.panel.add(this.l);
      this.l1 = new JLabel("Enter Name:");
      this.nameField = new JTextField();
      this.l2 = new JLabel("Enter Email ID:");
      this.emailField = new JTextField();
      this.l3 = new JLabel("Enter Company Name:");
      this.ComNameField = new JTextField();
      this.panel.add(this.l1);
      this.panel.add(this.nameField);
      this.panel.add(this.l2);
      this.panel.add(this.emailField);
      this.panel.add(this.l3);
      this.panel.add(this.ComNameField);
      this.saveButton = new JButton("Add New Supplier ");
      this.saveButton.addActionListener(this);
      this.panel.add(this.saveButton);
      this.add(this.panel);
      this.l1.setBounds(18, 200, 300, 50);
      this.l1.setFont(new Font("Serif", 1, 28));
      this.l1.setForeground(Color.blue);
      this.nameField.setBounds(320, 210, 200, 30);
      this.l2.setBounds(18, 300, 200, 50);
      this.l2.setFont(new Font("Serif", 1, 28));
      this.l2.setForeground(Color.blue);
      this.emailField.setBounds(320, 310, 200, 30);
      this.l3.setBounds(18, 400, 300, 50);
      this.l3.setFont(new Font("Serif", 1, 28));
      this.l3.setForeground(Color.blue);
      this.ComNameField.setBounds(320, 410, 200, 30);
      this.saveButton.setBounds(250, 500, 300, 50);
      this.saveButton.setBackground(Color.blue);
      this.saveButton.setForeground(Color.white);
      this.saveButton.setFont(new Font("Serif", 1, 28));
   }

   public void actionPerformed(ActionEvent var1) {
      try {
         String var2 = this.nameField.getText();
         String var3 = this.emailField.getText();
         String var4 = this.ComNameField.getText();
         Connection var5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store?serverTimezone=UTC", "root", "root");
         PreparedStatement var6 = var5.prepareStatement("insert into supplier (name, email, comName) values (?, ?, ?)");
         var6.setString(1, var2);
         var6.setString(2, var3);
         var6.setString(3, var4);
         var6.executeUpdate();
         String var7 = "New supplier added successfully.";
         JOptionPane.showMessageDialog((Component)null, var7);
      } catch (Exception var8) {
         System.err.println(var8);
      }

   }
}
