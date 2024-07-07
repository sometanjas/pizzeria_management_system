package src.views;

import src.controllers.FrameManager;
import src.storage.order.OrderDaoDbImpl;
import src.storage.order.OrderRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BestellungsHistoriePanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Bestellungshistorie");

    private JButton backButton = new JButton("Zurück");
    private DefaultTableModel tableModel = new DefaultTableModel();

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


        this.refreshData();

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
    }

    public void refreshData() {
        String[] header = new String[]{
                "Order ID", "Sum", "Lieferung", "Address", "Floor", "PLZ", "Telefon", "First Name", "Second Name"
        };
        this.tableModel.setDataVector(new Object[][]{}, header);
        List<OrderRecord> allOrders = OrderDaoDbImpl.getInstance().getAllOrders();
        for (OrderRecord o : allOrders) {
            Object[] rowData = {o.getOrderID(), o.getSum(), o.isLieferung(), o.getAddress(), o.getFloor(), o.getPlz(), o.getTelefon(), o.getFirstname(), o.getSecondname()};
            tableModel.addRow(rowData);
        }
    }
}