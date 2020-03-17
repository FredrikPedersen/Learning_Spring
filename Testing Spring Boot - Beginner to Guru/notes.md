# Notes from Testing Spring Boot: Beginner to Guru

## Section 2: Part 8 - Introduction to Testing Software

#### Testing Terminology

**Code Under Test** - This is the code or application you are testing.

**Test Fixture** - "A test ficture is a fixed state of a set of objects used as a baseline for running tests. 
The purpose of a test fixture is to ensure that there is a well known and fixed environment in which tests 
are run so that results are repeatable." - JUnit Docoumentation.

**Unit Tests** - Code written to test code under test.
- Designed to test specific sections of code.
- Percentage of lines of code tested is code coverage.
- Ideal code coverage is in the 70-80% range (there are obvious pieces of code which it is no value in testing).
- Should be 'unity' and execute very fast.
- Should have no external dependencies.
- ie no database, no Spring context, etc.
	
**Integration Tests** - Designed to test behaviours between objects and parts of the overall system.
- Much larger scope.
- Can include the Spring Context, Database and Message Brokers.
- Will run much slower than unit tests.
	
**Functional Tests** - Typically means you are trsting the running application.
- Application is live, likely deployed in a known environment.
- Functional touch points are tested - (i.e using a web driver, calling web services, sending/recieving messages etc).
	
#### The Testing Pyramid
- All three types of tests play important roles for sofware quality.
- The majority of tests should be Unit Tests.
	- Small, fast lightweight tests.
	- Very detailed and specific.
- Integration tests should be the next largest category.
- Functional tests are smallest and least detailed of the categories.
	
#### Importance of clean code
- Quality Code starts with... **QUALITY CODE**
- Follow good coding practises like [SOLID principles](https://www.baeldung.com/solid-principles) and [good OOP practices](https://www.codeproject.com/Articles/768052/Golden-Rules-Of-Good-OOP)
- Try reading [Clean Code by Robert Martin](https://www.ark.no/boker/Robert-C-Martin-Clean-Code-9780132350884?gclid=Cj0KCQjwx7zzBRCcARIsABPRscP31RSXqhMiWJ80MMGnbhx-K32SHpkRZpvzYQRoPfdqElNA_1mLUvUaApg0EALw_wcB&gclsrc=aw.ds) or [Design Patterns by "The Gang of Four"](https://en.wikipedia.org/wiki/Design_Patterns)
- Test coverage CANNOT overcome poor coding practices.

#### Agile Testing Methods
**TDD** - Test Driven Development
- Write tests first, then code to "fix" the tests. Refactor vode to cleanup, improve etc.

**BDD** - Behavious Driven Development
- Very similar to TDD.
- Describes the expected behaviour of the software.
	- Often expressed as: when/then; given/when/then
- Use both when appropriate!

#### Testing Components
**Mocks** - A fake implementation of a class used for testing.
- A test double for dependent objects, like a datasource.
- Can provde expected responses.
- Can verify expected interactions.

**Spy** - Like a mock, but a real object is used.
- Mocks completly replace expected object.
- Spies are wrappers, but with real objects inside.


## Section 2: Part 10 - Common Testing Frameworks for Java

#### JUnit

- The most popular testing framework for Java.
- Currently JUnit 4 is widely used in the industry.
- JUnit 5 was released in September 2017
	- Is rapidly gaining popularity and will most likely take over in the near future

#### TestNG

- Created by Cedric Beust in 2004 as an alternative to JUnit.
- Cedric wished to address deficiencies in JUnit.
- Functionality of TestNG and JUnit have evolved to be very close.
- Still popular, but has a much smaller user base.

#### Spock

- Testing Framework in Groovy for testing Java.
- Does require knowlegde of Groovy.
- Follows BDD approach.
- Includes own Mocking framework.
- Very popular where Groovy is used.


#### Mockito

- Mocking framework for testing.
	- Only does mocks.
	- Need to use with a testing framework such as JUnit or TestNG.
- Very popular for testing Spring Applications.

#### Spring MVC Test

- Testing module found in the Spring Framework.
- Very versatile for testing Spring MVC Controllers.
- Provides mock servlet environment.
- Used in conjunction with a testing framework such as JUnit, TestNG or Spock.

## Section 2: Part 11 - Beyond Testing with CI and CD

#### CI - Continuous Integration

**Continuous Integration** is a development practice that requires developers to integrate code into a shared repository several times a day. Each check-in is then verified by an automated build,
allowing teams to detect problemts early. 

"Continuous Integration doesen't get rid of bugs, but it does make them dramatically easier to find and remove." - Martin Fowler, Chief Scientist, ThoughWorks.

**CI Practices per Martin Fowler:** 
- Maintain a Single Source Repository. 
- Automate Build.
- Make Your Build Self-Testing.
- Every Commit Should Build on Integration Machine.
- Fix Broken Builds Immediately.
- Keep the build fast.
- Test in a Clone of the Production Environment.
- Make it Easy for Anyone to get the Latest Executable Version.
- Everyone Can See What is Happening.

**Common CI Build Servers**

Self-hosted:
- Jenkins, Bamboo, TeamCity, Hudson.
 
Cloud Based:
- CircleCI, TravisCI, Codeship, GitLab CI, AWS CodeBuild, and many more...

#### CD - Continuous Deployment
**Continuous Deployment** will automatically deploy build artifacts after all CI tests have run.
 - Should happen with every commit.
 - Completly Automated.
 - May include a staging area from which additional automated tests are run.
 - Easily confused with continuous delivery.
 
- Process to Automatically Deliver code changes directly to the Production Environment.
- Involves a High Degree of Automation in Testing and Deployment.
- Must have a *VERY* Mature Process.
- Can be Difficult in Some Industries due to Regulatory Requirements.
- This area is evolving.
- Few Hard “Rules” - No Standard Way.
- Best Practices” are maturing, and still a lot of lively debate!

## Section 3: Part 14 - Test Driven Development by Example

#### Popular quotes by [Kent Beck](https://en.wikipedia.org/wiki/Kent_Beck)

- "If I have the same logic in two places, I work with the design to understand how I can have only one copy. Designs without duplication tend to be easy to change".
- "Don't make more versions of your source code. Rather than add more code bases, fix the underlying design problem that is preventing you from running from a single code base".
- "If there are forms of testing, like stress and load testing, that find defects after development is "complete," bring them into the development cycle. Run load and stress tests continuously and automatically".