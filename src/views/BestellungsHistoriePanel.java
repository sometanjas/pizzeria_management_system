package src.views;

import src.controllers.FrameManager;
import src.storage.order.OrderDaoDbImpl;
import src.storage.order.OrderRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BestellungsHistoriePanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Bestellungshistorie");

    private JButton backButton = new JButton("Zurueck");

    public BestellungsHistoriePanel(FrameManager frameManager) {

        super();
        this.frameManager = frameManager;

        // Layout setup

        setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.add(companyLabel);
        panel.add(backButton);
        panel.setVisible(true);
        companyLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        add(panel);


        String[] header = new String[]{
                "Order ID", "Sum", "Lieferung", "Address", "Floor", "PLZ", "Telefon", "First Name", "Second Name"
        };
        List<OrderRecord> allOrders = OrderDaoDbImpl.getInstance().getAllOrders();
        DefaultTableModel model = new DefaultTableModel(header, allOrders.size());
        for (OrderRecord o : allOrders) {
            Object[] rowData = {o.getOrderID(), o.getSum(), o.isLieferung(), o.getAddress(), o.getFloor(), o.getPlz(), o.getTelefon(), o.getFirstname(), o.getSecondname()};
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPan = new JScrollPane(table);
        add(scrollPan);


        // To-Do
//        CustomerDao customerDao = new CustomerDaoDbImpl();
//        List<Customer> customerList = customerDao.getAllCustomer();
//        for (Person p : persons) {
//            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Age: " + p.getAge());
//        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }
}