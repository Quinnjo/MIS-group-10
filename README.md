# MIS-group-10
**Authors: Quinn McAndrew, Justin Fontano, Ben Stilphen**
This is a partial implementation of a larger medical information system.  This repository contains a user interface overlaying a patient database. Use cases are provided below.


## Usage
### Launch the Interface
To launch the user interface, navigate to the directory `out/production/MIS-group-10` and run the command `java ProfileInterface <filepath>`, where `<filepath>` is the path to the text file containing the patient data.
### Create a New Patient
To add a new patient to the database, locate the pane titled "Enter Patient". Fill in the boxes with the corresponding information and hit the "Confirm Patient" button. If any of the fields are missing or contain poorly formatted information, an error message may pop up. Otherwise, you will receive confirmation that the patient has been added to the database.
### Delete a Patient
To delete a patient from the database, enter their date of birth and last name in the "Delete Patient" pane and then hit the delete button. A confirmation will appear if the patient was successfully deleted, and an error message will appear otherwise.
### Find a Patient
To find a patient in the database, enter their date of birth and last name in the "Find Patient" pane and then hit the search button. A window with the patient details will appear if the patient exists, and an error message will appear otherwise.
### Modify a Patient
To modify a patient, first load them by using the "Find Patient" function. Then, enter the new value of the field you wish to modify into the appropriate box, and click the corresponding update button. A confirmation will pop up when the patient is successfully modified.
### Summary Reports
To obtain a summary report of all patients in the database matching a certain field, enter the value of the field you wish to filter by into the appropriate box and hit the "Search Patients" button. A report containing all patients who match the field will appear.
### Exiting
To exit the interface, hit the 'X' button in the top corner of the window. Every action that modifies the database will cause the values to be saved, and any modifications made in one session will persist until the next time the interface is launched.