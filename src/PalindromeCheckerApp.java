import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp{
    public static void main(String[] args){
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version 1.0");
        System.out.println("System Initialized Successfully");


            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

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

            scanner.close();
        }
    }