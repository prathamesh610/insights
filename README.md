# Insights Service - Feeding India

# How to run server?
For linux/mac:
```
./gradlew bootrun
```
For windows:
```
./gradlew.bat bootrun
```

The server will start on port 8080.
To initialize and add values in database the file can be found at:
```
/src/main/resources/queries.sql
```

Please run this file to initialize the database and populate some data.
To change mysql username password, it can be updated in `application.properties` file with `spring.datasource.username` as the username and `spring.datasource.password` as the password for your mysql instance.