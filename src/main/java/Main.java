import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        APIJokeSource apiJokeSource = new APIJokeSource();
        System.out.println("===Program wyświetla żarty o Chucku Norrisie===");
        int validaton = 0;
        while (validaton < 5) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wprowadz ilość żartów do wyświetlenia :");
                int how = scanner.nextInt();
                apiJokeSource.getSource(how).forEach(joke -> System.out.println(joke.getValue()));
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono błędne dane.");
                validaton++;
            }
        }
    }
}
