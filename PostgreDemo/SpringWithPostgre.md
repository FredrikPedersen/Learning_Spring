# Setting up PostgreSQL for Spring project

### Sources

1. [General Guide](https://developer.okta.com/blog/2018/12/13/build-basic-app-spring-boot-jpa)
2. [Maven Dependencies Explanation](https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-postgresql/)
3. [PostgresSQL Commands cheatsheet](https://karloespiritu.github.io/cheatsheets/postgresql/)


### Installing Postgres and enable CLI

1. Download and install PostgreSQL from [here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
2. Add Postgres to Path
	- Good practice is to create a home variable and add that + /bin to path.
	- Add a System varible called POSTGRES_HOME, set to wherever the root folder for Postgres version is located.
	- Then add %POSTGRES_HOME%\bin to path.
3. Open Powershell and try:
	```Powershell
	psql -V
	```
	- Should return your version of Postgres.
4. Log into Postgres
	```Powershell
	psql -U postgres
	```
	
### Start, stop and restart

```Powershell
pg_ctl -D "PATH-TO-POSTGRESVERSION\data" start
pg_ctl -D "PATH-TO-POSTGRESVERSION\data" stop
pg_ctl -D "PATH-TO-POSTGRESVERSION\data" restart
```

### Create Database for the project

- **Create Database**

```Powershell
create database demodb;
```

- **Create User**

```Powershell
create user demouser;
alter user demouser with encrypted password 'somepassword';
grant all privileges on database demodb to demouser;
```

# Spring Project to do simple insertion in database

1. Create a new Spring Project. Make sure Spring Data JPA and Spring Data Rest are added to the project.
2. Add PostgreSQL dependency:
```XML
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
3. Create [Model](https://github.com/FredrikPedersen/Learning_Spring/tree/master/PostgreDemo/src/main/java/com/fredrikpedersen/postgredemo/model/Person.java) and [Repository](https://github.com/FredrikPedersen/Learning_Spring/tree/master/PostgreDemo/src/main/java/com/fredrikpedersen/postgredemo/repository/PersonRepository.java).
4. Add configurations for the database in [application.properties](https://github.com/FredrikPedersen/Learning_Spring/blob/master/PostgreDemo/src/main/resources/application.properties).
5. Seed some data when running the project in the [Application class](https://github.com/FredrikPedersen/Learning_Spring/blob/master/PostgreDemo/src/main/java/com/fredrikpedersen/postgredemo/PostgreDemoApplication.java).
6. Verify data creation by running the following commands after logging into Postgres:
```Powershell
\connect demodb #connects to the database
\dt #displays all tables
SELECT * FROM person; #displays data in person-table
```
