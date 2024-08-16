package database;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class ThogakadePOS {
    private static ThogakadePOS instance;
    private List<Customer> connection;

    private ThogakadePOS() {
        connection = new ArrayList<>();
    }

    public static ThogakadePOS getInstance() {
        return null == instance ? instance = new ThogakadePOS() : instance;
    }

    public List<Customer> getConnection() {
        return connection;
    }

    public String generateNextID(){
        return String.format("C%04d",connection.size()+1);
    }
}
