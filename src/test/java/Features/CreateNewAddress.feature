Feature: Create new address to existed account in MyStore

  Scenario Outline: User wants to add new address to their account
    Given The user is on "https://mystore-testlab.coderslab.pl" website
     When The User click on Sign In tile
      And User types correct email address and password to their account and click the SIGN IN button in the form zone
      And User click on the Addresses tile
      And User click on the + Create new address tile
      And User completes the new address form "<alias>", "<address>", "<city>", "<zip/postal code>", "<country>", "<phone>" and click the SAVE button
      And User address has been created
      And User wants delete added addresses
     Then Addresses deleted
     Examples:
      | alias   | address         | city    | zip/postal code  | country         | phone       |
      | Nowak   | 23 Fielding St  | London  | SE17 3HE         | United Kingdom  | 98121354312 |
