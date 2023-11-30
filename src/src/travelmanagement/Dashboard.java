//package travelmanagement;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Dashboard extends JFrame implements ActionListener {
//
//    JButton add_Personal_detail, view_personal_detail, update_personal_detail, check_package, book_package,
//            view_package, view_hotel, destination, book_hotel, view_book_hotel, payment, calculator, notedpad,
//            about, show_data, delete_personal_detail ;
//    String username;
//    Dashboard(String username){
//
//        this.username = username;
////        setBounds(0,0,1600,1000);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setLayout(null);
//
//
//        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("image/cambodia.jpg"));
//        Image background2 = background.getImage().getScaledInstance(1810, 1100, Image.SCALE_DEFAULT);
//        ImageIcon background3 = new ImageIcon(background2);
//        JLabel backGround = new JLabel(background3);
//        backGround.setBounds(0,0,1810,1000);
//        add(backGround);
//
//        JPanel p1 = new JPanel();
//        p1.setLayout(null);
//        p1.setBackground(new Color(255, 183, 107));
//        p1.setBounds(0,0,1600,65);
//        backGround.add(p1);
//
//        JLabel heading = new JLabel("Dashboard");
//        heading.setBounds(90,10,300,40);
//        heading.setFont(new Font("Tahoma",Font.BOLD,30));
//        heading.setForeground(Color.white);
//        p1.add(heading);
//
//        ImageIcon dasboard1 = new ImageIcon(ClassLoader.getSystemResource("image/dashboard.png"));
//        Image dasboard2 = dasboard1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
//        ImageIcon dasboard3 = new ImageIcon(dasboard2);
//        JLabel icon = new JLabel(dasboard3);
//        icon.setBounds(5,0,70,70);
//        heading.setIcon(dasboard3);
//
//
//        add_Personal_detail = new JButton();
//        add_Personal_detail.setBounds(95, 100, 300, 150);
//        add_Personal_detail.setBackground(new Color(173, 216, 230));
//        add_Personal_detail.addActionListener(this);
//        backGround.add(add_Personal_detail);
//
//// Create an ImageIcon and set it as HTML content for the button
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/addpersonal.png"));
//        Image i2 = i1.getImage().getScaledInstance(280, 140, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        add_Personal_detail.setIcon(i3);
//
//        // Set alignment to center for both text and icon
////        add_Personal_detail.setHorizontalAlignment(SwingConstants.CENTER);
////        add_Personal_detail.setVerticalAlignment(SwingConstants.BOTTOM);
//
//        // Update personal detail
//        update_personal_detail = new JButton();
//        update_personal_detail.setBounds(445, 100, 300, 150);
//        update_personal_detail.setBackground(new Color(173, 216, 230));
//        update_personal_detail.addActionListener(this);
//        backGround.add(update_personal_detail);
//
//// Create an ImageIcon and set it as HTML content for the button
//        ImageIcon update = new ImageIcon(ClassLoader.getSystemResource("image/updatepersonal.png"));
//        Image update_person = update.getImage().getScaledInstance(280, 150, Image.SCALE_DEFAULT);
//        ImageIcon update_person_detailimg = new ImageIcon(update_person);
//        update_personal_detail.setIcon(update_person_detailimg);
//
//        //  view person detail
//        view_personal_detail = new JButton();
//        view_personal_detail.setBounds(785, 100, 300, 150);
//        view_personal_detail.setBackground(new Color(173, 216, 230));
//        view_personal_detail.addActionListener(this);
//        backGround.add(view_personal_detail);
//
//        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon view = new ImageIcon(ClassLoader.getSystemResource("image/viewdetail.png"));
//        Image view_person = view.getImage().getScaledInstance(200, 140, Image.SCALE_DEFAULT);
//        ImageIcon view_person_detailimg = new ImageIcon(view_person);
//        view_personal_detail.setIcon(view_person_detailimg);
//
//        //  delete person detail
//        delete_personal_detail = new JButton();
//        delete_personal_detail.setBounds(1125, 100, 300, 150);
//        delete_personal_detail.setBackground(new Color(173, 216, 230));
//        delete_personal_detail.addActionListener(this);
//        backGround.add(delete_personal_detail);
//
//        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon delete = new ImageIcon(ClassLoader.getSystemResource("image/deletepersonal.png"));
//        Image delete_person = delete.getImage().getScaledInstance(290, 150, Image.SCALE_DEFAULT);
//        ImageIcon delete_person_detailimg = new ImageIcon(delete_person);
//        delete_personal_detail.setIcon(delete_person_detailimg);
//
//        // Check package
//        check_package = new JButton();
//        check_package.setBounds(95, 280, 300, 150);
//        check_package.setBackground(new Color(173, 216, 230));
//        check_package.addActionListener(this);
//        backGround.add(check_package);
//
//// Create an ImageIcon and set it as HTML content for the button
//        ImageIcon check_package1 = new ImageIcon(ClassLoader.getSystemResource("image/checkpackage.png"));
//        Image check_package2 = check_package1.getImage().getScaledInstance(270, 130, Image.SCALE_DEFAULT);
//        ImageIcon check_package3 = new ImageIcon(check_package2);
//        check_package.setIcon(check_package3);
//
//        // book package
//        book_package = new JButton();
//        book_package.setBounds(445, 280, 300, 150);
//        book_package.setBackground(new Color(173, 216, 230));
//        book_package.addActionListener(this);
//        backGround.add(book_package);
//
//// Create an ImageIcon and set it as HTML content for the button
//        ImageIcon book_package1 = new ImageIcon(ClassLoader.getSystemResource("image/bookpackage.png"));
//        Image book_package2 = book_package1.getImage().getScaledInstance(270, 130, Image.SCALE_DEFAULT);
//        ImageIcon book_package3 = new ImageIcon(book_package2);
//        book_package.setIcon(book_package3);
//
//        //  View Package
//        view_package = new JButton();
//        view_package.setBounds(785, 280, 300, 150);
//        view_package.setBackground(new Color(173, 216, 230));
//        view_package.addActionListener(this);
//        backGround.add(view_package);
//
//        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon view_package1 = new ImageIcon(ClassLoader.getSystemResource("image/viewpackage.png"));
//        Image view_package2 = view_package1.getImage().getScaledInstance(240, 140, Image.SCALE_DEFAULT);
//        ImageIcon view_package3 = new ImageIcon(view_package2);
//        view_package.setIcon(view_package3);
//
//        // View Hotel
//        view_hotel = new JButton();
//        view_hotel.setBounds(1125, 280, 300, 150);
//        view_hotel.setBackground(new Color(173, 216, 230));
//        view_hotel.addActionListener(this);
//        backGround.add(view_hotel);
//
//        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon view_hotel1 = new ImageIcon(ClassLoader.getSystemResource("image/checkhotel.png"));
//        Image view_hotel2 = view_hotel1.getImage().getScaledInstance(200, 140, Image.SCALE_DEFAULT);
//        ImageIcon view_hotel3 = new ImageIcon(view_hotel2);
//        view_hotel.setIcon(view_hotel3);
//
//        // Book hotel
//        book_hotel = new JButton();
//        book_hotel.setBounds(95, 460, 300, 150);
//        book_hotel.setBackground(new Color(173, 216, 230));
//        book_hotel.addActionListener(this);
//        backGround.add(book_hotel);
//
//// Create an ImageIcon and set it as HTML content for the button
//        ImageIcon book_hotel1 = new ImageIcon(ClassLoader.getSystemResource("image/bookhotel.png"));
//        Image book_hotel2 = book_hotel1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
//        ImageIcon book_hotel3 = new ImageIcon(book_hotel2);
//        book_hotel.setIcon(book_hotel3);
//
//        // view booked hotel
//        view_book_hotel = new JButton();
//        view_book_hotel.setBounds(445, 460, 300, 150);
//        view_book_hotel.setBackground(new Color(173, 216, 230));
//        view_book_hotel.addActionListener(this);
//        backGround.add(view_book_hotel);
//
//// Create an ImageIcon and set it as HTML content for the button
//        ImageIcon view_book_hotel1 = new ImageIcon(ClassLoader.getSystemResource("image/viewbookedhotel.png"));
//        Image view_book_hotel2 = view_book_hotel1.getImage().getScaledInstance(280, 150, Image.SCALE_DEFAULT);
//        ImageIcon view_book_hotel3 = new ImageIcon(view_book_hotel2);
//        view_book_hotel.setIcon(view_book_hotel3);
//
//        //  destination
//        destination = new JButton();
//        destination.setBounds(785, 460, 300, 150);
//        destination.setBackground(new Color(173, 216, 230));
//        destination.addActionListener(this);
//        backGround.add(destination);
//
//        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon destination1 = new ImageIcon(ClassLoader.getSystemResource("image/destination.png"));
//        Image destination2 = destination1.getImage().getScaledInstance(180, 140, Image.SCALE_DEFAULT);
//        ImageIcon destination3 = new ImageIcon(destination2);
//        destination.setIcon(destination3);
//
//        // payment
//        payment = new JButton();
//        payment.setBounds(1125, 460, 300, 150);
//        payment.setBackground(new Color(173, 216, 230));
//        payment.addActionListener(this);
//        backGround.add(payment);
//
//        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon payment1 = new ImageIcon(ClassLoader.getSystemResource("image/payment.png"));
//        Image payment2 = payment1.getImage().getScaledInstance(150, 120, Image.SCALE_DEFAULT);
//        ImageIcon payment3 = new ImageIcon(payment2);
//        payment.setIcon(payment3);
//
//        // calculator
//        calculator = new JButton();
//        calculator.setBounds(95, 630, 300, 150);
//        calculator.setBackground(new Color(173, 216, 230));
//        calculator.addActionListener(this);
//        backGround.add(calculator);
////
////// Create an ImageIcon and set it as HTML content for the button
//        ImageIcon calculator1 = new ImageIcon(ClassLoader.getSystemResource("image/calculator.png"));
//        Image calculator2 = calculator1.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT);
//        ImageIcon calculator3 = new ImageIcon(calculator2);
//        calculator.setIcon(calculator3);
////
////        //  notedpad
//        notedpad = new JButton();
//        notedpad.setBounds(445, 630, 300, 150);
//        notedpad.setBackground(new Color(173, 216, 230));
//        notedpad.addActionListener(this);
//        backGround.add(notedpad);
////
////        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon notedpad1 = new ImageIcon(ClassLoader.getSystemResource("image/notedpad.png"));
//        Image notedpad2 = notedpad1.getImage().getScaledInstance(140, 130, Image.SCALE_DEFAULT);
//        ImageIcon notedpad3 = new ImageIcon(notedpad2);
//        notedpad.setIcon(notedpad3);
////
////        // about
//        about = new JButton();
//        about.setBounds(785, 630, 300, 150);
//        about.setBackground(new Color(173, 216, 230));
//        about.addActionListener(this);
//        backGround.add(about);
////
////        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon about1 = new ImageIcon(ClassLoader.getSystemResource("image/about.png"));
//        Image about2 = about1.getImage().getScaledInstance(110, 130, Image.SCALE_DEFAULT);
//        ImageIcon about3 = new ImageIcon(about2);
//        about.setIcon(about3);
//
//        show_data = new JButton();
//        show_data.setBounds(1125, 630, 300, 150);
//        show_data.setBackground(new Color(173, 216, 230));
//        show_data.addActionListener(this);
//        show_data.addActionListener(this);
//        backGround.add(show_data);
////
////        // Create an ImageIcon and set it as HTML content for the button
//        ImageIcon show1 = new ImageIcon(ClassLoader.getSystemResource("image/showdata.png"));
//        Image show2 = show1.getImage().getScaledInstance(130, 150, Image.SCALE_DEFAULT);
//        ImageIcon show3 = new ImageIcon(show2);
//        show_data.setIcon(show3);
//
//
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new Dashboard("");
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == add_Personal_detail){
//            new AddCustomer(username);
//        } else if (ae.getSource() == view_personal_detail) {
//            new ViewCustomer(username);
//        } else if (ae.getSource() == update_personal_detail) {
//            new UpdateCustomer(username);
//        } else if (ae.getSource() == check_package) {
//            new CheckPackage();
//        } else if (ae.getSource() == book_package) {
//            new BookPackage(username);
//        } else if (ae.getSource() == view_package) {
//            new ViewPackage(username);
//        } else if (ae.getSource() == view_hotel) {
//            new CheckHotel();
//        } else if (ae.getSource() == destination) {
//            new Destination();
//        } else if (ae.getSource() == book_hotel) {
//            new BookHotel(username);
//        } else if (ae.getSource() == view_book_hotel) {
//            new ViewBookedHotel(username);
//        } else if (ae.getSource() == payment) {
//            new Payment();
//        } else if (ae.getSource() == calculator) {
//            try{
//                Runtime.getRuntime().exec("calc.exe");
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == notedpad) {
//            try{
//                Runtime.getRuntime().exec("notepad.exe");
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == about) {
//            new About();
//        } else if (ae.getSource() == delete_personal_detail) {
//            new DeletePersonalDetail(username);
//        } else if (ae.getSource() == show_data) {
//            new ShowData(username);
//        }
//    }
//}
