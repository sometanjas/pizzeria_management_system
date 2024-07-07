package src.controllers;

import src.ingredient.IngredientOrderItem;
import src.views.*;

import javax.swing.*;
import java.util.List;

public class FrameManager {
    private JFrame frame;
    private LoginView loginView;
    private MainMenuPanel mainMenuPanel;
    private BestellungsHistoriePanel bestellungsHistoriePanel;
    private BookkeepingPanel bookkeepingPanel;
    private BusinessReceiptPanel businessReceiptPanel;
    private CustomerReceiptPanel customerReceiptPanel;
    private DeliveryDataPanel deliveryDataPanel;
    private PLZPanel plzPanel;
    private PLZErrorPanel plzErrorPanel;
    private QuestionDeliveryPanel questionDeliveryPanel;
    private SpeisekartePanel speisekartePanel;
    private ZutatenBestandPanel zutatenBestandPanel;
    private ZutatenCheckerPanel zutatenCheckerPanel;
    private PickupDataPanel pickupDataPanel;


    public FrameManager() {
        this.frame = new JFrame("Pizza Management System");
    }

    public void initialize(LoginView loginView,
                           MainMenuPanel mainMenuPanel,
                           BestellungsHistoriePanel bestellungsHistoriePanel,
                           BookkeepingPanel bookkeepingPanel,
                           BusinessReceiptPanel businessReceiptPanel,
                           CustomerReceiptPanel customerReceiptPanel,
                           DeliveryDataPanel deliveryDataPanel,
                           PLZPanel plzPanel, PLZErrorPanel plzErrorPanel,
                           QuestionDeliveryPanel questionDeliveryPanel,
                           SpeisekartePanel speisekartePanel,
                           ZutatenBestandPanel zutatenBestandPanel,
                           ZutatenCheckerPanel zutatenCheckerPanel,
                           PickupDataPanel pickupDataPanel) {
        this.loginView = loginView;
        this.mainMenuPanel = mainMenuPanel;
        this.bestellungsHistoriePanel = bestellungsHistoriePanel;
        this.bookkeepingPanel = bookkeepingPanel;
        this.businessReceiptPanel = businessReceiptPanel;
        this.customerReceiptPanel = customerReceiptPanel;
        this.deliveryDataPanel = deliveryDataPanel;
        this.plzPanel = plzPanel;
        this.plzErrorPanel = plzErrorPanel;
        this.questionDeliveryPanel = questionDeliveryPanel;
        this.speisekartePanel = speisekartePanel;
        this.zutatenBestandPanel = zutatenBestandPanel;
        this.zutatenCheckerPanel = zutatenCheckerPanel;
        this.pickupDataPanel = pickupDataPanel;

        this.frame.setSize(1500, 500);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setAllInvisible();

        this.loginView.setVisible(true);
        this.frame.getContentPane().add(this.loginView);

        this.frame.setVisible(true);
    }

    public void showMainView() {
        this.setAllInvisible();
        this.mainMenuPanel.setVisible(true);
        this.frame.getContentPane().add(this.mainMenuPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showQuestionDelivery() {
        this.setAllInvisible();
        this.questionDeliveryPanel.setVisible(true);
        this.frame.getContentPane().add(this.questionDeliveryPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showBestellungsHistorie() {
        this.setAllInvisible();
        this.bestellungsHistoriePanel.refreshData();
        this.bestellungsHistoriePanel.setVisible(true);
        this.frame.getContentPane().add(this.bestellungsHistoriePanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showBookkeeping() {
        this.setAllInvisible();
        this.bookkeepingPanel.refreshData();
        this.bookkeepingPanel.setVisible(true);
        this.frame.getContentPane().add(this.bookkeepingPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showWarehouse() {
        this.setAllInvisible();
        this.zutatenBestandPanel.setVisible(true);
        this.frame.getContentPane().add(this.zutatenBestandPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showPLZ() {
        this.setAllInvisible();
        this.plzPanel.setVisible(true);
        this.frame.getContentPane().add(this.plzPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showPLZError() {
        this.setAllInvisible();
        this.plzErrorPanel.setVisible(true);
        this.frame.getContentPane().add(this.plzErrorPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showSpeisekarte() {
        this.setAllInvisible();
        this.speisekartePanel.setVisible(true);
        this.frame.getContentPane().add(this.speisekartePanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showDeliveryData() {
        this.setAllInvisible();
        this.deliveryDataPanel.setVisible(true);
        this.frame.getContentPane().add(this.deliveryDataPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showCustomerReceipt() {
        this.setAllInvisible();
        this.customerReceiptPanel.refreshData();
        this.customerReceiptPanel.setVisible(true);
        this.frame.getContentPane().add(this.customerReceiptPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showZutatenCheckerPanel() {
        this.setAllInvisible();
        this.zutatenCheckerPanel.setVisible(true);
        this.frame.getContentPane().add(this.zutatenCheckerPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }


    public void showBusinessReceiptPanel(List<IngredientOrderItem> items) {
        this.setAllInvisible();
        this.businessReceiptPanel.refreshData(items);
        this.businessReceiptPanel.setVisible(true);
        this.frame.getContentPane().add(this.businessReceiptPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showLogin() {
        this.setAllInvisible();
        this.loginView.setVisible(true);
        this.frame.getContentPane().add(this.loginView);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void showPickup() {
        this.setAllInvisible();
        this.pickupDataPanel.setVisible(true);
        this.frame.getContentPane().add(this.pickupDataPanel);
        this.frame.revalidate();
        this.frame.repaint();
    }


    private void setAllInvisible() {
        this.frame.getContentPane().invalidate();
        this.loginView.setVisible(false);
        this.mainMenuPanel.setVisible(false);
        this.bestellungsHistoriePanel.setVisible(false);
        this.bookkeepingPanel.setVisible(false);
        this.businessReceiptPanel.setVisible(false);
        this.customerReceiptPanel.setVisible(false);
        this.deliveryDataPanel.setVisible(false);
        this.plzPanel.setVisible(false);
        this.questionDeliveryPanel.setVisible(false);
        this.speisekartePanel.setVisible(false);
        this.zutatenBestandPanel.setVisible(false);
        this.zutatenCheckerPanel.setVisible(false);
        this.pickupDataPanel.setVisible(false);
    }
}
