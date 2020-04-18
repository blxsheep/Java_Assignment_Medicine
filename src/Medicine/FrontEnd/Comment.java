package Medicine.FrontEnd;

import Medicine.BackEnd.API;
import Medicine.BackEnd.BComment;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
public class Comment {

    TextField textbox = new TextField();
    Button btn = new Button("Submit! and Thankyou");
    Button back = new Button("Back");
    VBox pane = new VBox();
    Stage third = new Stage();

    public Comment(Stage primary) {
        textbox.setPrefSize(250, 20); //size ลูก
        textbox.setMaxSize(250, 20);
        VBox.setMargin(textbox, new Insets(10));
        
        pane.setPadding(new Insets(20)); //size แม่
        pane.setAlignment(Pos.CENTER);
        third.setTitle("Comment");
        pane.getChildren().addAll(textbox, btn, back);
        Scene scene = new Scene(pane, 400, 200);
        third.setScene(scene);
        third.setResizable(false);
        third.setOnHiding(event -> {

            primary.show();
        });
        btn.setOnAction((ActionEvent ex) -> {

            String s = textbox.getText();
            BComment cm = new BComment(s);
            API.addComment(cm);
            System.out.println(API.getCustom("BComments"));
            third.hide();
            primary.show();
        });
        
        back.setOnAction((ActionEvent ex) -> {
            third.hide();
            primary.show();
        });
    }

    public void show() {
        third.show();
    }

}
