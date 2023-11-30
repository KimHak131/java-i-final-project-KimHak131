package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel label_username, label_name;
    JComboBox combo_id;
    JTextField fill_number, fill_country, fill_address, fill_email, fill_phone;
    JRadioButton rmale, rfemale;
    JButton add, back;
    AddCustomer(String username){

        setBounds(450,200,850,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

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

        combo_id = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        combo_id.setBounds(220,90,150,25);
        combo_id.setBackground(Color.white);
        add(combo_id);

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

        rmale = new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.white);
        add(rfemale);

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

        add = new JButton("Add");
        add.setBackground(Color.orange);
        add.setForeground(Color.black);
        add.setBounds(70,410,100,25);
        add.addActionListener(this);
        add(add);

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
            ResultSet result = connection.statement.executeQuery("select *  from account where username = '"+username+"'");
            while (result.next()){
                label_username.setText(result.getString("username"));
                label_name.setText(result.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }

    public static void main(String[] args) {

        new AddCustomer("kimhak");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){
            String username = label_username.getText();
            String id = (String) combo_id.getSelectedItem();
            String number = fill_number.getText();
            String name = label_name.getText();
            String gender = null;
            if (rmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }

            String country = fill_country.getText();
            String address = fill_address.getText();
            String phone = fill_number.getText();
            String email = fill_number.getText();

            try{
                Conn connection = new Conn();
                String query = "insert into customer values('"+username+"','"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                connection.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }
}
