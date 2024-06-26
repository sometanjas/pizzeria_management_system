package src.storage.order;

public class OrderRecord {
    boolean lieferung;
    int plz;
    String firstname;
    String secondname;
    String address;
    int floor;
    String telefon;
    int orderID;


    public OrderRecord(boolean lieferungPreference, int plz, String firstname, String secondname, String address, int floor, String telefon) {
        this.lieferung = lieferungPreference;
        this.plz = plz;
        this.firstname = firstname;
        this.secondname = secondname;
        this.address = address;
        this.floor = floor;
        this.telefon = telefon;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
