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

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        leftPanel.add(tomatoLabel);
        leftPanel.add(tomatoQty);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(salmoneLabel);
        leftPanel.add(salmoneQty);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(schinkenLabel);
        leftPanel.add(schinkenQty);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(tonnoLabel);
        leftPanel.add(tonnoQty);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(onionLabel);
        leftPanel.add(onionQty);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(doughLabel);
        leftPanel.add(doughQty);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(bestellenButton);
        leftPanel.add(wrongInput);

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel killSwitchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        killSwitchPanel.setBackground(Color.WHITE);
        killSwitchPanel.add(killSwitchButton);

        add(companyLabel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
        add(killSwitchPanel, BorderLayout.SOUTH);

        killSwitchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameManager.showMainView();
            }
        });

        this.refreshData();
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
