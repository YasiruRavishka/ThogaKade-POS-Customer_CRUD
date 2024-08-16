package controller;

import com.jfoenix.controls.JFXTextField;
import database.ThogakadePOS;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {
    @FXML
    public AnchorPane addNewCustomerForm;

    @FXML
    private JFXTextField txtID;

    @FXML
    private ComboBox<String> cmbTitle;

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
        txtID.setText(ThogakadePOS.getInstance().generateNextID());
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("MR.");
        titles.add("Miss");
        cmbTitle.setItems(titles);

        btnClearAllOnAction(new ActionEvent());
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        List<Customer> customerList = ThogakadePOS.getInstance().getConnection();
        customerList.add(
                new Customer(
                        txtID.getText(),
                        String.format("%s%s", cmbTitle.getValue(), txtName.getText()),
                        dateDOB.getValue(),
                        txtAddress.getText(),
                        txtNumber.getText()
                )
        );
        btnClearAllOnAction(new ActionEvent());
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        ((Stage)addNewCustomerForm.getScene().getWindow()).close();
    }

    @FXML
    void btnClearAllOnAction(ActionEvent event) {
        txtID.setText(ThogakadePOS.getInstance().generateNextID());
        cmbTitle.setValue(null);
        txtName.setText(null);
        dateDOB.setValue(null);
        txtAddress.setText(null);
        txtNumber.setText(null);
    }
}
