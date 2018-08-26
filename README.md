# Library app build instruction

Steps to run the project:
1. Open the project in your IDE as a gradle module project. The project includes a configured gradle wrapper. Don't add any framework support, because it's a plain java console application (without UI).
2. Refresh gradle project.
3. Run test case suite located in /src/test/java/LibraryTestSuite.java. (jUnit 4.12 will be linked by gradle)
4. You can also see library books' enumeration and any book's details. To do this, use an entry application java file located in /src/main/java/Main.java. It contains a sample script that will show up my app's features.
