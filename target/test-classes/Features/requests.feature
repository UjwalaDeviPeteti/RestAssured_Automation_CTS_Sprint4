Feature: To validate the rahul sheety endpoints with the given request

Scenario: To validate the authpost request
  Given Enter the baseuri and Authpostrequest
  When Send the Authpost request
  Then Validate the auth response
  And Log the auth results

Scenario: to validate the tokenpost request
  Given Enter the baseuri and Tokenrequest
  When Send the Tokenpost request
  Then Validate the token response
  And Log the token results

Scenario: to validate the addbookingpost request
  Given Enter the baseuri and Addrequest
  When Send the Addbookingpost request with booking details
  Then Validate the booking response
  And Log the booking results

Scenario: to validate the viewbookingget request
  Given Enter the baseuri and GetListrequest
  When Send the GetList request
  Then Validate the listofbooks response
  And Log the listofbooks results

Scenario: to validate the bookingidget request
  Given Enter the baseuri and GetIdrequest
  When Send the GetById request with bookingId
  Then Validate the bookingid response
  And Log the bookingid results

Scenario: to validate the bookingclassget request
  Given Enter the baseuri and GetClassrequest
  When Send the GetByClass request with trainClass
  Then Validate the bookingclass response
  And Log the bookingclass results

Scenario: to validate the deleteid request
  Given Enter the baseuri and DeleteIdrequest
  When Send the DeleteById request with bookingId
  Then Validate the deleteid response
  And Log the deleteid results
