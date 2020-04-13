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
public class User extends Person {

    final String role = "User";

    public User() {
        super();
    }

//    public User(String name, String lname, String age, String stuId, String id, String password, String email,String gender) {
//        super(name, lname, age, stuId, id, password, email,gender);
//    }

   

    public String getRole() {
        return role;
    }

    public static User getById(String id) {
        return   (User) Person.getById(id);
    }

    public static int getIndex(String id) {
        return Person.getIndex(id, new User(), new Database("users"));
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "User" + s; //To change body of generated methods, choose Tools | Templates.
    }

}
