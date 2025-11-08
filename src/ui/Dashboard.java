
package ui;

import ui.medicines.*;
import ui.suppliers.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Dashboard extends JFrame implements ActionListener {
   JButton b1;
   JButton b2;
   JButton b3;
   JButton b4;
   JButton b5;
   JButton b6;
   JButton b7;
   JButton b8;
   JLabel back1;
   JLabel l1;

   Dashboard() {
      ImageIcon var1 = new ImageIcon("images/Dashboard_img.png");
      this.back1 = new JLabel("", var1, 2);
      this.back1.setBounds(0, 0, 1920, 1080);
      this.setVisible(true);
      this.setSize(2000, 2000);
      this.setLayout((LayoutManager)null);
      this.l1 = new JLabel("Admin Dashboard");
      this.l1.setBounds(400, 30, 1000, 100);
      this.l1.setFont(new Font("Algerian", 1, 50));
      this.l1.setForeground(Color.blue);
      this.b1 = new JButton("Add Medicines");
      this.b2 = new JButton("Delete Medicines");
      this.b3 = new JButton("View Medicines");
      this.b4 = new JButton("Update Medicines");
      this.b5 = new JButton("Add New Supplier");
      this.b6 = new JButton("view suppiler");
      this.b7 = new JButton("Log out and Exit");
      this.b1.setBounds(100, 200, 220, 200);
      this.b2.setBounds(400, 200, 220, 200);
      this.b3.setBounds(700, 200, 220, 200);
      this.b4.setBounds(1000, 200, 250, 200);
      this.b5.setBounds(300, 450, 250, 200);
      this.b6.setBounds(600, 450, 240, 200);
      this.b7.setBounds(900, 450, 220, 200);
      this.b1.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.b2.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.b3.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.b4.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.b5.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.b6.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.b7.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.b1.setForeground(Color.blue);
      this.b2.setForeground(Color.blue);
      this.b3.setForeground(Color.blue);
      this.b4.setForeground(Color.blue);
      this.b5.setForeground(Color.blue);
      this.b6.setForeground(Color.blue);
      this.b7.setForeground(Color.blue);
      this.b1.setFont(new Font("Times New Roman", 1, 25));
      this.b2.setFont(new Font("Times New Roman", 1, 25));
      this.b3.setFont(new Font("Times New Roman", 1, 25));
      this.b4.setFont(new Font("Times New Roman", 1, 25));
      this.b5.setFont(new Font("Times New Roman", 1, 25));
      this.b6.setFont(new Font("Times New Roman", 1, 25));
      this.b7.setFont(new Font("Times New Roman", 1, 25));
      this.b1.addActionListener(this);
      this.b2.addActionListener(this);
      this.b3.addActionListener(this);
      this.b4.addActionListener(this);
      this.b5.addActionListener(this);
      this.b6.addActionListener(this);
      this.b7.addActionListener(this);
      this.add(this.l1);
      this.add(this.b1);
      this.add(this.b2);
      this.add(this.b3);
      this.add(this.b4);
      this.add(this.b5);
      this.add(this.b6);
      this.add(this.b7);
      this.add(this.back1);
   }

   public void actionPerformed(ActionEvent var1) {
      if (var1.getSource() == this.b1) {
         new MedAdd();
      } else if (var1.getSource() == this.b2) {
         new MedDel();
      } else if (var1.getSource() == this.b3) {
         new MedDisplay();
      } else if (var1.getSource() == this.b4) {
         new UpdateMed();
      } else if (var1.getSource() == this.b5) {
         new SupplierAdd();
      } else if (var1.getSource() == this.b6) {
         new ViewSuppliers();
      } else if (var1.getSource() == this.b7) {
         this.dispose();
      }

   }
}
