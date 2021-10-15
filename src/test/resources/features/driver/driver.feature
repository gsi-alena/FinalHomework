Feature: Drivers List view
  As a: GoHeavy Admin / Fleet Owner
  I want to: Add drivers
  So that: I can add drivers

Background: 
    Given Any user is logged as GoHeavy Admin / Document Approver/ Fleet Owner 
  
  Scenario: Add Driver
    Given The user is in Drivers List view
    And Clicks on the AddDriver button
    When User insert driver valid data 
    And Clicks on the Add button 
    Then The system saves the new driver information
    And The system displays popup with driver creation success message "<A new Driver was successfully created.>"

  #Scenario Outline: Approve Driver documents
  #Given The user is in Drivers List view
  #When Select Driver "<pdriver>" 
  #And Clicks on the Documents icon that belong to a driver 
  #And Clicks on the View icon on the Documents for Driver view
  #When Clicks on the Approve button on the Driver name -Document Type view
  #Then The system set to Clear the driver document status
 
  #Examples:
  #|name|
  #|Lola|
  #|Pedro|
 
  Scenario Outline: Activate Driver
    Given The user Added driver "<pdriver>"
    And The user Added Vehicle "<pvehicle>"
    And Approved Driver "<pdriver>" and Vehicle documents "<pvehicle>"
    And The user is in Drivers List view
    When Select Driver "<pdriver>" 
    And Clicks on the Edit icon
    When Update Driver Status to "<status>" 
    Then The system displays popup with success update message "<The Driver was successfully updated.>"
    And Check the Driver is activated on Drivers List view

    Examples:
    |pdriver|pvehicle|status|
    |Lola|12345678945612547|GoHeavy Ready|
    #|Pedro|12511115545454125|GoHeavy Ready|