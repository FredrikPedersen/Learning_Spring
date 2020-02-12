# Notes from Spring Framework 5: Begunner to Guru

## Section 1: Part 13:
To access the database created using JPA, go to the file*application.properties* and enter:
*spring.h2.console.enabled=true*.

Then in the browser go to *localhost:8080/h2-console* and make sure that JDBC URL is set to
*jdbc:h2:mem:testdb*, then press *connect*.

## Section 3: Part 33:

#### The SOLID Principles of Object Oriented Programming

**1. The Single Responsibility Principle**
- Every class should have a single responsibility
- There should never be more than one reason for a class to change
- Your classes should be small. No more than a screen full of code.
- Avoid "god" classes.
- Split big classes into smaller classes.

**2. The Open/Closed Principle**
- Your Classes Should Be Open for Extension.
- But closed for modification.
- You should be able to extend a class' behaviour, without modifying it.
- Use private variables with getters and setters - ONLY when you need them.
- Use abstract base classes.

**3. The Liskov Substitution Principle**
- Objects in a program should be replaceable with instance of their subtypes WITHOUT altering the correctness of the program.
- Violations will often fail the *Is a*-test.
- A Square *Is a* Rectangle.
- However, a Rectanle *Is not* a Square.

**4. The Interface Segregation Principle**
- Make fine grained interfaces that are client specific.
- Many client specific interfaces are better than one general purpose interface.
- Keep your components focused and minimize dependencies between them.

**5. The Dependency Inversion Principle**
- Abstractions should not depend upon details.
- Details should depend upon abstractions.
- Important that higher level and lower level objects depend on the same abstract interaction.
- This is not the same as Dependency Injection - which is how objects obtain dependent objects.

## Section 3: Part 36:

#### Dependency Injection for 5 year olds

*"When you go and get things out of the refrigerator for yourself, you can cause problems. You might leave the door open, you might*
*get something Mommy or Daddy doesen't want you to have. You might even be looking for something we don't even have or which has expired.*

*What you should be doing is stating a need, like "I need something to drink with linch", and then we will make sure you have something*
*when you sit down to eat"*

John Munsch, 28 October 2009

- Dependency Injection is where a needed dependency is injected by another object.
- The class being injected has no responsibility in instantiating the object being injected.

#### Types of Dependency Injection

- By class properties - least preffered.
	- Using private properties is **EVIL** (invokes the reflection API and makes unit testing hard).
- By Setters - Area of much debate (generally breaks OOP patterns).
- By Constructor - Most Preferred (classes can't be instantiated without the dependencies).

#### Concrete Classes vs Interfaces

- Dependency Injection can be done with Concrete Classes or with Interfaces.
- Generally DI with Concrete Classes shoould be avoided.
- DI via Interfaces is highly preffered:
	- Allows runtime to decide implementation to inject.
	- Follow Intercafe Segregation Principle of **SOLID**.
	- Also, makes your code more testable.

#### Inversion of Control

- Is a technique to allow dependencies to be injected at runtime.
- Dependencies are not predetermined.

*"One important chracteristic of a framework is that the methods deined by the user to tailer the framework wil often be called
from within the framework itself, rather than from the user's application code. The framework often plays the role of the main
program in coordinating and sequencing application activity. This inversion of control gives frameworks the power so serves as
extensible skeletons. The methods supplied by the user tailer the generic algorithms defined in the framework for a particular
application"*

Ralph Johnson and Brian Foote

#### IoC vs Dependency Injection

- IOC and DI are easily confused
- DI refers much to the composition of your classes.
	- ie - you compose your classes with DI in mind
- IoC is the runtime environment of your code
	- ie - Spring Framework's IoC container
	
## Section 3: Part 56:

See this part again when you want to do releases. Your Git Repo is currently not configured correctly for the Maven
Release Plugin to be allowed to push to the repo.

## Section 4: Part 78:

### Spring Framework Stereotypes

**@Component:** Indicates that an annotated class is a component, and it will be created as a bean.

**@Controller:** Indicates that an annotated class has the role of a Spring MVC Controller.

**@RestController:** Convenience Annotation which extends @Controller and adds @Responsebody.

**@Repository:** Indicates that an annotated class is a Repository. Originally defined by Domain-Driven Design as "a mechanism for encapsulating storage,
retrieval and search behaviour which emulates a collection of objects."

**@Service:** Indicates that an annotated class is a Service. Originally defuned by Domain-Driven Design as "an operation offered as an interface that
stands alone in the model, with no encapsulated state."

## Section 5: Part 83:

### Dependency Management

- Maven or Gradle are supported for curated dependencies
- Each version of Spring Boot is configured to work with a specific version of Spring Framework.
- Overriding the Spring Framework version is NOT recommended.
 
### Maven Support

- Maven project inherit from a Srping Boot Parent POM
- When possible, do not specify versions in your POM. Allow the version to inherit from the parent.
- The Srping Boot Maven Plugin alows for packaging the executable JAR.

### Spring Boot Starters

- Starters are top level dependencies for popular Java libraries.
- Will bring in dependencies for the project and related Spring Components.
- Starter *spring-boot-starter-data-jpa* brings in:
	- Hibernate.
	- Spring Data JPA - and related Spring deps.
	
### Spring Boot Annotations

```Java
//Main Annotation to use
@SpringBootApplication 

//Declares class as Spring Configuration
@Configuration

//Enables auto configuration
@EnableAutoConfiguration

//Scans for components inn current package and all child packages
@ComponentScan
```

### Disabling Specific Auto Config

- Auto configuration will bring a lot of configuration classes in supplied Spring Boot JARs.
- You can specify classes to exclude with:

```Java
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
```

## Section 5: Part 85: 

### Spring Bean Scopes

- **Singleton** - (default) Only one instance of the bean is created in the IoC containter.
- **Prototype** - A new instance is created each time the bean is requested.
- **Request** - A single instance per http request. Only valid in the context of a web-aware Spring ApplicationContext.
- **Session** - A single instance per http session. Only valid in the context of a web-aware Spring ApplicationContext. 
- **Global Session** - A single instance per global session. Typically only used in a Portlet Context. Only valid in the context of a web-aware Spring ApplicationContext.
- **Application** - Bean is scoped to the lifecycle of a ServletContect. Only valid in the context of a web-aware Spring ApplicationContext.
- **Websocket** - Scopes a single bean definition to the lifecycle of a Websocket. Only valid in the context of a web-aware Spring ApplicationContext.
- **Custom Scope** - Spring Scopes are extensible, and you can define your own scope by implementating Spring's "Scope"-interface.

### Declaring Bean Scope

- No declaration needed for singleton scope.
- In Java configuration, use *@Scope* annotation.
- In XML configuration, scope is an XML attribute of the *bean*-tag.

## Section 7: Part 115:

### Spring Boot Development Tools

- Added to project via artifact *spring-boot-devtools'*.
- Developer tools are automatically disabled when running a packaged application (ie a Java-JAR).
- By default not included in repackaged archives.

### Dev Tools Features

- Automatic Restart:
	- Triggers a restart of the Spring Context when classes change.
	- Uses two classloaders. One for your application, one for project JAR dependencies.
	- Restarts are very fast, since only your project classes are being loaded.
	
- By default you need to select *Build -> Build Project*.
- There is an advaned setting you can change to make this more seamless.

### Template Caching

- By default, templates are cached for performance.
- But caching will require a container restart to refresh the cache.
- Developer Tools will disable template caching so the restart is not required to see changes.

### LiveReload

- Live Reload is a technology to automatically trigger a browser refresh when resources are changed.
- Spring Boot Developer Tools includes a LiveReload server.
- Browser plugins are available for free from [livereload's webpage](http://livereload.com/)

## Section 7: Part 116: 

### IntelliJ Compiler Configuration for Spring Boot Development Tools

- Open search function by pressing CTRL + SHIFT + A.
- Search for Registry.
- Find key *compiler.automake.allow.when.app.running* and set it to be enabled.
- Then go to *Settings (CTRL + ALT + S) -> Build, Execution and Deployment -> Compiler* and enable *Build Project Automatically*.
- Restart IntelliJ.

## Section 8: Part 136:

### JPA Entity Relationships

```Java
//One entity is related to one other entity
@OneToOne

//One entity is related to maneu entities (Collections and Arrays)
@OneToMany

//Inverse of OneToMany
@ManyToOne

//Many entities related to many entities. Each has a List or Set reference to the other.
//A join table is used to define the relationships.
@ManyToMany
```

### Unidirectional vs Bidirectional

- Unidirectiional is one-way
	- Mapping is only done one way. One side of the relationship will not know about the other.

- Bidrectional is two way
	- Both sides know about each other.
	- Generally recommended to use Bidirectional, since you can navigate the object graph in either direction.
	
	
### *Owning Side*

- The owning side in the relationship will hold the foreign key in the database.
- One to one is the side where the foreign key is specified.
- OneToMay and ManyToOne is the *Many*-side.
- *mappedBy* is used to define the field wich *owns* the reference of the relationship.
 
 
### Fetch Types
	
- Lazy Fetch Type - Data is not required until referenced.
- Eager Fetch Type - Data is queried up front.
- Hibernate 5 supports the JPA 2.1 Fetch Type Defaults, which are:
	- OneToMany - Lazy.
	- ManyToOne - Eager.
	- ManyToMany - Lazy.
	- OneToOne - Eager.

## Section 8: Part 146:

### Hibernate DDL Auto

- DDL = Data Definition Language.
- DML = Data Manipulation Language.
- Hibernate property is set by the Srping property spring.jba.hibernate.ddl-auto.
- Options are: none, validate, update, create, create-drop.
- Spring Boot will use create-drop form embedded databases (hsql, h2, derby) or none.

### Initialize with Hibernate

- Data can be loaded from import.sql.
	- Hibernate feature (not Spring Specific).
	- Must be on root of class path.
	- Only executed if Hibernate's ddl-auto property is set to create or create-drop.
	
### Spring JDBC

- Spring DataSource initializer via Srping Boot will by default load schema.sql and data.sql from the root of the classpath.
- Spring Boot will also load from schema-${platform}.sql and data-${platform}.sql.
	- Must set spring.datasource.platform.
	- May conflict with Hibernate's DDL Auto property.
	- Should use setting of none or validate.
	











