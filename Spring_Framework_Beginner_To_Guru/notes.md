# Notes from Spring Framework 5: Begunner to Guru

## Section 1: Part 13:
To access the database created usin JPA, go to the file*application.properties* and enter:
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

*"One important chracteristic of a framework is that the methods deined by the user to tailer the framework wil often be called*
*from within the framework itself, rather than from the user's application code. The framework often plays the role of the main*
*program in coordinating and sequencing application activity. This inversion of control gives frameworks the power so serves as*
*extensible skeletons. The methods supplied by the user tailer the generic algorithms defined in the framework for a particular*
*application"*

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