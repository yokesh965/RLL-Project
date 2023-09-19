Feature: Manage appointment for patients

@Manage_Appointment
  Scenario: Manage Appointment
    Given a user is on the landing page of openmrs website
    And he entered valid credentials and click log in button
    And he clicks Appointment Scheduling card
    And he clicks Manage Appointments card
    And he entered value and select patient
    And he select service type
    And select timeframe
    And select time block
    And click next
    Then click Save