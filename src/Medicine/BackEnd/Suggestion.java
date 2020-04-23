/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Voranipit
 */
public class Suggestion extends Person {
    String message  ; 
    String receiver ; 

    public Suggestion(String message, String receiver) {
        this.message = message;
        this.receiver = receiver;
    }

    Suggestion() {
      this.message = ".."; //To change body of generated methods, choose Tools | Templates.
      this.receiver = "...";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public static void  addSug (Suggestion sug){
        Database db = new Database ();
        db.setFile("Suggestions");
        ArrayList<Suggestion> arr = new ArrayList<>();
        arr = API.getAllSug();
        if(arr == null){
            ArrayList<Suggestion> arr2 = new ArrayList<>();
            arr2.add(sug);
            db.write(arr2);
        }
        else{
            arr.add(sug);
            db.write(null);
            db.write(arr);
    }
    }

    @Override
    public String toString() {
        return "Suggestion{" + "message=" + message + ", receiver=" + receiver + '}';
    }

    @Override
    public String getRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//       public static void addSug(Suggestion  drug) {
//        Database db = new Database();
//        db.setFile("Suggestions");
//        ArrayList<Suggestion> d = API.getAllSug();
//        
//
//        if (d == null) {
//            ArrayList<Suggestion> k = new ArrayList<Suggestion>();
//            k.add(drug);
//            db.write(k);
//        } else {
//
//            d.add(drug);
//            db.write(null);
//            db.write(d);
//        }
//    }
//
//    public static void removeDrug(String Dname) {
//        int index = Drug.getIdxDrug(Dname);
//        System.out.println("inx" + index);
//        Database db = new Database();
//        db.setFile("Drugs");
//        ArrayList<Drug> d = API.getAllDrug();
//        d.remove(index);
//        db.write(null);
//        db.write(d);
//
//    }
//
//    public static void editDrug(String Old_Drugname, Drug New) {
//        // Hard when merge ,Have to create new Drug.
//        int index = Drug.getIdxDrug(Old_Drugname);
//        Database db = new Database();
//        db.setFile("Drugs");
//        ArrayList arr = API.getAllDrug();
//        db.write(null);
//        arr.add(index, New);
//        arr.remove(index + 1);
//        db.write(arr);
//
//    }
//    
//        public static int getIdxSug(String name) {
//        Database db = new Database();
//        db.setFile("Suggestions");
//        ArrayList<Suggestion> arr;
//        if (db.check()) {
//            arr = API.getAllSug();
//            int res = Suggestion.searchDrug(name, "", arr);
//            return res;
//        } else {
//            System.out.println("Get Indx Drug Falied.");
//            return -1;
//        }
//    }
//        public static int searchDrug(String name, String kind, ArrayList<Suggestion> source) {
//        ArrayList<Integer> byName, byKind, result;
//        byName = new ArrayList<>();
//        byKind = new ArrayList<>();
//
//        if (source != null) {
//            for (int i = 0; i < source.size(); i++) {
//                if (source.get(i).getName().equals(name)) {
//                    byName.add(i);
//                }
//                if (source.get(i).getKind().equals(kind)) {
//                    byKind.add(i);
//                }
//            }
//        }
//        if (byName.size() > 0 && byKind.size() > 0) {
//            result = (ArrayList<Integer>) Drug.intersection(byKind, byName);
//        } else {
//            result = byName.size() > 0 ? byName : byKind;
//        }
//        if (result != null && result.size() > 0) {
//            return result.get(0);
//        } else {
//            return -1;
//        }
//
//    }
//
//    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
//        List<T> list = new ArrayList<>();
//        list1.stream().filter((t) -> (list2.contains(t))).forEachOrdered((t) -> {
//            list.add(t);
//        });
//        return list;
//    }
}
