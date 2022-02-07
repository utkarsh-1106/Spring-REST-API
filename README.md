# Employee-Department Management REST API
***

This is the example project that shows you how to build Spring boot REST API which has basic CRUD APIs using Spring JPA.


## Features

- Create department
- List all departments
- Fetch single department by id
- Update department by id
- Delete department by id
- Delete all departments
- Create employee
- List all employees
- Fetch single employee by id
- Update employee by id
- Delete employee by id
- Delete all employees

## Pre-requisites
- Install Spring STS or any other IDE
- Install **Postman** plugin/app in Chrome for testing Rest calls

## Installation (How to run this project?)

Download the project and follow any of these two methods
* Method-1:
    * Open CMD and change directory to "target" folder
    * run this command `java -jar edm-application-0.0.1-SNAPSHOT.jar`
* Method-2:
    * And import it to any IDE
    * Open the class `EdmApplication.java`
    * run it as Java application


## Invoking the Rest Controller
- GET `/departments` Gets all the departments http://localhost:8080/departments
- GET `/departments/id` Get the department http://localhost:8080/departments/1
- POST `/departments` Create new department http://localhost:8080/departments
- PUT `/departments/id` Update the department http://localhost:8080/departments
- DELETE `/departments` Deletes all the departments http://localhost:8080/departments
- DELETE `/departments/id` Deletes the department http://localhost:8080/departments/3
- GET `/employees` Gets all the employees http://localhost:8080/employees
- GET `/employees/id` Get the employee http://localhost:8080/employees/1
- POST `/employees` Create new employee http://localhost:8080/employees
- PUT `/employees/id` Update the employee http://localhost:8080/employees
- DELETE `/employees` Deletes all the employees http://localhost:8080/employees
- DELETE `/employees/id` Deletes the employee http://localhost:8080/employees/3

## API Reference

We will create an Employee-Department REST API, following are the rest end points


### Schema Diagram
![img_1.png](https://github.com/utkarsh-1106/Spring-REST-API/blob/main/img_1.png?raw=true)
```
Table department {
  id int [pk]
  name String
}

Table employee {
  id int [pk]
  name String
  department department
 }
```

## Examples of some API Request-Response

`Request:`
```http
  POST /localhost:8080/departments
```
`Response:`
```json
{
  "id": 1,
  "name": "Paytm Mall"
}
```
`Request:`
```http
  POST /localhost:8080/employees
```
`Response:`
```json
{
  "id": 1,
  "name": "Utkarsh",
  "department": {
    "id": 1,
    "name": "Paytm Mall"
  }
}
```
`Request:`
```http
  GET /localhost:8080/departments
```
`Response:`
```json
[
  {
    "id": 1,
    "name": "Paytm Mall"
  }
]
```
`Request:`
```http
  GET /localhost:8080/employees
```
`Response:`
```json
[
  {
    "id": 1,
    "name": "Utkarsh",
    "department": {
      "id": 1,
      "name": "Paytm Mall"
    }
  }
]
```