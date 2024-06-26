package src.model;

import src.ingredient.Ingredient;
import src.storage.order.OrderDaoDbImpl;
import src.storage.order.OrderRecord;
import src.storage.warehouse.WarehouseDaoDbImpl;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static Order self = null;


    private Order() {
        this.items = new ArrayList<>();
    }

    public static Order getInstance() {
        if (self == null) self = new Order();
        return self;
    }

    private ArrayList<OrderItem> items;

    private boolean lieferung;
    private int plz;
    private String firstname;
    private String secondname;
    private String address;
    private String floor;
    private String telefon;
    private int orderID;

    public void save() throws Exception {
        // get all ingredients and their cumulative values
        List<Ingredient> ingrs = this.extractIngredient();
        // get all items from warehouse
        List<Ingredient> availableIngrs = WarehouseDaoDbImpl.getInstance().getAllIngredients();
        // check if enough in warehouse
        if (!this.isEnoughIngredients(availableIngrs, ingrs)) {
            throw new NotEnoughIngrsException("not enough ingredients");
        }
        // withdraw from warehouse
        for (Ingredient ingr : ingrs) {
            WarehouseDaoDbImpl.getInstance().withdrawIngredient(ingr.getName(), ingr.getValue());
        }
        // add order record
        OrderRecord or = buildOrderRecord();
        OrderDaoDbImpl.getInstance().addOrder(or);
    }

    // resulting set will present a flat list of all ingredients that needs to be withdrawn from warehouse
    private List<Ingredient> extractIngredient() throws Exception {
        ArrayList<OrderItem> items = this.getItems();
        ArrayList<Ingredient> resultingIngrs = new ArrayList<>();
        for (OrderItem item : items) {
            int pizzaQty = item.getQuantity();
            ArrayList<Ingredient> ingrs = item.getPizza().getIngredients();
            for (Ingredient ingr : ingrs) {
                resultingIngrs.add(new Ingredient(ingr.getName(), ingr.getValue() * pizzaQty));
            }
        }
        return resultingIngrs;
    }

    private boolean isEnoughIngredients(List<Ingredient> availableIngrs, List<Ingredient> requiredIngrs) {
        for (Ingredient availableIngr : availableIngrs) {
            int leftoverValue = availableIngr.getValue();
            for (Ingredient requiredIngr : requiredIngrs) {
                if (availableIngr.getName().equals(requiredIngr.getName())) {
                    leftoverValue -= requiredIngr.getValue();
                }
            }
            if (leftoverValue < 0) {
                return false;
            }
        }
        return true;
    }

    private OrderRecord buildOrderRecord() {
        int intFloor = Integer.parseInt(this.floor);
        return new OrderRecord(this.lieferung, this.plz, this.firstname, this.secondname, this.address, intFloor, this.telefon);
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    public static void setSelf(Order self) {
        Order.self = self;
    }

    public boolean isLieferung() {
        return lieferung;
    }

    public void setLieferung(boolean lieferung) {
        this.lieferung = lieferung;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
