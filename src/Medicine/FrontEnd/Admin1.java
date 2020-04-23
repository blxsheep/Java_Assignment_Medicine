/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import Medicine.BackEnd.BSymptom;
import Medicine.BackEnd.Drug;
import java.util.ArrayList;
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
import Medicine.BackEnd.*;
import java.util.HashSet;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author ASUS
 */
public class Admin1 extends Application {

    public boolean isDuplicate(Drug dg, ArrayList<String> kind) {
        int ch = 0;
        for (int i = 0; i < kind.size(); i++) {
            if (kind.get(i).equals(dg.getKind())) {
                ch = 1;
            }
        }
        if (ch == 1) {
            return true; // duplicate
        } else {
            return false;
        }

    }

    public boolean isDup2(Drug dg, List<String> temp) {
        int ch = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).equals(dg.getName())) {
                ch = 1;
            }
        }
        if (ch == 1) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<String> cbtype() {
        ArrayList<String> type = new ArrayList<>();
        List<List<String>> name = new ArrayList<>();
        String line = new String();
        List<String> temp = new ArrayList<>();
        //  ArrayList chtype = new ArrayList<>();
        int[][] a = new int[50][50];
        int[] chtype = new int[50];
        int first = 0;
        //First Line is type

        ArrayList<Drug> arr = API.getAllDrug();
        for (int i = 0; i < arr.size(); i++) {
            temp.clear();
            System.out.println("LoopI");
            if (first == 0) {
                type.add(arr.get(i).getKind());
                System.out.println("Add First");
                first = 1;
            } else {

//                    System.out.print("Type =  "+type.get(k) + " vs ");
//                    System.out.println("Arr "+i +">>"+ arr.get(i).getKind());
                if (!isDuplicate(arr.get(i), type)) {
                    type.add(arr.get(i).getKind());
                    System.out.println("Added");
                }
            }
            System.out.println(type);
        }
        return type;
    }

    public List<List<String>> cbname() {
        ArrayList<String> type = new ArrayList<>();
        List<List<String>> name = new ArrayList<>();
        String line = new String();
        List<String> temp = new ArrayList<>();
        //  ArrayList chtype = new ArrayList<>();
        int[][] a = new int[50][50];
        int[] chtype = new int[50];
        int first = 0;
        //First Line is type

        ArrayList<Drug> arr = API.getAllDrug();
        for (int i = 0; i < arr.size(); i++) {
            temp.clear();
            System.out.println("LoopI");
            if (first == 0) {
                type.add(arr.get(i).getKind());
                System.out.println("Add First");
                first = 1;
            } else {

//                    System.out.print("Type =  "+type.get(k) + " vs ");
//                    System.out.println("Arr "+i +">>"+ arr.get(i).getKind());
                if (!isDuplicate(arr.get(i), type)) {
                    type.add(arr.get(i).getKind());
                    System.out.println("Added");
                }
            }
            System.out.println(type);
        }
        for (int i = 0; i < type.size(); i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < arr.size(); j++) {
                if (type.get(i).equals(arr.get(j).getKind()) && !isDup2(arr.get(j), temp)) {
                    temp.add(arr.get(j).getName());
                }

                System.out.print("temp= " + temp);

            }
            name.add(temp);

            System.out.println("NAme= " + name);
        }
        return name;
    }

    public void ReadDATA2() {
        ArrayList<String> type = new ArrayList<>();
        List<List<String>> name = new ArrayList<>();
        String line = new String();
        List<String> temp = new ArrayList<>();
        //  ArrayList chtype = new ArrayList<>();
        int[][] a = new int[50][50];
        int[] chtype = new int[50];
        int first = 0;
        //First Line is type

        ArrayList<Drug> arr = API.getAllDrug();
        for (int i = 0; i < arr.size(); i++) {
            temp.clear();
            System.out.println("LoopI");
            if (first == 0) {
                type.add(arr.get(i).getKind());
                System.out.println("Add First");
                first = 1;
            } else {

//                    System.out.print("Type =  "+type.get(k) + " vs ");
//                    System.out.println("Arr "+i +">>"+ arr.get(i).getKind());
                if (!isDuplicate(arr.get(i), type)) {
                    type.add(arr.get(i).getKind());
                    System.out.println("Added");
                }
            }
            System.out.println(type);
        }
        for (int i = 0; i < type.size(); i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < arr.size(); j++) {
                if (type.get(i).equals(arr.get(j).getKind()) && !isDup2(arr.get(j), temp)) {
                    temp.add(arr.get(j).getName());
                }

                System.out.print("temp= " + temp);

            }
            name.add(temp);

            System.out.println("NAme= " + name);
        }

    }
    ArrayList<BSymptom> arr = new ArrayList<BSymptom>();
    Text[] alltext;
    Button[] allbutton;
    Button removeBtn = new Button();
    Button upbackBtn = new Button();
    Button updateBtn = new Button();
    Button informBtn = new Button();
    Button logoutBtn = new Button();
    Button diagnoseBtn = new Button();
    Scene[] scene;
    VBox[] Row;
    VBox VshowPatient = new VBox(1);
    VBox queuePatient = new VBox(1);
    HBox pVbox = new HBox(20);
    HBox sVbox = new HBox(20);
    HBox diagH = new HBox(20);
    HBox patientPane = new HBox();
    TextField[] allfill;
    TextField diagnoseField = new TextField();
    TextField price = new TextField();
    TextField stock = new TextField();
    HBox[] Column;
    VBox addpage = new VBox(4);
    VBox addq = new VBox(4);
    HBox addpage2 = new HBox(4);
    VBox Na = new VBox(14);
    HBox page1 = new HBox(10);
    VBox page2 = new VBox(6);
    VBox page2s = new VBox(70);
    VBox updatepage = new VBox(50);
    Scene admain = new Scene(page1, 450, 150);
    Scene adupdate = new Scene(updatepage, 450, 450);
    Scene adadd = new Scene(addpage, 450, 450);
    Scene adshowpatient = new Scene(addq, 450, 450);
    // ArrayList arr = API.getAllDrug()
    ObservableList<String> Type = FXCollections.observableArrayList(cbtype());
    ObservableList<String> Type1 = FXCollections.observableArrayList(cbtype());
    ObservableList<List<String>> Medname = FXCollections.observableArrayList();
    ObservableList<List<String>> Medname1 = FXCollections.observableArrayList();
    ObservableList<List<String>> Medname2 = FXCollections.observableArrayList();
    //  ObservableList<String> count = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "---------------");

    ComboBox typeBox = new ComboBox(Type); //Updatepage Lower cb
    ComboBox typeBox2 = new ComboBox(Type1);
    ComboBox mednameBox = new ComboBox(Medname);
    ComboBox mednameBox2 = new ComboBox(Medname1);
    ComboBox mednameBox3 = new ComboBox(Medname2);

    public void reset() {
        ObservableList<String> Type = FXCollections.observableArrayList(cbtype());
        ObservableList<String> Type1 = FXCollections.observableArrayList(cbtype());
        ObservableList<List<String>> Medname = FXCollections.observableArrayList();
        ObservableList<List<String>> Medname1 = FXCollections.observableArrayList();
        //  ObservableList<String> count = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "---------------");

        ComboBox typeBox = new ComboBox(Type); //Updatepage Lower cb
        ComboBox typeBox2 = new ComboBox(Type1);
        ComboBox typeBox3 = new ComboBox(Type);
        ComboBox mednameBox = new ComboBox(Medname);
        ComboBox mednameBox2 = new ComboBox(Medname1);
    }
    //  ComboBox CountBox = new ComboBox(count);

    /*
           but1 => goto check 
           but2 => goto updateMed
           but3 => goto view
           but4 => goto addMed
     */
    Admin1() {

        setHbox();
        setTextbox();
        setbut();
        settext();
        setVbox();
        Updatepage();
        Setadd();
        showpatient();
        
        allbutton[4].setText("เพิ่มยา");
        allbutton[3].setText("เพิ่มยาตัวใหม่");
        allbutton[2].setText("อัพเดท/ดูข้อมูล");
        allbutton[1].setText("ตรวจสอบอาการผู้ป่วย");
        logoutBtn.setText("Logout");
        Column[1].setAlignment(Pos.CENTER);
        for (int i = 1; i < 4; i++) {
            Column[1].getChildren().add(allbutton[i]);
        }
        page1.setAlignment(Pos.CENTER);
        page1.getChildren().addAll(Column[1], logoutBtn);

    }

    void Updatepage() {
        mednameBox2.setVisibleRowCount(3);
        mednameBox.setVisibleRowCount(3);
        //CountBox.setVisibleRowCount(3);
        informBtn.setText("ดูข้อมูล");
        updateBtn.setText("อัพเดท");
        upbackBtn.setText("ย้อนกลับ");
        removeBtn.setText("Remove");
        alltext[1].setText("_______________________________________________________________________________________________________________");
        pVbox.getChildren().addAll(price);
        sVbox.getChildren().addAll(stock);
        pVbox.setAlignment(Pos.CENTER);
        sVbox.setAlignment(Pos.CENTER);
        Row[2].getChildren().addAll(typeBox2, mednameBox2, informBtn, removeBtn);
        page2.getChildren().addAll(typeBox, mednameBox, pVbox, sVbox, updateBtn, upbackBtn);
        page2.setAlignment(Pos.BOTTOM_CENTER);
        page2s.setAlignment(Pos.TOP_CENTER);
        page2s.getChildren().add(Row[2]);
        updatepage.getChildren().addAll(page2s, page2);
        updatepage.setAlignment(Pos.CENTER);
    }

    void Setadd() {
        alltext[0].setText("หมวดหมู่");
        alltext[4].setText("ชื่อยา :");
        alltext[5].setText("สรรพคุณ :");
        alltext[6].setText("จำนวน :");
        alltext[7].setText("ราคา :");
        alltext[8].setText("วันหมดอายุ:");
        allbutton[4].setText("Register");
        allbutton[5].setText("back");
        Na.setAlignment(Pos.TOP_RIGHT);
        Row[6].setAlignment(Pos.TOP_RIGHT);
        for (int j = 1; j <= 5; j++) {
            Na.getChildren().addAll(alltext[j + 3]);
            Row[6].getChildren().addAll(allfill[j]);
        }
        Column[0].setAlignment(Pos.TOP_CENTER);
        Column[0].setAlignment(Pos.TOP_CENTER);
        Column[0].getChildren().addAll(alltext[0], allfill[7]);
        addpage2.setAlignment(Pos.TOP_CENTER);
        addpage2.getChildren().addAll(Na, Row[6]);
        allbutton[4].setAlignment(Pos.CENTER_RIGHT);
        allbutton[5].setAlignment(Pos.CENTER_RIGHT);
        Column[11].getChildren().addAll(allbutton[4], allbutton[5]);
        Column[11].setAlignment(Pos.CENTER);
        addpage.setAlignment(Pos.TOP_CENTER);
        addpage.getChildren().addAll(addpage2, Column[0], Column[11]);
    }

    void refreshshowpatient() {
        arr = API.getAllSymptom();
        
        System.out.println(arr);
        if (arr == null) {
            VshowPatient.getChildren().clear();
            VshowPatient.getChildren().add(new Text(String.format("No Older Patient")));
        } else {
            VshowPatient.getChildren().clear();
            for (int i = 0; i < arr.size(); i++) {
                //  addq.getChildren().clear();

                VshowPatient.getChildren().add(new Text(String.format("Symptom  : %s   Writer : %s\n", arr.get(i).getCymtomp(), arr.get(i).getPatient())));

            }
        }
 
    }

    void showpatient() {
        mednameBox3.setVisibleRowCount(3);
        allbutton[7].setText("อ่านทั้งหมด");
        allbutton[8].setText("ย้อนกลับ");
        diagnoseBtn.setText("ส่งคำตอบรับ");
        diagH.getChildren().add(diagnoseField);
        diagH.setAlignment(Pos.BOTTOM_CENTER);
        queuePatient.getChildren().addAll(allbutton[7], mednameBox3,diagH,diagnoseBtn, allbutton[8]);
        queuePatient.setAlignment(Pos.BOTTOM_CENTER);
        patientPane.getChildren().addAll(queuePatient);
        patientPane.setAlignment(Pos.BOTTOM_CENTER);
        addq.getChildren().addAll(VshowPatient, patientPane);
        VshowPatient.setAlignment(Pos.CENTER);
        addq.setAlignment(Pos.CENTER);
        
        
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
