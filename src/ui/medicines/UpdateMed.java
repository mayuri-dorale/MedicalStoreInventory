package ui.medicines;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateMed extends JFrame implements ActionListener {
   JTextField medicineId;
   JTextField priceField;
   JButton updateButton;
   JPanel panel;
   JLabel l;
   JLabel l1;
   JLabel l2;

   public UpdateMed() {
      this.setTitle("Update suppliers details");
      this.setSize(1000, 1500);
      this.setVisible(true);
      this.panel = new JPanel();
      this.panel.setVisible(true);
      this.panel.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.panel.setBounds(400, 400, 500, 500);
      this.panel.setLayout((LayoutManager)null);
      this.l = new JLabel("Our Suppliers");
      this.l.setBounds(200, 30, 1200, 100);
      this.l.setFont(new Font("Algerian", 1, 40));
      this.l.setForeground(Color.blue);
      this.panel.add(this.l);
      this.l1 = new JLabel("Medicine ID:");
      this.medicineId = new JTextField();
      this.panel.add(this.medicineId);
      this.l2 = new JLabel("Price:");
      this.priceField = new JTextField();
      this.panel.add(this.priceField);
      this.add(this.panel);
      this.panel.add(this.l1);
      this.panel.add(this.l2);
      this.l1.setBounds(18, 200, 300, 50);
      this.l1.setFont(new Font("Serif", 1, 28));
      this.l1.setForeground(Color.blue);
      this.medicineId.setBounds(320, 210, 200, 30);
      this.l2.setBounds(18, 300, 200, 50);
      this.l2.setFont(new Font("Serif", 1, 28));
      this.l2.setForeground(Color.blue);
      this.priceField.setBounds(320, 310, 200, 30);
      JButton var1 = new JButton("Update details");
      this.panel.add(var1);
      var1.addActionListener(this);
      var1.setBounds(250, 380, 300, 50);
      var1.setBackground(Color.blue);
      var1.setForeground(Color.white);
      var1.setFont(new Font("Serif", 1, 28));
   }

   public void actionPerformed(ActionEvent var1) {
      try {
         int var2 = Integer.parseInt(this.medicineId.getText());
         double var3 = Double.parseDouble(this.priceField.getText());
         Connection var5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store?serverTimezone=UTC", "root", "root");
         Statement var6 = var5.createStatement();
         int var7 = var6.executeUpdate("Update medicines set price=" + var3 + "where id=" + var2);
         String var8;
         if (var7 > 0) {
            var8 = "One row updated successfully.";
            JOptionPane.showMessageDialog((Component)null, var8);
         } else {
            var8 = "No record found.";
            JOptionPane.showMessageDialog((Component)null, var8);
         }
      } catch (Exception var9) {
         System.out.println(var9);
      }

   }
}

