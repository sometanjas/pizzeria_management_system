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
    private JLabel companyLabel = new JLabel("Customer Receipt");
    private JButton backButton = new JButton("Zurück zum Hauptmenü");

    private DefaultTableModel tableModel = new DefaultTableModel();

    public CustomerReceiptPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;

        // Header
        companyLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        companyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(companyLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Table
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Panel to center the table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.add(Box.createVerticalGlue());
        scrollPane.setMaximumSize(new Dimension(600, 400));  // Set preferred size for the scroll pane
        scrollPane.setPreferredSize(new Dimension(600, 400)); // Set maximum size for the scroll pane
        tablePanel.add(scrollPane);
        tablePanel.add(Box.createVerticalGlue());

        add(tablePanel, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        footerPanel.setBackground(Color.WHITE);
        footerPanel.add(backButton);
        add(footerPanel, BorderLayout.SOUTH);

        // ActionListener
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });

        // Initial Data Load
        this.refreshData();
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

