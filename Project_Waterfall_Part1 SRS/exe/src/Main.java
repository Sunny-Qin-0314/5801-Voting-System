import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numOfSeats = 0, numOfBallots = 0, numOfCandidates = 0;

        System.out.println("Voting System: ");
        System.out.println("OPL");
        Scanner scanner = new Scanner(System.in);

        try{
            numOfSeats = scanner.nextInt();
            numOfBallots = scanner.nextInt();
            numOfCandidates = scanner.nextInt();
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(numOfSeats);
        System.out.println(numOfBallots);
        System.out.println(numOfCandidates);

    }
}
