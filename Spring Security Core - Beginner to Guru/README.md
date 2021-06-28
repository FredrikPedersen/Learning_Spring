# Spring Security - Notes

## Key Security Terminology

### Authentication

 - The Process or action of verifying the identity of a user or process.
 - Spring Security has a built in class for this, called Authentication.
	- Out of the box it supports Basic, Form, Digest and Certificate authentication.
 - Spring Security calls a authenticated user for a Principal, and is often refered to as a Authenticated Principal

#### Authorization
 - The Function of specifying access rights and privileges to resources.


## Spring Security Modules

 - Spring Security Core and Spring Security Config
	- Core authentication and autorizations functionality
	- Custom configurations via annotations or XML.

 - Spring Security Test
	- If you need to test the security implementation

 - Spring Security Web
	- Used for securing webapplications
	
 - ... there are a lot more of these.
 
## Section 3 HTTP Basic Auth
 
### Overview

 - HTTP Basic Authentication is part of the HTTP Specification (last updated in RFC 7617 in 2015).
 - Basic Authentication provides a standard way for HTTP Clients to submit username and password, either by URL encoding or HTTP Headers
	 - **URL Encoding** - *https://username:password@example.com*
	 - **HTTP Header** - *Key: Authorization, Value: Basic <Base64 encoded string>*, where the string is <username:password>.
 - URL and Header encoding is **not** secure!
	 - It is a trivial task to revert Base64 encoding
 - To protect user credentials, HTTPS is recommended
 - HTTP Basic Authentication is also criticized for sending user credentials in every request.
 
### Spring Security HTTP Basic Authentication

 - When Spring Boot detects Spring Security on the classpath, it will auto-configure Spring Security for HTTP Basic Authentication.
 - All paths will be secured with a default username and password, except for actuator info and health.
	 - Default User - user.
	 - Default password - random UUID printed in console on application startup.
	 - Can be overridden by setting spring.security.user.name and spring.security.user.password properties.

## Section 5 In-Memory Authentication Provider

### Spring Security Authentication Process

 - **Authentication Filter** - A filter for a specific authentication type in the Srping Security filter chain (ie. basic auth, remember me cookie etc).
 - **Authentication Manager** - Standard API Interface used by filter.
 - **Authentication Provider** - The implementation of Authentiacation - (in memory, database, etc).
 - **User Details Service** - Service to provide information about user.
 - **Password Encoder** - Service to encrypt and verify passwords.
 - **Security Context** - Holds details about authenticated entity.

### In Memory User Details Manager

 - Implements User Details Service.
 - Used by Spring Boot Auto-configuration.
 - Non-persistent implementation, uses in-memory map.
 	- Mainly used for testing and demonstration purposes.
	
## Section 6: Password Security

### Password Storage and Encoding
 - When logging in, the application needs to verify the enetered password matches the password stored in the system.
 - Legacy systems sometimes store passwords in plain text, which is obviously not ideal.
 - Other systems encrypt the password in the database, then decrypt to verify, which is not ideal either.

### Password Hash
 - A hash is a one-way mathematical algorithm applied to the password.
	 - One way meaning the hash value can be generated from a password.
	 - But the password cannot be generated from the hash value.
 - Example:
 	- password: password1.
	- Hash value: 5f4dcc3b5aa765d61d8327deb882cf99.
 - Here the string "password1" will always hash to 5f4dcc3b5aa765d61d8327deb882cf99.	

### Password Salt
 - Problem where hash functions generate known hash values.
 - Became a dictionary attack to guess passwords from hash value.
 - Solution is to use a salt value.
 - A salt is additional data added to the value being hashed.
 - Example of password with salt: password1{ThisIsMyReallyLongPasswordSaltValue}
 - Modern algorithms use random salt values.
	 - Thus hash value changes each time.

### Password Hash Functions
 - The security area of Hash functions is effectively an arms race.
 - As computational power increases, researchers find more vulnerabilities.
 - Spring Security supports plain text and older hash functions for compatibility with legacy systems.
	 - These encoders are marked as deprecated to warn you they are not recommended for use.

### Delegating Password Encoder
 - Spring Security 5 introduced a delegating password encoder.
 - Allows storage of password hashes in multiple formats.
 - Password hashes stored as *-{encodername}< somepasswordhashvalue >*.
 - Allows you to support multiple hash algorithms while migrating.

### Password Encoder Recommendation
 - The Spring Security Team recommends using an adaptive one way encoding function such as:
	 - BCrypt (default).
	 - Pbkdf2.
	 - SCrypt.
 - These are also considered "slow", which are computationally expensive to guard against brute force attacks.	

## Section 7: Custom Authentication Filter

### Spring Security Filters
 - All Spring Security Filters implement the Filter interface.
 	- Part of the Java Servlet API
	- Accepts Servlet Request, Servlet Response, and Filter Chain.
 - Can be used to implement actions on the Request or Response.
 - HTTP Basic Authentication us using the filter BasicAuthenticationFilter.
 	- Inspects request for HTTP Basic credentials and performs authentication.
	
### Custom Spring Security Filter Use Case
 - Hypothetically speaking we have a REST API using custom headers for Authentication.
 	- Goal here is to mimic a legacy application, this is not a recommended approach for Authentication.
 - Legacy Application sending API key and API Secret in HTTP Headers.
 - Create Spring Security filter for this legacy Authentication.
 	- Extend Spring Security's AbstractAuthenticationProcessingFilter.
 	- Configure Spring Security to use Custom Filter. 
	
## Section 8: Database Authentication

### Spring Security Database Authentication

 - Using a traditional database for authentication is a matter of providing an alternate User Details Service.
 	- Spring Security provides the interface, you provide the implementation.
 	- Can be in-memory, JDBC, NoSQL, external service, etc.
 - Spring Security does provide a JDBC implementation with database schemas.
 	- Typically a starting point and then customized to your application.
	
	
### Spring Security JPA Authentication
 
 - Provide custom Database Authentication using Spring Data JPA.
 - Need User and Authority JPA Entities.
 - Spring Data JPA Respositories.
 - Custom implementation of User Details Service using Spring Data Repositories.
 - Configure Spring Security to use custom implementation os User Details Service.


## Section 9: User Roles

### Authorization in Spring Security

 - Authorization is the approval to perform an action within the application.
 - Authorization can be as simple as allow all or is authenticated.
 - Specific action can be limited to specific roles or authorities.
 - By default, Spring Security roles start with "ROLE_".
 - Spring Security Authorities may be any String value.

### Roles vs Authorities

 - Typically a role is considered a group of one or more authorities.
 - In Spring Security Context:
 	- Roles by default starts with "ROLE_".
		- Configuration uses methods of hasRole() or hasAnyRole() - requires prefix.
	- Authorities are any String.
		- Configuration uses methods of hasAuthority() or hasAnyAuthority().

### Access Decision Voters

 - Acess Decision Voters provide a vote on allowing access
	 - ACCESS_ABSTAIN - Voter has no opinion.
	 - ACCESS_DENIED - Voter does not approve.
	 - ACCESS_GRANTED - Voter approves access.
	
<img alt="Pivotal's Access Decision Manager Diagram" src="https://docs.spring.io/spring-security/site/docs/3.2.0.CI-SNAPSHOT/reference/html/images/access-decision-voting.png" width="100%"/>

### Role Voter

 - Most commonly used voter in Spring Security.
 - Uses role names to grant access.
 - If authenticated user has role, access is granted.
 	- If no authorities begin with prefix of ROLE_ this voter will abstain.
	
### Authenticated Voter

 - Grants Access based on level of authentication. 
 - **Anonymously** - Not Authenticated.
 - **Remembered** - Authenticated via Remember me cookie.
 - **Fully** - Fully authenticated.

### Consensus Voter

 - Accepts list of Access Decision Voters.
 - Polls each voter.
 - Access granted based on total of allowed ve denied responses.

### Role Hierarchy Voter

 - Allows configuration of Role Hierarchies
 - Example:
	 - ROLE_USER
	 - ROLE_ADMIN > ROLE_USER > ROLE_UNREGISTERED
	 - ROLE_ADMIN will have all of its authorities, and those of ROLE_USER and ROLE_UNREGISTERED.
	
### Security Expressions

| Expression | Description |
| --- | --- |
| permitAll | Allows all access |
| denyAll | Denies all access |
| isAnonymous | Is Authenticated Anonymously | 
| isAuthenticated | Is Authenticated (Fully or remembered) |
| isRememberMe | Is Authenticated with Remember Me Cookie |
| isFullyAuthenticated | Is Fully Authenticated |
| hasRole | Has Authority with ROLE_** |
| hasAnyRole | Accepts list of ROLE_** Strings |
| hasAuthority | Has authority String value |
| hasAnyAuthority | Accepts list of String authority values |
| hasIpAddress | Accepts IP Address or IP/Netmask |

### Http Filter Security Interceptor

 - Securing specific URLs is done using Spring Security Filters.
 - Filters use configured voters to determine authorization.
 - Security expressions available for use in Java configuration of HttpSecurity.

### Method Security

 - Spring Security also has method level security.
 - Enable using **@EnableGlobalMethodSecurity**  configuration annotation.
 - **@Secured** - accepts list of roles, or IS_AUTHENTICATED_ANONYMOUSLY.
 - **@PreAuthorize** - accepts security expressions.
 - Under the covers Spring Security is using AOP (Aspect Oriented Programming) to intercept and use the AccessDecisionManger
	 - Same technique as filter.
	

