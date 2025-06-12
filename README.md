# Java Line Counter

This is a command-line tool written in Java that counts the lines of code in `.java` source files. It can count either **physical lines** (total number of lines including blank lines and comments) or **logical lines of code** (excluding comments and empty lines). It supports recursive directory traversal and wildcards.

## Getting Started

These instructions will help you get a copy of the project running on your local machine for development and testing purposes.

### Prerequisites

You will need the following installed:

- [Java 17+](https://jdk.java.net/)
- [Maven 3.8+](https://maven.apache.org/install.html)
- Git (optional, for cloning)

### Installing

Clone the repository:

``` 
git clone https://github.com/your-username/java-line-counter.git
cd java-line-counter
```

Build the project using Maven:
```
mvn clean install
```

### Running the Application

You can run the program with:

```
java -cp target/java-line-counter-1.0-SNAPSHOT.jar com.yourname.countlines.App [phy|loc] <fileOrDirectory>
```
Example:
```
java -cp target/java-line-counter-1.0-SNAPSHOT.jar com.yourname.countlines.App loc src/
```
This will recursively count logical lines of code in all .java files inside the src/ directory.

## Running the tests

Run the automated unit tests with Maven:
```
mvn test
```
Unit Tests

Unit tests are written using JUnit and ensure the logic in **LineCounter** works as expected.

Example:

```
@Test
void testPhysicalLineCount() throws IOException {
    Path path = Paths.get("src/test/resources/TestFile.java");
    assertEquals(10, LineCounter.countPhysicalLines(path));
}
```
### Coding Style

The code follows the Google Java Style Guide and was formatted accordingly.

## Deployment

To package:
```
mvn package
```
Then run using:
```
java -cp target/java-line-counter-1.0-SNAPSHOT.jar com.yourname.countlines.App [phy|loc] <file>
```
## Design
To see more about the class diagram go to **DESIGN.md**
# Test Report

## Files Tested

- `LineCounter.java`
- `FileUtils.java`

## Summary

| Class        | Method                   | Test Description                             | Result  |
|--------------|--------------------------|----------------------------------------------|---------|
| LineCounter  | countPhysicalLines       | Counts all lines including comments/whitespace | Passed  |
| LineCounter  | countLogicalLines        | Counts only real code lines                  | Passed  |
| FileUtils    | findJavaFiles            | Finds all `.java` files recursively          | Passed  |

## 📚 Javadoc

La documentación del código está disponible en la carpeta `target/site/apidocs/index.html` después de ejecutar:

```bash
mvn javadoc:javadoc
````

## LOC/h Report

- Time spent: 5.5 hours
- Logical lines of code: 88
- Productivity: **16 LOC/h**

## Built With

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

* [Maven](https://maven.apache.org/) - Dependency Management

* [ JUnit 4](https://junit.org/junit4/)

## Contributing

Please read **CONTRIBUTING.md** for details on how to contribute.

## Authors

* Diego Armando Macia Diaz – Initial work

## License

* This project is licensed under the GNU License – see the LICENSE.md file.
