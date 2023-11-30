package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ViewCustomer extends JFrame implements ActionListener {

    JButton back;
    ViewCustomer(String username){
        setBounds(450,180,870,620);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Your Information");
        text.setBounds(270,5,600,40);
        text.setForeground(Color.orange);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        JLabel lbl_username = new JLabel("Username");
        lbl_username.setBounds(30,60,150,25);
        add(lbl_username);

        JLabel label_username = new JLabel();
        label_username.setBounds(220,60,150,25);
        add(label_username);

        JLabel lbl_id = new JLabel("ID");
        lbl_id.setBounds(30,120,150,25);
        add(lbl_id);

        JLabel label_id = new JLabel();
        label_id.setBounds(220,120,150,25);
        add(label_id);

        JLabel lbl_number = new JLabel("Number");
        lbl_number.setBounds(30,180,150,25);
        add(lbl_number);

        JLabel label_number = new JLabel();
        label_number.setBounds(220,180,150,25);
        add(label_number);

        JLabel lbl_name = new JLabel("Name");
        lbl_name.setBounds(30,240,150,25);
        add(lbl_name);

        JLabel label_name = new JLabel();
        label_name.setBounds(220,240,150,25);
        add(label_name);

        JLabel lbl_gender = new JLabel("Gender");
        lbl_gender.setBounds(30,310,150,25);
        add(lbl_gender);

        JLabel label_gender = new JLabel();
        label_gender.setBounds(220,310,150,25);
        add(label_gender);

        JLabel lbl_country = new JLabel("Country");
        lbl_country.setBounds(430,60,150,25);
        add(lbl_country);

        JLabel label_country = new JLabel();
        label_country.setBounds(620,60,150,25);
        add(label_country);

        JLabel lbl_address = new JLabel("Address");
        lbl_address.setBounds(430,120,150,25);
        add(lbl_address);

        JLabel label_address = new JLabel();
        label_address.setBounds(620,120,150,25);
        add(label_address);

        JLabel lbl_phone = new JLabel("Phone");
        lbl_phone.setBounds(430,180,150,25);
        add(lbl_phone);

        JLabel label_phone = new JLabel();
        label_phone.setBounds(620,180,150,25);
        add(label_phone);

        JLabel lbl_email = new JLabel("Email");
        lbl_email.setBounds(430,240,150,25);
        add(lbl_email);

        JLabel label_email = new JLabel();
        label_email.setBounds(620,240,150,25);
        add(label_email);

        back = new JButton("Back");
        back.setBackground(Color.orange);
        back.setForeground(Color.black);
        back.setBounds(350,370,100,25);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(105, 400, 650, 450);
        add(image);

        try{
            Conn connection = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet result = connection.statement.executeQuery(query);
            while(result.next()){
                label_username.setText(result.getString("username"));
                label_id.setText(result.getString("id"));
                label_number.setText(result.getString("number"));
                label_name.setText(result.getString("name"));
                label_gender.setText(result.getString("gender"));
                label_country.setText(result.getString("country"));
                label_address.setText(result.getString("address"));
                label_phone.setText(result.getString("phone"));
                label_email.setText(result.getString("email"));
            }

        }catch (Exception e){

        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewCustomer("kimhak");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        setVisible(false);
    }
}
