package Medicine.FrontEnd;

import Medicine.BackEnd.API;
import Medicine.BackEnd.BSymptom;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Symptom {

    Stage body = new Stage();

    String output = "";

    public Symptom(Stage primary) {

        this.body.setOnHidden((e) -> {
            this.body.hide();
            primary.show();
        });

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        List<CheckBox> listCB = new ArrayList<>();

        int index = 0;

        CheckBox cb = new CheckBox(String.format("ปวดหัว"));

        listCB.add(cb);
        pane.add(cb, 0, 1);
        CheckBox cb1 = new CheckBox(String.format("ปวดท้อง"));

        listCB.add(cb1);
        pane.add(cb1, 0, 2);
        CheckBox cb2 = new CheckBox(String.format("ผื่นคัน"));

        listCB.add(cb2);
        pane.add(cb2, 0, 3);
        CheckBox cb3 = new CheckBox(String.format("ท้องเสีย"));

        listCB.add(cb3);
        pane.add(cb3, 0, 4);
        CheckBox cb4 = new CheckBox(String.format("เวียนศีรษะ "));

        listCB.add(cb4);
        pane.add(cb4, 0, 5);
        CheckBox cb5 = new CheckBox(String.format("อาเจียน"));

        listCB.add(cb5);
        pane.add(cb5, 0, 6);
        CheckBox cb6 = new CheckBox(String.format("มีไข้"));

        listCB.add(cb6);
        pane.add(cb6, 0, 7);
        CheckBox cb7 = new CheckBox(String.format("เจ็บคอ"));

        listCB.add(cb7);
        pane.add(cb7, 0, 8);
        CheckBox cb8 = new CheckBox(String.format("คัดจมูก"));

        listCB.add(cb8);
        pane.add(cb8, 0, 9);
        CheckBox cb9 = new CheckBox(String.format("ไอ"));

        listCB.add(cb9);
        pane.add(cb9, 0, 10);
        Button btn = new Button("Click to result");
        btn.setOnAction(((t) -> {
            for (CheckBox x : listCB) {
                if (x.isSelected()) {
                    output += String.format(" %s", x.getText());
                }
            }
            BSymptom st = new BSymptom(output);
            API.addSymptom(st);
            System.out.println("Result : " + output);
            System.out.println(API.getAllSymptom());

            this.body.hide();
            primary.show();
        }));
        pane.add(btn, 5, 11, 3, 1);
        Scene scene = new Scene(pane, 800, 600);

        this.body.setScene(scene);
    }

    public void show() {
        this.body.show();
    }

}
