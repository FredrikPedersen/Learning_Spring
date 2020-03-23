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
- An assumption is used for checking if it makes sense to run a test under certain conditions. If an assumption is failed, it will not result in test failure, but test abortion.
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

#### Tagging and Filtering Tests

- Tags can be used to filter tests by what part of the program they are testing (like controllers or models).

```Java

@Tag("controllers")
public interface ControllerTests {
}

class IndexControllerTest implements ControllerTests {
}
```

- To filter tests (in IntelliJ):
1. Go to the dropdown box (where what class you are going to run is selected) to the left of the run-button in the top toolbar.
2. Click on the dropdown box's arrow, and select **Edit Configurations**.
3. Click on the "+"-button in the top left corner.
4. Add a new JUnit Configuration, name it appropriately, set **Test Kind** to *tags*, and in **Tag Expression**, fill in the sort of tagged classes you want to run
	- In our example I could fill in "controllers" to make all testclasses tagged with "controllers" run.
5. Apply and run.

## Section 6: Part 63 - JUnit Nested Tests

- Nested tests allows for setting up complex tests.
- A use case for this is when testing a class dependent on other classes. In the example provided in the course, there is a Service, called OwnerService. An Owner has a Pet, and a Pet has a PetType. 
 The Owner Service is then reliant on the PetTypeService and the PetService to function, so we write nested tests, first testing the PetType service, then the PetService, and then at last the OwnerService.
 This way we ensure that the whole whole chain of dependent classes are working with unit tests. 
- See example of this in the **Advanced JUnit project**, in the testclass [OwnerMapServiceTest](https://github.com/FredrikPedersen/Learning_Spring/blob/master/Testing%20Spring%20Boot%20-%20Beginner%20to%20Guru/advanced-junit/src/test/java/com/fredrikpedersen/petclinic/services/map/OwnerMapServiceTest.java).

## Section 6: Part 64 & 65 - Test Interfaces and Default Methods

- Interfaces are a great tool to define common properties in tests, i.e Tags or duplicate logic.
- See documentation for @TestInstance and it's uses cases [here](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/TestInstance.html).

```Java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controller")
public interface ControllerTests {
	
	@BeforeAll
	default void beforeAll() {
		System.out.println("Hello from ControllerTests!");
	}
}
```

## Section 6: Part 66 - Repeating Tests with JUnit 5

- In some scenarios, you may want to run a test multiple times.
	- A use case might be if you generate a random number and want to make sure it stays within a certain range.
- Use the @RepeatedTest(value = n, name ="{displayName} : {currentRepetition} - {totalRepetitions}")
	- n is the number of repetitions.
	- displayName is pulled from the methods's displayname.
	- currentRepetition and totalRepetitions are both configured automatically.
	- the name attribute is simply for formatting the name in the "test results"-box, it has no functionality.

```Java
@RepeatedTest(value = 10, name ="{displayName} : {currentRepetition} - {totalRepetitions}")
@DisplayName("Repeated Test")
void repeatedTest() {
}
```

## Section 6: Part 67 - JUnit Test Dependency Injection

- JUnit Defines a Parameter Resolver API to resolve parameters at runtime.
- Allows JUnit to inject parameters into test methods.
- There are three built in resolvers:
	- TestInfo - Provides info about the test name, method, class and tags.
	- RepetionInfo - Provides information about the test repetition. NB! Only available in RepeatedTests.
	- TestReporter - Allows you to publish runtime information for test reporting.
	
```Java
@RepeatedTest(5)
void TestWithDependencyInjection(TestInfo testInfo, RepetitionInfo repetitionInfo) {
	System.out.println(testInfo.getDisplayName() + " " + repetitionInfo.getCurrentRepetition());
}
```

## Section 6: Part 70 to 76 - JUnit Parameterized Tests

- Parameterized tests are used to provide data into tests.
	- Will run once for each value provided. Ex: valueSourceTest will run twice.
- First you need a dependency ([latest version](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params)) :

```XML
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-params</artifactId>
	<version>5.6.0</version>
</dependency>
```

 - Have this input.csv file located in resources folder:

```CSV
state, val1, val2
FL, 1, 1
OH, 2, 2
MI, 3, 1
```

```Java

public enum OwnerType {

	INDIVIDUAL, COMPANY
}

public class CustomArgsProvider implements ArgumentsProvider {
	
	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
		return Stream.of(Arguments.of("FL", 1, 1),
				Arguments.of("OH", 2, 2));
	}

}

class ParameterizedTests {

	@DisplayName("Value Source Test -")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@ValueSoruce(strings = {"Spring", "Framework"})
	void valueSourceTest(String val) {
		System.out.println(val);
	}
	
	@DisplayName("Enum Source Test -")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}
	
	@DisplayName("CSV Input Test -")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@CsvSource({
		"FL, 1, 1",
		"OH, 2, 2",
		"MI, 1, 1"
	})
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}
	
	@DisplayName("CSV File Test -")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@CsvFileSource(resources = "/input.csv", numLinesToSkip = 1) 	//needs a CSV file in resources
	void csvFileTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}
	
	@DisplayName("Method Provider Test -")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@MethodSource("getArgs")
	void fromMethodTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}
	
	@DisplayName("Custom Provider Test -")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@ArgumentsSource(CustomArgsProvider.class)
	void fromCustomProviderTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}
	
	private static Stream<Arguments> getArgs() {
		return Stream.of(Arguments.of("FL", 1, 1),
				Arguments.of("OH", 2, 2));
	}
	
}
```

## Section 7: Part 81 to 85 - Running Tests with IntelliJ and Maven

#### General Tips

- Under run configurations (see *Tagging and Filtering Tests* on how to get there), you can define Environment Variables which are made available at runtime.
	- Handy for API Keyes and other credentials
- When right-clicking a test (or test folder) in the project window, you can select "Run with test coverage" to get test coverage statistics.

#### Maven Surefire Plugin

- Can be used to clean the project (remove all generated files) and run all tests.
- Needs a plugin configuration:
```XML
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <argLine>
            --illegal-access=permit
        </argLine>
    </configuration>
</plugin>
```

- Reports from the Surefire can be found under target -> surefire-reports.
- By adding two plugins, we can generate more human friendly test reports.
```XML
<plugins>
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-site-plugin</artifactId>
		<version>3.7.1</version>
	</plugin>
</plugins>

<reporting>
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-surefire-report-plugin</artifactId>
		<version>2.22.0</version>
	</plugin>		
</reporting>
```

- Now, in the Maven tab in the right sidepanel, run the *site*-script.
- A site-folder with HTML files will be generated under target -> site.



#### Maven Failsafe Plugin

- Can be run by selecting Maven tab in the sidepanel, and running the "verify" script.
- Needs a plugin configuration:
```XML
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-failsafe-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <argLine>
            --illegal-access=permit
        </argLine>
    </configuration>
	<executions>
		<execution>
			<goals>
				<goal>integration-test</goal>
				<goal>verify</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```
	
## Section 9: Part 101 & 102 - Introduction to Mockito

- Mockito is the most popular mocking framewok for testing Java,
- Mocks (aka test doubles) are alternate implementations of objects to replace real objects in tests.
- Works well with dependency injection.
- For the class under test, injected dependencies can be mocks.

#### Types of mocks

- **Dummy** - Object used to get the code to compile.
- **Fake** - An object that has an implementation, but not production ready.
- **Stub** - An object wuth pre defined answers to method calls.
- **Mock** - An object with pre-defined answers to method calls, and has expectations of executions. Can throw an exception if an unexpected invocation occurs.
- **Spy** - In Mockito, Spies are Mock like wrappers around the actual object. Will function as the actual object it is mocking, unless any behaviour is overridden. 

#### Terminology

- **Verify** - Used to verify number of times a mocked method has been called.
- **Argument Matcher** - Matches arguments passed to Mocked Method and will allow or disallow.
- **Argument Captor** - Captures arguments passed to a Mocked Method
	- Allows you to perform assertions of what was passed in to method.


#### Mockito Annotations

```Java
@Mock 	//used to create a mock
@Spy 	//used to create a spy
@InjectMocks 	//Inject mocks/spies into a class under test
@Captor 	//Captures arguments to mock
```

#### Mockito Dependencies

```XML
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.3.3</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>3.3.3</version>
    <scope>test</scope>
</dependency>
```

#### Section 9: Part 103 to 107: Creating Mockito Mocks


- Three different ways to create mocks
	- Inline with static method mock(Clazz.class).
	- Annotated with @Mock over an object with MockitoAnnotations.initMocks(this).
	- Annotated with @Mock over an object with @ExtendWith(MockitoExtension.class) at class level.

```Java

@ExtendWith(MockitoExtension.class) //Alternative way to initializing annotated mocks
class mockInitDemo {
	
	@Mock
	Map<String, Object> annotatedMapMock;
	
	@BeforeEach
	void setUp() {
		//Initialize annotated mocks
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	void inlineMock() {
		//Example of how to make an inline mock of a Map object
		Map inlineMapMock = mock(Map.class);
		
		assertEquals(inlineMapMock.size(), 0);
	}
	
	@Test
	void annotatedMock() {
		//Checking that our annotated mock has been initialized properly
		annotatedMapMock.put("key", "value");
		assertEquals(annotatedMapMock.size(), 1);
	}
}
```

- Injecting Mocks into an Object
	- @InjectMocks tells Mockito to injectmocks into an object at runtime.
	- This is done by checking for constructors.

- Verify is used to make sure a method is called a certain number of times during the test
	- May also specify atMost, atLeastOnce, and never. These are pretty much self explanatory.

```Java

@ExtendWith(MockitoExtension.class)
class mockInjectDemo {
	
	@Mock
	SomeRepository someRepository;
	
	@InjectMocks
	SomeService someService;
	
	@Test
	void delete() {
		someService.deleteById(1);
		someService.deleteById(2);
		
		verify(someRepository, times(2)).deleteById(1);
	}
	
	@Test
	void deleteOnce() {
		someService.deleteById(1);
		
		verify(someRepository, atLeastOnce()).deleteById(1);
	}
	
	@Test
	void deleteAtMost() {
		someService.deleteById(1);
		
		verify(someRepository, atMost(5)).deleteById(1);
	}
	
	@Test
	void deleteNever() {
		someService.deleteById(1);
		
		verify(someRepository, never()).deleteById(2);
	}
}
```

## Section 9: Part 110 and 111 - Returning Values from Mocks and Argument Matchers

- You tell mocks what should be returned when their methods are called
	- In this example we make SomeRepository's findById-method return person when called with the parameter value 1.
	
- In the ArgumentMatcher example we simply verify that someRepository.delete() has been called with any parameter value of type Person.

```Java
class returnFromMocks {
	
	@Mock
	SomeRepository someRepository;
	
	@InjectMocks
	SomeService someService;
	
	@Test
	void returnFromMock() {
		
		//given
		Person person = new Person();
		when(someRepository.findById(1)).thenReturn(Optional.of(person));
		
		//when
		Person foundPerson = someService.findById(1);
		
		//then
		assertThat(foundPerson).isNotNull();
		verify(someRepository).findById(1); //Here we could have used anyInt() instead of 1
	}
	
	@Test
	void usingArgumentMatcher() {
		Person person = new Person();
		
		someService.delete(person);
		
		verify(someRepository).delete(any(Person.class));
	}

}
```

## Section 11: Advanced Mockito

#### Throwing Exceptions

 - Mockito can be used to throw exceptions when a method is called.

```Java
@Test
void testDoThrow() {

	doThrow(new RuntimeException()).when(someRepository).delete(any());
	
	assertThrows(RuntimeException.class, () -> someRepository.delete(new Person()));
	
	verify(someRepository).delete(any());
}
```

#### Argument Matchers

- We can use Argument Matchers to controll the mock's return value based on input arguments.

```Java
@Test
void argumentMatcherDemo() {

	//given
	final String MATCH_ME = "MATCH_ME";
	Person person = new Person();
	person.setName(MATCH_ME);
	
	Person savedPerson = new Person();
	savedPerson.setId(1);
	
	when(someRepository.save(argThat(argument -> argument.getName().equals(MATCH_ME)))).thenReturn(savedPerson);

	Person returnedPerson = someService.save(person);
	
	assertThat(returnedPerson.getId()).isEqualTo(1);
}
````

#### Argument Capture

- Argument Captors can be used to check what is passed to methods.
	- Captors can be declared inline or with annotations.

```Java

public class SomeService{

	public List<Person> peopleWithNameLike(Person person) {
        return someRepository.findAllByNameLike(person.getName());
    }
}

class MockitoDemos {

	@Captor
	ArgumentCaptor<String> captor; //Remove comment on inline declaration and comment this out if you want to test inline declaration.

	@Test
	void argumentCaptureDemo() {
		Person person = new Person(1, "Fredrik");
		List<Person> personList = new ArrayList<>();
		//final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		when(someRepository.findAllByNameLike(captor.capture())).thenReturn(personList);
		
		List<Person> returnList = someService.peopleWithNameLike(person);
		
		assertThat(captor.getValue()).isEqualtToIgnoringCase("Fredrik");
	}
}

```

#### Mockito Answers

- Mockito Answers can be used to modify the response behaviour from methods.
- See [here](http://sangsoonam.github.io/2019/01/24/mockito-answers.html) for some additional info.

```Java
class MockitoDemos {

	@Captor
	ArgumentCaptor<String> captor;

	@BeforeEach
	void setUp() {
		given(someService.findAllByLastName(captor.capture())).willAnswer(invocation -> {
			
			List<Person> people = new ArrayList<>();
			String name = invocation.getArgument(0);
			
			if (name.equals("Pedersen") {
				people.add(new Person(1, "Fredrik", "Pedersen"));
				return people;
			} else if (name.equals("DontFindMe") {
				return people;
			} else if (name.equals("FindMe") {
				people.add(new Person(1, "Fredrik", "Pedersen"));
				people.add(new Person(2, "Nikita", "Petrovs"));
				return people;
			}
			
			throw new RuntimeException("Invalid Argument");
		});
	}
	
	@Test
	void answerDemo() {
	
		//given
		Person person = new Person (1, "Fredrik", "Pedersen");
		
		//when
		String viewName = someController.findPersoByLastName(person); //assuming that the controller returns a view called "people/{personId}" when a person is found
		
		//then
		assertThat("Pedersen").isEqualtToIgnoringCase(captor.getValue());
		assertThat("someSite/people/1").isEqualToIgnoringCase(viewName);
	
	}
	
	@Test
	void answerDemo2() {
	
		//given
		Person person = new Person (1, "Fredrik", "DontFindMe");
		
		//when
		String viewName = someController.findPersoByLastName(person); //assuming that the controller returns a view called "people/notfound" when the people list is empty
		
		//then
		assertThat("DontFindMe").isEqualtToIgnoringCase(captor.getValue());
		assertThat("someSite/notfound").isEqualToIgnoringCase(viewName);
	
	}
	
	@Test
	void answerDemo3() {
	
		//given
		Person person = new Person (1, "Fredrik", "FindMe");
		
		//when
		String viewName = someController.findPersoByLastName(person); //assuming that the controller returns a view called "people/peopleList" when there are more than one person in the returned list.
		
		//then
		assertThat("FindMe").isEqualtToIgnoringCase(captor.getValue());
		assertThat("someSite/peopleList").isEqualToIgnoringCase(viewName);
	}
}


```

## Section 12: Testing With Spring Framework

#### Spring Framework Testing Features

- **Features for Unit Testing**
	- Environment - Mock Environment and Properties Source.
	- JNDI - Mock of JNDI Lookup.
	- Servlet API - For testing of web environment.
	- Spring Web Reactive - Testing of reactive web environment.

- **Testing Utilities**
	- ReflectionTestUtils - allows use of reflection to modify private fields.
	- Spring can autowire private properties (considered poor practice).
	- Can also be used to hook into bean lifecycle events.
	- AOP Utils - Helps with testing of AOP.

#### Spring MVC Test

- Robust Framework for Testing Controller interactions.
	- MockHttpServletRequest - Mock implementation of request/respone.
	- MockHttpSession - Mock of HTTP session.
	- ModelAndViewAssert - Assertion Utilities.
- Framework allows testing of web requests withouth the need of a running container.
	- Allows true unit tests for controller.
	- Tests run much faster when the web contect is not started.

#### Spring Integration Testing

- Integration testing is when the Spring Context is started to support the test.
- Loading the Spring Context is considered an expensive operation.
	- Can take 10-40 seconds, depending on complexity and hardware.
- Spring will cache the context between tests to improve performance.
- Dependency Injection - Spring can be used to inject beans into test classes.
- Transaction Management - By default Spring will automatically rolllback database transactions.

#### Spring Framework Testing Annotations

```Java
@BootstrapWith //Class-level annotation to configure how the test context is bootstrapped
@ContextConfiguration //Class-level annotation to configure the application context
@WebAppConfiguration //Class-level annotation to configure a web application context
@ContextHierarchy //Class-level annotation to set multiple @ContextConfigurations
@ActiveProfiles //Class-level annotation to set active profiles for tests
@TestPropertySource //Class-level annotation to set property source for test
@DirtiesContext //Class or method-level annotation which tells Spring to re-load context after

@TestExecutionListeners //Used to configure test execution listeners
@Commit //Class or method-level annotation to commit action of test to database
@Rollback //Class or method-level annotation to rollback action of test from database
@BeforeTransaction //Run a method which returns void before a transaction is started
@AfterTransaction //Run a method which returns void after a transaction has completed
@Sql //Used to configre SQL scripts to run before a test
@SqlConfig //Configuration for the parsing of SQL Scripts
@SqlGroup //Configure a grouping of SQL Scripts

//Spring JUnit 5 Annotations
@SpringJUnitConfig //Combines @ContextConfiguration with @ExtendWith(SpringExtension.class) to configure the Spring Context for the test
@SpringJUnitConfig //Combines @ContextConfiguration and @WebAppConfiguration with @ExtendWith(SpringExtension.class) to configre the Spring Context for the test
@EnabledIf //Conditional execution of test
@DisabledIf //Conditional execution of test 
```

## Section 14: Spring MVC Test

#### Spring MVC Test Configuration Modes

- Standalone Setup
	- Very light weight, ideal for unit tests.
	- Tests one controller at a time.
	- Allows for testing of controller requests and responses.

- WebAppContextSetup
	- Loads larger context of Spring Configuration.
	- Tests many controllers per configuration.
	- Allows for testing of application config.


#### Static imports

- Spring MVCTest users a "fluen" API via several Static Imports.
	- MockMvcRequestBuilders - Builds Request.
	- MockMvcResultsMatchers - Create assertions against response.
	- MockMvcBuilders - Configure and build an instance of MockMvs.
	
#### Important Differences from Container

- Spring MVC Tests does not use a running Servlet Container.
- Not network requests are made.
- HTML is not generated, thus templates are not executed (JSP, Thymeleaf etc).
- You can test the view (template) requested, or directed to.
	- You cannot test excpected HTML to be generated.
- Spring does support testing with a running container when needed.

#### Using Spring MVC Test

- NB! These sample controllers are returning views, and are not REST Controllers!
- These samples are here to show use of Spring MVC Test, for how to test REST Controllers, see Section 16!
- Here we are also using JUnit BDD, which is a bit easier to read and understand.
	- Like *given(someService.findAll()).willReturn(personList)* instead of *when(someService.findAll()).thenReturn(personList)*
	- Functionality is the same, but the methods are different. 
	

#### Testing a Controller Method returning a View

```Java

@Controller
public class SomeController {

	private final SomeService someService;
	
	public SomeController(SomeService someService) {
	
		this.someService = someService;
	}
	
	@RequestMapping(value = "/index.html")
	public String showAll(Map<String, Object> model) {
	
		List<Person> people = someService.findAll();
		model.put("people", people);
		return "index";
	}

}

@ExtendWith(MockitoExtension.class)
class MVCTestDemo {

	@Mock
	private SomeService someService;
	
	@InjectMocks
	private SomeController someController;
	
	MockMvc mockMvc;
	List<Person> personList = new ArrayList<>();
	
	@BeforeEach
	void setUp() {
	
		personList.add(new Person());
		given(someService.findAll()).willReturn(personList);
		
		mockMvc = MockMvcBuilders.standaloneSetup(someController).build();
	}
	
	@Test
	void mockMvcGet() {
		mockMvc.perform(get("/index.html"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("person"))
				.andExpect(view().name("index"));
	}
}
```

#### Testing a Form POST

- Controller takes in a person as a parameter

```Java

@Controller
public class SomeController {

	private final SomeService someService;
	
	public SomeController(SomeService someService) {
	
		this.someService = someService;
	}
	
	@RequestMapping(value = "/index.html", method = RequestMethod.POST)
	public String showAll(@Valid Person person, BindingResult result) {
		//posting logic
	}

}

@ExtendWith(MockitoExtension.class)
class MVCTestDemo {

	@Mock
	private SomeService someService;
	
	@InjectMocks
	private SomeController someController;
	
	MockMvc mockMvc;
	List<Person> personList = new ArrayList<>();
	
	@BeforeEach
	void setUp() {

		mockMvc = MockMvcBuilders.standaloneSetup(someController).build();
	}
	
	@Test
	void mockMvcPost() {
		mockMvc.perform(post("/index.html")
					.param("firstName", "Fredrik")
					.param("lastName", "Pedersen")
					.param("address", "Roadstreet 123"))
				.andExpect(status().isOk())
	}
}
```

## Section 15: Testing With Spring Boot

#### Spring Testing Context with Spring Boot

- **@SpringBootTest** - will enable Spring Context.
	- Annotation includes @ExtendWith(SpringExtension.class) (only in JUnit 5!).
- Can be used to start a WebEnvironment with the use of @SpringBootTest(webEnvironment = <option>)
	- **Options**:
	- MOCK - Default, loads mock web environment.
	- RANDOM_PORT - Provided embedded web server listening on a random port (useful to avoid port conflicts).
	- DEFINED_PORT - Provides embedded web server listening on a 8080 (default) or server port defined in application.properties.
	- NONE - No Web Environment.

#### Spring Boot Test Annotations
```Java
@TestComponent //Stereotype for test components
@TestConfiguration //Java Configuration for tests
@LocalServerPort //Inject port of running server
@MockBean //Inject Mockito Mock
@SpyBean //Inject Mockito Spy
```
	
## Section 16: Spring MVC REST Controller Tests

#### Jayway JsonPath

- Is used to read JSON documents.
- GitHub repo with documentation can be found [here](https://github.com/json-path/JsonPath).
- Page where you can try different queries is found [here](http://jsonpath.herokuapp.com/).
- Is included in Spring Boot dependencies.

- **NOTE: From here on the tests are being run in the Brewery Project. Writing samples for everything being demonstrated will be very time consuming, so I will link to the relevant Test instead.**

#### Using JsonPath in MockMVC Tests

- See [BeerControllerTest: testGetBeerById](https://github.com/FredrikPedersen/Learning_Spring/blob/master/Testing%20Spring%20Boot%20-%20Beginner%20to%20Guru/brewery/src/test/java/com/fredrikpedersen/brewery/web/controllers/BeerControllerTest.java) for use on single attributes.
- See [BeerControllerTest: testListBeers](https://github.com/FredrikPedersen/Learning_Spring/blob/master/Testing%20Spring%20Boot%20-%20Beginner%20to%20Guru/brewery/src/test/java/com/fredrikpedersen/brewery/web/controllers/BeerControllerTest.java) for use on list attributes.

#### Using Custom Message Converters with Spring MVC Test

- You can create your own Jackson object converters. The exact use cases for this is not explained in the course.
- In BeerControllerTest we add a method jackson2HttpMessageConverter, then in the setUp-method where we build the mockMvc, we add *setMessageConverters(jackson2HttpMessageConverter())* before .build() is called.
- In BeerControllerTest: testGetBeerById we now add a DateTimeFormatter and an assertion on the date object in the validBeer-object.
- This part came somewhat out of the blue in the course and is not really explained any better.

#### @WebMvc Test Slice

- Configuring a test for using the Spring Context requires a bit of a different setup.
- In the @WebMVC example we don't use the full Spring Context, just the Web-part of it, hence the @WebMvcTest and not @SpringBootTest tag.
- See [BeerControllerTestWithContext](https://github.com/FredrikPedersen/Learning_Spring/blob/master/Testing%20Spring%20Boot%20-%20Beginner%20to%20Guru/brewery/src/test/java/com/fredrikpedersen/brewery/web/controllers/BeerControllerTestWithContext.java).

#### Using Test RestTemplate

- This part demonstrates how to create an Integration Test utilizing the entire Spring Context.
- The test itself just asserts that the number of Beers in the database are correct (3).
- See [BeerControllerIT](https://github.com/FredrikPedersen/Learning_Spring/blob/master/Testing%20Spring%20Boot%20-%20Beginner%20to%20Guru/brewery/src/test/java/com/fredrikpedersen/brewery/web/controllers/BeerControllerIT.java).

## Section 17: Testing With WireMock

#### Introduction to WireMock

- Wiremock is a simulator for HTTP based APIs
- Can be configured to serve canned responses.
- Also, can be used to verify requests.
- Like Mockito, but for WebServices.

#### Wiremock: Key Features

- HTTP Response Stubbing
	- Response based on matchers for URL, header, and/or body.
- Request Verification.
- Run for Unit tests or standalone.
- Configure via Java, JSON or JSON over HTTP.
- Recording and playback.
- Configurable delays.

#### Wiremock Standalone Use

- WireMock standalone instructions and download link can be found [here](http://wiremock.org/docs/running-standalone/).
- With JSON configuration, add the JSON config to the folder "mappings", which is generated in the same folder you run WireMock from.
	- Remember to restart WireMock when adding new mappings.
- In the course the following config is used for the brewery application:
	- It tells WireMock that for GET-requests the specified URL, it should return the specified response.

```JSON
{
	"id" : "b3685b8b-6085-4463-bdee-e5f5dbdaf48a",
	"request" : {
		"url" : "/v1/payors/0a818933-087d-47f2-ad83-2f986ed087eb",
		"method" : "GET"
	},
	"response" : {
		"status" : 200,
		"body" : "{\"payorId\":\"0a818933-087d-47f2-ad83-2f986ed087eb\"}",
		"transformers" : [ "response-template" ]
	},
	"uuid" : "b3685b8b-6085-4463-bdee-e5f5dbdaf48a"
}
```

#### Testing With WireMock

- Using Wiremock with JUnit5 requires the following in your POM:

```XML
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.JensPiegsa</groupId>
    <artifactId>wiremock-extension</artifactId>
    <version>0.4.0</version>
    <scope>test</scope>
</dependency>
```

- See [GitHub page](https://github.com/JensPiegsa/wiremock-extension) for updated versions and an Example use of the extension.
- Se [BeerOrderStatusChangeEventListenerTest] (https://github.com/FredrikPedersen/Learning_Spring/blob/master/Testing%20Spring%20Boot%20-%20Beginner%20to%20Guru/brewery/src/test/java/com/fredrikpedersen/brewery/events/BeerOrderStatusChangeEventListenerTest.java) for how to mock a response from a HTTP API.
