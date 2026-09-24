import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }

        for (int k = 0; k < 9; k++) {
            int rowX;
            int collumnX;
            while (true) {
                System.out.println("podaj pozycję na której chcesz umieścić X");

                if (!scanner.hasNextInt()) {
                    System.out.println("Wybierz liczbę");
                    scanner.next();
                    continue;
                }
                int postionX = scanner.nextInt();

                if (postionX < 1 || postionX > 9) {
                    System.out.println("pozycja poza przedziałem");
                    continue;
                }

                rowX = (postionX - 1) / 3;
                collumnX = (postionX - 1) % 3;

                if (board[rowX][collumnX].equals("X") || board[rowX][collumnX].equals("O")) {
                    System.out.println("to pole jest już zajęte");
                    continue;
                }
                break;
            }
            board[rowX][collumnX] = "X";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.print("\n");
            }

        }


        scanner.close();
    }
}