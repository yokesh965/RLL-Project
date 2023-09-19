Feature: Capture Vitals of the patient

@invalid_data
Scenario Outline: A user with Invalid data must get error message
Given a user is on the landing page of OpenMRS
When he enter the username as "admin"
And he enter the password as "Admin123"
And he clicks on the Login button
And he clicks on the Capture Vitals
And he clicks on any one patient from the list
And he clicks on the Confirm button
And he enters the height as "<height>"
And he enters the weight as "<weight>"
And he enters the temperature as "<temperature>"
Then he must get a error message "Maximum: 43"

Examples:
|height|weight|temperature|
|150|50|50|