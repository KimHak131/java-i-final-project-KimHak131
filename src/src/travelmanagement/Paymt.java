package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paymt extends JFrame implements ActionListener {
    JButton back;
    Paymt() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/paymentcard.png"));
        Image i2 = i1.getImage().getScaledInstance(550, 450, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 10, 750, 600); // Adjusted size to fit the image better
        add(image);

        back = new JButton("Back");
        back.setBounds(20, 20, 80, 40);
        back.setBackground(Color.ORANGE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Paymt();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back){
            setVisible(false);
            new Payment();
        }
    }}

