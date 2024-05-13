package src;

import java.text.DecimalFormat;

public class Receipt {
    private String customerName;
    private String pizzaType;
    private int quantity;
    private double totalPrice;

    public Receipt(String customerName, String pizzaType, int quantity, double totalPrice) {
        this.customerName = customerName;
        this.pizzaType = pizzaType;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String generateReceipt(){
        DecimalFormat df = new DecimalFormat("#.##");
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Pizza Type: ").append(pizzaType).append("\n");
        sb.append("Quantity: ").append(quantity).append("\n");
        sb.append("Total Price: €").append(df.format(totalPrice)).append("\n");
        return sb.toString();
    }

    //Verknüpfung mit restlichem code...
/*
    // Erstellen einer Quittung für eine Bestellung
    Receipt receipt = new Receipt("Max Mustermann", "Margherita", 2, 17.98);
    String generatedReceipt = receipt.generateReceipt();
System.out.println(generatedReceipt);
*/

}
