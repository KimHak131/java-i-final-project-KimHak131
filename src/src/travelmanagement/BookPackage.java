package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    Choice choose_package;
    JTextField fill_person;
    String username;
    JLabel label_username, label_number, label_phone, label_totalPrice, label_id;
    JButton checkprice, bookpackage, back;
    BookPackage(String username){
        this.username = username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/package.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 390, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, -70, 600, 600);
        add(image);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setForeground( Color.ORANGE);
        add(text);

        JLabel lbl_username = new JLabel("Username");
        lbl_username.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_username.setBounds(40,60,100,25);
        add(lbl_username);

        label_username = new JLabel();
        label_username.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_username.setBounds(250,60,200,25);
        add(label_username);

        JLabel lbl_package = new JLabel("Select Package");
        lbl_package.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_package.setBounds(40,110,200,25);
        add(lbl_package);

        choose_package = new Choice();
        choose_package.add("Gold Package");
        choose_package.add("Silver Package");
        choose_package.add("Bronze Package");
        choose_package.setBounds(250,110,200,25);
        add(choose_package);

        JLabel lbl_person = new JLabel("Total Person");
        lbl_person.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_person.setBounds(40,160,100,25);
        add(lbl_person);

        fill_person = new JTextField();
        fill_person.setFont(new Font("Tahoma", Font.PLAIN,16));
        fill_person.setBounds(250,160,200,25);
        add(fill_person);

        JLabel lbl_id = new JLabel("ID");
        lbl_id.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_id.setBounds(40,210,100,25);
        add(lbl_id);

        label_id = new JLabel();
        label_id.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_id.setBounds(250,210,100,25);
        add(label_id);

        JLabel lbl_number = new JLabel("Number");
        lbl_number.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_number.setBounds(40,260,100,25);
        add(lbl_number);

        label_number = new JLabel();
        label_number.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_number.setBounds(250,260,100,25);
        add(label_number);

        JLabel lbl_phone = new JLabel("Phone");
        lbl_phone.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_phone.setBounds(40,310,100,25);
        add(lbl_phone);

        label_phone = new JLabel();
        label_phone.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_phone.setBounds(250,310,100,25);
        add(label_phone);

        JLabel lbl_totalPrice = new JLabel("Total Price");
        lbl_totalPrice.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_totalPrice.setBounds(40,360,100,25);
        add(lbl_totalPrice);

        label_totalPrice = new JLabel();
        label_totalPrice.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_totalPrice.setBounds(250,360,100,25);
        add(label_totalPrice);

        setVisible(true);

        try{
            Conn connection = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet result = connection.statement.executeQuery(query);
            while(result.next()){
                label_username.setText(result.getString("username"));
                label_id.setText(result.getString("id"));
                label_number.setText(result.getString("number"));
                label_phone.setText(result.getString("phone"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.ORANGE);
        checkprice.setForeground(Color.black);
        checkprice.setBounds(40,400,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.ORANGE);
        bookpackage.setForeground(Color.black);
        bookpackage.addActionListener(this);
        bookpackage.setBounds(180,400,120,25);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setBounds(320,400,120,25);
        add(back);


        setVisible(true);
    }



    public static void main(String[] args) {
        new BookPackage("kimhak");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice){
            String pack = choose_package.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")){
                cost += 250;
            } else if (pack.equals("Silver Package")) {
                cost += 200;
            }else{
                cost += 150;
            }

            int people = Integer.parseInt(fill_person.getText());
            cost *= people;
            label_totalPrice.setText("USD " + cost);

        } else if (ae.getSource() == bookpackage) {
            try{
                Conn connection = new Conn();
                connection.statement.executeUpdate("insert into bookpackage values ('"+label_username.getText()+ "', '"+choose_package.getSelectedItem() + "', '"+fill_person.getText()+ "', '"+label_id.getText()+ "', '"+label_number.getText()+ "', '"+label_phone.getText()+ "', '"+label_totalPrice.getText()+ "')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }
}
