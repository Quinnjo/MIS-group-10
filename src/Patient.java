public class Patient {
    String lastName;
    String firstName;
    String address;
    String phoneNumber;
    String dateOfBirth;
    float copay;
    public Patient(String lastName, String firstName, String address, String phoneNumber, String dateOfBirth, float copay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.copay = copay;
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

    enum insuranceType {
        PRIVATE,
        GOVERNMENT
    }
    enum patientType {
        PEDIATRIC,
        ADULT,
        GERIATRIC
    }
}
