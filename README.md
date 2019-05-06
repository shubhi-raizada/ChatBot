# ChatBot
## Technology stack
Java 8,
Spring suite(Rest, boot,data, jpa,web),
H2 database

## REST API Documentation
Swagger UI documentation
Actuator for health

###### GET /users
This is a rest api to get all users in the system. Following is the sample response: 


     Sample response: [
                           {
                             "id": 1,
                             "phone": 9807654321
                           },
                           {
                             "id": 2,
                             "phone": 7890654322
                           },
                           {
                             "id": 3,
                             "phone": 9807654373
                           },
                           {
                             "id": 4,
                             "phone": 7899654324
                           },
                           {
                             "id": 5,
                             "phone": 9007654325
                           },
                           {
                             "id": 6,
                             "phone": 7890654326
                           }
                         ]

###### GET /users?phone=9807654321
This is a rest api to get a given user. The api end point takes user phone number as a request parameter. Following is the sample response: 

     Params: phone

     Sample response: [
                           {
                             "id": 1,
                             "phone": 9807654321
                           }
                         ]

###### GET /users/{phone}/messages
This is a rest api to get all messages sent or recieved by a given user sorted in descending order. The api end point takes  user phone number as a path variable. Following is the sample response: 

     Params: phone

     Sample response: [
                          {
                              "id": 1,
                              "toUser": 7890654322,
                              "fromUser": 9807654321,
                              "msgText": "Hello",
                              "time_stamp": "2018-10-02T07:16:45.354+0000"
                          }
                          :
                          :

                      ]

###### POST /users/{phone}/sendMessages
 This is a rest api to send and save all messages sent from one user to other. The api consumes a request json with sender and receiver phone numbers and message text and also sender's phone number as path variable. Following is the sample request and response for this rest call : 

      Params : phone
      
      Request Body : {
                       "toUser": 7890654322,
                       "fromUser": 9807654321,
                       "msgText": "Hello"
                    }


      Sample response : message sent

## H2 databse Documentation
An in memory database gets created when whenever the application gets started using spring boot. In this application there are two tables used : USER and MESSAGE. Since spring boot provides Autoconfiguration for H2 databse. 

            Link to local H2-database : localhost:8001/h2-console
            JDBC Url : jdbc:h2:mem:testdb
            
