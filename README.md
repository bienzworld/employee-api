# Employee API
* This API contains Create, Read, Update and Delete of Employees information.
* It works on "java-challenge" repository.

## How to use this spring-boot project
* Install packages with `mvn package`
* Run `mvn spring-boot:run` for starting the application (or use your IDE)

### Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :
* Swagger UI : http://localhost:8080/swagger-ui.html
* H2 UI : http://localhost:8080/h2-console

### Restrictions
- use java 8

## Features
<table>
  <tr><th>No</th><th>Feature</th><th>Method</th><th>URI</th><th>Note</th></tr>
  <tr><td>1</td><td>Get All Employees Info</td><td>GET</td><td>/api/v1/employees</td><td>Gets all the record of employees information</td></tr>
  <tr><td>2</td><td>Get Specific Employees Info By Id</td><td>GET</td><td>/api/v1/employees/{employeeId}</td><td>Get specific employees info using employees id</td></tr>
  <tr><td>3</td><td>Insert Employee Record on Database</td><td>POST</td><td>/api/v1/employees</td><td>Insert new employee info</td></tr>
  <tr><td>4</td><td>Update Employee Info</td><td>PUT</td><td>/api/v1/employees/{employeeId}</td><td>Update employees info using employees id</td></tr>
  <tr><td>5</td><td>Delete Employee Info</td><td>DELETE</td><td>/api/v1/employees/{employeeId}</td><td>Delete a record on Employee table using employees id</td></tr>
</table>

## How to start development
1. Get source code from [repository](https://github.com/bienzworld/java-challenge.git)
    ```bash
    $ git clone https://github.com/bienzworld/java-challenge.git
    ``` 

#### My experience in Java
- My experience in Java lies mostly in full-stack development. But I enjoy working more at the backend. 
- Most of my projects in regards to Java are creating internal and external API, new feature and frontend. 
- I have about 9+ years of work experience in web and software development.
