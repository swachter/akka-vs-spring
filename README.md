# akka-vs-spring

Check behaviour of Spring and Akka under load

The application starts two servers:

1. Spring-Http-Server under port 8080
2. Akka-Http-Server under port 9090

Both servers return a simple string on a get request.

Start the application using

```
mvn exec:java
```

Execute a load tests on port 8080 (Spring version)

```
mvn gatling:execute -Dgatling.skip=false -Dport=8080
```

This returns on an Ubuntu box:

```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      41625 (OK=41625  KO=0     )
> min response time                                   2000 (OK=2000   KO=-     )
> max response time                                   3694 (OK=3694   KO=-     )
> mean response time                                  2173 (OK=2173   KO=-     )
> std deviation                                        271 (OK=271    KO=-     )
> response time 50th percentile                       2059 (OK=2059   KO=-     )
> response time 75th percentile                       2221 (OK=2221   KO=-     )
> mean requests/sec                                1304.573 (OK=1304.573 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                             0 (  0%)
> 800 ms < t < 1200 ms                                   0 (  0%)
> t > 1200 ms                                        41625 (100%)
> failed                                                 0 (  0%)
================================================================================
```

Execute a load tests on port 9090 (Akka version)

```
mvn gatling:execute -Dgatling.skip=false -Dport=9090
```

returns:

```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      44114 (OK=44114  KO=0     )
> min response time                                   2009 (OK=2009   KO=-     )
> max response time                                   2223 (OK=2223   KO=-     )
> mean response time                                  2018 (OK=2018   KO=-     )
> std deviation                                         14 (OK=14     KO=-     )
> response time 50th percentile                       2011 (OK=2012   KO=-     )
> response time 75th percentile                       2021 (OK=2021   KO=-     )
> mean requests/sec                                1379.856 (OK=1379.856 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                             0 (  0%)
> 800 ms < t < 1200 ms                                   0 (  0%)
> t > 1200 ms                                        44114 (100%)
> failed                                                 0 (  0%)
================================================================================```
```
