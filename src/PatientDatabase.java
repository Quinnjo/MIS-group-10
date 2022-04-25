/*
 * The patient database class
 */

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.lang.Exception;
//import java.io.*;

public class PatientDatabase {
    final int MAX_PATIENT_NUMBER = 100;

    private ArrayList<Patient> patientList;
    private int numPatients;
    String filePath;

    public PatientDatabase(String filePath) {
        this.filePath = filePath;
        patientList = new ArrayList<Patient>(); // make

        // TODO: open and process the file
        try {
            readFromFile();
        } catch(DatabaseFileException e) {
            e.printStackTrace();
        }
    }

    /*
     * Using the object's filepath, read patients into a database
     * If we run into an error processing the patient, throw an exception
     * The patient format should be akin to the schema provided in the project specifications
     * This format schema can be found in /data/schema.txt
     */
    protected void readFromFile() throws DatabaseFileException {
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // While the buffered reader has input, insert new profiles
            while(br.ready()) {
                insertProfile(readPatient(br));
            }
            br.close();
        } catch(FileNotFoundException e) {
            throw new DatabaseFileException("File at path: '" + filePath + "' could not be opened!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read Patient from a BufferedReader
    // assumes that the BufferedReader has at least 11 lines
    // enough to contain the full schema
    protected Patient readPatient(BufferedReader br) throws IOException {
        String firstName = br.readLine();
        String lastName = br.readLine();
        String address = br.readLine();
        String phoneNumber = br.readLine();
        String dateOfBirth = br.readLine();
        float copay = Float.parseFloat(br.readLine());
        Patient.InsuranceType insuranceType = Patient.parseInsuranceType(br.readLine());
        Patient.PatientType patientType = Patient.parsePatientType(br.readLine());
        String physicianName = br.readLine();
        String physicianNumber = br.readLine();
        Patient.MedicalConditions.Allergies allergies =
                Patient.MedicalConditions.parseAllergies(br.readLine());
        Patient.MedicalConditions.Illnesses illnesses =
                Patient.MedicalConditions.parseIllnesses(br.readLine());
        Patient patient = new Patient(lastName, firstName, address, phoneNumber,
                dateOfBirth, copay, insuranceType, patientType,
                new Patient.MedicalConditions(physicianName, physicianNumber,
                        allergies, illnesses));
        return patient;
    }

    protected void writeToFile() {
        File file = new File(filePath);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(Patient p : patientList) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Writes a Patient p to BufferedWriter bw according to the schema
    protected void writePatient(Patient p, BufferedWriter bw) throws IOException {
        bw.write(p.getFirstName());
        bw.newLine();
        bw.write(p.getLastName());
        bw.newLine();
        bw.write(p.getAddress());
        bw.newLine();
        bw.write(p.getDateOfBirth());
        bw.newLine();
        bw.write(String.valueOf(p.getCopay()));
        bw.newLine();
        bw.write(p.getInsuranceType().name());
        bw.newLine();
        bw.write(p.getPatientType().name());
        bw.newLine();
        bw.write(p.getMedicalConditions().getName());
        bw.newLine();
        bw.write(p.getMedicalConditions().getPhoneNumber());
        bw.newLine();
        bw.write(p.getMedicalConditions().getAllergies().name());
        bw.newLine();
        bw.write(p.getMedicalConditions().getIllnesses().name());
        bw.newLine();
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
        // Find patient based off of parameters, and display patient
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
     * Summary report methods
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

    // Exception to be thrown if patients in the file at filepath are not formatted correctly
    public class DatabaseFileException extends  Exception {
        public DatabaseFileException() {
            super();
        }

        public DatabaseFileException(String message) {
            super(message);
        }
    }
}