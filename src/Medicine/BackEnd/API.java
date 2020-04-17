/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class API {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(API.getAllUser());
//         Authority.login("Gai", "g12345"); 
//        API.InitDrugInform();
//        System.out.println(API.getAllDrug());
//        
        
        

//        db.setFile("BSymptoms");
//        ArrayList<BSymptom> st = new ArrayList<BSymptom>();
//        API.InitSymptom();
//        System.out.println(API.getCustom("BSymptoms"));
        //db.setFile("Drugs");
        
      
 //      int  index = Drug.getIdxDrug("b1");
    //    System.out.println(index);
//        ArrayList<Drug> arr = new ArrayList<Drug>();
//        API.InitDrugInform();
//        System.out.println(API.getCustom("Drugs"));
//
//       API.addDrug(new Drug("asd", "name1", "20/10/20", "Testing add", 1, 20));
//        System.out.println(API.getCustom("Drugs"));
//             
//       API.removeDrug("b1");
//        System.out.println(API.getCustom("Drugs"));
//        API.editDrug("b2", new Drug("Edit", "Edited", "20/10/20", "Testing add", 1, 20));
//       
//       System.out.println(API.getCustom("Drugs"));
//       
//       ArrayList<Comment> cm = new ArrayList<Comment>();
//        API.InitComment();
//        API.addComment(new BComment("Hello Admin", "drgn"));
//        System.out.println(API.getCustom("Comments"));
    }

    public static boolean _INIT_DATABASE_() {
        Database db = new Database();

        return db._init_();
    }

    public static boolean _NEW_DATABASE_(String fileName) {
        Database db = new Database();
        return db.newDatabase(fileName, null);
    }

    public static ArrayList<ArrayList<Object>> _GET_DATABASE_() {
        Database db = new Database("Lists");
        ArrayList<ArrayList<Object>> arr = new ArrayList<>();
        ArrayList<String> list = (ArrayList<String>) db.get();
        for (String file : list) {
            db.setFile(file);
            arr.add((ArrayList<Object>) db.get());
        }
        return arr;
    }

    /**
     * Get all Account
     *
     * @return
     */
    public static ArrayList<User> getAllUser() {
        Person st = new User();
        Database db = st.getDbPath();
        return (ArrayList<User>) db.get();
    }

    public static ArrayList<Admin> getAllAdmin() {
        Person st = new Admin();
        Database db = st.getDbPath();
        return (ArrayList<Admin>) db.get();
    }

    public static ArrayList<Drug> getAllDrug() {
        Person st = new Drug();
        Database db = st.getDbPath();
        return (ArrayList<Drug>) db.get();
    }
    
    public static ArrayList<BComment> getAllComment() {
        Person st = new BComment();
        Database db = st.getDbPath();
        return (ArrayList<BComment>) db.get();
    }
    
    public static ArrayList<BSymptom> getAllSymptom() {
        Person st = new BSymptom();
        Database db = st.getDbPath();
        return (ArrayList<BSymptom>) db.get();
    }

    public static ArrayList<Object> getCustom(String file) {
        Database db = new Database(file);
        return (ArrayList<Object>) db.get();
    }

    /**
     * Return an Index from Object Database
     *
     * @param Person and it's Child
     * @param o
     * @return Index
     */
    public static <E extends Person> int searchByObject(E object) {
        Database db = object.getDbPath();
        return Person.search(object.getFirstName(), object.getUsername(), (ArrayList<Person>) db.get());
    }

    public static Person searchById(String id) {
        ArrayList<Person> arr = Database.getPerson();
        if (arr != null) {
            int res = Person.search("", id, arr);
            if (res != -1) {
                return arr.get(res);
            } else {
                return null;
            }
        } else {
            System.out.println("Get Data Falied.");
            return null;
        }
    }

    public static <E extends Person> boolean saveToDatabase(E... o) {
        return E.submit(o);
    }

    /**
     * Pass file name and your data
     *
     * @param <E>
     * @param file
     * @param data
     * @return boolean
     */
    public static <E extends Person> boolean saveToCustom(String file, E... data) {
        Database db = new Database(file);
        ArrayList<Person> cs;
        for (Person c : data) {
            cs = (ArrayList<Person>) db.get();
            int isExist = Person.search(null, c.getUsername(), cs);
            if (isExist != -1) {
                cs.set(isExist, c);
            } else {
                if (cs == null) {
                    cs = new ArrayList<>();
                }
                cs.add(c);
            }
            if (!db.write(cs)) {
                System.out.println("Submit Falied.");
                return false;
            }
        }
        return true;
    }

    public static void InitDrugInform() {

        Database db = new Database();
        ArrayList<Drug> arr = new ArrayList<Drug>();

        db.setFile("Drugs");
        Drug d1 = new Drug("A", "a1", "20/2/20", "Nothing Here", 200, 1);
        Drug d2 = new Drug("A", "a2", "20/2/20", "Nothing Here", 20500, 2);
        Drug d3 = new Drug("B", "b1", "20/2/20", "Nothing Here", 2007, 3);
        Drug d4 = new Drug("B", "b2", "20/2/20", "Nothing Here", 270, 4);
        arr.add(d1);
        arr.add(d2);
        arr.add(d3);
        arr.add(d4);
        db.write(arr);

    }
     public static void InitComment() {

        Database db = new Database();
        ArrayList<BComment> arr = new ArrayList<BComment>();

        db.setFile("BComments");
      BComment  c = new BComment ("Ment Rakk","Dek doi");
        
        arr.add(c);
       
        db.write(arr);

    }
     
     public static void InitSymptom() {

        Database db = new Database();
        ArrayList<BSymptom> arr = new ArrayList<BSymptom>();

        db.setFile("BSymptoms");
      BSymptom  c = new BSymptom ("Symptom Rxample");
        
        arr.add(c);
       
        db.write(arr);

    }

    public static void addDrug(Drug drug) {
      Database db = new Database();
        db.setFile("Drugs");
        ArrayList<Drug> d= API.getAllDrug();
        
       if(d ==null){
           ArrayList<Drug> k =new ArrayList<Drug>();
              k.add(drug);
                db.write(k);
       }else {
      
        d.add(drug);
        db.write(null);
        db.write(d);
       }
    }

    public static void removeDrug(String Dname) {
        int index = Drug.getIdxDrug(Dname);
        System.out.println("inx"+index);
        Database db =  new Database();
        db.setFile("Drugs");
        ArrayList<Drug> d = API.getAllDrug();
        d.remove(index);
        db.write(null);
        db.write(d);

    }
      public static void editDrug(String Old_Drugname,Drug New) {
          // Hard when merge ,Have to create new Drug.
         int index = Drug.getIdxDrug(Old_Drugname);
         Database db = new Database();
         db.setFile("Drugs");
         ArrayList  arr = API.getAllDrug();
         db.write(null);
         arr.add(index, New);
         arr.remove(index+1);
          db.write(arr);
          

    }
    public static void addComment(BComment cm) {

         Database db = new Database();
        db.setFile("BComments");
        ArrayList<BComment> d = API.getAllComment();
        
       if(d ==null){
           ArrayList<BComment> k =new ArrayList<BComment>();
              k.add(cm);
                db.write(k);
       }else {
      
        d.add(cm);
        db.write(null);
        db.write(d);
       }
    }
    public static void addSymptom(BSymptom st) {

         Database db = new Database();
        db.setFile("BSymptoms");
        ArrayList<BSymptom> d = API.getAllSymptom();
        
       if(d ==null){
           ArrayList<BSymptom> k =new ArrayList<BSymptom>();
              k.add(st);
                db.write(k);
       }else {
      
        d.add(st);
        db.write(null);
        db.write(d);
       }
    }
    

}
