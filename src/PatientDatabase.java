/*
 * The patient database class
 */
static final int MAX_PATIENT_NUMBER = 100;

public class PatientDatabase {
    private Patient array[MAX_PATIENT_NUMBER];
    private int numPatients;
    String filePath;

    public PatientDatabase(String filePath) {
        this.filePath = filePath;

        // TODO: open and process the file
    }

    public void insertProfile(Patient patient) {
        // TODO: insert patient into database
    }

    public void deleteProfile(String lastName, String dateOfBirth) {
        // TODO: delete patient profile from database
    }

    // This method should take another parameter that holds the updated patient information
    // But what type should that parameter be? Another patient class?
    // Remember: a patient's date of birth may not be modified!
    public void updateProfile(String lastName, String dateOfBirth) {
        // TODO: update patient profile
    }

    public void displayPatient(String lastName, String dateOfBirth) {
        // TODO: find patient based off of parameters, and display patient
        // What does display mean? What is the return type of this function?
    }

    /*
     * TODO: Summary report methods
     * We should be able to search patients based on doctor, insurance type, etc.
     * and display these patients in search results
     */
}