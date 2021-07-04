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

#app_data.sql

              USE arif_travel_agencydb;
              -- Insert Role init data
              INSERT INTO `arif_travel_agencydb`.roles_tbl (`id`, `description`, `is_deleted`, `name`) VALUES ('99999990', 'Role for User', '0', 'ROLE_USER');

              -- Insert Location init data
              INSERT INTO `arif_travel_agencydb`.location_tbl (`id`, `is_active`, `title`) VALUES ('99999999', '1', 'Sylhet');
              INSERT INTO `arif_travel_agencydb`.location_tbl (`id`, `is_active`, `title`) VALUES ('99999998', '1', 'Bandarban');
              INSERT INTO `arif_travel_agencydb`.location_tbl (`id`, `is_active`, `title`) VALUES ('99999997', '1', 'Khulna');

              -- Create Status View
              DROP TABLE IF EXISTS `arif_travel_agencydb`.STATUS_VIEW;
              DROP VIEW IF EXISTS `arif_travel_agencydb`.STATUS_VIEW;
              CREATE VIEW STATUS_VIEW AS
                  SELECT st.id,st.status_body,st.privacy_type,st.location_id,st.user_id,
                  us.full_name, lc.title
              FROM 
              status_tbl st, users_tbl us, location_tbl lc 
              WHERE 
              st.user_id = us.id
              and
              st.location_id=lc.id;


# Note that: 
  This SQL must be run properly after MySQL server and Application running completed, Otherwise, the application cannot work properly.
  -------------------------------------------------------------------------------------------------------------------------------------

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

Docker Image:

https://hub.docker.com/repository/docker/imranmadbar/arif-travel-agency-app



![image](https://user-images.githubusercontent.com/32607915/124375039-b5184e80-dcc1-11eb-82da-64883a255afd.png)


