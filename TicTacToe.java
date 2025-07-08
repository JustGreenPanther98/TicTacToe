import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) throws InvalidInputOXException {
		// 2 player with X and O
		String[][] tictactoe = new String[3][3];
		// Initial
		Scanner input = new Scanner(System.in);
		int select = -1, counter = 1, NumberOfTry = 0;
		String OX;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tictactoe[i][j] = String.valueOf(counter);
				counter++;
			}
		}
		System.out.println("OX GAME\n");
		displayBoard(tictactoe);
		do {
			System.out.print("\nEnter Position For Your Move (1-9): ");
			try {
				select = input.nextInt();
				if (select <= 0 || select > 9)
					throw new InvalidInputOXException();
			} catch (InvalidInputOXException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number between 1 and 9.");
				input.next();
			}
			if (NumberOfTry % 2 == 0)
				OX = "X";
			else
				OX = "O";
			switch (select) {
			case 1:
				if (!hasOX(0, 0, tictactoe)) {
					tictactoe[0][0] = OX;
					NumberOfTry++;
				}
				break;
			case 2:
				if (!hasOX(0, 1, tictactoe)) {
					tictactoe[0][1] = OX;
					NumberOfTry++;
				}
				break;
			case 3:
				if (!hasOX(0, 2, tictactoe)) {
					tictactoe[0][2] = OX;
					NumberOfTry++;
				}
				break;
			case 4:
				if (!hasOX(1, 0, tictactoe)) {
					tictactoe[1][0] = OX;
					NumberOfTry++;
				}
				break;
			case 5:
				if (!hasOX(1, 1, tictactoe)) {
					tictactoe[1][1] = OX;
					NumberOfTry++;
				}
				break;
			case 6:
				if (!hasOX(1, 2, tictactoe)) {
					tictactoe[1][2] = OX;
					NumberOfTry++;
				}
				break;
			case 7:
				if (!hasOX(2, 0, tictactoe)) {
					tictactoe[2][0] = OX;
					NumberOfTry++;
				}
				break;
			case 8:
				if (!hasOX(2, 1, tictactoe)) {
					tictactoe[2][1] = OX;
					NumberOfTry++;
				}
				break;
			case 9:
				if (!hasOX(2, 2, tictactoe)) {
					tictactoe[2][2] = OX;
					NumberOfTry++;
				}
				break;
			}
			displayBoard(tictactoe);
		} while (!isWin(tictactoe) && NumberOfTry < 9);
		if (NumberOfTry == 9)
			System.out.println("\n\nTIE!");
		else
			System.out.println("\n\n" + OX + " Won");
	}

	public static void displayBoard(String[][] arr) {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(arr[i][j] + " ");
			if (i != 2)
				System.out.println("\n------");
		}
	}

	private static boolean hasOX(int x, int y, String[][] arr) {
		if (arr[x][y].toUpperCase() == "X" || arr[x][y].toUpperCase() == "O")
			return true;
		return false;
	}

	public static boolean isWin(String[][] arr) {
		if (arr == null || arr.length > 3)
			return false;
		if (arr[0][0].equals(arr[1][1]) && arr[0][0].equals(arr[2][2]))
			return true;
		if (arr[0][2].equals(arr[1][1]) && arr[0][2].equals(arr[2][0]))
			return true;
		if (arr[0][0].equals(arr[0][1]) && arr[0][0].equals(arr[0][2]))
			return true;
		if (arr[1][0].equals(arr[1][1]) && arr[1][0].equals(arr[1][2]))
			return true;
		if (arr[2][0].equals(arr[2][1]) && arr[2][0].equals(arr[2][2]))
			return true;
		if (arr[0][0].equals(arr[1][0]) && arr[0][0].equals(arr[2][0]))
			return true;
		if (arr[0][1].equals(arr[1][1]) && arr[0][1].equals(arr[2][1]))
			return true;
		if (arr[0][2].equals(arr[1][2]) && arr[0][2].equals(arr[2][2]))
			return true;

		return false; // TIE
	}
}