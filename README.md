# Hexagonal Architecture

[Read this article on Dev.to](https://dev.to/jorgetovar621/hexagonal-architecture-javakotlin-example-15i7)

I've worked on numerous projects that claim to follow the Hexagonal Architecture style. Each of them has inspired this article, either because they had intriguing ideas or because I didn't entirely agree with their implementation (such as mixing business logic with framework dependencies).

The goal of this post is to create an open-source artifact that embodies the fundamental principles of Clean Architecture:

- Framework-independent
- Testable
- Independent of the user interface
- Independent of the database
- Independent of any external service
- **Inversion of dependencies**: Low-level modules (Infrastructure: UI, Database, Integrations) depend on high-level abstractions (Business Logic)

[GitHub Repository](https://github.com/jorgetovar/hexagonal-architecture-java)

To keep the example simple, we create a basic Use-case where, based on some resources and the authors/mentors, we mark them as optional or mandatory.

## Java/Kotlin Artifact

**Initial considerations:**

- Business logic must be independent (We create a Gradle Module with plain Java)
- Framework, database, and other low-level details will reside in another module/project (Spring Project in Kotlin)

The low-level abstractions module depends on the domain module (Business logic):

```gradle
implementation(project(":domain"))
```

### Build from source

Compile and run tests:
```bash
./gradlew clean build
```

Run the application:
```bash
./gradlew bootRun
```

![Spring boot running](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/4ijyp564tihug0fj4st0.png)

Testing HTTP calls:

Using the [HTTPie](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html) client in IntelliJ IDEA.

![HTTP test](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/q1qwkxn72k9ntzng59o6.png)
 
## Clean Architecture 

Good software design is about how we organize the code of the system to manage complexity. The idea is to create modular systems with high cohesion and low coupling, ultimately promoting the separation of concerns and allowing some flexibility to evolve our systems. 

"The outer circles are mechanisms. The inner circles are policies."

### Business Objects

These don't have any outward dependencies and are the fundamental part of the application. It's the same language that the business speaks.

### Use-Cases

These are the features or descriptions of what users can do with our system. Essentially, it's what we call "Business logic." 

### Input and Output Ports

These are abstractions of what a user can do (Input ports) and any external integration, database, or low-level detail (Output adapter).

### Input and Output Adapters

These are the implementations of the Ports. Low-level details, the database, the HTTP controller, the CLI, essentially the glue between the users and the core of our business (use-cases).

![Clean Architecture Reflectoring](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/d09cs5fobzwe8r9k3fju.png)

## Onion Architecture

Key tenets of the onion architecture:
- The application is built around the business-independent model.
- Inner layers define interfaces; outer layers implement interfaces.
- The direction of coupling is toward the center.
- The application core code can be compiled and run separately from the infra code.

## Design Considerations

- Effort is inversely proportional to software design.
- Make it work, then make it right.
- The key to going fast is not building things that make you go slow.
- The primary value is meeting customer needs.
- The second value is having a good structure that allows the software to be maintainable.
- Architecture must show intent!
- Isolate things and defer decisions.
- Acceptance tests must be finished in the middle of the sprint.

### Code Example

- The module of business logic is independent of the framework and database, using plain **Java**.
- Low-level details were implemented in the Kotlin project.

If we need to change the database, or even the framework, it's easy. We just need to implement the DomainRepository class with another type of database, for example, my preferred one: DynamoDB.

## Resources

- [Reflectoring Clean Architecture](https://reflectoring.io/spring-hexagonal/)
- [Clean Architecture by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)  
