## Alien Run

Solo project for the course TDT4100 at NTNU

This project is based of the popular mobile game Temple Run, and is writen in Java using JavaFX for the user inferface, with simple file saving and mainly using included libraries (because of the requirements set for this project)

# Starting the game

To start the game, all you need is JVM on you PC
Run the main methode in TempleRunApp.java file found under src/main/java/templeRun in your favourite code editor 

## Setup
1. Ensure you have Java and JavaFX installed on your system. If not, download and install them from the official websites.
2. Clone or download the repository to your local machine.
```bash
git clone https://github.com/Spiderpig02/AlienRun.git
cd AlienRun
```
3. Compile and run the program.
```bash
mvn clean javafx:run
```




# How to run Tests
To run the full test suite, run the following command in the root directory of the project:
```bash
mvn test
```