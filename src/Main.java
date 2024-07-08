package src;

import src.controllers.BookkeepingController;
import src.controllers.FrameManager;
import src.controllers.LoginController;
import src.controllers.ZutatenBestandPanelController;
import src.storage.Migrations;
import src.views.*;

public class Main {
    public static void main(String[] args) {
        // create a controller containing the main frame
        FrameManager frameManager = new FrameManager();
        // Initialize Views
        BestellungsHistoriePanel bestellungsHistoriePanel = new BestellungsHistoriePanel(frameManager);

        // ZutatenBestand & WarehouseChecker (is enough money)
        WarehouseCheckerPanel warehouseCheckerPanel = new WarehouseCheckerPanel(frameManager);
        ZutatenBestandPanel zutatenBestandPanel = new ZutatenBestandPanel(frameManager);
        ZutatenBestandPanelController zutatenBestandPanelController = new ZutatenBestandPanelController(zutatenBestandPanel, frameManager);
        zutatenBestandPanel.addBestellenButtonController(zutatenBestandPanelController);

        // Bookkeeping
        BookkeepingPanel bookkeepingPanel = new BookkeepingPanel(frameManager);
        BookkeepingController bookkeepingController = new BookkeepingController(bookkeepingPanel);
        bookkeepingPanel.addDepositMoneyButtonController(bookkeepingController);

        QuestionDeliveryPanel questionDeliveryPanel = new QuestionDeliveryPanel(frameManager);
        PLZPanel plzPanel = new PLZPanel(frameManager);
        PLZErrorPanel plzErrorPanel = new PLZErrorPanel(frameManager);



        BusinessReceiptPanel businessReceiptPanel = new BusinessReceiptPanel(frameManager);
        CustomerReceiptPanel customerReceiptPanel = new CustomerReceiptPanel(frameManager);
        DeliveryDataPanel deliveryDataPanel = new DeliveryDataPanel(frameManager);

        SpeisekartePanel speisekartePanel = new SpeisekartePanel(frameManager);

        ZutatenCheckerPanel zutatenCheckerPanel = new ZutatenCheckerPanel(frameManager);

        MainMenuPanel mainMenuPanel = new MainMenuPanel(frameManager, questionDeliveryPanel, bestellungsHistoriePanel, zutatenBestandPanel, bookkeepingPanel);

        PickupDataPanel pickupDataPanel = new PickupDataPanel(frameManager);

        // Login
        LoginView loginView = new LoginView(frameManager, mainMenuPanel);
        User myModel = new User("admin", "admin");
        myModel.addObserver(loginView);
        LoginController loginController = new LoginController(myModel, loginView);
        loginView.addLoginButtonController(loginController);

        // initialize controllers
        frameManager.initialize(loginView,
                mainMenuPanel,
                bestellungsHistoriePanel,
                bookkeepingPanel,
                businessReceiptPanel,
                customerReceiptPanel,
                deliveryDataPanel,
                plzPanel,
                plzErrorPanel,
                questionDeliveryPanel,
                speisekartePanel,
                zutatenBestandPanel,
                zutatenCheckerPanel,
                pickupDataPanel,
                warehouseCheckerPanel);


        // create database schema if not exist - created manually
        Migrations.getInstance().createTables();


    }
}
