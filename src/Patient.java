
public class Patient {
    String lastName;
    String firstName;
    String address;
    String phoneNumber;
    String dateOfBirth;
    float copay;
    InsuranceType insuranceType;
    PatientType patientType;
    MedicalConditions medicalConditions;

    public enum InsuranceType {
        Private,
        Government,
        Unspecified
    }
    public static InsuranceType parseInsuranceType(String str) {
        if(str.equalsIgnoreCase("private")) {
            return InsuranceType.Private;
        } else if(str.equalsIgnoreCase("government")) {
            return InsuranceType.Government;
        } else {
            return InsuranceType.Unspecified;
        }
    }
    public enum PatientType {
        Pediatric,
        Adult,
        Geriatric,
        Unspecified
    }
    public static PatientType parsePatientType(String str) {
        if(str.equalsIgnoreCase("pediatric")) {
            return PatientType.Pediatric;
        } else if(str.equalsIgnoreCase("adult")) {
            return PatientType.Adult;
        } else if(str.equalsIgnoreCase("geriatric")) {
            return PatientType.Geriatric;
        } else {
            return PatientType.Unspecified;
        }
    }

    public static class MedicalConditions {
        String name; // name of physician
        String phoneNumber; // phone number of physician
        Allergies allergies;
        Illnesses illnesses;
        public enum Allergies {
            Food,
            Medication,
            Seasonal,
            None,
            Other
        }
        public static Allergies parseAllergies(String str) {
            if(str.equalsIgnoreCase("food")) {
                return Allergies.Food;
            } else if(str.equalsIgnoreCase("medication")) {
                return Allergies.Medication;
            } else if(str.equalsIgnoreCase("seasonal")) {
                return Allergies.Seasonal;
            } else if(str.equalsIgnoreCase("none")) {
                return Allergies.None;
            } else {
                return Allergies.Other;
            }
        }
        public enum Illnesses {
            Diabetes,
            CHD,
            Asthma,
            None,
            Other
        }
        public static Illnesses parseIllnesses(String str) {
            if(str.equalsIgnoreCase("diabetes")) {
                return Illnesses.Diabetes;
            } else if(str.equalsIgnoreCase("chd")) {
                return Illnesses.CHD;
            } else if(str.equalsIgnoreCase("asthma")) {
                return Illnesses.Asthma;
            } else if(str.equalsIgnoreCase("none")) {
                return Illnesses.None;
            } else {
                return Illnesses.Other;
            }
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

    /*
    Example format:
    John Doe - 123-456-7890
    Jane Doe - 909-909-9090
     */
    public String shortFormat() {
        return getFirstName() + " " + getLastName() + " - " + getPhoneNumber();
    }
}
