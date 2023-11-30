package travelmanagement;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField fill_username, fill_password;
    Login() {
        setSize(800, 400);
        setLocation(400, 200);
        setLayout(null);

        getContentPane().setBackground(Color.LIGHT_GRAY); // Background color changed to orange

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(173, 216, 230)); // Adjusted panel color
        p1.setBounds(0, 0, 400, 600);
        add(p1);

        // Icon login import
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login1.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 100, 200, 300);
        p1.add(image);

        // Login form
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        p2.setBackground(new Color(255, 183, 107));
        add(p2);

        JLabel label_username = new JLabel("Username");
        label_username.setBounds(60, 20, 100, 25);
        label_username.setFont(new Font("Bungee", Font.PLAIN, 20));
        p2.add(label_username);

        fill_username = new JTextField();
        fill_username.setBounds(60, 60, 270, 30);
        fill_username.setBorder(BorderFactory.createEmptyBorder());
        p2.add(fill_username);

        JLabel label_password = new JLabel("Password");
        label_password.setBounds(60, 100, 100, 25);
        label_password.setFont(new Font("Bungee", Font.PLAIN, 20));
        p2.add(label_password);

        fill_password = new JTextField();
        fill_password.setBounds(60, 140, 270, 30);
        fill_password.setBorder(BorderFactory.createEmptyBorder());
        p2.add(fill_password);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(173, 216, 230)); // Button color changed to orange
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(173, 216, 230))); // Border color adjusted
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(200, 200, 130, 30);
        signup.setBackground(new Color(173, 216, 230)); // Button color changed to orange
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(173, 216, 230))); // Border color adjusted
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forget Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(173, 216, 230)); // Button color changed to orange
        password.setForeground(Color.white);
        password.setBorder(new LineBorder(new Color(173, 216, 230)));
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(270, 255, 150, 20); // Adjusted label position
        text.setForeground(new Color(255, 0, 0));
        p2.add(text);

        setVisible(true);
    }

    public static void main(String[] args) {

        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){
            try {
                String username = fill_username.getText();
                String password = fill_password.getText();

                // get the data username and password from mysql
                String query = "select * from account where username = '"+ username+ "' AND password = '"+ password+ "'";
                Conn connection = new Conn();

                ResultSet result = connection.statement.executeQuery(query);
                if (result.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
}
