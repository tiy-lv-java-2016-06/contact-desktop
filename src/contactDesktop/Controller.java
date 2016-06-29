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

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField nameText, phoneText, emailText;

    public void addContact(){
        String name = nameText.getText();
        String phoneNumber = phoneText.getText();
        String email = emailText.getText();

        if ((name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incomplete Contact");
            alert.setHeaderText("You Forgot Something!");
            alert.setContentText("You must enter a Name, Phone #, and E-Mail.");
            alert.showAndWait();
        }
        else{
            Contact contact = new Contact(name, phoneNumber, email);
            contacts.add(contact);
            nameText.setText("");
            phoneText.setText("");
            emailText.setText("");
        }
    }

    public void removeContact(){
        Contact contact = (Contact)list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
