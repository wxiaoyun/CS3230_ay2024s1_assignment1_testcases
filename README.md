# CS3230 AY2024S1 Assignment 1 Test Cases

This repository is dedicated to students of NUS who are enrolled in CS3230 for the academic year 2023/24, semester 1. It contains code designed to test the correctness of students' implementation for the assignment's questions.

## Getting Started

### Method 1: Cloning the Repository

1. **Clone the Repository**: Open your terminal and run the following command to clone this repository to your local machine:
    ```bash
    git clone https://github.com/ForAeons/CS3230_ay2024s1_assignment1_testcases.git
    ```
2. **Navigate to the Repository Directory**: 
    ```bash
    cd CS3230_ay2024s1_assignment1_testcases
    ```
3. **Edit the Static String in the TestSolution Class**: Don't forget to modify the `testFileDir` static string in the `TestSolution` class to the absolute path to the directory containing the input and output txt files:
    ```java
    private static String testFileDir = "/absolute/path_to/test_file_dir/";
    ```

### Method 2: Copy-Paste

1. **Copy the Code**: Click on the `Code` button on the repository page, then click on `Download ZIP`. Once downloaded, extract the ZIP file to access the code.
2. **Paste the Code**: Copy the code files from the extracted folder and paste them into your desired directory on your local machine.
3. **Edit the Static String in the TestSolution Class**: Don't forget to modify the `testFileDir` static string in the `TestSolution` class to the absolute path to the directory containing the input and output txt files:
    ```java
    private static String testFileDir = "/absolute/path_to/test_file_dir/";
    ```

## Contribute

You can contribute adding more test cases. Here's how you can contribute:

1. **Fork the Repository**: Click on the 'Fork' button at the top right corner of the repository page to create a copy of this repository in your GitHub account.
2. **Clone the Forked Repository**: Run the following command in your terminal to clone the forked repository to your local machine:
    ```bash
    git clone https://github.com/your-username/CS3230_ay2024s1_assignment1_testcases.git
    ```
3. **Create a New Branch**: Navigate to the cloned repository directory and create a new branch for your test cases:
    ```bash
    cd CS3230_ay2024s1_assignment1_testcases
    git checkout -b my-test-cases
    ```
4. **Add Your Test Cases**: Copy your test case files into the `root` directory of the cloned repository.
5. **Commit and Push Your Changes**: Once you've added your test cases and edited the `TestSolution` class, commit and push your changes to your forked repository:
    ```bash
    git add .
    git commit -m "Add my test cases"
    git push origin my-test-cases
    ```
6. **Create a Pull Request**: Come back to this repository on GitHub, switch to the 'Pull requests' tab, and click on the 'New pull request' button. Choose your fork and branch to create a new pull request.

## Acknowledgments

- Thanks to all contributors who help in improving the test cases and making learning a collaborative effort.
