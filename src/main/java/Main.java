
import java.util.Scanner;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    static char index = ' ';
    private static char[][] ticTac;
    static int choice = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        game();
    }

    private static void game() {
        StringBuilder builder = new StringBuilder();
        ticTac = new char[3][3];
        for (int i2 = 0; i2 < ticTac.length; i2++) {
            for (int j2 = 0; j2 < ticTac[0].length; j2++) {
                ticTac[i2][j2] = ' ';
            }
        }
        builder.append("---------\n");
        builder.append("| ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                builder.append(ticTac[i][j] + " ");

            }

            if (i != 2) {
                builder.append("|\n| ");
            } else {
                builder.append("|\n");
            }
        }
        builder.append("---------\n");
        System.out.println(builder);
        position();
    }


    private static void position() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        System.out.println("Enter the coordinates: ");
        String input1 = scanner.nextLine();
        int x = 0;
        int y = 0;
        try {
            String[] pieces = input1.split(" ");
            x = Integer.parseInt(pieces[0]);
            y = Integer.parseInt(pieces[1]);

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            position();
            return;
        }
        if (x > 3 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            position();
            return;
        }

        for (int i = 0; i < ticTac.length + 1; i++) {
            for (int j = 0; j < ticTac[0].length + 1; j++) {
                if (i == x && j == y && choice % 2 != 0) {
                    if (ticTac[i - 1][j - 1] == ' ') {
                        ticTac[i - 1][j - 1] = 'X';
                        choice++;

                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        position();
                        return;
                    }
                } else if (i == x && j == y && choice % 2 == 0) {
                    if (ticTac[i - 1][j - 1] == ' ') {
                        ticTac[i - 1][j - 1] = 'O';
                        choice++;

                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        position();
                        return;
                    }
                }
            }
        }

        builder.append("---------\n");
        builder.append("| ");
        for (int i1 = 0; i1 < ticTac.length; i1++) {
            for (int j = 0; j < ticTac[0].length; j++) {
                builder.append(ticTac[i1][j] + " ");
            }
            if (i1 != 2) {
                builder.append("|\n| ");
            } else {
                builder.append("|\n");
            }
        }
        builder.append("---------\n");
        System.out.println(builder);
        check();

    }

    private static void check() {
        String answer = null;
        for (int i = 0; i < ticTac.length; i++) {
            if ((ticTac[0][2] != ' ') && (ticTac[0][2] == ticTac[1][1]
                    && ticTac[1][1] == ticTac[2][0])) {
                answer = (ticTac[0][2] + " wins");
                System.out.println(answer);
                return;
            } else if ((ticTac[0][0] != ' ') && (ticTac[0][0] == ticTac[1][1]
                    && ticTac[1][1] == ticTac[2][2])) {
                answer = (ticTac[0][0] + " wins");
                System.out.println(answer);
                return;
            } else if ((ticTac[0][i] != ' ') && (ticTac[0][i] == ticTac[1][i]
                    && ticTac[1][i] == ticTac[2][i])) {
                answer = (ticTac[0][i] + " wins");
                System.out.println(answer);
                return;
            } else if ((ticTac[i][0] != ' ') && (ticTac[i][0] == ticTac[i][1]
                    && ticTac[i][1] == ticTac[i][2])) {
                answer = (ticTac[i][0] + " wins");
                System.out.println(answer);
                return;
            }
        }
        if (choice > 9) {
            System.out.println("Draw");
            return;
        } else {
            position();
            return;
        }

    }
}