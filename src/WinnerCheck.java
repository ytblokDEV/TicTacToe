import java.util.Objects;

public class WinnerCheck {
    public static String winnerCheck(String[][] board){
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[i][0], board[i][1]) && Objects.equals(board[i][1], board[i][2])) {
                return board[i][0];
            }
            if (Objects.equals(board[0][i], board[1][i]) && Objects.equals(board[1][i], board[2][i])) {
                return board[0][i];
            }
        }

        if (Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[1][1], board[2][2])) {
            return board[0][0];
        }

        if (Objects.equals(board[0][2], board[1][1]) && Objects.equals(board[1][1], board[2][0])) {
            return board[0][2];
        }

        return " ";
    }
}
