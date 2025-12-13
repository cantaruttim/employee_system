[DEVELOPING]

A small application that we can create Users as well as marker our shift time of work.
For future implementations on front side we should see our location on map in real time.

# System
Build in two parts. This fullstack implementation is divided as described:

- On front side, we would see a menu where we can specify what we would like to see (Finance Report, CheckIn/CheckOut of an employee). On CheckIn and CheckOut parts we would see where on the map we are right now!
- On the other hand, on the back side, we would see all the business rules of our program.

# Architecture
<i>developing</i>

That is important to understand what I've being doing on this project. Those routes are specialized on
a unique task. Those tasks are described on these `README`. The main specialized architecture could be seen below:

## Employee
![Employee Architecture](imgs/employee_architecture.png)

## Users
![User Architecture](imgs/user_architecture.png)


# Models
<i>developing</i>

This system has two main models, `Employee` that is composed by `EmployeeAddress`, `EmployeeFinanceInfo`, `EmployeeCoordination`.
Here I used composition to implement and create an Employee. Because, MongoDB do not work well with Relational information.

After we create an Employee, we should see the User created on MongoDB

The second main class of this program is the class `UserEmployee`. This class is used after the Employee is created.
So, the User can log in on the login page.

This class is the most complex one. Because we have some business rules related to that User
1. The password is cryptographic
2. We can change password
3. The User only can log in, if that user is found on the Mongo database

# Controllers

## EmployeeController

The Basic CRUD controller where we can create, updated, delete and list the information regarding an Employee

## UserController

Controller responsible to get information about the users.
Those information must not be deleted! 

## AuthController

Controller that is responsible to authenticate an User after the Employee were created.
