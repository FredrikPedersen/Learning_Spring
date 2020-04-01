# Setting up PostgreSQL for Spring project


### Installing Postgre and enable CLI

1. Download and install PostgreSQL from [here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
2. Add Postgre to Path
	- Good practice is to create a home variable and and that + /bin to path.
	- Add a System varible called POSTGRE_HOME, set to wherever the root folder for Postgre version is located.
	- Then add %POSTGRE_HOME%\bin to path.
3. Open Powershell and try:
	```Powershell
	psql -V
	```
	- Should return your version of Postgre.
4. Log into Postgre
	```Powershell
	psql -U postgres
	```
	
5. See [this cheatsheet](https://karloespiritu.github.io/cheatsheets/postgresql/) for a list of commands.
	
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