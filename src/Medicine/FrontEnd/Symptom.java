
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
        
        this.body.setOnHidden((e)->{
            this.body.hide();
            primary.show();
        });
        
        
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        List<CheckBox> listCB = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                CheckBox cb = new CheckBox(String.format("I'm %d", index++));
                listCB.add(cb);
                pane.add(cb, i, j);
            }
        }

        Button btn = new Button("Click to result");
        btn.setOnAction(((t) -> {
            for (CheckBox x : listCB) {
                if (x.isSelected()) {
                    output += String.format("\n%s", x.getText());
                }
            }
            System.out.println("Result : " + output);
            this.body.hide();
            primary.show();
        }));
        pane.add(btn, 5, 11, 3, 1);
        Scene scene = new Scene(pane, 800, 600);

        this.body.setScene(scene);
    }
    
    public void show(){
        this.body.show();
    }
    
}
