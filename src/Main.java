package src;

import src.ingredient.IngredientCheese;
import src.ingredient.IngredientSchinken;
import src.ingredient.IngredientTomato;
import src.pizza.PizzaInterface;
import src.pizza.PizzaMargaretta;
import src.pizza.PizzaSchinken;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
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


        JFrame frame = new JFrame("Pizzeria Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/*
        JPanel LoginPanel = new LoginPanel();
        frame.getContentPane().add(LoginPanel);
        frame.setSize(800,400);
        frame.setVisible(true);

        JPanel LoginErrorPanel = new LoginErrorPanel();
        frame.getContentPane().add(LoginErrorPanel);
        frame.setSize(800, 400);
        frame.setVisible(true);

        JPanel MainMenuPanel = new MainMenuPanel();
        frame.getContentPane().add(MainMenuPanel);
        frame.setSize(800,400);
        frame.setVisible(true);

        JPanel DeliveryPanel = new QuestionDeliveryPanel();
        frame.getContentPane().add(DeliveryPanel);
        frame.setSize(800,400);
        frame.setVisible(true);


        JPanel PLZPanel = new PLZPanel();
        frame.getContentPane().add(PLZPanel);
        frame.setSize(800,400);
        frame.setVisible(true);

        JPanel PLZErrorPanel = new PLZErrorPanel();
        frame.getContentPane().add(PLZErrorPanel);
        frame.setSize(800,400);
        frame.setVisible(true);

        JPanel DeliveryDataPanel = new DeliveryDataPanel();
        frame.getContentPane().add(DeliveryDataPanel);
        frame.setSize(800,400);
        frame.setVisible(true);


        JPanel ZutatenCheckerPanel = new ZutatenCheckerPanel();
        frame.getContentPane().add(ZutatenCheckerPanel);
        frame.setSize(800, 400);
        frame.setVisible(true);
*/
        JPanel ZutatenWarningPanel = new ZutatenWarningPanel();
        frame.getContentPane().add(ZutatenWarningPanel);
        frame.setSize(800, 400);
        frame.setVisible(true);


    }
}
