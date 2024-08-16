package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {
    private static Stage addCustomerForm;
    private static Stage viewCustomerForm;
    @FXML
    void btnAddNewCustomerOnAction(ActionEvent event) {
        if (null == addCustomerForm){
            addCustomerForm = new Stage();
            try {
                addCustomerForm.setTitle("Add new Customer");
                addCustomerForm.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_customer_form.fxml"))));
            } catch (IOException e) {
                System.out.println("Loading error -> Add Customer Form");
            }
        }
        addCustomerForm.show();
    }

    @FXML
    void btnViewCustomerOnAction(ActionEvent event) {
        if (null == viewCustomerForm){
            viewCustomerForm = new Stage();
            try {
                viewCustomerForm.setTitle("View Customer");
                viewCustomerForm.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/view_customer_form.fxml"))));
            } catch (IOException e) {
                System.out.println("Loading error -> View Customer Form");
            }
        }
        viewCustomerForm.show();
    }
}
