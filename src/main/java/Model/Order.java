package Model;

import java.sql.Timestamp;

public class Order {
    private int id;
    private Timestamp time;
    private int total;
    private Customer customer;

    public Order() {
    }

    public Order(int id, Timestamp time, int total, Customer customer) {
        this.id = id;
        this.time = time;
        this.total = total;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
