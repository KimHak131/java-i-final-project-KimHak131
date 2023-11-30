package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    Choice choose_hotel, choose_ac, choose_food;
    JTextField fill_person, fill_day;
    String username;
    JLabel label_username, label_number, label_phone, label_totalPrice, label_id;
    JButton checkprice, bookhotel, back;
    BookHotel(String username){
        this.username = username;
        setBounds(350,100,1100,700);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, -10, 700, 600);
        add(image);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(125,10,200,30);
        text.setForeground(Color.orange);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        JLabel lbl_username = new JLabel("Username");
        lbl_username.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_username.setBounds(40,60,100,25);
        add(lbl_username);

        label_username = new JLabel();
        label_username.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_username.setBounds(250,60,200,25);
        add(label_username);

        JLabel lbl_hotel = new JLabel("Select Hotel");
        lbl_hotel.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_hotel.setBounds(40,100,200,25);
        add(lbl_hotel);

        choose_hotel = new Choice();
        choose_hotel.setBounds(250,100,200,25);
        add(choose_hotel);

        try{
            Conn connection = new Conn();
            ResultSet result = connection.statement.executeQuery("select * from hotel");
            while (result.next()){
                choose_hotel.add(result.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbl_person = new JLabel("Total Person");
        lbl_person.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_person.setBounds(40,140,100,25);
        add(lbl_person);

        fill_person = new JTextField();
        fill_person.setFont(new Font("Tahoma", Font.PLAIN,16));
        fill_person.setBounds(250,140,200,25);
        add(fill_person);

        JLabel lbl_day = new JLabel("No. of Day");
        lbl_day.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_day.setBounds(40,180,100,25);
        add(lbl_day);

        fill_day = new JTextField("1");
        fill_day.setFont(new Font("Tahoma", Font.PLAIN,16));
        fill_day.setBounds(250,180,200,25);
        add(fill_day);

        JLabel lbl_AC = new JLabel("AC/ Non-AC");
        lbl_AC.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_AC.setBounds(40,220,100,25);
        add(lbl_AC);

        choose_ac = new Choice();
        choose_ac.add("AC");
        choose_ac.add("Non-AC");
        choose_ac.setBounds(250,220,200,20);
        add(choose_ac);

        JLabel lbl_food = new JLabel("Food Included");
        lbl_food.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_food.setBounds(40,260,100,25);
        add(lbl_food);

        choose_food = new Choice();
        choose_food.add("Yes");
        choose_food.add("No");
        choose_food.setBounds(250,260,200,20);
        add(choose_food);

        JLabel lbl_id = new JLabel("ID");
        lbl_id.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_id.setBounds(40,300,100,25);
        add(lbl_id);

        label_id = new JLabel();
        label_id.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_id.setBounds(250,300,100,25);
        add(label_id);

        JLabel lbl_number = new JLabel("Number");
        lbl_number.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_number.setBounds(40,340,100,25);
        add(lbl_number);

        label_number = new JLabel();
        label_number.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_number.setBounds(250,340,100,25);
        add(label_number);

        JLabel lbl_phone = new JLabel("Phone");
        lbl_phone.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_phone.setBounds(40,380,100,25);
        add(lbl_phone);

        label_phone = new JLabel();
        label_phone.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_phone.setBounds(250,380,100,25);
        add(label_phone);

        JLabel lbl_totalPrice = new JLabel("Total Price");
        lbl_totalPrice.setFont(new Font("Tahoma", Font.PLAIN,16));
        lbl_totalPrice.setBounds(40,420,100,25);
        add(lbl_totalPrice);

        label_totalPrice = new JLabel();
        label_totalPrice.setFont(new Font("Tahoma", Font.PLAIN,16));
        label_totalPrice.setBounds(250,420,100,25);
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
        checkprice.setBounds(40,500,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.ORANGE);
        bookhotel.setForeground(Color.black);
        bookhotel.addActionListener(this);
        bookhotel.setBounds(180,500,120,25);
        add(bookhotel);

        back = new JButton("Back");
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setBounds(320,500,120,25);
        add(back);


        setVisible(true);
    }



    public static void main(String[] args) {
        new BookHotel("kimhak");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice){
            try {
                Conn connection = new Conn();
                ResultSet result = connection.statement.executeQuery("select * from hotel where name= '" + choose_hotel.getSelectedItem() + "'");
                while (result.next()) {
                    int cost = Integer.parseInt(result.getString("costperperson"));
                    int food = Integer.parseInt(result.getString("foodincluded"));
                    int ac = Integer.parseInt(result.getString("acroom"));

                    int people = Integer.parseInt(fill_person.getText());
                    int days = Integer.parseInt(fill_day.getText());

                    String ac_selected = choose_ac.getSelectedItem();
                    String food_selected = choose_food.getSelectedItem();

                    if (people * days > 0) {
                        int total = 0;
                        total += ac_selected.equals("AC") ? ac : 0;
                        total += food_selected.equals("Yes") ? food : 0;
                        total += cost * people * days; // Calculating the cost per person per day
                        label_totalPrice.setText("USD " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookhotel) {
            try{
                Conn connection = new Conn();
                connection.statement.executeUpdate("insert into bookhotel values ('"+label_username.getText()+ "', '"+choose_hotel.getSelectedItem() + "', '"+fill_person.getText()+ "', '"+fill_day.getText()+ "', '"+choose_ac.getSelectedItem()+ "' , '"+choose_food.getSelectedItem()+ "', '"+label_id.getText()+ "', '"+label_number.getText()+ "', '"+label_phone.getText()+ "', '"+label_totalPrice.getText()+ "')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }
}
