# about
Developed a dynamic API for comprehensive customer data management,incorporating storage of names, emails, and dates of birth. \
Implemented logic for automatic assignment of customer groups based onoccupation, enhancing operational efficiency. \
Designed appropriate REST API for CRUD \
Demonstrated strong problem-solving skills by effectively handling exceptions and ensuring system stability. \

# To build the repository -  
1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.
3. to build without checkstyle or spotbug ./gradlew build -x checkstyleMain -x spotbugsMain

# The API will be available at http://localhost:8081/customer
# Endpoints
POST /customer/add: Add a new customer. \
GET /customer/getAll: Retrieve a list of all customers. \
GET /customer/get/{customerId}: Retrieve a specific customer by ID. \
PUT /customer/update/{customerId}: Update customer details. \
DELETE /customer/delete/{customerId}: Delete a customer by ID. \

# License - 
While this repository is licensed under APACHE 2.0 license, It is mandatory for users to share the readme.md and License file along with the changes they do in the contents.
# Images
 ![Screenshot (11)](https://github.com/anuj2398/customer-details/assets/59406385/9fa6275d-5fd7-400e-92c1-c05bb7c9325b)

 ![Screenshot (10)](https://github.com/anuj2398/customer-details/assets/59406385/1d68ce56-5760-439a-aadd-d625c06eb7f9)

 ![Screenshot (9)](https://github.com/anuj2398/customer-details/assets/59406385/6ac5961b-3a88-4bfe-ab71-8779cd240996)

 ![Screenshot (8)](https://github.com/anuj2398/customer-details/assets/59406385/3a51830b-353f-4e72-9142-24016739dc74)

##test result
  ![Screenshot (12)](https://github.com/anuj2398/customer-details/assets/59406385/3a27c849-1498-4d0b-b6a0-69bdc4df1c7a)
