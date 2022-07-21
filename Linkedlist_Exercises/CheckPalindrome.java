import java.util.LinkedList;
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> reversedList = new LinkedList<>();

        Scanner input = new Scanner(System.in);

        // HANDLE INVALID INPUTS
        try {
            // GET USER INPUTS
            System.out.println("Pls Enter the No Of Elements: ");
            int length = input.nextInt();

            System.out.println("Pls Enter " + length + " Elements: ");
            for (int i = 0; i < length; i++) {
                int x = input.nextInt();
                list.add(x);
            }
            System.out.println("You Entered : " + list);

            // INSERT VALUES IN REVERSED ORDER
            for(int i = (length - 1); i >=0; i--){
                reversedList.add(list.get(i));
            }

            // CHECK 2 LISTS
            if(list.equals(reversedList)) {
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Not a Palindrome");
            }
        } catch(Exception e){
            System.out.println("Input Values are Invalid");
        }
    }
}
