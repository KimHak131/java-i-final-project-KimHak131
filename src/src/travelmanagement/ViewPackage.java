package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ViewPackage extends JFrame implements ActionListener {
    JLabel label_username, label_package, label_totalPerson, label_price, label_number, label_id, label_phone;
    JButton back;
    ViewPackage(String username){
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // image gold package
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/goldpackage.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, -35, 600, 500);
        add(image);


        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("tahoma", Font.BOLD,22));
        text.setForeground(Color.orange);
        text.setBounds(30,0,300,30);
        add(text);

        JLabel lbl_username = new JLabel("Username");
        lbl_username.setFont(new Font("tahoma", Font.BOLD,14));
        lbl_username.setBounds(30,40,150,25);
        add(lbl_username);

        label_username = new JLabel();
        label_username.setFont(new Font("tahoma", Font.PLAIN,14));
        label_username.setBounds(220,40,150,25);
        add(label_username);

        JLabel lbl_package = new JLabel("Package");
        lbl_package.setBounds(30,80,150,25);
        lbl_package.setFont(new Font("tahoma", Font.BOLD,14));
        add(lbl_package);

        label_package = new JLabel();
        label_package.setBounds(220,80,150,25);
        label_package.setFont(new Font("tahoma", Font.PLAIN,14));
        add(label_package);

        JLabel lbl_totalPerson = new JLabel("Total Person");
        lbl_totalPerson.setBounds(30,120,150,25);
        lbl_totalPerson.setFont(new Font("tahoma", Font.BOLD,14));
        add(lbl_totalPerson);

        label_totalPerson = new JLabel();
        label_totalPerson.setBounds(220,120,150,25);
        label_totalPerson.setFont(new Font("tahoma", Font.PLAIN,14));
        add(label_totalPerson);

        JLabel lbl_id = new JLabel("ID");
        lbl_id.setBounds(30,160,150,25);
        lbl_id.setFont(new Font("tahoma", Font.BOLD,14));
        add(lbl_id);

        label_id = new JLabel();
        label_id.setBounds(220,160,150,25);
        label_id.setFont(new Font("tahoma", Font.PLAIN,14));
        add(label_id);

        JLabel lbl_number = new JLabel("Number");
        lbl_number.setFont(new Font("tahoma", Font.BOLD,14));
        lbl_number.setBounds(30,200,150,25);
        add(lbl_number);

        label_number = new JLabel();
        label_number.setFont(new Font("tahoma", Font.PLAIN,14));
        label_number.setBounds(220,200,150,25);
        add(label_number);

        JLabel lbl_phone = new JLabel("Phone");
        lbl_phone.setFont(new Font("tahoma", Font.BOLD,14));
        lbl_phone.setBounds(30,240,150,25);
        add(lbl_phone);

        label_phone = new JLabel();
        label_phone.setFont(new Font("tahoma", Font.PLAIN,14));
        label_phone.setBounds(220,240,150,25);
        add(label_phone);

        JLabel lbl_price = new JLabel("Price");
        lbl_price.setFont(new Font("tahoma", Font.BOLD,14));
        lbl_price.setBounds(30,280,150,25);
        add(lbl_price);

        label_price = new JLabel();
        label_price.setFont(new Font("tahoma", Font.PLAIN,14));
        label_price.setBounds(220,280,150,25);
        add(label_price);


        back = new JButton("Back");
        back.setBackground(Color.orange);
        back.setForeground(Color.black);
        back.setBounds(120,320,100,25);
        add(back);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/customer.png"));
//        Image i2 = i1.getImage().getScaledInstance(700, 480, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(105, 400, 650, 450);
//        add(image);

        try{
            Conn connection = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet result = connection.statement.executeQuery(query);
            while(result.next()){
                label_username.setText(result.getString("username"));
                label_id.setText(result.getString("id"));
                label_number.setText(result.getString("number"));
                label_phone.setText(result.getString("phone"));
                label_price.setText(result.getString("price"));
                label_package.setText(result.getString("package"));
                label_totalPerson.setText(result.getString("people"));
            }

        }catch (Exception e){

        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewPackage("kimhak");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        setVisible(false);
    }
}
