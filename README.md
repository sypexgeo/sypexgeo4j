__sypexgeo4j__  - is a Java REST client for [Sypex](https://sypexgeo.net/) geo service.
Sypex REST API allows to run up to 10000 requests per month for free.

[![Build Status](https://travis-ci.org/sypexgeo/sypexgeo4j.svg?branch=master)]	(https://travis-ci.org/sypexgeo/sypexgeo4j)

## Building

```
mvn -DskipTests=true clean package install
```

## Usage

```java
// Initialize client. The 'auth key' may be null
SxGeoResult result = new SxRestClient("auth key").get("93.92.217.228");
result.setCache(myCacheImpl); // set cache implementation (optional) 

// Most important fields have dedicated fields
result.city.name.en() ➟ "Seattle"
result.city.name.ru() ➟ "Сиэтл"
result.city.timeZone ➟ "America/Los_Angeles"
result.region.name.de() ➟ "Washington (Bundesstaat)"
result.country.name.fr() ➟ "États-Unis"

// All values from response are available as attributes
res.country.getStringAttribute(SxValue.AREA)  ➟ "9629091"
res.country.getIntAttribute(SxValue.AREA)  ➟ 9629091
```

### Requirements

Java 1.8+


### License

This project available under Apache License Version 2.0