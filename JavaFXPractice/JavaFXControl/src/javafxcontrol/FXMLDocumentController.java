/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxcontrol;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TableView table;
    @FXML
    private Button load;

    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void loadValues(ActionEvent event) {
      
        System.out.println("Clicked here");
 
        final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Jacob",     "Smith",    "jacob.smith@example.com" ),
            new Person("Isabella",  "Johnson",  "isabella.johnson@example.com" ),
            new Person("Ethan",     "Williams", "ethan.williams@example.com" ),
            new Person("Emma",      "Jones",    "emma.jones@example.com" ),
            new Person("Michael",   "Brown",    "michael.brown@example.com" )
        );
        
        StringConverter<Object> sc = new StringConverter<Object>() {
            @Override
            public String toString(Object t) {
                return t == null ? null : t.toString();
            }
 
            @Override
            public Object fromString(String string) {
                return string;
            }
        };
        
        TableColumn firstNameCol = new TableColumn();
        firstNameCol.setText("First");
        TableColumn lastNameCol = new TableColumn();
        lastNameCol.setText("Last");
        TableColumn emailCol = new TableColumn();
        emailCol.setText("Email");
        
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));        
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));              
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        emailCol.setMinWidth(200);
        
        
         
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn(sc));
        
        lastNameCol.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
     public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
         // p.getValue() returns the Person instance for a particular TableView row
         return p.getValue().lastNameProperty();
     }
  });
 
        
        //TableView tableView = new TableView();
        //tableView.setItems(data);
        //tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        table.setEditable(true);
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
    }
    
}
