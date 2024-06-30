package src.views;

import src.controllers.FrameManager;
import src.ingredient.IngredientOrderItem;
import src.model.Order;
import src.model.OrderItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BusinessReceiptPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Business Receipt");
    private JButton backButton = new JButton("Zurueck zum Hauptmenu");

    private DefaultTableModel tableModel = new DefaultTableModel();

    public BusinessReceiptPanel(FrameManager frameManager) {

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

    public void refreshData(List<IngredientOrderItem> items) {
        String[] header = new String[]{
                "Ingredient", "Quantity", "Price"
        };
        this.tableModel.setDataVector(new Object[][]{}, header);

        int totalPrice = 0;
        int totalQty = 0;
        for (IngredientOrderItem item : items) {
            if (item.getQty() == 0) {
                continue;
            }
            Object[] rowData = {item.getName(), item.getQty(), item.getPrice()};
            tableModel.addRow(rowData);
            totalPrice += item.getPrice() * item.getQty();
            totalQty += item.getQty();
        }
        Object[] rowData = {"Total", totalQty, totalPrice};
        tableModel.addRow(rowData);
    }
}

