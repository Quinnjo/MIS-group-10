/*
 * The patient database class
 */
import java.util.ArrayList;

public class PatientDatabase {
    final int MAX_PATIENT_NUMBER = 100;

    private ArrayList<Patient> patientList;
    private int numPatients;
    String filePath;

    public PatientDatabase(String filePath) {
        this.filePath = filePath;
        patientList = new ArrayList<Patient>(); // make

        // TODO: open and process the file
    }

    public void insertProfile(Patient patient) {
        // insert patient into database
        patientList.add(patient);
    }

    public void deleteProfile(String lastName, String dateOfBirth) {
        // delete patient profile from database
        for(int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);
            if(p.getLastName() == lastName && p.getDateOfBirth() == dateOfBirth) {
                patientList.remove(i);
                return;
            }
        }
    }

    // This method should take another parameter that holds the updated patient information
    // But what type should that parameter be? Another patient class?
    // Remember: a patient's date of birth may not be modified!
    public void updateProfile(String lastName, String dateOfBirth, Patient newPatient) {
        // TODO: update patient profile
        // TODO: make methods to update specific patient attributes?
        for(int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);
            if(p.getLastName() == lastName && p.getDateOfBirth() == dateOfBirth) {
                if(dateOfBirth == newPatient.getDateOfBirth()) {
                    patientList.set(i, newPatient);
                    return;
                } else {
                    // you can't update a patient's date of birth!
                    // we shouldn't modify the patient
                    // should we raise an exception?
                }
            }
        }
        // if we reach here, no patient was found
        // should we raise an exception?
    }

    public Patient findPatient(String lastName, String dateOfBirth) {
        // TODO: find patient based off of parameters, and display patient
        // What does display mean? What is the return type of this function?
        // For now, this method returns the patient that we seek
        for(int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);
            if(p.getLastName() == lastName && p.getDateOfBirth() == dateOfBirth) {
                return patientList.get(i);
            }
        }
        // we couldn't find a patient
        // return null? raise an exception?
        return null;
    }

    /*
     * TODO: Summary report methods
     * We should be able to search patients based on doctor, insurance type, etc.
     * and display these patients in search results
     */
}