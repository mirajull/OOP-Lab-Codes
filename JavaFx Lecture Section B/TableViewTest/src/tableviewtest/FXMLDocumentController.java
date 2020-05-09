/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewtest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

/**
 *
 * @author Aspire
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TableView tableView1;
    @FXML
    private TableColumn firstName;
    @FXML
    private TableColumn lastname;
    @FXML
    private TableColumn emailId;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      final ObservableList<Person> data = FXCollections.observableArrayList(
                new Person(true, "Jacob", "Smith", "jacob.smith@example.com"),
                new Person(false, "Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person(true, "Ethan", "Williams", "ethan.williams@example.com"),
                new Person(true, "Emma", "Jones", "emma.jones@example.com"),
                new Person(false, "Michael", "Brown", "michael.brown@example.com"));
        
  
         
         
         firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
         lastname.setCellValueFactory(new PropertyValueFactory("lastName"));
         emailId.setCellValueFactory(new PropertyValueFactory("email"));
         
  
        tableView1.setEditable(true);
        tableView1.setItems(data);
        tableView1.setEditable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
