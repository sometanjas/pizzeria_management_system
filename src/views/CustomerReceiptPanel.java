package src.views;

import src.controllers.FrameManager;
import src.model.Order;
import src.model.OrderItem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerReceiptPanel extends JPanel {
    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("CustomerReceipt");
    private JButton backButton = new JButton("Zurueck zum Hauptmenu");

    private DefaultTableModel tableModel = new DefaultTableModel();

    public CustomerReceiptPanel(FrameManager frameManager) {

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
                "Name", "Quantity", "Price"
        };
        this.tableModel.setDataVector(new Object[][]{}, header);

        int totalPrice = 0;
        int totalQty = 0;
        for (OrderItem item : Order.getInstance().getItems()) {
            String name = item.getPizza().getName();
            int price = item.getPizza().getPrice();
            int qty = item.getQuantity();

            Object[] rowData = {name, qty, price};
            tableModel.addRow(rowData);
            totalPrice += price;
            totalQty += qty;
        }
        Object[] rowData = {"Total", totalQty, totalPrice};
        tableModel.addRow(rowData);
    }
}

