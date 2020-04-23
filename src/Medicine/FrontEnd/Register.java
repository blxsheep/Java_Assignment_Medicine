/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.FrontEnd;

import Medicine.BackEnd.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public final class Register extends Application {

    boolean check, np;
    int i = 0, p = 0, o;
    VBox LogInpage = new VBox(5);
    BorderPane loginPane = new BorderPane();
    StackPane LoginStackPane = new StackPane();
    StackPane BgRegi = new StackPane();

    VBox Registerpage = new VBox(4);
    BorderPane REGIS_P = new BorderPane();
    HBox Registerpage2 = new HBox(4);

    HBox NameBox = new HBox(70);
    HBox PWBox = new HBox(70);

    HBox TextBox = new HBox(70);
    VBox Na = new VBox(14);

    public static String usrname = new String();

    VBox Error_Page = new VBox(60);
    VBox NameBox2 = new VBox(200);
    HBox BackBox = new HBox(20);

    Button next = new Button("OK");
    TextField fillName = new TextField();
    TextField fillPW = new PasswordField();

    Button back = new Button("back");

    ScrollPane sp = new ScrollPane();

    private Text[] alltext;
    private Button[] allbutton;
    Scene[] scene;
    VBox[] Row;
    TextField[] allfill;
    HBox[] Column;

    ObservableList<String> options = FXCollections.observableArrayList("Admin", "User");
    ObservableList<String> Registorr = FXCollections.observableArrayList("Admin", "User");
    ObservableList<String> gender = FXCollections.observableArrayList("MALE", "FEMALE");

    ComboBox comboBox = new ComboBox(options);
    ComboBox comboBox2 = new ComboBox(Registorr);
    ComboBox genderBox = new ComboBox(gender);

    //set all scene//   
    Scene s1 = new Scene(loginPane, 700, 650);
    Scene s2 = new Scene(Error_Page, 700, 650);
    Scene s3 = new Scene(REGIS_P, 700, 650);

    /////////////////////////////////////////////////////////////
    /////////////setting for scene///////////////////////////////
    //Create starting page//
    Register(Stage a) throws FileNotFoundException {

        /*-------------------------------------------------------*/
        // HBox.setMargin(fillName, new Insets(5));
        fillName.setPrefSize(150, 15);
        fillPW.setPrefSize(150, 15);
        //    fillName.setPromptText("asd");

        //  LogInpage.setStyle("-fx-background-image:url(\"src/Medicine/FrontEnd/Images/bg.png\");");
        //LogInpage.setStyle("-fx-background-color:rgb(51,51,51) ");
       // LogInpage.setPrefSize(600, 800);

        next.setPrefSize(200, 15);
        //     next.setMaxSize(120, 60); // linear-gradient(#042A5A, #0B509B)
        next.setStyle("-fx-background-color :linear-gradient(#042A5A,#0B509B); -fx-text-fill: red;-fx-border-color: black;");

        try {
            next.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Anantason-Regular.ttf")), 10));
            //  fillName.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Anantason-Regular.ttf")), 10));
         //   ImageView imgv = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/GIF1.gif"))));
//             ImageView imgv = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/GIF1.gif"))));
            ImageView imglf = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/bglog.png"))));
           // LogInpage.getChildren().add(imgv);
           
        ImageView bgRg = new ImageView(new Image(new FileInputStream(new File("src/Medicine/FrontEnd/Images/bglog.png"))));
          LoginStackPane.getChildren().add(imglf);
         BgRegi.getChildren().add(bgRg);
         
           //loginPane.setLeft(imglf);

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*-----------------------------------------------------------------------------*/

        settext();
        setVbox();
        settingscene();
        setbut();
        setHbox();
        setTextbox();
        SetErrpage();
        SetRegis(a);

        Admin1 Adminpage = new Admin1();
//<<<<<<< HEAD
        USER Userpage = new USER();
        np = false;
        fillName.setPromptText("YOUR ID");
        fillName.setStyle("-fx-background-color:white;");
        fillPW.setPromptText("YOUR PASSWORD");
        fillPW.setStyle("-fx-background-color:white;");

        LogInpage.setAlignment(Pos.CENTER);
        
        NameBox.setAlignment(Pos.CENTER);
        PWBox.setAlignment(Pos.CENTER);
        
        TextBox.setAlignment(Pos.CENTER);

        allbutton[3].setText("สมัครสมาชิก");
        allbutton[3].setAlignment(Pos.BOTTOM_RIGHT);

        alltext[1].setText("ยินดีต้อนรับเข้าสู่ระบบ");
        alltext[1].setFill(Color.YELLOWGREEN);
        alltext[1].setFont(Font.font(24));

        alltext[13].setText("");
        alltext[13].setFill(Color.RED);

       NameBox.getChildren().add(fillName);
        PWBox.getChildren().add(fillPW);
        BorderPane LoginBorderPane = new BorderPane();
        TextBox.getChildren().add(alltext[1]);
        LogInpage.getChildren().addAll(TextBox, NameBox, PWBox, alltext[13], next, allbutton[3]);
        LogInpage.setPadding(new Insets(20, 80, 20, 20));
        LoginBorderPane.setRight(LogInpage);
        LoginStackPane.getChildren().add(LoginBorderPane);
        
        loginPane.setCenter(LoginStackPane);
        loginPane.setTop(GLOBALBAR(a));
        

        next.setOnAction((ActionEvent t) -> {
            Person user = (Person) idcheckers();
            if (user != null) {
//<<<<<<< HEAD
//                System.out.println(user.getUserName() + " LOGIN ");
////                if (user.getRole().equals("Staff")) {
////                    alltext[13].setText("User welcome");
////                } else {
//=======
                System.out.println(user.getUserName() + " LOGIN " + user.getRole());
                if (user.getRole().equals("User")) {
                    usrname = user.getUserName();
                    //      alltext[13].setText("User welcome");
                    a.setScene(Userpage.Setscene(a));
                } else {
                    usrname = user.getUserName();
//>>>>>>> origin/BlxSheep
                    a.setScene(Adminpage.admain);
//<<<<<<< HEAD
                }
            } else {
                alltext[13].setText("เกิดข้อผิดพลาด กรุณาตรวจสอบ ID หรือ PASSWORD อีกครั้ง");
//=======
//
//                }
//
//            } else {
//                alltext[13].setText("เกิดข้อผิดพลาด กรุณาเช็ค id หรือ password อีกครั้ง");
//>>>>>>> origin/BlxSheep
                Setbacktostartingpage();
            }
        });
        allbutton[3].setOnAction((ActionEvent t) -> {
            a.setScene(scene[3]);
            a.setTitle("Registor_PAGE");
        });
        ///////////////ErrorPage//////////////////
        back.setOnAction((ActionEvent t) -> {
            Setbacktostartingpage();
            a.setScene(scene[1]);
            alltext[13].setText("");
            a.setTitle("LOGIN_PAGE");
        });
        ///////////Registor Page///////////////////
        ////// Back to Loginpage From RegistorPage
        allbutton[5].setOnAction((ActionEvent t) -> {
            Setbacktostartingpage();
            registerclear();
            alltext[12].setText("");
            alltext[13].setText("");
            a.setScene(scene[1]);
            a.setTitle("LOGIN_PAGE");
        });

        allbutton[4].setOnAction((ActionEvent t) -> {
            if (checkpassWord()) {
                for (int i = 1; i < 8; i++) {
                    System.out.println(allfill[i].getText());
                }
                alltext[12].setText(" Login Success Press Back To Continues ");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("asdasdasd");
                alert.setTitle("TITLE");
                alert.setHeaderText("Header");
                alert.showAndWait();

                if (comboBox2.getValue().equals("Admin")) {
                    // Admin st = new Admin(allfill[1].getText(), allfill[2].getText());
                    Admin st = new Admin(allfill[1].getText(), allfill[2].getText(), allfill[4].getText(), allfill[5].getText(), allfill[6].getText(), allfill[7].getText());
                    String s = String.format("%s", genderBox.getValue());
                    st.setGender(s);
                    Authority.registor(st);
                }// get role
                else if (comboBox2.getValue().equals("User")) {
                    //User st = new User(allfill[1].getText(), allfill[2].getText());
                    User st = new User(allfill[1].getText(), allfill[2].getText(), allfill[4].getText(), allfill[5].getText(), allfill[6].getText(), allfill[7].getText());
                    String s = String.format("%s", genderBox.getValue());
                    st.setGender(s);
                    Authority.registor(st);
                }
                System.out.println(comboBox2.getValue());
                registerclear();
            } else {
                alltext[12].setText("เกิดข้อผิดพลาดกรุณาเช็คข้อมูลอีกครั้ง");
            }
//                 << << << < HEAD
//            
// == == == =
/*********************************************************************************/
        });
        Adminpage.allbutton[1].setOnAction((ActionEvent t) -> {
            // Queue Patient
            String ss = new String();
            ArrayList<String> userName = new ArrayList<>();
            for (int j = 0; j < API.getAllUser().size(); j++) {
                ss = API.getAllUser().get(j).getUserName();
                userName.add(ss);

            }
            Adminpage.refreshshowpatient();
            Adminpage.mednameBox3.getItems().clear();
            Adminpage.mednameBox3.getItems().addAll(userName);
            //Adminpage.showpatient();
            a.setScene(Adminpage.adshowpatient);

//                 >>> >>> > origin / BlxSheep
        });
        Adminpage.allbutton[2].setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.adupdate);
        });
        Adminpage.allbutton[3].setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.adadd);
        });
        Adminpage.allbutton[5].setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.admain);
        });
    /********************************************************************************/
//             << << << < HEAD
//        
//    
        //   }
//                == == ==
        //Add to add drug
        Adminpage.allbutton[4].setOnAction((ActionEvent t) -> {
            String name = Adminpage.allfill[1].getText();
            String des = Adminpage.allfill[2].getText();
            int stock = Integer.parseInt(Adminpage.allfill[3].getText());
            int price = Integer.parseInt(Adminpage.allfill[4].getText());
            String kind = Adminpage.allfill[7].getText();
            String exp = Adminpage.allfill[5].getText();
            API.addDrug(new Drug(kind, name, exp, des, price, stock));
            System.out.println(API.getCustom("Drugs"));
            ArrayList<String> arr = Adminpage.cbtype();
            List<List<String>> arr2 = Adminpage.cbname();
            System.out.print("CBTYPE ==  ");
            System.out.print(arr);
            System.out.print("CBNAME==");
            System.out.println(arr2);
            ArrayList<String> Type1 = arr;
            Adminpage.typeBox.getItems().clear();
            Adminpage.typeBox2.getItems().clear();
            Adminpage.typeBox.getItems().addAll(Type1);
            Adminpage.typeBox2.getItems().addAll(Type1);
//                     >>> >>> > origin / BlxSheep
//                            << << << < HEAD

//                    Register() {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////                         == == == =
        });

        Adminpage.allbutton[7].setOnAction((ActionEvent t) -> {
            //clear

            Database db = new Database();
            db.setFile("BSymptoms");
            db.write(null);
            System.out.println(API.getAllAdmin());
            Adminpage.VshowPatient.getChildren().clear();
            Adminpage.VshowPatient.getChildren().add(new Text(String.format("No Older Patient")));
            Adminpage.mednameBox3.setVisibleRowCount(3);
            Adminpage.allbutton[7].setText("Read ALL");
            Adminpage.allbutton[8].setText("Back");
            Adminpage.addq.getChildren().addAll(Adminpage.VshowPatient, Adminpage.queuePatient);

        });
        //Remove drug
        Adminpage.removeBtn.setOnAction((ActionEvent t) -> {
            String newname = String.format("%s", Adminpage.mednameBox2.getValue());
            // Remove button 
            int index = Drug.getIdxDrug(newname);
            System.out.println(" index >>" + index);
            API.removeDrug(newname);

            ArrayList<String> arx = Adminpage.cbtype();
            List<List<String>> arr2 = Adminpage.cbname();
            System.out.print("CBTYPE ==  ");
            System.out.print(arx);
            System.out.print("CBNAME==");
            System.out.println(arr2);
            ArrayList<String> Type1 = arx;
            Adminpage.typeBox.getItems().clear();
            Adminpage.typeBox2.getItems().clear();
            Adminpage.typeBox.getItems().addAll(Type1);
            Adminpage.typeBox2.getItems().addAll(Type1);
//  

            System.out.println(API.getAllDrug());
        });
        Adminpage.informBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Adminpage.typeBox2.getValue() != null && Adminpage.mednameBox2.getValue() != null) {
                    System.out.println(String.format("Select %s -> %s", Adminpage.typeBox2.getValue(), Adminpage.mednameBox2.getValue()));
                    //API.InitDrugInform();
                    String s = String.format("%s", Adminpage.mednameBox2.getValue());
                    System.out.println(API.getCustom("Drugs"));
                    System.out.println(s);
                    int index = Drug.getIdxDrug(s);
                    Drug dg = Database.getDrug().get(index);
                    System.out.println(dg);
                    System.out.print("price = " + dg.getPrice());

                    //System.out.println(indx);
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(a);
                    VBox dialogVbox = new VBox(20);
                    // dialogVbox.getChildren().add(new Text(String.format("Select %s -> %s", cb1.getValue(),cb2.getValue())));
                    dialogVbox.getChildren().add(new Text(String.format("\n      Kind : %s\n\n      Name : %s\n\n      Description : %s\n\n      Price : %s\n\n      Stock : %s\n\n      Expiration Date : %s", dg.getKind(), dg.getName(), dg.getDescription(), dg.getPrice(), dg.getStock(), dg.getExpire())));
                    Scene dialogScene = new Scene(dialogVbox, 700, 200);
                    dialog.setScene(dialogScene);
                    dialog.show();
                } else {
                    System.out.println("Error!");
                }
            }
        });
        Adminpage.allbutton[8].setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.admain);
        });
        Adminpage.upbackBtn.setOnAction((ActionEvent t) -> {
            a.setScene(Adminpage.admain);
        });
//
        Adminpage.typeBox.setOnAction(new EventHandler<ActionEvent>() { // if cb1 change value = change value in cb 2 ...
            @Override
            public void handle(ActionEvent e) {

                Adminpage.mednameBox.getItems().clear(); // Clear old member
                int index = Adminpage.Type.indexOf(Adminpage.typeBox.getValue()); // Find index of (A,B,C) in type
                // Adminpage.Medname= FXCollections.observableArrayList(Adminpage.cbname());
                System.out.println(Adminpage.cbname());
                Adminpage.mednameBox.getItems().addAll(Adminpage.cbname().get(index)); // it mean name[i] -> but use .get(i)
            }
        });

        Adminpage.typeBox2.setOnAction(new EventHandler<ActionEvent>() { // if cb1 change value = change value in cb 2 ...
            @Override
            public void handle(ActionEvent e) {
                Adminpage.mednameBox2.getItems().clear(); // Clear old member
                int index = Adminpage.Type1.indexOf(Adminpage.typeBox2.getValue()); // Find index of (A,B,C) in type               
                // Adminpage.Medname= FXCollections.observableArrayList(Adminpage.cbname());
                System.out.println(Adminpage.cbname());
                Adminpage.mednameBox2.getItems().addAll(Adminpage.cbname().get(index)); // it mean name[i] -> but use .get(i)
            }
        });

        Adminpage.updateBtn.setOnAction((ActionEvent t) -> {
            int xprice = Integer.parseInt(Adminpage.price.getText());
            int xstock = Integer.parseInt(Adminpage.stock.getText());
            String newname = String.format("%s", Adminpage.mednameBox.getValue());
            String ntype = String.format("%s", Adminpage.typeBox.getValue());

            // Update button 
            int index = Drug.getIdxDrug(newname);
            System.out.println(" index >>" + index);
            ArrayList<Drug> arr = API.getAllDrug();
            String exp = arr.get(index).getExpire();
            String Des = arr.get(index).getDescription();
            API.editDrug(newname, new Drug(ntype, newname, exp, Des, xprice, xstock));

            System.out.println(API.getAllDrug());

        });
        Adminpage.logoutBtn.setOnAction((ActionEvent t) -> {
            a.setScene(s1);
            Setbacktostartingpage();
        });
        Userpage.logoutBtn.setOnAction((ActionEvent t) -> {
            a.setScene(s1);
            Setbacktostartingpage();
        });
        /**
         * *********************************************************************
         */

        Adminpage.diagnoseBtn.setOnAction((ActionEvent t) -> {
            String sk = String.format("%s", Adminpage.mednameBox3.getValue());
            String di = Adminpage.diagnoseField.getText();
            User uss = User.getById(sk);
//        uss.setSuggestion(di);
            //   Database  db = new Database();
            //db.setFile("Suggestions");
            Suggestion sg = new Suggestion(di, sk);
            Suggestion.addSug(sg);
            System.out.println(API.getCustom("Suggestions"));
            Adminpage.mednameBox3.setValue("");
            Adminpage.diagnoseField.setText("");
            //     System.out.println(uss.getSuggestion());
        });

        /**
         * *********************************************************************
         */
//                     >>> >>> > origin / BlxSheep
    }
    ///// set position error page ////

    void SetErrpage() {
        Error_Page.setAlignment(Pos.CENTER);
        NameBox2.setAlignment(Pos.CENTER);
        BackBox.setAlignment(Pos.BOTTOM_RIGHT);
        getAlltext()[3].setText("Plesae check YOUR ID or PASSWORD");
        getAlltext()[3].setFill(Color.RED);
        getAlltext()[2].setText("Error");
        getAlltext()[2].setFont(Font.font(20));
        BackBox.getChildren().add(back);
        NameBox2.getChildren().addAll(getAlltext()[2], getAlltext()[3]);
        Error_Page.getChildren().addAll(NameBox2, BackBox);
    }
    // next.setFont(Font.loadFont(new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Anantason-Regular.ttf")), 10));
    void SetRegis(Stage a) throws FileNotFoundException {
        
        Font f1 = new Font(28);
        getAlltext()[0].setText("สถานะ");
        getAlltext()[4].setText("ID :");
        getAlltext()[5].setText("PASSWORD :");
        getAlltext()[6].setText("CONFIRM PASSWORD :");
        getAlltext()[7].setText("ชื่อ :");
        getAlltext()[8].setText("นามสกุล :");
        getAlltext()[9].setText("อายุ :");
        getAlltext()[10].setText("อีเมล :");
        getAlltext()[11].setText("เพศ");
        getAlltext()[12].setText("");
        getAlltext()[12].setFill(Color.RED);
        getAllbutton()[4].setText("Register");
        getAllbutton()[5].setText("back");

        Na.setAlignment(Pos.TOP_RIGHT);
        Row[6].setAlignment(Pos.CENTER);
        for (int j = 1; j <= 7; j++) {
            Na.getChildren().addAll(getAlltext()[j + 3]);
            Row[6].getChildren().addAll(allfill[j]);
           Row[6].setSpacing(23);
        }
        for (int j = 0; j < 13; j++) {
           if(j!=2&&j!=3){
            FileInputStream font1 = new FileInputStream(new File("src/Medicine/FrontEnd/Fonts/Serithai-Regular.ttf"));
            getAlltext()[j].setFont(Font.loadFont(font1, 18));
           getAlltext()[j].setFill(Color.WHITE);
           }
        }
        /**
         * ***********************************************************************************
         */  // Insets ซ้าย บน ล่าง ขวา
        genderBox.setMinSize(175, 35);
        comboBox2.setMinSize(175, 35);

//        Column[0].setAlignment(Pos.CENTER);
//        Column[0].setAlignment(Pos.CENTER); // สถานะ
//        Column[0].getChildren().addAll(getAlltext()[0], comboBox2);
//         Column[0].setPadding(new Insets(10, 10, 10, 10));
         
         GridPane comboGrad = new GridPane();
         comboGrad.setPadding(new Insets(25,10, 25, 25));
         comboGrad.add(getAlltext()[0], 0, 0); comboGrad.add(comboBox2, 1, 0);
          comboGrad.add(getAlltext()[11], 0, 1); comboGrad.add(genderBox, 1, 1);
        comboGrad.setAlignment(Pos.CENTER_RIGHT); comboGrad.setVgap(2);comboGrad.setHgap(2);
        
//          Column[8].setAlignment(Pos.CENTER); // เพศ
//        Column[8].getChildren().addAll(getAlltext()[11], genderBox);
//        Column[8].setPadding(new Insets(10, 10, 10, 10));

        Registerpage2.setAlignment(Pos.CENTER);
        Registerpage2.getChildren().addAll(Na, Row[6]);
        Registerpage2.setPadding(new Insets(10, 10, 10, 10));

        getAllbutton()[4].setAlignment(Pos.CENTER);
        getAllbutton()[5].setAlignment(Pos.CENTER);

        Column[11].getChildren().addAll(getAllbutton()[4], getAllbutton()[5]);
        Column[11].setAlignment(Pos.CENTER);
        getAllbutton()[4].setAlignment(Pos.CENTER);
        getAllbutton()[5].setAlignment(Pos.CENTER);
        Column[11].setPadding(new Insets(10, 10, 10, 10));
       
        Registerpage.setAlignment(Pos.CENTER);
        Registerpage.getChildren().addAll(Registerpage2,comboGrad, getAlltext()[12], Column[11]);
        
        BorderPane RegiBorderPane = new BorderPane();
        RegiBorderPane.setRight(Registerpage);
        BgRegi.getChildren().addAll(RegiBorderPane);
        
        REGIS_P.setCenter(BgRegi);
        REGIS_P.setTop(GLOBALBAR(a));
    }

    /**
     * **************************************************************************************
     */
    //////////////////////////////////////////////////////
    ///////////////another function///////////////////////
    //////////////////////////////////////////////////////
    boolean checkpassWord() {
        if (allfill[2].getText().equals(allfill[3].getText()) && allfill[2].getText() != " ") {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    void Setbacktostartingpage() {
        fillName.setPromptText("YOUR ID");
        fillPW.setText("");
        comboBox.setValue("");
        scene[1] = s1;
    }

    void registerclear() {
        for (int j = 1; j < 8; j++) {
            allfill[j].setText("");
        }
        comboBox2.setValue("");
        genderBox.setValue("");
    }

    Object idcheckers() {
        System.out.println("test " + fillName.getText());
        return Authority.login(fillName.getText(), fillPW.getText());

    }

    public void settingscene() {
        scene = new Scene[5];
        scene[1] = s1;
        scene[2] = s2;
        scene[3] = s3;
    }

    public void settext() {
        setAlltext(new Text[20]);
        for (int i = 0; i < 20; i++) {
            getAlltext()[i] = new Text("");
        }
    }

    public void setbut() {
        setAllbutton(new Button[20]);
        for (int i = 1; i < 20; i++) {
            getAllbutton()[i] = new Button("");
            getAllbutton()[i].setAlignment(Pos.CENTER);
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
            Column[i] = new HBox(60);
            Column[i].setAlignment(Pos.CENTER);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    <<<<<<< HEAD
//
//    =======

    public static String getusrname() {

        return usrname;
    }

//    >>>>>>> origin
//    /BlxSheep
    /**
     * @return the alltext
     */
    public Text[] getAlltext() {
        return alltext;
    }

    /**
     * @param alltext the alltext to set
     */
    public void setAlltext(Text[] alltext) {
        this.alltext = alltext;
    }

    /**
     * @return the allbutton
     */
    public Button[] getAllbutton() {
        return allbutton;
    }

    /**
     * @param allbutton the allbutton to set
     */
    public void setAllbutton(Button[] allbutton) {
        this.allbutton = allbutton;
    }

    public HBox GLOBALBAR(Stage a) {
        HBox loginBar = new HBox();
        loginBar.setStyle("-fx-background-color:rgb(187,88,35) ");
        try {

            ImageView minImage = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/min1.png")));
            loginBar.getChildren().add(minImage);
            minImage.setOnMouseClicked((t) -> {
                a.setIconified(true);
            });
            loginBar.setAlignment(Pos.CENTER_RIGHT);

            ImageView closeImage = new ImageView(new Image(new FileInputStream("src/Medicine/FrontEnd/Images/cancle1.png")));
            loginBar.getChildren().add(closeImage);
            closeImage.setOnMouseClicked((t) -> {
                System.exit(0);
            });
            loginBar.setAlignment(Pos.CENTER_RIGHT);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginBar;
    }
}
