/*
 * The patient database class
 */

import java.util.ArrayList;
import java.lang.Exception;

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

    // This should throw an exception if a Patient is not found
    // throws PatientNotFoundException
    public void deleteProfile(String lastName, String dateOfBirth) throws PatientNotFoundException {
        // delete patient profile from database
        for(int i = 0; i < patientList.size(); i++) {
            Patient p = patientList.get(i);
            if(p.getLastName() == lastName && p.getDateOfBirth() == dateOfBirth) {
                patientList.remove(i);
                return;
            }
        }
        // if the patient is not found, throw an exception
        throw new PatientNotFoundException("No patient was found with query: LastName=" + lastName + ", DOB=" + dateOfBirth);
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

    // throws PatientNotFoundException
    public Patient findPatient(String lastName, String dateOfBirth) throws PatientNotFoundException {
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
        throw new PatientNotFoundException("No patient was found with query: LastName=" + lastName + ", DOB=" + dateOfBirth);
    }

    /*
     * TODO: Summary report methods
     * We should be able to search patients based on doctor, insurance type, etc.
     * and display these patients in search results
     */

    // ArrayList<Patient>
    /*
    In addition to the above actions for the individual patient profiles, additional functions allow summary
    reports to be compiled. These reports can be generated for each of the following fields individually –
    physician, patient type, insurance type, allergies, and illnesses.
    For this assignment, you need not consider a combination
    of these fields.

    These methods return a String list with patient names and phone numbers
    If no patients match, then return an empty String
     */


    /*
    Example format:
    John Doe - 123-456-7890
    Jane Doe - 909-909-9090
     */


    String physicianReport(String physicianName) {
        String result = "";
        for(Patient p : patientList) {
            if(p.medicalConditions.name == physicianName) {
                result = result + p.shortFormat();
                result += "\n";
            }
        }
        return result;
    }

    String patientTypeReport(Patient.PatientType patientType) {
        String result = "";
        for(Patient p : patientList) {
            if(p.patientType == patientType) {
                result = result + p.shortFormat();
                result += "\n";
            }
        }
        return result;
    }

    String insuranceTypeReport(Patient.InsuranceType insuranceType) {
        String result = "";
        for(Patient p : patientList) {
            if(p.insuranceType == insuranceType) {
                result = result + p.shortFormat();
                result += "\n";
            }
        }
        return result;
    }

    String allergiesReport(Patient.MedicalConditions.Allergies allergies) {
        String result = "";
        for(Patient p : patientList) {
            if(p.medicalConditions.allergies == allergies) {
                result = result + p.shortFormat();
                result += "\n";
            }
        }
        return result;
    }

    String illnessesReport(Patient.MedicalConditions.Illnesses illnesses) {
        String result = "";
        for(Patient p : patientList) {
            if(p.medicalConditions.illnesses == illnesses) {
                result = result + p.shortFormat();
                result += "\n";
            }
        }
        return result;
    }

    // Exception to be thrown if a database query cannot find the desired Patient object
    public class PatientNotFoundException extends Exception {
        public PatientNotFoundException() {
            super();
        }

        public PatientNotFoundException(String message) {
            super(message);
        }
    }
}