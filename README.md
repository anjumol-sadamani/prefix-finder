# Prefix Finder App

### Functional Requirement:

Given a list of string prefixes of variable length, the assignment is to implement a method that takes a string as a parameter,
and returns the longest prefix that matches the input string. A prefix matches if the input string starts with that prefix.

### Implementation:

Input
```shell
List of prefixes -  resources/Sample_prefixes.txt
Word - Read from console 
````

Output
```shell
longest prefix from the List of prefixes provided
````

Created Trie data structure using the List of prefixes provided. Queried the prefix-trie for the provided input word.
Returned the longest prefix found while traversing the prefix-trie.

### Time Complexity 
Creating Trie - O(M), where M is the number of characters in input file

Finding longest prefix - O(N), where N is the number of characters in longest prefix.


## Getting Started

Instruction to set up application locally for running, compiling and testing

### Prerequisites

1. Java 11
2. Maven

To Download dependencies, Run below command from project root
```shell
mvn install
```

### Build

Build - Run below command from project root
```shell
mvn compile
```

## Run tests

```shell
mvn test
```
## Package

```shell
mvn package
```

## Run App

To run from the command line

```shell
mvn exec:java -Dexec.mainClass=org.example.PrefixFinderApp
```

### Output

```shell
Enter a word(press \q to exit): artEyvAbcdfaad
Longest matching prefix: artEyv
Enter a word(press \q to exit): jhwFJa
Longest matching prefix: jhwFJ
Enter a word(press \q to exit): \q

```

