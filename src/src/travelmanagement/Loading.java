package travelmanagement;

import javax.swing.*;
import java.awt.*;


public class Loading extends JFrame implements Runnable {
    String username;
    Thread t;
    JProgressBar bar;
    Loading(String username){
        this.username = username;
        t = new Thread(this);

        setBounds(500,200,640,250);
        getContentPane().setBackground(Color.white);
        setLayout(null);


        // Label travel
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.orange);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait....");
        loading.setBounds(200,140,600,40);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(loading);

        JLabel label_username = new JLabel("Welcome " + username.toUpperCase());
        label_username.setBounds(20,160,600,40);
        label_username.setForeground(Color.orange);
        label_username.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label_username);

        t.start();
        setVisible(true);

    }

    public static void main(String[] args) {
        new Loading("");
    }

    @Override
    public void run() {
        try{
            for (int i = 1; i<= 101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max){
                    bar.setValue(bar.getValue() + 1);
                }else {
                    setVisible(false);
                    // new class object
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
