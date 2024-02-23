# spring-api

### Build and Run application

Build and generate JAR files

```
mvn clean install
```

Run application with different profiles

```
java -jar {jar_file_name} --spring.profiles.active={profile_name}

# Example
java -jar spring-api-0.0.1.jar --spring.profiles.active=QA
```
