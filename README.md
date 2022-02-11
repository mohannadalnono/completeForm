  #How to use

install sql community and make some tables in database correspond with programme needs.
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
