public class Patient {
    String lastName;
    String firstName;
    String address;
    String phoneNumber;
    String dateOfBirth;
    float copay;
    InsuranceType insuranceType;
    PatientType patientType;
    enum InsuranceType {
        PRIVATE,
        GOVERNMENT
    }
    enum PatientType {
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCopay(float copay) {
        this.copay = copay;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }
}
