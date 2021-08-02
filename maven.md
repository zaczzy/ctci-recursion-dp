# For using Maven with Cloud9

## First, understand maven
[In 5 minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

## Install Maven on Cloud9
[Guide to Install](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/install-software.html)

Initialize:
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

```
## Set up run configurations
__Set the CMD folder to be the root folder of the maven app in both configurations.__ 
1. maven-build
```
mvn package
```
2. maven-run
```
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```