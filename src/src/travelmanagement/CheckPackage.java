package travelmanagement;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage(){
        setBounds(100,20,1300,800);

        JTabbedPane tab = new JTabbedPane();

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        // image gold package
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/goldpackage.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 630, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, -13, 1300, 900);
        p1.add(image);

        JLabel label = new JLabel("Gold Package");
        label.setBounds(500,8,450,100);
        label.setForeground(new Color(255, 183, 107));
        label.setFont(new Font("Tahoma", Font.BOLD, 45));
        p1.add(label);
        tab.addTab("Package 1", null, p1);
        add(tab);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);

        ImageIcon silver1 = new ImageIcon(ClassLoader.getSystemResource("image/silverpackage.png"));
        Image silver2 = silver1.getImage().getScaledInstance(900, 630, Image.SCALE_SMOOTH);
        ImageIcon silver3 = new ImageIcon(silver2);
        JLabel image1 = new JLabel(silver3);
        image1.setBounds(10, -13, 1300, 900);
        p2.add(image1);

        JLabel label2 = new JLabel("Silver Package");
        label2.setBounds(500,8,450,100);
        label2.setForeground(new Color(255, 183, 107));
        label2.setFont(new Font("Tahoma", Font.BOLD, 45));
        p2.add(label2);
        tab.addTab("Package 2", null, p2);
        add(tab);

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.white);

        ImageIcon bronze1 = new ImageIcon(ClassLoader.getSystemResource("image/bronzepackage.png"));
        Image bronze2 = bronze1.getImage().getScaledInstance(900, 630, Image.SCALE_SMOOTH);
        ImageIcon bronze3 = new ImageIcon(bronze2);
        JLabel image2 = new JLabel(bronze3);
        image2.setBounds(10, -13, 1300, 900);
        p3.add(image2);

        JLabel label3 = new JLabel("Bronze Package");
        label3.setBounds(500,8,450,100);
        label3.setForeground(new Color(255, 183, 107));
        label3.setFont(new Font("Tahoma", Font.BOLD, 45));
        p3.add(label3);
        tab.addTab("Package 3", null, p3);
        add(tab);



        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
