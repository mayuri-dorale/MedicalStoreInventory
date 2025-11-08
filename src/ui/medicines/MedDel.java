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

public class MedDel extends JFrame implements ActionListener {
   JTextField IdField;
   JPanel panel;
   JLabel l;
   JLabel l1;

   public MedDel() {
      this.setTitle("Delete Medicines");
      this.setSize(1000, 1500);
      this.setVisible(true);
      this.panel = new JPanel();
      this.panel.setLayout((LayoutManager)null);
      this.panel.setVisible(true);
      this.l = new JLabel("Delete Medicine");
      this.l.setBounds(200, 30, 1200, 100);
      this.l.setFont(new Font("Algerian", 1, 40));
      this.l.setForeground(Color.blue);
      this.panel.add(this.l);
      this.panel.setBackground(Color.getHSBColor(238.0F, 130.0F, 238.0F));
      this.panel.setBounds(500, 300, 500, 400);
      this.l1 = new JLabel("Medicine ID:");
      this.IdField = new JTextField();
      this.panel.add(this.l1);
      this.panel.add(this.IdField);
      this.add(this.panel);
      this.l1.setBounds(18, 200, 300, 50);
      this.l1.setFont(new Font("Serif", 1, 28));
      this.l1.setForeground(Color.blue);
      this.IdField.setBounds(320, 210, 200, 30);
      JButton var1 = new JButton("Delete Medicine");
      this.panel.add(var1);
      var1.addActionListener(this);
      var1.setBounds(250, 300, 300, 50);
      var1.setBackground(Color.blue);
      var1.setForeground(Color.white);
      var1.setFont(new Font("Serif", 1, 28));
   }

   public void actionPerformed(ActionEvent var1) {
      try {
         int var2 = Integer.parseInt(this.IdField.getText());
         Connection var3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store?serverTimezone=UTC", "root", "root");
         PreparedStatement var4 = var3.prepareStatement("delete from medicines where id = ?");
         var4.setInt(1, var2);
         int var5 = var4.executeUpdate();
         String var6;
         if (var5 > 0) {
            var6 = "Medicine deleted successfully.";
            JOptionPane.showMessageDialog((Component)null, var6);
         } else {
            var6 = "No Medicine found with given ID.";
            JOptionPane.showMessageDialog((Component)null, var6);
         }
      } catch (Exception var7) {
         System.out.println(var7);
      }

   }
}
