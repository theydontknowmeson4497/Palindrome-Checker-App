import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version 1.0");
        System.out.println("System Initialized Successfully");


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();


        //Hardcoded Deque Method
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string \"" + text + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a palindrome.");
        }


        //Reversing the String Method
        int strLength = text.length();
        String reverse = "";
        for (int i = (strLength - 1); i >= 0; --i) {
            reverse = reverse + text.charAt(i);
        }
        if (text.toLowerCase().equals(reverse.toLowerCase())) {
            System.out.println(text + " is a Palindrome String.");
        } else {
            System.out.println(text + " is not a Palindrome String.");}


        //Character Array Method
        char[] chars = text.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        isPalindrome = true;
        while (start < end) {
            if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Character Array Method).");
        } else {
            System.out.println(text + " is NOT a Palindrome (Character Array Method).");
        }


        //Stack-Based Method
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            stack.push(c);
        }
        isPalindrome = true;
        for (char c : text.toCharArray()) {
            if (Character.toLowerCase(c) != Character.toLowerCase(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Stack Method).");
        } else {
            System.out.println(text + " is NOT a Palindrome (Stack Method).");
        }
        scanner.close();
    }
}