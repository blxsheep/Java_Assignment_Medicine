/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

/**
 *
 * @author Voranipit
 */
public class BSymptom extends Person{
    String cymtomp;
    String patient ;

    public BSymptom(String cymtomp) {
        this.cymtomp = cymtomp;
        this.patient ="Unknown";
    }

    public BSymptom(String cymtomp, String patient) {
        this.cymtomp = cymtomp;
        this.patient = patient;
    }

    public String getCymtomp() {
        return cymtomp;
    }

    public void setCymtomp(String cymtomp) {
        this.cymtomp = cymtomp;
    }

    public String getPatient() {
        return patient;
    }

    public BSymptom() {
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "BSymptom{" + "Symptom: " + cymtomp + ", Patient: " + patient + '}';
    }

    @Override
    public String getRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
}
