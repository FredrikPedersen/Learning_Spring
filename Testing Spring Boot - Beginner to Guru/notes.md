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

## Section 5: Part 46 - Overview og JUnit Assertions

#### JUnit Assertions

- **Assertion** - You are asserting a condition for the test to pass.
- **Grouped Assertions** - All assertions run in block, all failures reported.
- **Dependent Assertions** - Allows for blocks of grouped assertions.
- Exceptions are tested with assertThrows lambda expression.
- Timeouts are tested with assertTimeour lamdba expression.
- [JUnit 5 assertions documentation](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html).

## Section 5: Part 48 & 49 - JUnit Grouped and Dependent Assertions

 ```Java
 
@Test
void groupedAssertions() {
	
	//given
	Person person = new Person(1L, "John", "Doe");
	
	//then
	assertAll("Test Props Set",
		() -> assertEquals(person.getFirstName(), "John2", "FirstName failed"),
		() -> assertEquals(person.getLastName(), "Doe2", "LastName failed"));
}
	
@Test
void dependentAssertions() {
	
	//given
	Owner owner = new Owner(1L, "John", "Doe");
	owner.setCity("Oslo");
	owner.setPhone("12345678");
		
	//then
	assertAll("Properties Test",
		() -> assertAll("Person Properties",	
			() -> assertEquals(owner.getFirstName(), "John", "FirstName failed"),
			() -> assertEquals(owner.getLastName(), "Doe2", "LastName failed")),
		() -> assertAll("Owner Properties",
			() -> assertEquals("Oslo", owner.getCity(), "City failed"),
			() -> assertEquals("12345678", owner.getPhone(), "Phone failed"))
	);	
}
```	

## Section 5: Part 52 & 53 - Testing Expected Exceptions and Timeouts

```Java

public class SomeClass {

	public void exceptionThrowingMethod() {
		throw new Exception();
	}
	
	public void timeoutMethod() {
		Thread.sleep(100);
	}
	
}


class TestClass {

	private SomeClass someClass;
	
	@BeforeEach
	void setUp() {
		someClass = new SomeClass();
	}
	
	@Test
	void exceptionTest() {
		assertThrows(Exception.class, () -> someClass.exceptionThrowingMethod());
	}
	
	@Test
	void timeoutTest() {
		//assertTimeout waits for the timeout to finish before asserting the result. 
		assertTimeout(Duration.ofMillis(100), () -> someClass.timeoutMethod());
	}
	
	@Test
	void timeourPreemptiveTest() {
		//assertTimeoutPreemptively will fail the test once the condition duration is exceeded
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> someClass.timeoutMethod());
	}
}
```

## Section 5: Part 54 & 55 - JUnit Assumptions and Conditional Test Execution

- [Assumptions Documentation](https://junit.org/junit5/docs/5.0.0/api/org/junit/jupiter/api/Assumptions.html)
- An assumption is used for checking if it makes sense to run a test under certain conditions. If an assumption is failed, it will not result in test failure, but test abortian.
- The the most common use case for this is if you have an application running in different environments.
- See the JUnit [User Guide for narrowing down further whether a test should run or not](https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution). 

```Java
@Test
void testAssumptionTrue() {
	
	//will fail if you do not have a runtime variable set to "FREDRIK_RUNTIME", following tests will still run
	assumeTrue("FREDRIK".equalsIgnoreCase(System.getenv("FREDRIK_RUNTIME")));
}
```

## Misc JUnit functionality

#### To ignore/skip a test or testclass

```Java

@Disabled(value = "Disabled until we get our shit together")
class TestingClass {

	@Disabled
	@Test
	void testMethod() {
	}
}
```

#### Set a display name for the test (the test name displayed in the test result-panel in IntelliJ)

```Java
@DisplayName("This sets the display name")
@Test
void testMethod() {
}
```

## Section 6: Part 63 - JUnit Nested Tests

- Nested tests allows for setting up complex tests.
- A use case for this is when testing a class dependent on other classes. In the example provided in the course, there is a Service, called OwnerService. An Owner has a Pet, and a Pet has a PetType. 
 The Owner Service is then reliant on the PetTypeService and the PetService to function, so we write nested tests, first testing the PetType service, then the PetService, and then at last the OwnerService.
 This way we ensure that the whole whole chain of dependent classes are working with unit tests. 
- See example of this in the **Advanced JUnit project**, in the testclass **OwnerMapServiceTest**.

## Section 6: Part 64 - Test Interfaces and Filtering Tests

- Interfaces are a great tool to define common properties in tests, i.e Tags.
- Tags can be used to filter tests by what part of the program they are testing (like controllers or models).

```Java

@Tag("controllers")
public interface ControllerTests {
]

class IndexControllerTest implements ControllerTests {
}
```

- To filter tests (in IntelliJ), go to the dropdown box (where what class you are going to run is selected) to the left of the run-button in the top toolbar.
- Click on the dropdown box's arrow, and select **Edit Configurations**.
- Click on the "+"-button in the top left corner.
- Add a new JUnit Configuration, name it appropriately, set **Test Kind** to *tags*, and in **Tag Expression**, fill in the sort of tagged classes you want to run
	- In our example I could fill in "controllers" to make all testclasses tagged with "controllers" run.
- Apply and run.



	
	
	
