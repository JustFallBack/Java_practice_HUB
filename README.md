# Java_practice_HUB

## Description

This repository contains small java script I did as training during my 2nd year of bachelor's degree at Avignon Université.<br>
Every file is commented in english.<br>
If a folder does no have a README file, it means it is not necessary (the name of java classes should be explicite enough).<br>
Nevertheless, each class have a little introduction to better understand it's behaviour.<br>

## Compilation and usage

### Download JDK

To compile the Java files in this repository, you will need to have the Java Development Kit (JDK) installed on your system. Here is a step-by-step procedure to install OpenJDK:

1. Visit the OpenJDK website at [https://openjdk.java.net/](https://openjdk.java.net/) and navigate to the Downloads section.

2. Choose the version of OpenJDK that is compatible with your operating system and click on the download link.

3. Once the download is complete, run the installer and follow the on-screen instructions to install OpenJDK.

4. After the installation is complete, open a terminal or command prompt and verify that Java is installed by running the following command:

    ```shell
    java -version    ```

### Compile a Java project

1. A Java project is a folder containing `.java` files.

2. To compile a Java project, navigate to the root directory of the project in the terminal or command prompt.

3. Use the `javac` command followed by the name of the Java file you want to compile. For example, if your Java file is named `MyClass.java`, you would run the following command:

    ```shell
    javac MyClass.java
    ```

   This will generate a compiled bytecode file named `MyClass.class`.

4. If your project has multiple Java files, you can use the `javac` command with wildcard characters (`*`) to compile all Java files in the current directory. For example, to compile all Java files ending with `.java`, you would run the following command:

    ```shell
    javac *.java
    ```

   This will generate compiled bytecode files for each Java file in the current directory.

### Run a Java project

1. After the compilation is complete, you can run the Java program using the `java` command followed by the name of the class containing the `main` method. For example, if your main class is named `MainClass`, you would run the following command:

    ```shell
    java MainClass
    ```

2. If your main class requires command line arguments, you can pass them after the class name when running the Java program. For example, if your main class is named `MainClass` and requires two arguments, you would run the following command:

    ```shell
    java MainClass arg1 arg2
    ```

    Replace `arg1` and `arg2` with the actual values for your command line arguments.