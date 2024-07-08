package src.views;

import src.controllers.FrameManager;
import src.controllers.ZutatenBestandPanelController;
import src.ingredient.Ingredient;
import src.storage.warehouse.WarehouseDaoDbImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ZutatenBestandPanel extends JPanel {
    private FrameManager frameManager;

    private DefaultTableModel tableModel = new DefaultTableModel();

    private JLabel companyLabel = new JLabel("Zutaten-Bestellen", SwingConstants.CENTER);
    private JButton bestellenButton = new JButton("Bestellen");
    private JButton killSwitchButton = new JButton("Zurück");

    private JLabel tomatoLabel = new JLabel("Tomaten: 5 Euro / 1 kg");
    private JLabel salmoneLabel = new JLabel("Salmone: 20 Euro / 1 kg");
    private JLabel schinkenLabel = new JLabel("Schinken: 12 Euro / 1 kg");
    private JLabel tonnoLabel = new JLabel("Tonno: 12 Euro / 1 kg");
    private JLabel onionLabel = new JLabel("Onion: 5 Euro / 1 kg");
    private JLabel doughLabel = new JLabel("Dough: 4 Euro / 1 kg");
    private JLabel cheeseLabel = new JLabel("Cheese: 5 Euro / 1 kg");

    private JTextField tomatoQty = new JTextField(5);
    private JTextField salmoneQty = new JTextField(5);
    private JTextField schinkenQty = new JTextField(5);
    private JTextField tonnoQty = new JTextField(5);
    private JTextField onionQty = new JTextField(5);
    private JTextField doughQty = new JTextField(5);
    private JTextField cheeseQty = new JTextField(5);

    private JLabel wrongInput = new JLabel("");

    public ZutatenBestandPanel(FrameManager frameManager) {
        super(new BorderLayout());
        this.frameManager = frameManager;
        setBackground(Color.WHITE);

        companyLabel.setFont(new Font("SansSerif", Font.BOLD, 30));

        // Center Panel for ingredients and input fields
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 100, 10));

        // Add labels and text fields to center panel
        addIngredientRow(centerPanel, tomatoLabel, tomatoQty);
        addIngredientRow(centerPanel, salmoneLabel, salmoneQty);
        addIngredientRow(centerPanel, schinkenLabel, schinkenQty);
        addIngredientRow(centerPanel, tonnoLabel, tonnoQty);
        addIngredientRow(centerPanel, onionLabel, onionQty);
        addIngredientRow(centerPanel, doughLabel, doughQty);
        addIngredientRow(centerPanel, cheeseLabel, cheeseQty);

        // "Bestellen" button and error message
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(bestellenButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(wrongInput);

        // Align components to center
        bestellenButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        wrongInput.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(companyLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        // Table Panel for showing ingredients
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(200, 100));  // Adjust the size of the table

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(scrollPane, BorderLayout.CENTER);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 50, 400)); // Border to add some space

        // Footer Panel for the back button
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        footerPanel.setBackground(Color.WHITE);
        footerPanel.add(killSwitchButton);
        add(footerPanel, BorderLayout.SOUTH);

        // Wrapper panel to hold both centerPanel and rightPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(centerPanel);
        mainPanel.add(Box.createHorizontalStrut(20)); // Add some space between panels
        mainPanel.add(rightPanel);

        add(mainPanel, BorderLayout.CENTER);

        killSwitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });

        this.refreshData();
    }

    private void addIngredientRow(JPanel panel, JLabel label, JTextField textField) {
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
        row.setBackground(Color.WHITE);
        row.add(Box.createHorizontalGlue());
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        row.add(label);
        row.add(Box.createRigidArea(new Dimension(10, 0)));
        textField.setMaximumSize(new Dimension(100, 20)); // Smaller text fields
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        row.add(textField);
        row.add(Box.createHorizontalGlue());
        panel.add(row);
        panel.add(Box.createVerticalStrut(10));
    }

    public JLabel getWrongInput() {
        return wrongInput;
    }

    public void addBestellenButtonController(ZutatenBestandPanelController controller) {
        bestellenButton.addActionListener(controller);
    }

    public JTextField getTonnoQty() {
        return tonnoQty;
    }

    public JTextField getSchinkenQty() {
        return schinkenQty;
    }

    public JTextField getSalmoneQty() {
        return salmoneQty;
    }

    public JTextField getOnionQty() {
        return onionQty;
    }

    public JTextField getDoughQty() {
        return doughQty;
    }

    public JTextField getTomatoQty() {
        return tomatoQty;
    }

    public JTextField getCheeseQty() {
        return cheeseQty;
    }

    public void refreshData() {
        String[] header = new String[]{
                "Zutaten", "Value"
        };
        this.tableModel.setDataVector(new Object[][]{}, header);
        List<Ingredient> availableIngrs = WarehouseDaoDbImpl.getInstance().getAllIngredients();
        for (Ingredient i : availableIngrs) {
            Object[] rowData = {i.getName(), i.getValue()};
            tableModel.addRow(rowData);
        }

        tomatoQty.setText("");
        salmoneQty.setText("");
        schinkenQty.setText("");
        tonnoQty.setText("");
        onionQty.setText("");
        doughQty.setText("");
        cheeseQty.setText("");
    }
}


