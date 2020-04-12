/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weera
 */
public class Drug extends Person{

    private String kind = "";
    private String name = "";
    private String expire = "";
    private String description = "";
    private int price;
    private int stock;
    

    public Drug() {
    }

    public Drug(String kind,String name , String expire, String description, int price, int stock) {
        this.kind = kind;
        this.name =name;
        this.description = description;
        this.expire = expire;
        this.price = price;
        this.stock = stock;
    }
    
   
    
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static int searchDrug(String name, String kind, ArrayList<Drug> source) {
        ArrayList<Integer> byName, byKind, result;
        byName = new ArrayList<>();
        byKind = new ArrayList<>();
     
               
        if (source != null) {
            for (int i = 0; i < source.size(); i++) {
                if (source.get(i).getName().equals(name)) {
                    byName.add(i);
                }
                if (source.get(i).getKind().equals(kind)) {
                    byKind.add(i);
                }
            }
        }
        if (byName.size() > 0 && byKind.size() > 0) {
            result = (ArrayList<Integer>) Drug.intersection(byKind, byName);
        } else {
            result = byName.size() > 0 ? byName : byKind;
        }
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return -1;
        }

    }
 public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<>();
        list1.stream().filter((t) -> (list2.contains(t))).forEachOrdered((t) -> {
            list.add(t);
        });
        return list;
    }
   public static int getIdxDrug(String name,String kind, Database d) {
        Database db = d;
        ArrayList<Drug> arr;
        if (db.check()) {
            arr = (ArrayList<Drug>) db.get();
            int res = Drug.searchDrug("",name, arr);
            return res;
        } else {
            System.out.println("Get Data Falied.");
            return -1;
        }
    }

    
     @Override
    public String toString() {
        return "{Kind : " + this.kind + " Description : " + this.description + "}";
    }

}
