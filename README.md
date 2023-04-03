1. added the mvc home into weather as module named mvc1, signed in Eureka 
2. added the 3rd-party api into weather as module named mvc2, signed in Eureka 
3. config, discovery, gateway, search, details, mvc1, mvc2 executed successfully 
4. use search server to fatch getAllStudent(), getStudentById(), getAllEntries(), getEntriesByAuth() using RestTemplate and CompletableFuture
5. configure Hystrix to Search service 
6. configure swagger documentation in search service 
7. configure student service in gateway by modifying gateway-dev.properties, it is eabled to fetch Student information through gateway server.port

Issue: 
when change to self-generated keystore, throws some exceptions
