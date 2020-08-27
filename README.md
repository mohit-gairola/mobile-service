# mobile-service
Mobile service is REST API for searching handset records using different search criteria

# Supported Operartions
It supports GET operation to search handset records on the basis of 3 attributes (priceEur, sim, announceDate)

E.g. GET /mobile/search?priceEur=200
     GET /mobile/search?sim=eSIM
     GET /mobile/search?announceDate=1999&priceEur=200
     
# Validations
API checks for certain validations before processing the request.

E.g. Sim can only have following values :-

"No","Micro-SIM,"Mini-SIM","Nano-SIM","eSIM"

If any other value is found API returns with proper message and 400 BAD REQUEST

# Exception Handling
Exceptions have been gracefully handled at one place i.e. MobileExceptionController

It handles scenarios like :-

1) When Handset API is not reachable
2) Any Bad Request found
3) Any other unexpected error is found

# Test Cases
Test cases are written to cover almost all the major functionalities of Search API using Unit and Mock MVC test cases.

All the test cases reside in src/test/java

# How to run application
MobileServiceApplication.java is the main class which can be run to bring the application up.

If you run it on your local then API can called as shown below :-

GET http:localhosh:8080/mobile/search?priceEur=200

# Technologies & frameworks 
Java 8 
Spring Boot 2.3.3
