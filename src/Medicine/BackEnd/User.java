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
public class User extends Person {
public String  Suggestion ;

    public String getSuggestion() {
        return Suggestion;
    }

    public void setSuggestion(String Suggestion) {
        this.Suggestion = Suggestion;
    }
private String role = "User";
  //  private ArrayList<Course> courses = new ArrayList<Course>();

    public User() {
        super();
    }

    public User(String username, String password) {
        super(username, password);
    }

    public User(String username, String password, String name,  String lname, String age, String email) {
         super(username, password, name,  lname, age, email);
       
    }

   
   /* public void addCourses(Course... course) {
        this.courses.addAll(Arrays.asList(course));
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }*/

    public String getRole() {
      
        return role;
    }

    
    public static User getById(String id) {
        return (User) Person.getById(id);
    }

    public static int getIndex(String id) {
        return Person.getIndex(id, new User(), new Database("staffs"));
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "User" + s + " " + super.getUsername() + " " + super.getUserName() + " "  +super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }
}
    

