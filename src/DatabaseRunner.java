public class DatabaseRunner {
    public static void main(String[] args) {
        PatientDatabase database =
                new PatientDatabase(args[0]);
        try {
            Patient hopkins = database.findPatient("Hopkins", "1984-9-12");
            //System.out.println(hopkins);
            System.out.println("Report by doctor: Amos Green");
            System.out.println(database.physicianReport("Amos Green"));
            System.out.println("Report by allergies: Food");
            System.out.println(database.allergiesReport(Patient.MedicalConditions.Allergies.Food));
            System.out.println("Report by illness: Asthma");
            System.out.println(database.illnessesReport(Patient.MedicalConditions.parseIllnesses("ASTHMA")));
        } catch (PatientDatabase.PatientNotFoundException e) {
            e.printStackTrace();
        }

    }
}
