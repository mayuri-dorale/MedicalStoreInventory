package ui.medicines;

import db.DBConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MedDisplay extends JFrame {
   JTable jt;
   JLabel title;
   JPanel panel;

   public MedDisplay() {
      this.setTitle("View Medicines");
      this.setSize(1000, 700);
      this.setLocationRelativeTo((Component)null);
      this.setDefaultCloseOperation(2);
      this.setVisible(true);
      this.panel = new JPanel(new BorderLayout());
      this.panel.setBackground(new Color(138, 43, 226));
      this.panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
      this.title = new JLabel("Medicines List", 0);
      this.title.setFont(new Font("Algerian", 1, 40));
      this.title.setForeground(Color.WHITE);
      this.panel.add(this.title, "North");

      try {
         Connection var1 = DBConnection.getConnection();

         try {
            Statement var2 = var1.createStatement();
            ResultSet var3 = var2.executeQuery("SELECT * FROM medicines");
            DefaultTableModel var4 = new DefaultTableModel();
            var4.setColumnIdentifiers(new String[]{"ID", "Medicine Name", "Quantity", "Price (Rs)"});

            while(true) {
               if (!var3.next()) {
                  this.jt = new JTable(var4);
                  this.jt.setRowHeight(28);
                  this.jt.setFont(new Font("Serif", 0, 18));
                  this.jt.setGridColor(Color.LIGHT_GRAY);
                  this.jt.setSelectionBackground(new Color(186, 85, 211));
                  this.jt.setSelectionForeground(Color.WHITE);
                  this.jt.setBackground(Color.WHITE);
                  this.jt.setForeground(Color.DARK_GRAY);
                  JTableHeader var5 = this.jt.getTableHeader();
                  var5.setBackground(new Color(72, 61, 139));
                  var5.setForeground(Color.WHITE);
                  var5.setFont(new Font("Serif", 1, 20));
                  var5.setPreferredSize(new Dimension(100, 40));
                  JScrollPane var6 = new JScrollPane(this.jt);
                  var6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
                  this.panel.add(var6, "Center");
                  this.add(this.panel);
                  break;
               }

               var4.addRow(new Object[]{var3.getInt("id"), var3.getString("name"), var3.getInt("quantity"), var3.getDouble("price")});
            }
         } catch (Throwable var8) {
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var7) {
                  var8.addSuppressed(var7);
               }
            }

            throw var8;
         }

         if (var1 != null) {
            var1.close();
         }
      } catch (Exception var9) {
         JOptionPane.showMessageDialog(this, "Error loading data: " + var9.getMessage());
      }

   }
}

