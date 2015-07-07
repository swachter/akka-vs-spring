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

Execute a load tests on port 8080

```
mvn gatling:execute -Dgatling.skip=false -Dport=8080
```

This returns on my machine (Windows 7; no tweaks):

```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                     199535 (OK=199535 KO=0     )
> min response time                                      0 (OK=0      KO=-     )
> max response time                                    777 (OK=777    KO=-     )
> mean response time                                     9 (OK=9      KO=-     )
> std deviation                                         19 (OK=19     KO=-     )
> response time 50th percentile                          5 (OK=5      KO=-     )
> response time 75th percentile                          9 (OK=9      KO=-     )
> mean requests/sec                                6476.937 (OK=6476.937 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                        199535 (100%)
> 800 ms < t < 1200 ms                                   0 (  0%)
> t > 1200 ms                                            0 (  0%)
> failed                                                 0 (  0%)
================================================================================
```

Execute a load tests on port 8080

```
mvn gatling:execute -Dgatling.skip=false -Dport=9090
```

This returns on my machine:

```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                      77962 (OK=17381  KO=60581 )
> min response time                                      0 (OK=0      KO=991   )
> max response time                                  60807 (OK=2135   KO=60807 )
> mean response time                                   847 (OK=80     KO=1067  )
> std deviation                                        482 (OK=268    KO=247   )
> response time 50th percentile                       1043 (OK=3      KO=1061  )
> response time 75th percentile                       1082 (OK=8      KO=1091  )
> mean requests/sec                                1222.281 (OK=272.498 KO=949.784)
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                         16592 ( 21%)
> 800 ms < t < 1200 ms                                 417 (  1%)
> t > 1200 ms                                          372 (  0%)
> failed                                             60581 ( 78%)
---- Errors --------------------------------------------------------------------
> java.net.ConnectException: Connection refused: no further info  60580 (100,00%)
rmation: localhost/127.0.0.1:9090
> java.util.concurrent.TimeoutException: Request timed out to lo      1 ( 0,00%)
calhost/127.0.0.1:9090 of 60000 ms
================================================================================
```
