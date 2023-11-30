package travelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ShowData extends JFrame implements ActionListener {

    ShowData(String username) {
        setBounds(100,20,1300,800);

        JTabbedPane tab = new JTabbedPane();

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        // image gold package
        DefaultPieDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createPieChart("Package Booking Percentage", dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(300,100,700,500);
        p1.add(chartPanel, BorderLayout.CENTER);

        tab.addTab("Data of Package", null, p1);
        add(tab);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);

        // image gold package
        DefaultPieDataset dataset1 = createdatahotel();
        JFreeChart chart1 = ChartFactory.createPieChart("Hotel Booking Percentage", dataset1, true, true, false);
        ChartPanel chartPanel1 = new ChartPanel(chart1  );
        chartPanel1.setBounds(300,100,700,500);
        p2.add(chartPanel1  , BorderLayout.CENTER);

        tab.addTab("Data of Hotel", null, p2);
        add(tab);

        setVisible(true);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int goldCount = 0, silverCount = 0, bronzeCount = 0;

        try {
            Conn connection = new Conn();
            String query = "select * from bookpackage";
            ResultSet resultSet = connection.statement.executeQuery(query);

            while (resultSet.next()) {
                String packageType = resultSet.getString("package");

                switch (packageType) {
                    case "Gold Package":
                        goldCount++;
                        break;
                    case "Silver Package":
                        silverCount++;
                        break;
                    case "Bronze Package":
                        bronzeCount++;
                        break;

                }
            }

            dataset.setValue("Gold Package", goldCount);
            dataset.setValue("Silver Package", silverCount);
            dataset.setValue("Bronze Package", bronzeCount);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private DefaultPieDataset createdatahotel() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int hotel1 = 0, hotel2 = 0, hotel3 = 0, hotel4 = 0, hotel5 = 0, hotel6 = 0, hotel7 = 0, hotel8 = 0, hotel9 = 0;

        try {
            Conn connection = new Conn();
            String query = "select * from bookhotel";
            ResultSet resultSet = connection.statement.executeQuery(query);

            while (resultSet.next()) {
                String packageType = resultSet.getString("name");

                switch (packageType) {
                    case "Ring Boutique Hotel SiemReap":
                        hotel1++;
                        break;
                    case "La Residence WatBo":
                        hotel2++;
                        break;
                    case "Central Suite Residence":
                        hotel3++;
                        break;
                    case "Lub D":
                        hotel4++;
                        break;
                    case "Angkor Land Urban Boutique":
                        hotel5++;
                        break;
                    case "Aroma Angkor Boutique":
                        hotel6++;
                        break;
                    case "The Rabbit Hole Hotel & Spa":
                        hotel7++;
                        break;
                    case "Araya Angkor Residence":
                        hotel8++;
                        break;
                    case "Ladear Privilege Angkor":
                        hotel9++;
                        break;

                }
            }

            dataset.setValue("Ring Boutique Hotel SiemReap", hotel1);
            dataset.setValue("La Residence WatBo", hotel2);
            dataset.setValue("Central Suite Residence", hotel3);
            dataset.setValue("Lub D", hotel4);
            dataset.setValue("Angkor Land Urban Boutique", hotel5);
            dataset.setValue("Aroma Angkor Boutique", hotel6);
            dataset.setValue("The Rabbit Hole Hotel & Spa", hotel7);
            dataset.setValue("Araya Angkor Residence", hotel8);
            dataset.setValue("Ladear Privilege Angkor", hotel9);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static void main(String[] args) {
        new ShowData("kimhak");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
}
