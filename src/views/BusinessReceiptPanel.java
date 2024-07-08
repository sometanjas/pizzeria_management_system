package src.views;

import src.controllers.FrameManager;
import src.ingredient.IngredientOrderItem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BusinessReceiptPanel extends JPanel {

    private FrameManager frameManager;
    private JLabel companyLabel = new JLabel("Business Receipt");
    private JButton backButton = new JButton("Zurück zum Hauptmenü");

    private DefaultTableModel tableModel = new DefaultTableModel();

    public BusinessReceiptPanel(FrameManager frameManager) {
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

