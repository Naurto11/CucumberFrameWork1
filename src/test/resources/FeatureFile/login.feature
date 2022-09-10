Feature: To validate the login Functionality of JMS Application

  Scenario: 
    
    To validate login with invalid username and invalid password

    Given user has to chrome browser and pass the url
    When user has to enter the value in testdata1 and testdata2 field 
    And user has to click the login button
     
 
    Then user has to navigate the error page
