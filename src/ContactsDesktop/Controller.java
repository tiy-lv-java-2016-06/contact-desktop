package ContactsDesktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    public void addContact(){
        String contactName = name.getText();
        String contactPhone = phone.getText();
        String contactEmail = email.getText();
        Contact contact = new Contact(contactName, contactPhone, contactEmail);
        if((!contactName.isEmpty() && !contactPhone.isEmpty() && !contactEmail.isEmpty())) {
            contacts.add(contact);
            name.setText("");
            phone.setText("");
            email.setText("");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!!");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all 3 fields! Name, Phone #, and Email");

            alert.showAndWait();
        }
    }

    public void removeContact(){
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
