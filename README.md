


#To build the repository -  

1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.
3. to build without checkstyle or spotbug ./gradlew build -x checkstyleMain -x spotbugsMain

#The API will be available at http://localhost:8080/api/customers.
##Endpoints
POST /api/customers/add: Add a new customer. \
GET /api/customers/getAll: Retrieve a list of all customers. \
GET /api/customers/get/{customerId}: Retrieve a specific customer by ID. \
PUT /api/customers/update/{customerId}: Update customer details. \
DELETE /api/customers/delete/{customerId}: Delete a customer by ID. 
License - 
While this repository is licensed under APACHE 2.0 license, It is mandatory for users to share the readme.md and License file along with the changes they do in the contents.
