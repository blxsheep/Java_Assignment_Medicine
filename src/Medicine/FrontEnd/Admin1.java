/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Admin1 extends  Application{
      Text[] alltext;
    Button[] allbutton;
    Scene[] scene;
    VBox[] Row;
    TextField[] allfill;
    HBox[] Column;
    VBox addpage = new VBox(4);
  HBox addpage2 = new HBox(4);
    VBox Na= new VBox(14);
    HBox page1= new HBox(10);
    VBox page2= new VBox(10);
    VBox page2s= new VBox(70);
    VBox updatepage = new VBox(50);
    Scene admain = new Scene(page1, 450, 150);
    Scene adupdate = new Scene(updatepage, 450, 450);
    Scene adadd = new Scene(addpage, 450, 450);
    ObservableList<String> Type = FXCollections.observableArrayList("ยาลดอาการปวด", "ยาลดไข้","ยาแก้ไอ","ยาฆ่าเชื้อ","---------------");
    ObservableList<String>Medname = FXCollections.observableArrayList("Admin", "User","---------------");
    ObservableList<String> count = FXCollections.observableArrayList("1", "2","3","4","5","6","7","8","9","10","---------------");

    ComboBox typeBox = new ComboBox(Type);
    ComboBox typeBox2 = new ComboBox(Type);
    ComboBox typeBox3 = new ComboBox(Type);
    ComboBox mednameBox = new ComboBox(Medname);
    ComboBox mednameBox2 = new ComboBox(Medname);
    ComboBox CountBox = new ComboBox(count);
    /*
           but1 => goto check 
           but2 => goto updateMed
           but3 => goto view
           but4 => goto addMed
    */  
    Admin1(){
        setHbox();
        setTextbox();
        setbut();
        settext();
        setVbox();
        Updatepage();
        Setadd();
        allbutton[4].setText("เพิ่มยา");
        allbutton[3].setText("เพิ่มยาตัวใหม่");
        allbutton[2].setText("อัพเดท/ดูข้อมูล");
        allbutton[1].setText("ตรวจสอบอาการผู้ป่วย");
        Column[1].setAlignment(Pos.CENTER);
        for (int i = 1; i < 4; i++) {
             Column[1].getChildren().add(allbutton[i]);
        }    
        page1.setAlignment(Pos.CENTER);
        page1.getChildren().add(Column[1]);
    }
    
    void Updatepage(){
       mednameBox2.setVisibleRowCount(3);
        allbutton[7].setText("ดูข้อมูล");
       mednameBox.setVisibleRowCount(3);
        CountBox.setVisibleRowCount(3);
        allbutton[6].setText("อัพเดท");
        allbutton[5].setText("ย้อนกลับ");
        alltext[1].setText("_______________________________________________________________________________________________________________");
        Row[2].getChildren().addAll(typeBox2,mednameBox2,allbutton[7],alltext[1]);
        page2.getChildren().addAll(typeBox,mednameBox,CountBox,allbutton[6],allbutton[5]);
        page2.setAlignment(Pos.BOTTOM_CENTER);
        page2s.setAlignment(Pos.TOP_CENTER);
        page2s.getChildren().add(Row[2]);
        updatepage.getChildren().addAll(page2s,page2);
        updatepage.setAlignment(Pos.CENTER);
    }
    void Setadd() {
        alltext[0].setText("หมวดหมู่");
        alltext[4].setText( "ชื่อยา :");
        alltext[5].setText("สรรพคุณ :");
        alltext[6].setText("จำนวน :");
        alltext[7].setText("ราคา :");
        allbutton[4].setText("Register");
        allbutton[5].setText("back");
        Na.setAlignment(Pos.TOP_RIGHT);
         Row[6].setAlignment(Pos.TOP_RIGHT);
        for (int j = 1; j <= 4; j++) {
         Na.getChildren().addAll(alltext[j+3]);
          Row[6].getChildren().addAll(allfill[j]);
        }
        Column[0].setAlignment(Pos.TOP_CENTER);
         Column[0].setAlignment(Pos.TOP_CENTER);
        Column[0].getChildren().addAll(alltext[0], typeBox3);
        addpage2.setAlignment(Pos.TOP_CENTER);
         addpage2.getChildren().addAll(Na,Row[6]);
        allbutton[4].setAlignment(Pos.CENTER_RIGHT);
        allbutton[5].setAlignment(Pos.CENTER_RIGHT);
        Column[11].getChildren().addAll(allbutton[4], allbutton[5]);
        Column[11].setAlignment(Pos.CENTER);
        addpage.setAlignment(Pos.TOP_CENTER);
        addpage.getChildren().addAll(addpage2, Column[0], Column[11]);
    }
    
     public void settext() {
        alltext = new Text[20];
        for (int i = 0; i < 20; i++) {
            alltext[i] = new Text("");
        }
    }

    public void setbut() {
        allbutton = new Button[20];
        for (int i = 1; i < 20; i++) {
            allbutton[i] = new Button("");
            allbutton[i].setAlignment(Pos.CENTER);
        }
    }

    public void setVbox() {
        Row = new VBox[20];
        for (int i = 1; i < 20; i++) {
            Row[i] = new VBox(4);
            Row[i].setAlignment(Pos.CENTER);
        }
    }

    public void setTextbox() {
        allfill = new TextField[20];
        for (int i = 1; i < 20; i++) {
            allfill[i] = new TextField("");
            allfill[i].setAlignment(Pos.CENTER);
        }

    }

    public void setHbox() {
        Column = new HBox[20];
        for (int i = 0; i < 20; i++) {
            Column[i] = new HBox(10);
            Column[i].setAlignment(Pos.CENTER);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

}
