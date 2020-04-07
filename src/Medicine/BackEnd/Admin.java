/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author USER
 */
public class Admin extends Person {

    final String role = "Admin";
    
    private ArrayList<Drug> drug = new ArrayList<Drug>();

    public Admin() {
        super.setDbPath(new Database("admins"));
    }

    public Admin(String name, String id, String password) {
        super(name, id, password);
        super.setDbPath(new Database("admins"));
    }
    
    public void addDrugs(Drug... drug) {
        this.drug.addAll(Arrays.asList(drug));
    }

    public ArrayList<Drug> getDrugs() {
        return drug;
    }
    
    public void setDrugs(ArrayList<Drug> drug) {
        this.drug = drug;
    }

    public String getRole() {
        return role;
    }

    public static Admin getById(String id) {
        return (Admin) Person.getById(id);
    }

    public static int getIndex(String id) {
        return Person.getIndex(id, new Admin(), new Database("admins"));
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Admin" + s; //To change body of generated methods, choose Tools | Templates.
    }
}
