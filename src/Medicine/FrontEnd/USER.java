
import com.sun.javafx.sg.prism.NGTriangleMesh;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dunkdink
 */
public class USER extends Application {

    List<String> type = new ArrayList<>();
    List<List<String>> name = new ArrayList<>();
    Button button;
    
    //comment
    Comment third;

    public static void main(String[] args) {
        launch(args);
    }
    
    public void ReadDATA(){
        String line = new String();
        List<String> temp = new ArrayList<>();
        //First Line is type
        int indexLine = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/database/", "data.txt") , Charset.forName("UTF-8"))) {
            while ((line = reader.readLine()) != null ) { // one loop = 1 line
                //System.out.println(line);
                if(indexLine==0){ // First line
                    type = Arrays.asList(line.split(","));
                }
                else{
                    temp = new ArrayList<>(); // clear
                    temp = Arrays.asList(line.split(","));
                    name.add(temp);
                }
                indexLine++;
            }
        }catch (IOException e) {
            System.err.println(e);
        }
        
        System.out.println(type);
    }
    
    @Override
    public void start(Stage userStage) throws Exception { // this is main!
        Symptom sym = new Symptom(userStage);
        sym.show();
        
        userStage.setResizable(false);
        
        third = new Comment(userStage);
        ReadDATA(); // Call Function
        userStage.setTitle("Pharmacy Information System");
        
        Button button = new Button();
        button.setText("Ctegory1");
        
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public  void handle(ActionEvent e){
                System.out.println("Click! 1");
            }
        });
            
        
        Button button2 = new Button("ดูข้อมูลของยา");
        Button button3 = new Button("ขอความคิดเห็นเกี่ยวกับโปรแกรม");
        
        
        /*
        ex A: a1,a2,a3,a4
           B: b1,b2,b3,b4,b5
           C: ca1,cccc ...
        */
        /*List<String> type = new ArrayList<>();
        List<List<String>> name = new ArrayList<>();
        type.add("A");
        type.add("B");
        type.add("C");

        List<String> tempName = new ArrayList<>();
        tempName.add("a1");
        tempName.add("a2");
        tempName.add("a3");
        name.add(tempName);
        
        tempName = new ArrayList<>(); //Clear old member
        tempName.add("b1");
        tempName.add("b2");
        tempName.add("b3");
        name.add(tempName);
        
        tempName = new ArrayList<>(); //Clear old member
        tempName.add("c1");
        tempName.add("c2");
        tempName.add("c3");
        name.add(tempName);
        */
        
        ComboBox cb1 = new ComboBox();
        ComboBox cb2 = new ComboBox();
        cb1.setMinSize(200, 30);
        cb2.setMinSize(200, 30);     
        cb1.setPromptText("เลือกประเภทยา");
        cb2.setPromptText("เลือกยา");
        
        //change font size                                  color
        //cb1.setStyle("-fx-background-color: linear-gradient(#FFFFFF, #A12345);-fx-font-size: 17.0");
        
        // insert member to combobox
        cb1.getItems().addAll(type);
        
        BorderPane layout = new BorderPane();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(cb1,cb2,button2,button3);
        //INSERT TOP LEFT BOTTON RIGHT
        VBox.setMargin(cb1,new Insets(10, 0, 5, 0)); // set Margin btn1
        VBox.setMargin(cb2,new Insets(10, 0, 5, 0)); // set Margin btn2
        vbox.setAlignment(Pos.CENTER);
        layout.setCenter(vbox);
        Scene scene = new Scene(layout, 400, 250);
        userStage.setScene(scene);
        //userStage.show();
        
        
        //Event zone
        cb1.setOnAction(new EventHandler<ActionEvent>(){ // if cb1 change value = change value in cb 2 ...
            @Override public void handle(ActionEvent e){
                cb2.getItems().clear(); // Clear old member
                int index = type.indexOf(cb1.getValue()); // Find index of (A,B,C) in type
                cb2.getItems().addAll(name.get(index)); // it mean name[i] -> but use .get(i)
            }
        });
        
        button2.setOnAction((ActionEvent e) -> { 
            if(cb1.getValue() != null && cb2.getValue() != null){
                System.out.println(String.format("Select %s -> %s", cb1.getValue(),cb2.getValue()));
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(userStage);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text(String.format("Select %s -> %s", cb1.getValue(),cb2.getValue())));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            }
            else
                System.out.println("Error!");

        });
        
        button3.setOnAction((ActionEvent ex)->{
            third.show();
            userStage.hide();
        });
        
        
    }

}
