
# TermSolver

TermSolver is a simple Java application that evaluates mathematical expressions containing numbers and the operators `*`, `+`, `/`, and `-`.

## Features

- Evaluates mathematical expressions with basic arithmetic operators.
- Handles both integer and floating-point arithmetic.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/termsolver.git
    ```
2. Navigate to the project directory:
    ```bash
    cd termsolver
    ```
3. Compile the Java files:
    ```bash
    javac termsolver/*.java
    ```

## Usage

1. Run the TermSolver:
    ```bash
    java termsolver.TermSolver "your_expression_here"
    ```
    Replace `"your_expression_here"` with the mathematical expression you want to evaluate.

## Project Structure

```
termsolver/
├── Node.java
├── TermSolver.java
```

- **`Node.java`**: Contains the `Node` class, which represents a node in the parse tree. Each node can be an operator or a literal.
- **`TermSolver.java`**: Contains the `TermSolver` class, which parses and evaluates the mathematical expressions.

## Classes and Methods

### Node.java

- **Node(String content)**: Creates a new node with the specified content.
- **Node(String content, Node left, Node right)**: Creates a new node with the specified content and subtrees.
- **String getContent()**: Returns the content of the node.
- **void setContent(String content)**: Sets the content of the node.
- **Node getLeft()**: Returns the left subtree.
- **Node getRight()**: Returns the right subtree.
- **void setLeft(Node left)**: Sets the left subtree.
- **void setRight(Node right)**: Sets the right subtree.

### TermSolver.java

- **parse(String term)**: Parses the given expression into a parse tree.
- **evaluate(Node node)**: Recursively evaluates the parse tree.
- **main(String[] args)**: Entry point of the application. Parses and evaluates the expression provided as a command-line argument.

## Contribution

Feel free to contribute to this project by creating pull requests or reporting issues. Your feedback and contributions are highly appreciated.

## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or suggestions, please contact me at arneseufert@web.de.

---

Thank you for using TermSolver!
