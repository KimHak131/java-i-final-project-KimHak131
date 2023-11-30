package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel label_username, label_name;
    JTextField fill_number, fill_country, fill_address, fill_email, fill_phone, fill_id, fill_gender;
    JRadioButton rmale, rfemale;
    JButton update, back;
    UpdateCustomer(String username){

        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,5,300,25);
        text.setForeground(Color.orange);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        // username label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        label_username = new JLabel();
        label_username.setBounds(220,50,150,25);
        add(label_username);

        JLabel lbl_id = new JLabel("ID");
        lbl_id.setBounds(30,90,150,25);
        add(lbl_id);

        fill_id = new JTextField();
        fill_id.setBounds(220,90,150,20);
        add(fill_id);

        JLabel lbl_number = new JLabel("Number");
        lbl_number.setBounds(30,130,150,25);
        add(lbl_number);

        fill_number = new JTextField();
        fill_number.setBounds(220,130,150,20);
        add(fill_number);

        JLabel lbl_name = new JLabel("Name");
        lbl_name.setBounds(30,170,150,25);
        add(lbl_name);

        label_name = new JLabel();
        label_name.setBounds(220,170,150,25);
        add(label_name);

        JLabel lbl_gender = new JLabel("Gender");
        lbl_gender.setBounds(30,210,150,25);
        add(lbl_gender);

        fill_gender = new JTextField();
        fill_gender.setBounds(220,210,150,20);
        add(fill_gender);

        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(rmale);
        buttongroup.add(rfemale);

        JLabel lbl_country = new JLabel("Country");
        lbl_country.setBounds(30,250,150,25);
        add(lbl_country);

        fill_country = new JTextField();
        fill_country.setBounds(220,250,150,20);
        add(fill_country);

        JLabel lbl_address = new JLabel("Address");
        lbl_address.setBounds(30,290,150,25);
        add(lbl_address);

        fill_address = new JTextField();
        fill_address.setBounds(220,290,150,20);
        add(fill_address);

        JLabel lbl_email = new JLabel("Email");
        lbl_email.setBounds(30,330,150,25);
        add(lbl_email);

        fill_email = new JTextField();
        fill_email.setBounds(220,330,150,20);
        add(fill_email);

        JLabel lbl_phone = new JLabel("Phone");
        lbl_phone.setBounds(30,370,150,25);
        add(lbl_phone);

        fill_phone = new JTextField();
        fill_phone.setBounds(220,370,150,20);
        add(fill_phone);

        update = new JButton("Update");
        update.setBackground(Color.orange);
        update.setForeground(Color.black);
        update.setBounds(70,410,100,25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.orange);
        back.setForeground(Color.black);
        back.setBounds(220,410,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/tourist.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 40, 400, 420);
        add(image);

        try{
            Conn connection = new Conn();
            ResultSet result = connection.statement.executeQuery("select *  from customer where username = '"+username+"'");
            while (result.next()){
                label_username.setText(result.getString("username"));
                label_name.setText(result.getString("name"));
                fill_id.setText(result.getString("id"));
                fill_number.setText(result.getString("number"));
                fill_gender.setText(result.getString("gender"));
                fill_country.setText(result.getString("country"));
                fill_address.setText(result.getString("address"));
                fill_phone.setText(result.getString("phone"));
                fill_email.setText(result.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }

    public static void main(String[] args) {

        new UpdateCustomer("kimhak");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update){
            String username = label_username.getText();
            String id = fill_id.getText();
            String number = fill_number.getText();
            String name = label_name.getText();
            String gender = fill_gender.getText();
            String country = fill_country.getText();
            String address = fill_address.getText();
            String phone = fill_phone.getText();
            String email = fill_email.getText();

            try{
                Conn connection = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
                connection.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }
}
