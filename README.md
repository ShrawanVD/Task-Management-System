# Task-Management-System
Build TMS and performed crud operations over it using rest api's
This project has the architecture having entity layer, controller layer, service layer and the repository layer.

Entity class - It has the model datatypes and field values saved and initiated with loads of getters and setters for each field values.
Its also responsible for depicting the columns and rows in the schema which would be made in the mysql database.

Controller class - It's responisble for connecting to the service layer and responsible for interacting with the user.
This layer has the RESTful API's defined.

Service layer - This is the business logic layer of the project which has all the necessary logic available for fetching the
appropriate data from the database as it's connected to the dao or repository layer

Repository layer - This is the heart of the application as it is connected to the database which in our case is MYSQL database

There are some other packages also namely, Security config package which is used to implement the authentication property for each 
endpoints. (we have used the basic authentication with the inmemory usage feature).

We can test the rest api endpoints using the postman and also cross-verify the schematic representation using the mysql workbench.
The toolkit used here is - Spring Tool Suite (STS).
