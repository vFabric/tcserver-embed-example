# tcserver-embed-example

## Purpose

To demonstrate the creation and use of a basic embedded tc Runtime instance using the Pivotal Commercial Maven Repository to pull down the tc Server artifacts in a Maven project.

## Prerequisites 

  * Create your own Pivotal Commercial Maven Repository (vCMR) account at https://commercial-repo.pivotal.io.
  * Create the settings.xml or gradle.properties as suggested by the Pivotal Commercial Maven Repository for `Pivotal tc Server Release Repo (3.1.3+)
  
## Build and Usage

### Maven

```bash
./mvnw clean compile package
java -jar target/example-4.0.5-jar-with-dependencies.jar 
```

The above steps will build and run a fatjar containing all dependencies. The example will listen on port 8080

### Gradle

```bash
./gradlew run
```

This will build and start the application listening on port 8080

Additional Documentation
========================

Full tc Server Documentation can me found at https://tcserver.docs.pivotal.io/

More on embedded tc Server can be found at https://tcserver.docs.pivotal.io/4x/docs-tcserver/topics/postinstall-getting-started.html#postinstall-embedding-tc-server
