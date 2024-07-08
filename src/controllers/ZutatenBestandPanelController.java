package src.controllers;

import src.ingredient.Ingredient;
import src.ingredient.IngredientOrderItem;
import src.storage.transactions.TransactionRecord;
import src.storage.transactions.TransactionsDaoDbImpl;
import src.storage.warehouse.WarehouseDaoDbImpl;
import src.views.ZutatenBestandPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class ZutatenBestandPanelController implements ActionListener {
    private FrameManager frameManager;
    private ZutatenBestandPanel zutatenBestandPanel;

    public ZutatenBestandPanelController(ZutatenBestandPanel zutatenBestandPanel, FrameManager frameManager) {
        this.zutatenBestandPanel = zutatenBestandPanel;
        this.frameManager = frameManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            IngredientOrderItem tomatoItem = new IngredientOrderItem("tomato",
                    Ingredient.getAvailableValues().get("tomato"),
                    Integer.parseInt(zutatenBestandPanel.getTomatoQty().getText()));
            IngredientOrderItem salmonItem = new IngredientOrderItem("salmon",
                    Ingredient.getAvailableValues().get("salmon"),
                    Integer.parseInt(zutatenBestandPanel.getSalmoneQty().getText()));
            IngredientOrderItem schinkenItem = new IngredientOrderItem("schinken",
                    Ingredient.getAvailableValues().get("schinken"),
                    Integer.parseInt(zutatenBestandPanel.getSchinkenQty().getText()));
            IngredientOrderItem tuneItem = new IngredientOrderItem("tune",
                    Ingredient.getAvailableValues().get("tune"),
                    Integer.parseInt(zutatenBestandPanel.getTonnoQty().getText()));
            IngredientOrderItem onionItem = new IngredientOrderItem("onion",
                    Ingredient.getAvailableValues().get("onion"),
                    Integer.parseInt(zutatenBestandPanel.getOnionQty().getText()));
            IngredientOrderItem doughItem = new IngredientOrderItem("dough",
                    Ingredient.getAvailableValues().get("dough"),
                    Integer.parseInt(zutatenBestandPanel.getDoughQty().getText()));
            IngredientOrderItem cheeseItem = new IngredientOrderItem("cheese",
                    Ingredient.getAvailableValues().get("cheese"),
                    Integer.parseInt(zutatenBestandPanel.getDoughQty().getText()));

            List<IngredientOrderItem> items = Arrays.asList(tomatoItem, salmonItem, schinkenItem, tuneItem, onionItem, doughItem, cheeseItem);

            // Ausrechnung von der bestellten Ingredients
            int totalValue = 0;
            for (IngredientOrderItem item : items) {
                totalValue += item.getQty() * item.getPrice();
            }

            // Die Geschaeftskonto-Bilanz
            List<TransactionRecord> allTransactions = TransactionsDaoDbImpl.getInstance().getAllTransactions();
            int currentBalance = 0;
            for (TransactionRecord t : allTransactions) {
                currentBalance += t.getValue();
            }

            // Die Pruefung. ob wir die Bestellung von Ingredients vollziehen koennen: (Bilanz - was bestellt wird)
            if (currentBalance < totalValue) {
                frameManager.showWarehouseChecker();
                return;
            }

            // Warehouse update (was gekauft wird -> in Warehouse addiert)
            for (IngredientOrderItem item : items) {
                WarehouseDaoDbImpl.getInstance().depositIngredient(item.getName(), item.getQty());
            }

            // Transaction wird geschaffen und in die DB eingepflegt
            TransactionRecord transaction = TransactionRecord.NewPurchaseTransactionRecord(totalValue);
            TransactionsDaoDbImpl.getInstance().addTransaction(transaction);

            frameManager.showBusinessReceiptPanel(items);
        } catch (NumberFormatException ex) {
            zutatenBestandPanel.getWrongInput().setText("Ungültige Eingabe");
            zutatenBestandPanel.getWrongInput().setForeground(Color.RED);
            zutatenBestandPanel.refreshData();
        }
    }
}
