package net.kiranatos.variant3.start;

import java.io.InputStream;
import net.kiranatos.variant3.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    private static final Locale DEFAULT_LOCALE = new Locale("ru");

    @Override
    public void start(Stage primaryStage) throws Exception{

        Locale.setDefault(DEFAULT_LOCALE);

        FXMLLoader fxmlLoader = new FXMLLoader();
        //fxmlLoader.setLocation(Main.class.getResource("/fxml/variant3/main.fxml"));        
        //fxmlLoader.setLocation(getClass().getResource("/fxml/variant3/main.fxml"));
        //fxmlLoader.setLocation(Main.class.getResource("/fxml/variant3/main.fxml"));
        //InputStream is = Main.class.getClass().getResourceAsStream("/fxml/variant3/main.fxml");
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.variant3.Locale"));
        //fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale"));

        Parent fxmlMain = (Parent) fxmlLoader.load(Main.class.getClass().getResourceAsStream("/fxml/variant3/main.fxml"));
        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(primaryStage);

        primaryStage.setTitle(fxmlLoader.getResources().getString("address_book"));
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(400);
        primaryStage.setScene(new Scene(fxmlMain, 300, 275));
        primaryStage.show();

        testData();
    }

    private void testData() {
//        CollectionAddressBook addressBook = new CollectionAddressBook();
//        addressBook.fillTestData();
//        addressBook.print();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
