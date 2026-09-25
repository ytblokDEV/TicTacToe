import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = {
                { "1", "2", "3" },
                { "4", "5", "6" },
                { "7", "8", "9" }
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        for (int k = 0; k < 5; k++) {
            // #################################
            // Wstawianie "X"
            // #################################
            int rowX = 0;
            int collumnX = 0;
            while (true) {
                System.out.println("podaj pozycję na której chcesz umieścić X lub exit aby wyjść");

                String buffer = scanner.nextLine().trim();

                if (buffer.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }

                int postionX;
                try {
                    postionX = Integer.parseInt(buffer);
                } catch (NumberFormatException e) {
                    System.out.println("Wybierz liczbę");
                    continue;
                }

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
                    System.out.print(" ");
                }
                System.out.print("\n");
            }

            String wynik = WinnerCheck.winnerCheck(board);
            if (!wynik.equals(" ")){
                System.out.println("wygrywa: " + wynik);
                System.exit(1);
            }
            // #################################
            // Wstawianie "O"
            // #################################
            int rowO;
            int collumnO;
            while (true) {
                System.out.println("podaj pozycję na której chcesz umieścić O lub exit aby wyjść");

                String buffer = scanner.nextLine().trim();
                if (buffer.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }

                int postionO;
                try {
                    postionO = Integer.parseInt(buffer);
                } catch (NumberFormatException e) {
                    System.out.println("Wybierz liczbę");
                    continue;
                }

                if (postionO < 1 || postionO > 9) {
                    System.out.println("pozycja poza przedziałem");
                    continue;
                }

                rowO = (postionO - 1) / 3;
                collumnO = (postionO - 1) % 3;

                if (board[rowO][collumnO].equals("X") || board[rowO][collumnO].equals("O")) {
                    System.out.println("to pole jest już zajęte");
                    continue;
                }
                break;
            }
            board[rowO][collumnO] = "O";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
            wynik = WinnerCheck.winnerCheck(board);
            if (!wynik.equals(" ")){
                System.out.println("wygrywa: " + wynik);
                System.exit(2);
            }

        }
        scanner.close();
    }
}
