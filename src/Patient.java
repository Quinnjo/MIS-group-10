public class Patient {
    String lastName;
    String firstName;
    String address;
    String phoneNumber;
    String dateOfBirth;
    float copay;
    InsuranceType insuranceType;
    PatientType patientType;
    public enum InsuranceType { //override toString?
        PRIVATE,
        GOVERNMENT
    }
    public enum PatientType { //override toString?
        PEDIATRIC,
        ADULT,
        GERIATRIC
    }

    public Patient(String lastName, String firstName, String address, String phoneNumber, String dateOfBirth, float copay, InsuranceType insuranceType, PatientType patientType) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.copay = copay;
        this.insuranceType = insuranceType;
        this.patientType = patientType;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public float getCopay() {
        return copay;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void updateCopay(float copay) {
        this.copay = copay;
    }

    public void updateInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void updatePatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public class MedicalConditions {
        String name;
        String phoneNumber;
        Allergies allergies;
        Illnesses illnesses;
        enum Allergies { //toString?
            FOOD,
            MEDICATION,
            SEASONAL,
            NONE,
            OTHER
        }
        enum Illnesses { //toString?
            DIABETES,
            CHD,
            ASTHMA,
            NONE,
            OTHER
        }

        public MedicalConditions(String name, String phoneNumber, Allergies allergies, Illnesses illnesses) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.allergies = allergies;
            this.illnesses = illnesses;
        }

        public String getName() {
            return name;
        }

        public void updateName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void updatePhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Allergies getAllergies() {
            return allergies;
        }

        public void updateAllergies(Allergies allergies) {
            this.allergies = allergies;
        }

        public Illnesses getIllnesses() {
            return illnesses;
        }

        public void updateIllnesses(Illnesses illnesses) {
            this.illnesses = illnesses;
        }
    }
    public void printVariables(Patient p) {
        System.out.println("First Name: "+p.getFirstName());
        System.out.println("Last Name: "+p.getLastName());
        System.out.println("Address: "+p.getAddress());
        System.out.println("Phone Number: "+p.getPhoneNumber());
        System.out.println("Date of Birth: "+p.getDateOfBirth());
        System.out.println("Copay: "+p.getCopay());
        System.out.println("Insurance Type: "+p.getInsuranceType());
        System.out.println("Patient Type: "+p.getPatientType());
    }
}
