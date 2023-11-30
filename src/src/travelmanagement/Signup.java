package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Signup extends JFrame implements ActionListener{

    JButton create, back;
    JTextField fill_username, fill_name, fill_password, fill_answer;
    Choice security;
    Signup(){
        setSize(800, 400);
        setLocation(400, 200);
        setLayout(null);

        getContentPane().setBackground(Color.LIGHT_GRAY); // Background color changed to orange

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(173, 216, 230)); // Adjusted panel color
        p1.setBounds(0, 0, 400, 600);
        p1.setLayout(null);
        add(p1);

// Icon login import
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 290, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
//        image.setBounds();


// Calculate the center position
        int imageWidth = i3.getIconWidth();
        int imageHeight = i3.getIconHeight();
        int panelWidth = 385; // Width of p2
        int panelHeight = 300; // Height of p2
        int x = (panelWidth - imageWidth) / 2;
        int y = (panelHeight - imageHeight) / 2;

        image.setBounds(x, y, imageWidth, imageHeight);

// Login form
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        p2.setBackground(new Color(255, 183, 107));
        add(p2);
        p2.add(image);



        JLabel label_username = new JLabel("Username");
        label_username.setBounds(50, 20, 125, 25);
        label_username.setFont(new Font("Bungee", Font.BOLD, 14));
        p1.add(label_username);

        fill_username = new JTextField();
        fill_username.setBounds(190, 20, 180, 25);
        fill_username.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_username);

        JLabel label_name = new JLabel("Name");
        label_name.setBounds(50, 60, 125, 25);
        label_name.setFont(new Font("Bungee", Font.BOLD, 14));
        p1.add(label_name);

        fill_name = new JTextField();
        fill_name.setBounds(190, 60, 180, 25);
        fill_name.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_name);

        JLabel label_password = new JLabel("Password");
        label_password.setBounds(50, 100, 125, 25);
        label_password.setFont((new Font("Bungee", Font.BOLD, 14)));
        p1.add(label_password);

        fill_password = new JTextField();
        fill_password.setBounds(190, 100, 180, 25);
        fill_password.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_password);

        JLabel label_security = new JLabel("Security Question");
        label_security.setBounds(50, 140, 125, 25);
        label_security.setFont(new Font("Bungee", Font.BOLD, 14));
        p1.add(label_security);

        security = new Choice();
        security.add("Favorite Player in football team");
        security.add("Favorite Singer");
        security.add("Favorite place to visit in SiemReap");
        security.add("Favorite Person");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);


        JLabel label_answer = new JLabel("Answer");
        label_answer.setBounds(50, 180, 120, 25);
        label_answer.setFont(new Font("Bungee", Font.BOLD, 14));
        p1.add(label_answer);

        fill_answer = new JTextField();
        fill_answer.setBounds(190, 180, 180, 25);
        fill_answer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_answer);

        create = new JButton("Create");
        create.setBackground(new Color(255, 183, 107));
        create.setForeground(Color.white);
        create.setBounds(80, 250, 100, 30);
        create.setFont(new Font("Bungee", Font.BOLD, 14));
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(new Color(255, 183, 107));
        back.setForeground(Color.white);
        back.setBounds(250, 250, 100, 30);
        back.setFont(new Font("Bungee", Font.BOLD, 14));
        back.addActionListener(this);
        p1.add(back);


        setVisible(true);
    }
    public static void main(String[] args) {

        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create){
            String username = fill_username.getText();
            String name = fill_name.getText();
            String password = fill_password.getText();
            String question = security.getSelectedItem();
            String answer = fill_answer.getText();

            String query = "insert into account values('"+ username + "', '"+ name + "', '"+ password +"', '"+ question +"', '"+ answer +"')";
            try{
                Conn connection = new Conn();
                connection.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login();
            } catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

}
