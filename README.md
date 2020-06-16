# simter-category

A Category Manager.

## Maven Modules

| Sn | Name                         | Type | Parent                 | Remark
|----|------------------------------|------|------------------------|--------
| 1  | [simter-category]            | pom  | [simter-build]         | Build these modules and define global properties and pluginManagement
| 2  | simter-category-bom          | pom  | simter-category        | Bom
| 3  | simter-category-parent       | pom  | simter-category        | Define global dependencies and plugins
| 4  | simter-category-core         | jar  | simter-category-parent | Core API: [Category], [CategoryDao] and [CategoryService]
| 5  | simter-category-dao-mongo    | jar  | simter-category-parent | [CategoryDao] Implementation By Reactive MongoDB
| 6  | simter-category-dao-r2dbc    | jar  | simter-category-parent | [CategoryDao] Implementation By R2DBC
| 7  | simter-category-dao-jpa      | jar  | simter-category-parent | [CategoryDao] Implementation By JPA
| 8  | simter-category-rest-webflux | jar  | simter-category-parent | [Rest API] Implementation By WebFlux
| 9  | simter-category-starter      | jar  | simter-category-parent | Microservice Starter

## Requirement

- Maven 3.6+
- Kotlin 1.3+
- Java 8+
- Spring Framework 5.2+
- Spring Boot 2.3+
- Reactor 3.3+

[simter-build]: https://github.com/simter/simter-build
[simter-category]: https://github.com/simter/simter-category
[Category]: https://github.com/simter/simter-category/blob/master/simter-category-core/src/main/kotlin/tech/simter/category/core/Category.kt
[CategoryDao]: https://github.com/simter/simter-category/blob/master/simter-category-core/src/main/kotlin/tech/simter/category/core/CategoryDao.kt
[CategoryService]: https://github.com/simter/simter-category/blob/master/simter-category-core/src/main/kotlin/tech/simter/category/core/CategoryService.kt
[Rest API]: ./docs/rest-api.md