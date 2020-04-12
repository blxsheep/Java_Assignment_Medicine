/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

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

        // Test pull
        //Registing 
//        Student st = new Student("Drgn","Last","20","62010777","IDishere","pass","mail");
//        st.setFirstName("Drgn");
//        Authority.registor(st);
//        System.out.println(Authority.login("IDishere","passc"));
        //Database db = new Database();
        //API._NEW_DATABASE_("Drugs");
        // API.InitDrugInform();
        //System.out.println(API.getCustom("Drugs"));
        //db.setFile("Drugs");
        //API.saveToCustom("Drugs", drug);
        //Drug drug = new Drug("ytk", "14Sep", "pls god", 10, 10);
        //API.addDrug(dg);
//        
        //API.saveToCustom("Drugs", drug);
        //  System.out.println(API.getCustom("Drugs"));
        /*     get datafield
      Database db = new Database();
              db.setFile("Drugs");
              ArrayList<Drug> arr = new ArrayList<Drug>();
              arr.add(new Drug("G","g1","exp","des",20,200));
              db.read();
             Drug rev =  (Drug)API.getCustom("Drugs").get(0); // get obj
             System.out.println(rev.getStock());
         */
        // System.out.println(API.getCustom("Drugs"));
//    }
      /*  API.InitDrugInform();
        Database db = new Database();
        db.setFile("Drugs");
        System.out.println(Drug.getIdxDrug("B", "b1", db));
*/

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
    public static void addDrug(Drug drug) {
        Database db = new Database();
        API._NEW_DATABASE_("Drugs");

        db.setFile("Drugs");
        //API.saveToCustom("Drugs", drug);

//        drug = (ArrayList<Drug>) db.get();
//        drug.add(new Drug("drug", "14Sep", "pls god", 10, 10));
        API.saveToCustom("Drugs", drug);
    }

    public static ArrayList<Student> getAllStudent() {
        Person st = new Student();
        Database db = st.getDbPath();
        return (ArrayList<Student>) db.get();
    }

    public static ArrayList<Staff> getAllStaff() {
        Person st = new Staff();
        Database db = st.getDbPath();
        return (ArrayList<Staff>) db.get();
    }

    public static ArrayList<Admin> getAllAdmin() {
        Person st = new Admin();
        Database db = st.getDbPath();
        return (ArrayList<Admin>) db.get();
    }

    public static ArrayList<Course> getAllCourse() {
        Person st = new Course();
        Database db = st.getDbPath();
        return (ArrayList<Course>) db.get();
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
        int index = 0;
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
}


/* Manual Add Drug 
   Database db = new Database();
        db.setFile("Drugs");
        ArrayList<Drug> dg = new ArrayList<>();
        dg = (ArrayList<Drug>) db.get();
        dg.add(new Drug("drug", "14Sep", "pls god", 10, 10));
        db.write(dg);
        dg.clear();
 */
