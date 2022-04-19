package src;
public class Patient {
    String lastName;
    String firstName;
    String address;
    String phoneNumber;
    String dateOfBirth;
    float copay;
    InsuranceType insuranceType;
    PatientType patientType;
    public enum InsuranceType {
        PRIVATE,
        GOVERNMENT
    }
    public enum PatientType {
        PEDIATRIC,
        ADULT,
        GERIATRIC
    }
    MedicalConditions medicalConditions;

    public Patient(String lastName, String firstName, String address, String phoneNumber, String dateOfBirth, float copay, InsuranceType insuranceType, PatientType patientType, MedicalConditions medicalConditions) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.copay = copay;
        this.insuranceType = insuranceType;
        this.patientType = patientType;
        this.medicalConditions = medicalConditions;
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

    public MedicalConditions getMedicalConditions() {
        return medicalConditions;
    }

    public void updateMedicalConditions(MedicalConditions medicalConditions) {
        this.medicalConditions = medicalConditions;
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
        public enum Allergies { //toString?
            FOOD,
            MEDICATION,
            SEASONAL,
            NONE,
            OTHER
        }
        public enum Illnesses { //toString?
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

    @Override
    public String toString() {
        return "Patient Details:\n" +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Address: " + address + '\n' +
                "Phone Number: " + phoneNumber + '\n' +
                "Date of Birth: " + dateOfBirth + '\n' +
                "Copay: " + copay + '\n' +
                "Insurance Type: " + insuranceType + '\n' +
                "Patient Type: " + patientType + '\n' +
                "Medical Conditions: " + medicalConditions +
                '}';
    }
}
