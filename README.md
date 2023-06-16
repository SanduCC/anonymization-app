Create docker container 🐋: 
docker run --name anonymization_data --rm -e POSTGRES_USER=localuser -e POSTGRES_PASSWORD=localpass 
-e PGDATA=/var/lib/postgresql/data/pgdata 
-v /tmp:/var/lib/postgresql/data -p 5432:5432 -it postgres

Liquibase scripts executes automatically on application startup.

It should create database and tables and insert data.

Used DBeaver to connect to database and check data. https://dbeaver.io/download/

Used Postman to test API. https://www.postman.com/downloads/

Application defaults to localhost:8080

AnonymizedPersonAssembler contains the logic for anonymization.

