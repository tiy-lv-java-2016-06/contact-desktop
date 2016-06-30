package contactDesktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    File file = new File("contacts.json");
    FileWriter fw = new FileWriter(file);
    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField nameText, phoneText, emailText;

    public Controller() throws IOException {
    }

    public void addContact() throws IOException {
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
            JsonSerializer serializer = new JsonSerializer();
            String json = serializer.serialize(contact);
            fw.write(json);
            fw.close();
            nameText.setText("");
            phoneText.setText("");
            emailText.setText("");
        }
    }

    public void removeContact() throws IOException {

       Contact contact = (Contact)list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(contacts);
        fw.write(json);
        fw.close();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonParser fileParser = new JsonParser();
        //Error is happening below.
        assert fileReader != null;
        fileReader.useDelimiter("\\Z");
        String contents = fileReader.next();
        //ObservableList<Contact> loadContacts = contacts;
        //Error is on line 89
        //contacts = fileParser.parse(contents, ObservableList.class);
        //list.setItems(contacts);
    }
}
