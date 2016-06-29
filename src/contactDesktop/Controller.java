package contactDesktop;

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
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    @FXML
    ListView list;

    /**
     * Method to add a new contact. If any contact fields are not filled, an alert will pop up and wait
     * for user input.
     */
    public void addContact(){
        String contactName = name.getText();
        String contactPhone = phone.getText();
        String contactEmail = email.getText();

        Contact contact = new Contact(contactName, contactPhone, contactEmail);

        if (!name.getText().isEmpty() && !phone.getText().isEmpty() && !email.getText().isEmpty()) {

            contacts.add(contact);

            name.setText("");
            phone.setText("");
            email.setText("");
    }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if (name.getText().isEmpty()){
                alert.setTitle("Must enter name!!!");
                alert.showAndWait();
            }
            else if (phone.getText().isEmpty()){
                alert.setTitle("Must enter phone!!!");
                alert.showAndWait();
            }
            else if (email.getText().isEmpty()){
                alert.setTitle("Must enter email!!!");
                alert.showAndWait();
            }
        }

    }

    /**
     * Method to remove a selected contact.
     */
    public void removeContact(){

        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    list.setItems(contacts);
    }
}
