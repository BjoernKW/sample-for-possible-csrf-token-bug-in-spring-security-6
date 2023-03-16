# sample-for-possible-csrf-token-bug-in-spring-security-6
Sample project for https://github.com/spring-projects/spring-security/issues/12869

To verify the behaviour describe in the issue, run the Spring Boot application in this project.

Then, import the Postman collection in the project's root directory ([Sample for possible CSRF token bug in Spring Security 6.postman_collection.json](Sample%20for%20possible%20CSRF%20token%20bug%20in%20Spring%20Security%206.postman_collection.json))
and run the `POST /sample` request from that collection (please note: That request includes a test script, which sets a `sample-xsrf-token` variable.
This variable subsequently is used as an `X-XSRF-TOKEN` request header for the POST request).

**Expected outcome**: The request should succeed (HTTP 200).

**Actual outcome**: The request fails with HTTP 403 and this log message from the Spring Boot application:

"*2023-03-16T11:59:12.366+01:00 DEBUG 81085 --- [nio-8080-exec-2] o.s.security.web.csrf.CsrfFilter         : Invalid CSRF token found for http://localhost:8080/sample*".
