/*
 * Entirely static class meant to test PatientDatabase functionalities
 * We should be able to:
 * - Load the database from a file
 * - Find a patient
 * - Get a summary report based on physician name, allergies, or illnesses
 * - Insert a patient
 * - Remove a patient
 * - Update a patient
 * - Write the database to a file
 * - See database changes reflected in the file
 * - Catch exceptions related to the database including
 *      * DatabaseFileException (the database file is not formatted properly)
 *      * PatientNotFoundException (no patient could be found in a search query)
 */

public class DatabaseRunner {
    public static void main(String[] args) {
        try {
            // load a new database
            PatientDatabase database = new PatientDatabase(args[0]);
            // Find and print the patient with these parameters
            Patient hopkins = database.findPatient("Hopkins", "1984-9-12");
            System.out.println(hopkins);

            System.out.println("Report by doctor: Amos Green");
            System.out.println(database.physicianReport("Amos Green"));
            System.out.println("Report by allergies: Food");
            System.out.println(database.allergiesReport(Patient.MedicalConditions.Allergies.Food));
            System.out.println("Report by illness: Asthma");
            System.out.println(database.illnessesReport(Patient.MedicalConditions.parseIllnesses("ASTHMA")));

            // Insert a patient and save to the file
            database.insertProfile(makeDemoPatient("2031234567"));
            database.writeToFile();

            // Find the newly inserted patient and print them
            Patient recoverPatient = database.findPatient("McAndrew", "2002-06-13");
            System.out.println(recoverPatient.shortFormat());

            // update the patient
            //Patient updatedPatient = makeDemoPatient("8087073333");
            //database.updateProfile("McAndrew", "Quinn", updatedPatient);

            // find the updated patient and print them again
            System.out.println(database.findPatient("McAndrew", "2002-06-13").shortFormat());

            // delete this patient from the database
            database.deleteProfile("McAndrew", "2002-06-13");

            database.writeToFile();
        } catch (PatientDatabase.PatientNotFoundException e) {
            e.printStackTrace();
        } catch (PatientDatabase.DatabaseFileException e) {
            e.printStackTrace();
        }

        // Try opening a database at a bad filepath
        try {
            PatientDatabase database = new PatientDatabase("../junk/filepath/file.txt");
        } catch (PatientDatabase.DatabaseFileException e) {
            e.printStackTrace();
        }

        // Try finding, updating, or deleting a patient that doesn't exist
        try {
            PatientDatabase database = new PatientDatabase(args[0]);
            Patient p = database.findPatient("NoName", "NoDOB");
            database.deleteProfile("NoName", "NoDOB");
            //database.updateProfile("NoName", "NoDOB", makeDemoPatient("number"));
        } catch (PatientDatabase.DatabaseFileException e) {
            e.printStackTrace();
        } catch (PatientDatabase.PatientNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Patient makeDemoPatient(String phoneNumber) {
        return new Patient("McAndrew", "Quinn", "11 Husky Way", phoneNumber, "2002-06-13",
                5.0F, Patient.InsuranceType.Private, Patient.PatientType.Pediatric,
                new Patient.MedicalConditions("Larry Medicine", "9099099090",
                        Patient.MedicalConditions.Allergies.Seasonal, Patient.MedicalConditions.Illnesses.Asthma));
    }
}


