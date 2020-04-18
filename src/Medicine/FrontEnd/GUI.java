/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;
import Medicine.BackEnd.Person;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        stage.show();
        stage.setScene(Setscene(stage));
        
    }
    public Scene Setscene(Stage stage) {
        
        Register a = new Register(stage);
        
        stage.setTitle("LOGIN_PAGE");
        
        return a.scene[1];
    }
    

    public static void main(String[] args) {
        launch(args);
        
    }
}