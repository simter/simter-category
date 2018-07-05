# Simter Category Modules

## Requirement

- Maven 3.5.2+
- Kotlin 1.2.31+
- Java 8+
- Spring Framework 5+
- Spring Boot 2+
- Reactor 3+

## Maven Modules

Sn | Name                                  | Parent                       | Remark
---|---------------------------------------|------------------------------|--------
1  | [simter-category-build]               | [simter-build:0.5.0]         | Build modules and define global properties and pluginManagement
2  | [simter-category-dependencies]        | simter-category-build        | Define global dependencyManagement
3  | [simter-category-parent]              | simter-category-dependencies | All sub modules parent module, Define global dependencies and plugins
4  | [simter-category-data]                | simter-category-parent       | Define Service and Dao Interfaces
5  | [simter-category-data-reactive-mongo] | simter-category-parent       | Dao Implementation By Reactive MongoDB
6  | [simter-category-data-jpa]            | simter-category-parent       | Dao Implementation By JPA
7  | [simter-category-rest-webflux]        | simter-category-parent       | Rest API By WebFlux
8  | [simter-category-starter]             | simter-category-parent       | Microservice Starter


Remark : Module 1, 2, 3 all has maven-enforcer-plugin and flatten-maven-plugin config. Other modules must not configure them.


[simter-build:0.5.0]: https://github.com/simter/simter-build/tree/0.5.0
[simter-category-build]: https://github.com/simter/simter-category
[simter-category-dependencies]: https://github.com/simter/simter-category/tree/master/simter-category-dependencies
[simter-category-parent]: https://github.com/simter/simter-category/tree/master/simter-category-parent
[simter-category-data]: https://github.com/simter/simter-category/tree/master/simter-category-data
[simter-category-data-jpa]: https://github.com/simter/simter-category/tree/master/simter-category-data-jpa
[simter-category-data-reactive-mongo]: https://github.com/simter/simter-category/tree/master/simter-category-data-reactive-mongo
[simter-category-rest-webflux]: https://github.com/simter/simter-category/tree/master/simter-category-rest-webflux
[simter-category-starter]: https://github.com/simter/simter-category/tree/master/simter-category-starter