# Clean Architecture


- Entities are business objects
- Use case use the business objects and made application-independent abstractions

### Initial considerations: 

- Java domain module with all the business logic and use cases
- Infra module with Spring Boot dependencies, configurations, and adapters

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

# Resources

- [Reflectoring](https://reflectoring.io/spring-hexagonal/)
- [Clean Architecture by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)  
