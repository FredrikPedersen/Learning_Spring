# Spring MVC RESTful dependencies

 - Lombok
 - Spring Web
 - Spring DevTools
 - Spring DataJPA
 - H2 Database
 
### MapStruct

Used for converting POJOS to DTOs using annotations.

Add plugin "MapStruct Support".

```XML

In properties:

<org.mapstruct.version>1.3.1.Final</org.mapstruct.version>

In build:

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
    <version>3.7.0</version>
    <configuration>
        <source>11</source>
        <target>11</target>
        <annotationProcessorPaths>
            <path>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
            </path>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>${org.mapstruct.version}</version>
			</path>
        </annotationProcessorPaths>
        <compilerArgs>
            <compilerArg>
                -Amapstruct.defaultComponentModel=spring
            </compilerArg>
        </compilerArgs>
    </configuration>
</plugin>

In Dependencies:

<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>${org.mapstruct.version}</version>
</dependency>

<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>${org.mapstruct.version}</version>
	<scope>provided</scope>
</dependency>
```