/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;
import Medicine.BackEnd.*;
import Medicine.BackEnd.Person;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author USER
 */

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println( API.getAllSymptom());
       
       
        Pane pane = new Pane();
        stage.setScene(Setscene(stage));
        stage.centerOnScreen();
        stage.show();
       API.InitDrugInform();
        
    }
    public Scene Setscene(Stage stage) throws FileNotFoundException {
        Register a = new Register(stage);
        stage.setTitle("LOGIN_PAGE");
        stage.initStyle(StageStyle.UNDECORATED);
        return a.scene[1];
    }
    
    public static void main(String[] args) throws InterruptedException {
//        new LOGIN().setVisible(true); 
    launch(args);
     
    }
 }
//***********************************************************************************/
