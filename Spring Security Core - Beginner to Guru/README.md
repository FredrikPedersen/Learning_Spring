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


	 
 
 