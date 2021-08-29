package com.moulik.bookkeeper;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Spring is an application framework that solves a lot of common problems that enterprise applications usually face. It creates an application by helping the 
 *  programmer focus only on the business requirements and takes care of the common concerns on its own like connecting to Databases, running queries, handling
 *  HTTP Requests etc. E.g. You can create POJOs specific to your business model and then annotate them with @Service through which Spring applies a lot of 
 *  things to it so that it can be effectively used later.
 *  
 *  Problems with Spring:
 *  1. Huge Framework (it handles a lot of concerns so it has gotten huge)
 *  2. Multiple Setup Steps (it can connect to a lot of databases but for that you need to do a lot of steps)
 *  3. Multiple Configuration Steps
 *  4. Multiple build and deploy steps
 *  
 *  Spring Boot is a application framework that makes it easy to create stand-alone, production-grade Spring based applications that one can "just run".
 *  It takes care of a lot of things to make the job of a programmer easier. 
 *
 *	Features of Spring Boot:
 *	* It is opinionated
 *	* Convention over configuration
 *	* Stand-alone
 *	* Production Ready
 *
 *	Setup of Spring Boot:
 *	Min Java 8 Version JDK should be installed and set in the path and JAVA_HOME
 *	Use any IDE: STS, Eclipse, IntelliJ
 *
 *	Maven:
 *	Typically when we create a java app, we have to keep track of dependent jars and libraries that our app requires, such as for jdbc driver, for hibernate,
 *	for running servers etc. We take these jars and add these to our classpath. But, Maven is a tool which can take care of handling dependencies for us. 
 *	It lets you declare all the dependencies that you require in a file called pom.xml and then downloads those dependencies onto our system in a local repo.
 *	It also helps create a starter project to which we can add our business logic.
 *
 *	1. First we can create a simple maven project by adding the maven coordinates and other details.
 *	2. To make our project into a spring boot project we add the dependency as a parent:
 *		<parent>
 *			<groupId>org.springframework.boot</groupId>
 *			<artifactId>spring-boot-starter-parent</artifactId>
 *			<version>2.5.2</version>
 *			<relativePath/> <!-- lookup parent from repository -->
 *		</parent>
 *	3. To make our project as a web application, we add the following dependency:
 *		<dependency>
 *			<groupId>org.springframework.boot</groupId>
 *			<artifactId>spring-boot-starter-web</artifactId>
 *		</dependency>
 *	4. For setting it as a Java 1.8 Project, set it in the properties
 *		<properties>
 *			<java.version>11</java.version>
 *		</properties>
 *
 *	The starting point of our Spring boot application is the class which has the main method.
 *	This class is annotated with @SpringBootApplication
 *	The main method is where we give the command
 *		SpringApplication.run(MainClassName.class, args);
 *
 */
public class SpringBootIntroduction {

}
