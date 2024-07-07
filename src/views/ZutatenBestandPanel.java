package src.views;

import src.controllers.FrameManager;
import src.controllers.ZutatenBestandPanelController;
import src.ingredient.Ingredient;
import src.storage.order.OrderDaoDbImpl;
import src.storage.order.OrderRecord;
import src.storage.transactions.TransactionRecord;
import src.storage.transactions.TransactionsDaoDbImpl;
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

    private JTextField tomatoQty = new JTextField(15);
    private JTextField salmoneQty = new JTextField(15);
    private JTextField schinkenQty = new JTextField(15);
    private JTextField tonnoQty = new JTextField(15);
    private JTextField onionQty = new JTextField(15);
    private JTextField doughQty = new JTextField(15);

    private JLabel wrongInput = new JLabel("");

    public ZutatenBestandPanel(FrameManager frameManager) {

        super(new BorderLayout());
        this.frameManager = frameManager;
        setBackground(Color.WHITE);

        companyLabel.setFont(new Font("SansSerif", Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 600, 50, 600));
        setBackground(Color.WHITE);

        this.refreshData();

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        tomatoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tomatoQty.setAlignmentX(Component.CENTER_ALIGNMENT);
        salmoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        salmoneQty.setAlignmentX(Component.CENTER_ALIGNMENT);
        schinkenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        schinkenQty.setAlignmentX(Component.CENTER_ALIGNMENT);
        tonnoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tonnoQty.setAlignmentX(Component.CENTER_ALIGNMENT);
        onionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        onionQty.setAlignmentX(Component.CENTER_ALIGNMENT);
        doughLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        doughQty.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(tomatoLabel);
        panel.add(tomatoQty);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(salmoneLabel);
        panel.add(salmoneQty);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(schinkenLabel);
        panel.add(schinkenQty);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tonnoLabel);
        panel.add(tonnoQty);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(onionLabel);
        panel.add(onionQty);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(doughLabel);
        panel.add(doughQty);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(bestellenButton);
        panel.add(wrongInput);

        // Panel for kill switch button
        JPanel killSwitchPanel = new JPanel(new BorderLayout());
        killSwitchPanel.setBackground(Color.WHITE);
        killSwitchPanel.add(killSwitchButton, BorderLayout.WEST);

        add(companyLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(killSwitchPanel, BorderLayout.SOUTH);



        killSwitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });
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
    }
}
