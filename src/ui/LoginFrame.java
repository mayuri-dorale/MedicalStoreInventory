package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel title, userLabel, passLabel, bg;
    JTextField username;
    JPasswordField password;
    JButton loginBtn;

    public LoginFrame() {

        setTitle("Login");
        setSize(500, 500);
        setLayout(null);
        setVisible(true);

        ImageIcon img = new ImageIcon("images/Login_img.jpeg");
        bg = new JLabel("", img, JLabel.LEFT);
        bg.setBounds(0, 0, 1500, 900);

        title = new JLabel("Medical Store Inventory");
        title.setBounds(200, 30, 1200, 100);
        title.setFont(new Font("Algerian", Font.BOLD, 30));
        title.setForeground(Color.BLUE);

        JPanel panel = new JPanel(null);
        panel.setBounds(500, 300, 500, 400);
        panel.setBackground(Color.getHSBColor(255, 223, 153));

        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");

        username = new JTextField();
        password = new JPasswordField();

        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);

        userLabel.setBounds(30, 100, 150, 40);
        passLabel.setBounds(30, 180, 150, 40);

        username.setBounds(180, 100, 200, 30);
        password.setBounds(180, 180, 200, 30);

        loginBtn.setBounds(140, 270, 200, 50);

        panel.add(userLabel);
        panel.add(username);
        panel.add(passLabel);
        panel.add(password);
        panel.add(loginBtn);

        add(title);
        add(panel);
        add(bg);
    }

    public void actionPerformed(ActionEvent e) {
        if (username.getText().equals("admin1") && password.getText().equals("admin1")) {
            dispose();
            new Dashboard();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
        }
    }
}
