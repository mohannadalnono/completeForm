# How to use
> windows users just could install XAMPP and you're good to go! 


> just make sure not have more than MYSQL installed on the same PORT.

Install sql community and make some tables in database correspond with programme needs.
install XAMPP and launch it (make sure you dont have any database service running in background to avoid issues)
  for linux users checkup by writing (service mysql status) then (service mysql stop) if mysql for example is running.
  after launching MySQL from XAMPP, use LAMPP bin to make tables (make tables correspond to program tabels) :
  
    --> CREATE USER 'mea'@'localhost' IDENTIFIED BY '0000';
  	
    --> GRANT ALL PRIVILEGES ON *.* TO 'mea'@'localhost';
    
    now you can login by LAMPP bin using mea for username and 0000 for password, then connecting to DB from JavaProgram using them
    
    --> PathWhereLamppInstalled/lampp/bin/mysql -u mea -p  
	 
    --> Enter password: 0000
    
    --> create database myinfo
    
    --> use myinfo
    
    --> create table formI(name VARCHAR(25),addresse VARCHAR(50),hobbies VARCHAR(20),gender VARCHAR(10),lang VARCHAR(50),choice VARCHAR(50));
    
JDBC external library is already added to the project.


# What program can do

* Insert client informations using friendly GUI
* Import external list of clients information and insert it to DataBase
* Export all clients informations in DataBase with extension .txt to same program path directory
* Display all clients informations in DataBase as human readable list in TextField within the GUI
* Delete client from DataBase according to his ID
   > Note that ID not included in DataBase but it's static variable in java code, and it still exported and generated when import from outside!
* Clear inserted Fields within GUI (NOT MDL)
