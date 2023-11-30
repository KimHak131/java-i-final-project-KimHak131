package travelmanagement;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ForgetPassword extends JFrame implements ActionListener {

    JButton search, retrieve, back;
    JTextField fill_username, fill_name, fill_password, fill_question, fill_answer;
    Choice security;
    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Forget Password");
        text.setBounds(120,5,600,40);
        text.setForeground(Color.orange);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

//         set image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/forgetpassword.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 290, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(535,-10,300,350);
        add(image);


        // Panel 1
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(173, 216, 230));
        p1.setLayout(null);
        p1.setBounds(30,50,500,280);
        add(p1);

        // username label
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,25);
        username.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(username);

        // fill username
        fill_username = new JTextField();
        fill_username.setBounds(220,20,150,25);
        fill_username.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_username);

        // search
        search = new JButton("Search");
        search.setBackground(new Color(255, 183, 107));
        search.setForeground(Color.white);
        search.setBounds(380, 20, 100,25);
        search.addActionListener(this);
        p1.add(search);

        // username label
        JLabel name = new JLabel("Name");
        name.setBounds(40,60,100,25);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(name);

        // fill username
        fill_name = new JTextField();
        fill_name.setBounds(220,60,150,25);
        fill_name.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_name);

        // username label
        JLabel question = new JLabel("Security Question");
        question.setBounds(40,100,100,25);
        question.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(question);

        // fill question
        fill_question = new JTextField();
        fill_question.setBounds(220,100,150,25);
        fill_question.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_question);

        JLabel answer = new JLabel("Answer");
        answer.setBounds(40,140,100,25);
        answer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(answer);

        // fill_answer
        fill_answer = new JTextField();
        fill_answer.setBounds(220,140,150,25);
        fill_answer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_answer);

        // retrieve
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(new Color(255, 183, 107));
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380, 140, 100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        // password label
        JLabel password = new JLabel("Password");
        password.setBounds(40,180,100,25);
        password.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(password);

        // fill password
        fill_password = new JTextField();
        fill_password.setBounds(220,180,150,25);
        fill_password.setBorder(BorderFactory.createEmptyBorder());
        p1.add(fill_password);

        // back button
        back = new JButton("Back");
        back.setBackground(new Color(255, 183, 107));
        back.setForeground(Color.white);
        back.setBounds(200, 230  , 100,25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+ fill_username.getText()+ "' ";
                Conn connection = new Conn();

                ResultSet result = connection.statement.executeQuery(query);
                while (result.next()){
                    fill_name.setText(result.getString("name"));
                    fill_question.setText(result.getString("security"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == retrieve) {
            try{
                String query = "select * from account where answer = '"+ fill_answer.getText()+ "' AND username = '"+ fill_username.getText()+ "'";
                Conn connection = new Conn();

                ResultSet result = connection.statement.executeQuery(query);
                while (result.next()){
                    fill_password.setText(result.getString("password"));

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Login();
        }
    }
}
