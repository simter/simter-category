# simter-category-test

## 1. Unit test tools in [TestHelper.kt]

A unit test tools for generate random value:

- `fun randomCategory(): Category`

## 2. Integration test

### 2.1. Start server

For test purpose, start the test server:

```shell
$ cd ../simter-category-starter
$ mvn clean spring-boot:run
```

> Ignore this if test on another server.

### 2.2. Run integration test on server

```shell
$ cd ../simter-category-test
$ mvn clean test -P integration-test
```

This will run all the integration test on each rest-api define in <[rest-api.md]>.

Want to run the integration test on the real server, just add specific param:

| ParamName  | Remark         | Default value
|------------|----------------|---------------
| server-url | server address | http://127.0.0.1:8086/category


[TestHelper.kt]: https://github.com/simter/simter-category/blob/master/simter-category-test/src/main/kotlin/tech/simter/category/test/TestHelper.kt
[rest-api.md]: https://github.com/simter/simter-category/blob/master/docs/rest-api.md
