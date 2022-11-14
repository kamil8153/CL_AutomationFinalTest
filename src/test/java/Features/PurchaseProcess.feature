 Feature: Purchase process with existed account in MyStore

  Scenario Outline: User wants add product to the cart and finalized purchase process
   Given The user is on "https://mystore-testlab.coderslab.pl" website
   When The User click on Sign In tile
   And User types correct email address and password to their account and click the SIGN IN button in the form zone
   And User click on Clothes tile
   And User click on Hummingbird Printed Sweater tile
   And User check if the discount on the product is 20%
   And User choose size "<size>"on drop down list
   And User add "<QTY>"
   And User click on add to cart button
   And User click proceed to checkout button on product page
   And User click proceed to checkout button on cart page
   And User choose main addresses and click CONTINUE button
   And User choose PrestShop Pick Up in- store option and click continue button
   And User click Pay By Check option, check checkbox I agree to the terms... and click place order button
   And Order has been created and confirmed, screenshot created
   And User click on your account
   And User click on order history
   Then Check if order is on the list with status awaiting check payment and make sure the amount is the same like on order page
   Examples:
    | size | QTY |
    | m    | 5   |
