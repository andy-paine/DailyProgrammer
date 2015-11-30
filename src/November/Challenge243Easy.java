package November;

import java.io.IOException;
import java.util.Scanner;

public class Challenge243Easy {

    /*Abundant and Deficient Numbers*/

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int number = input.nextInt();
            int sumOfDivisors = 0;
            for (int i=1; i<number; i++)
                if (number%i==0)
                    sumOfDivisors += i;

            if (sumOfDivisors<number)
                System.out.println(number + " deficient");
            else if (sumOfDivisors>number)
                System.out.println(number + " abundant by " + (sumOfDivisors - number));
            else
                System.out.println(number + " ~~neither~~ deficient");
        }
    }
}
