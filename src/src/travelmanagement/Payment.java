package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    JButton pay, back;

    Payment(){
        setBounds(500,200,800,600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/imagepayment.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        pay = new JButton("Pay");
        pay.setBounds(500,20,80,40);
        pay.setBackground(Color.ORANGE);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(600,20,80,40);
        back.setBackground(Color.ORANGE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay){
            setVisible(false);
            new Paymt();
        }else{
            setVisible(false);
        }
    }
}
