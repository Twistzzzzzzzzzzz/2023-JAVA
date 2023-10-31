import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter start number: ");
        int start = input.nextInt();
        System.out.print("Enter end number: ");
        int end = input.nextInt();
        int answer = 0;
        if (start >= end) {
            System.out.println("You entered wrong numbers.");
            System.exit(0);
        }
        for(int i = start; i<=end; i++){
            answer += i;
        }
        System.out.println("The sum of numbers from " + start + " to " + end + " is " + answer);
    }
}
