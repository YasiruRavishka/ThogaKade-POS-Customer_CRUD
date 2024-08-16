package controller;

import com.jfoenix.controls.JFXTextField;
import database.ThogakadePOS;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnClearOnAction(new ActionEvent());
        tblCustomer.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            txtID.setText(newValue.getId());
            txtName.setText(newValue.getName());
            dateDOB.setValue(newValue.getDateOfBirth());
            txtAddress.setText(newValue.getAddress());
            txtNumber.setText(newValue.getNumber());
        }));
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("number"));

        List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        customerList.forEach(obj -> {
            customerObservableList.add(obj);
        });

        tblCustomer.setItems(customerObservableList);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (ThogakadePOS.getInstance().getConnection().isEmpty()){
            return;
        }
        ThogakadePOS.getInstance().getConnection().remove(Integer.parseInt(txtID.getText().substring(1))-1);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            Customer currentValue = ThogakadePOS.getInstance().getConnection().get(Integer.parseInt(txtID.getText().substring(1))-1);
            currentValue.setName(txtName.getText());
            currentValue.setDateOfBirth(dateDOB.getValue());
            currentValue.setAddress(txtAddress.getText());
            currentValue.setNumber(txtNumber.getText());
        } catch (IndexOutOfBoundsException ex){
            System.out.println("Invalid index.");
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent actionEvent) {
        txtID.setText(null);
        txtName.setText(null);
        dateDOB.setValue(null);
        txtAddress.setText(null);
        txtNumber.setText(null);
    }
}
