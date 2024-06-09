package src;

import src.controllers.FrameManager;
import src.controllers.LoginController;
import src.ingredient.IngredientCheese;
import src.ingredient.IngredientSchinken;
import src.ingredient.IngredientTomato;
import src.pizza.*;
import src.views.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // available pizzas
        ArrayList<PizzaInterface> availablePizzas = new ArrayList<>(Arrays.asList(
                new PizzaMargaretta(),
                new PizzaSalmone(),
                new PizzaSchinken(),
                new PizzaTonno()
        ));
        for (PizzaInterface pi : availablePizzas) {
            pi.build();
        }
        // create a controller containing the main frame
        FrameManager frameManager = new FrameManager();
        // Initialize Views
        BestellungsHistoriePanel bestellungsHistoriePanel = new BestellungsHistoriePanel(frameManager);
        BookkeepingPanel bookkeepingPanel = new BookkeepingPanel(frameManager);
        ZutatenBestandPanel zutatenBestandPanel = new ZutatenBestandPanel(frameManager);

        QuestionDeliveryPanel questionDeliveryPanel = new QuestionDeliveryPanel(frameManager);
        PLZPanel plzPanel = new PLZPanel(frameManager);


        BusinessReceiptPanel businessReceiptPanel = new BusinessReceiptPanel();
        CustomerReceiptPanel customerReceiptPanel = new CustomerReceiptPanel(frameManager);
        DeliveryDataPanel deliveryDataPanel = new DeliveryDataPanel(frameManager);

        SpeisekartePanel speisekartePanel = new SpeisekartePanel(frameManager, availablePizzas);

        ZutatenCheckerPanel zutatenCheckerPanel = new ZutatenCheckerPanel(frameManager);
        ZutatenWarningPanel zutatenWarningPanel = new ZutatenWarningPanel(frameManager);

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
                questionDeliveryPanel,
                speisekartePanel,
                zutatenBestandPanel,
                zutatenCheckerPanel,
                zutatenWarningPanel,
                pickupDataPanel);


        // Initialize Objects
        Warehouse warehouse = new Warehouse();
        warehouse.setCheese(new IngredientCheese(2000));
        warehouse.setSchinken(new IngredientSchinken(2000));
        warehouse.setTomato(new IngredientTomato(2000));
        // Create order functionality
        int qty = 1; // from input
        String pizzaName = "margaretta"; // from input
        PizzaInterface pizza;
        pizza = new PizzaMargaretta();
//        switch (pizzaName) {
//            case "margaretta": {
//                pizza = new PizzaMargaretta();
//            }
//            case "schinken": {
//                pizza = new PizzaSchinken();
//            }
//            default: {
//                throw new IllegalArgumentException("Unrecognized pizza name: " + pizzaName);// if unrecognised input - return error
//            }
//        }
        pizza.build(); // initialize the ingredients and price

        OrderItem orderItem = new OrderItem(pizza, qty);
        Order order = new Order();
        order.addOrderItem(orderItem);

        boolean withdrawSuccess = warehouse.withdrawIngredients(order);
        if (!withdrawSuccess) {
            // handle insufficient ingredients' capacity in warehouse
        }

        if (warehouse.isThresholdViolated()) {
            // alert on the low volume (below threshold) of ingredient in warehouse
        }

        // save order to database
        // ...
        //

    }
}
