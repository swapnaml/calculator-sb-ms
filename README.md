# calculator-sb-ms

Clculator-sb-ms is a retail service, helps to perform the arithmatic operations such as addition, substraction, multiplication and devision. Spring Boot application and the tomcat embedded servlet been using.

Required software:
jdk 8
maven 3.8.0 (any version of 3.x.x)

procedure to execute:
Download the repository
extract
open in IDE and run the job

To verify the application available:
http://localhost:8080/calculator/healthCheck

The API's to perform the business operations are:

add:
http://localhost:8080/calculator/add?value1=80&value2=20
sub:
http://localhost:8080/calculator/sub?value1=80&value2=20
multiply
http://localhost:8080/calculator/multiply?value1=80&value2=20
divide:
http://localhost:8080/calculator/divide?value1=80&value2=20
to Get all the records stored
http://localhost:8080/calculator/data
