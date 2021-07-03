# bs23-assignment-project

#Uses Technology

1) Java 8
2) Spring Boot 2.5.2
3) Spring Security
4) MySQL Database
5) Thaymleft and Bootstrap 4



#Setup Database

1) Install mysql 5+
2) Create database name `arif_travel_agencydb`


#Run Application
1) Download Project from Git Repository.
2) Take Maven update for dependency and install it 
3) Build project for war or jar
4) Run the application, App will be run on server port 8080
5) When App run successful ORM generate the table, after that import app_data.sql file what is on project resource folder.



#Docker

1) Run a mysql docker image as
=>docker run -d -p 3333:3306 --name=arif_travel_agencydb --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_DATABASE=arif_travel_agencydb" -it mysql:5.7.18

2)Build image 
=>docker image build -t imranmadbar/arif-travel-agency-app .
or 
Get get image from 

3) Run the application
=>docker run --name arif-travel-agency-app -t --link arif_travel_agencydb:arif_travel_agencydb -p 8080:8080 imranmadbar/arif-travel-agency-app

4) After runing application import app_data.sql





