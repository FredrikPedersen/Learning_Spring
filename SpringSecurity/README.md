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