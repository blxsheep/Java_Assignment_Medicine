/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

/**
 *
 * @author weera
 */
public class Drug extends Person{

    private String kind = "";
    private String expire = "";
    private String description = "";
    private int price;
    private int stock;

    public Drug() {
    }

    public Drug(String kind, String expire, String description, int price, int stock) {
        this.kind = kind;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
     @Override
    public String toString() {
        return "{Kind : " + this.kind + " Description : " + this.description + "}";
    }

}
