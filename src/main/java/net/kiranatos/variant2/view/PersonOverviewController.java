package net.kiranatos.variant2.view;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import net.kiranatos.variant2.MainApp;
import net.kiranatos.variant2.model.Person;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(
                new Callback< 
                        TableColumn.CellDataFeatures <Person, String>, 
                        ObservableValue<String> 
                        >() {
                            @Override
                            public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> cellData) {
                                return cellData.getValue().firstNameProperty();
                            }
                        });
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        System.out.println("metod initialize");
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
        System.out.println("metod setMainApp");
    }
}