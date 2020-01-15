## From Section 1: Part 13:
To access the database created usin JPA, go to the file*application.properties* and enter:
*spring.h2.console.enabled=true*.

Then in the browser go to *localhost:8080/h2-console* and make sure that JDBC URL is set to
*jdbc:h2:mem:testdb*, then press *connect*.

## From Section 3: Part 33:

#### The SOLID Principles of Object Oriented Programming

1. The Single Responsibility Principle
- Every class should have a single responsibility
- There should never be more than one reason for a class to change
- Your classes should be small. No more than a screen full of code.
- Avoid "god" classes.
- Split big classes into smaller classes.

2. The Open/Closed Principle.
- Your Classes Should Be Open for Extension.
- But closed for modification.
- You should be able to extend a class' behaviour, without modifying it.
- Use private variables with getters and setters - ONLY when you need them.
- Use abstract base classes.

3. The Liskov Substitution Principle
- Objects in a program should be replaceable with instance of their subtypes WITHOUT altering the correctness of the program.
- Violations will often fail the *Is a*-test.
- A Square *Is a* Rectangle.
- However, a Rectanle *Is not* a Square.

4. The Interface Segregation Principle
- Make fine grained interfaces that are client specific.
- Many client specific interfaces are better than one general purpose interface.
- Keep your components focused and minimize dependencies between them.

5. The Dependency Inversion Principle
- Abstractions should not depend upon details.
- Details should depend upon abstractions.
- Important that higher level and lower level objects depend on the same abstract interaction.
- This is not the same as Dependency Injection - which is how objects obtain dependent objects.