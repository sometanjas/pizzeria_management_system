package src;

import src.controllers.BookkeepingController;
import src.controllers.FrameManager;
import src.controllers.LoginController;
import src.ingredient.Ingredient;
import src.model.Order;
import src.model.OrderItem;
import src.pizza.*;
import src.storage.Migrations;
import src.storage.warehouse.WarehouseDaoDbImpl;
import src.views.*;

public class Main {
    public static void main(String[] args) {

        // create a controller containing the main frame
        FrameManager frameManager = new FrameManager();
        // Initialize Views
        BestellungsHistoriePanel bestellungsHistoriePanel = new BestellungsHistoriePanel(frameManager);
        ZutatenBestandPanel zutatenBestandPanel = new ZutatenBestandPanel(frameManager);

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
        //SpeisekartePanel speisekartePanel = new SpeisekartePanel(frameManager, availablePizzas);

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
                pickupDataPanel);


        // create database schema if not exist - created manually
        Migrations.getInstance().createTables();

        // create DAOs

        // Initialize Objects
        // entrySet():
        // The entrySet() method returns a set of map entries, where each entry is an instance of Map.Entry<K, V>.
        // Here, K is the type of keys and V is the type of values in the map.
        // Using entrySet(), you can iterate over the map and access both keys and values directly.
        for (var entry : Ingredient.getAvailableValues().entrySet()) {
            WarehouseDaoDbImpl.getInstance().addIngredient(entry.getKey(), 2000);
        }

        // create test order


        // Create order functionality
        int qty = 1; // from input
        PizzaInterface pizza;
        pizza = new PizzaMargaretta();
        try {
            pizza.build(); // initialize the ingredients and price
        } catch (Exception e) {
            return;
        }
        OrderItem orderItem = new OrderItem(pizza, qty);

        Order.getInstance().addOrderItem(orderItem);
        Order.getInstance().setFirstname("firstnameInput");
        Order.getInstance().setSecondname("secondnameInput");
        Order.getInstance().setAddress("addressInput");
        Order.getInstance().setFloor("1");
        Order.getInstance().setTelefon("telefonInput");
        Order.getInstance().setPlz(10313);
        Order.getInstance().setLieferung(true);
        try {
            Order.getInstance().save();
        } catch (Exception e) {
            return;
        }

//        boolean withdrawSuccess = warehouse.withdrawIngredients(order);
//        if (!withdrawSuccess) {
//            // handle insufficient ingredients' capacity in warehouse
//        }
//
//        if (warehouse.isThresholdViolated()) {
//            // alert on the low volume (below threshold) of ingredient in warehouse
//        }

        // save order to database
        // ...
        //

    }
}
