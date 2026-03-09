import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

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
            System.out.println("The string \"" + text + "\" is a palindrome.(Hardcoded - Deque Method");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a palindrome.(Hardcoded -Deque Method");
        }


        //Reversing the String Method
        int strLength = text.length();
        String reverse = "";
        for (int i = (strLength - 1); i >= 0; --i) {
            reverse = reverse + text.charAt(i);
        }
        if (text.toLowerCase().equals(reverse.toLowerCase())) {
            System.out.println(text + " is a Palindrome String.(Reversing the String Method)");
        } else {
            System.out.println(text + " is not a Palindrome String.(Reversing the String Method");
        }


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


        //Queue and Stack Based Method
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> astack = new Stack<>();

        for (char c : text.toCharArray()) {
            queue.add(c);
            astack.push(c);
        }

        isPalindrome = true;

        while (!queue.isEmpty()) {
            if (Character.toLowerCase(queue.remove()) != Character.toLowerCase(astack.pop())) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Queue + Stack Method).");
        } else {
            System.out.println(text + " is NOT a Palindrome (Queue + Stack Method).");
        }


        //Array-Deque based method
        Deque<Character> adeque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            adeque.addLast(c);
        }
        isPalindrome = true;
        while (adeque.size() > 1) {
            if (Character.toLowerCase(adeque.removeFirst()) != Character.toLowerCase(adeque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(text + " is a Palindrome (Optimized Deque Method).");
        } else {
            System.out.println(text + " is NOT a Palindrome (Optimized Deque Method).");
        }


        //Linked List Based Method
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : text.toCharArray()) {
            list.add(ch);
        }
        boolean isPalindromee = true;
        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) {
                isPalindromee = false;
                break;
            }
        }


        //Recursive Palindrome Checker
        boolean isRecursivePalindrome = check(text, 0, text.length() - 1);
        if (isRecursivePalindrome) {
            System.out.println(text + " is a Palindrome (Recursive Method).");
        } else {
            System.out.println(text + " is NOT a Palindrome (Recursive Method).");
        }
        scanner.close();
    }

    private static boolean check(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
            return false;
        }
        return check(s, start + 1, end - 1);
    }
}