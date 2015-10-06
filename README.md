__sypexgeo4j__  - is a Java interface to [Sypex](https://sypexgeo.net/) geo service.

[![Build Status](https://travis-ci.org/sypexgeo/sypexgeo4j.svg?branch=master)]	(https://travis-ci.org/sypexgeo/sypexgeo4j)

## Building

```
mvn -DskipTests=true clean package install
```


## Usage

```java
SxGeoResult result = new SxRestClient().get("93.92.217.228");

// Most used non-null values have predefined fields
result.city.name.enValue() ➟ "Seattle"
result.city.name.ruValue() ➟ "Сиэтл"
result.city.timeZone ➟ "America/Los_Angeles"
result.region.name.deValue() ➟ "Washington (Bundesstaat)"
result.country.name.frValue() ➟ "États-Unis"

// All values are available as attributes
res.country.getStringAttribute(SxValue.AREA)  ➟ "9629091"
res.country.getIntAttribute(SxValue.AREA)  ➟ 9629091
```

### Requirements

Java 1.8+


### License

This project available under Apache License Version 2.0