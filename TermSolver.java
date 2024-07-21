package term;

import java.util.Scanner;

public class TermSolver {
	
	private static int currentToken;
	
	//5 + 6 * 7 + 8          5 + 6 + 7 * 8 * 5
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type in your Term: ");
		
		String term = scanner.nextLine();
		
		Node startNode = generateTree(term);
		
		System.out.println(executeTree(startNode));
	}
	
	/**
	 * generates the tree to the specified string.
	 * @param term
	 * @param start
	 * @param end
	 * @return
	 */
	private static Node generateTree(String term) {
		String substring = trimSpaces(term);
		int index = getRightestOperator(substring);
		Node node = null;
		if(isOperator(substring.substring(index, index + 1))) {
			node = new Node(substring.substring(index, index + 1));
		} else {
			node = new Node(getNumber(term, index));
		}
		
		if(substring.split("\\s").length == 1) {
			return node;
		}
		
		node.setLeft(generateTree(substring.substring(0, index)));
		node.setRight(generateTree(substring.substring(index + 1, substring.length())));
		
		return node;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	private static double executeTree(Node node) {
		if(! isOperator(node.getContent())) {
			return Double.parseDouble(node.getContent());
		}
		
		double left = executeTree(node.getLeft());
		double right = executeTree(node.getRight());
		
		return node.getContent().equals("+")? left + right : node.getContent().equals("-")? left - right : 
			node.getContent().equals("*")? left * right : node.getContent().equals("/")? left / right : -1;
	}
	
	/**
	 * 
	 * @param term
	 * @param index
	 * @return
	 */
	private static String getNumber(String term, int index) {
		int end = index + 1;
		
		while(end < term.length() && term.charAt(end) != ' ') {
			end++;
		}
		
		return term.substring(index, end);
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static String trimSpaces(String s) {
		int minusEnd = 0, plusStart = 0;
		for(int i = s.length() - 1; i >= 0; i--, minusEnd++) {
			if(s.charAt(i) != ' ') {
				break;
			}
		}
		
		for(int i = 0; i < s.length(); i++, plusStart++) {
			if(s.charAt(i) != ' ') {
				break;
			}
		}
		
		return s.substring(0 + plusStart, s.length() - minusEnd);
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static int getRightestOperator(String s) {
		int index = s.length() - 1;
		for(int i = index - 1; i >= 0; i--, index--) {
			if(s.charAt(i) == ' ') {
				break;
			}
		}
		
		for(int i = index - 1; i >= 0; i--) {
			if(! isOperator(s.substring(index, index + 1)) && isOperator(s.substring(i, i + 1))) {
				index = i;
			} else if(isOperator(s.substring(index, index + 1)) && (s.charAt(index) == '*' || s.charAt(index) == '/') &&
					isOperator(s.substring(i, i + 1)) && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				index = i;
			}
		}
		
		
		return index;
	}
	
	/**
	 * checks if the given string is an operator.
	 * @param s the string we need to check.
	 * @return true if it is an operator, false otherwise
	 */
	private static boolean isOperator(String s) {
		switch(s) {
		case "+":
			return true;
		case "-":
			return true;
		case "*":
			return true;
		case "/":
			return true;
		default:
			return false;
		}
	}

	private static String getNextToken(String term) {
		return term.split("\\s").length > currentToken? term.split("\\s")[currentToken++] : "";
	}

}
