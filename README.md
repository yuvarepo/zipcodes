# zipcodes
### Synopsis

This is a simple service

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), and process t0 produces the minimum number of ranges required to represent the same restrictions as the input.

### Runtime of this program :: O(n logn)

### Unit Test Cases
Tests contain all corner cases and mock input values passed to see expected output

### Input Examples

``` 
input = [94133,94133] [94200,94299] [94600,94699]
output = [94133,94133] [94200,94299] [94600,94699]

input = [94133,94133] [94200,94299] [94226,94399] 
output = [94133,94133] [94200,94399]
```

### Service

````
java -jar zipcodes-0.0.1-SNAPSHOT.jar 90804,95747 90805,95748 92300,92348 92301,92347

output
[90804,95748]
````

### Maven Build and test

```` 
 mvn clean install
````

