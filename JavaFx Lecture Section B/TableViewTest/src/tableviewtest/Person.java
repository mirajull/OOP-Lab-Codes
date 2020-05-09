/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewtest;


 
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
 
public class Person {
 
        private final BooleanProperty invited;
        private final StringProperty firstName;
        private final StringProperty lastName;
        private final StringProperty email;
 
        public Person(boolean invited, String fName, String lName, String email) {
            this.invited = new SimpleBooleanProperty(invited);
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }
 
        public BooleanProperty invitedProperty() { return invited; }
 
        public StringProperty firstNameProperty() { return firstName; }
 
        public StringProperty lastNameProperty() { return lastName; }
 
        public StringProperty emailProperty() { return email; }
}