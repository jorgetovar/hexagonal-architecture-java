# Hexagonal Architecture

[Dev.to Hexagonal Architecture Article](https://dev.to/jorgetovar621/hexagonal-architecture-javakotlin-example-15i7)

I have been working on many projects that claim to be using the Hexagonal Architecture Style. All of them inspired this article because they have some interesting ideas or perhaps I didn't agree with the implemented structure (Business logic with Frameworks dependencies). 

The goal of this post is to create an open-source artifact that exposes the fundamental ideas of Clean Architecture: 

- Independent of frameworks
- Testable
- Independent of UI
- Independent of database
- Independent of any external service
- **Inversion of dependencies**: Low level **(Infrastructure: UI, Database, Integrations)** modules depends on High Level abstractions **(Business Logic)**

[Github Repository](https://github.com/jorgetovar/hexagonal-architecture-java)

To keep the example simple: we create a basic Use-case where based on some resources and the authors/mentors mark them as optional or mandatory.

## Java/Kotlin Artifact

**Initial considerations:**

- Business logic must be independent (We create a Gradle Module with just plain Java)
- Framework, database, and those low-level details will be in another module/project (Spring Project in Kotlin)

Low-level abstractions module depends on domain module (Business logic):


` implementation(project(":domain"))`


### Build from source

Compile and run tests:
`./gradlew clean build`

Run the application:
`./gradlew bootRun`

![Spring boot running](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/4ijyp564tihug0fj4st0.png)

Running HTTP calls:

The [HTTPie](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html) client in IntelliJ IDEA.

![Http test](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/q1qwkxn72k9ntzng59o6.png)
 
## Clean Architecture 

Good design in software is about the way in which we organize the code of the system to manage complexity. The idea is to create modular systems with high cohesion and low coupling, and after all, promote separation of concerns and allow some flexibility to evolve our systems. 

"The outer circles are mechanisms. The inner circles are policies".


### Business Objects

They don’t have any outward dependency and are the fundamental part of the application. The same language that the business speaks.

### Use-Cases

They are the features or descriptions of what the users can do with our system. Actually, what we call the "Business logic". 

### Input and Output Ports

They are the abstractions of what a user can do (Input ports), and any external integration, database, or low-level detail (Output adapter).

### Input and Output Adapters

They are the implementation of the **Ports**. Low-level details, the database, the HTTP controller, the CLI, basically the glue between the users and the core of our business (use-cases).


![Clean Architecture Reflectoring](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/d09cs5fobzwe8r9k3fju.png)


## Onion Architecture

The key tenets of onion architecture
- The application is built around the business independent model
- Inner layer define interfaces, outer layer implement interfaces
- Direction of coupling is toward the center
- The application core code can be compiled and run separately from Infra code

## Design considerations

- Effort is inversely proportional to Software design
- Make it work, then make it right
- The key to going fast is not to build the things that make you go slow
- First value is to meet customer needs
- Second value its have a good structure that allows the software to be maintainable
- Architecture must show intent!
- Isolate things and defer decisions
- Acceptance test must be finished in the middle of the sprint

### Code Example

- Module of business logic is independent of the Framework and Database. Just plain **Java**.
- Low-Level details were implemented in the Kotlin project. 

If we need to change the database, ever the framework is easy. We just need to implement the DomainRepository class with another type of Database, for example, my preferred one: DynamoDB.


## Resources

- [Reflectoring Clean Architecture](https://reflectoring.io/spring-hexagonal/)
- [Clean Architecture by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)  
 
