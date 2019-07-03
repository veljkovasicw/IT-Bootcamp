package pak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IksOks {
	public static void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static boolean ProveraVertikala(char[][] matrix, int M) {
		int brojacXa = 0;
		int brojacOksa = 0;
		String pobO = "Pobeda igraca O";
		String pobX = "Pobeda igraca X";

		int brojacJota = 0;
		boolean pobeda = false;

		

		while (brojacJota < matrix.length) {

			for (int i = 0, j = brojacJota; i < matrix.length; i++) {

				if (matrix[i][j] == 'X') {
					brojacXa++;
					brojacOksa = 0;
				}
				if (matrix[i][j] == 'O') {
					brojacOksa++;
					brojacXa = 0;
				}
				if (matrix[i][j] == ' ') {
					brojacXa = 0;
					brojacOksa = 0;
				}

				if (brojacOksa == M) {
					System.out.println(pobO);
					pobeda = true;
					break;
				} else if (brojacXa == M) {
					System.out.println(pobX);
					pobeda = true;
					break;
				}
			}
			brojacXa = 0;
			brojacOksa = 0;
			brojacJota++;
		}
		return pobeda;
	}

	public static boolean ProveraHorizontala(char[][] matrix, int M) {
		int brojacXa = 0;
		int brojacOksa = 0;
		String pobO = "Pobeda igraca O";
		String pobX = "Pobeda igraca X";

		boolean pobeda = false;

		for (int i = 0; i < matrix.length; i++) {

			brojacXa = 0;
			brojacOksa = 0;

			for (int j = 0; j < matrix[i].length; j++) {

				if (matrix[i][j] == 'X') {
					brojacXa++;
					brojacOksa = 0;
				}
				if (matrix[i][j] == 'O') {
					brojacOksa++;
					brojacXa = 0;
				}
				if (matrix[i][j] == ' ') {
					brojacXa = 0;
					brojacOksa = 0;
				}

				if (brojacOksa == M) {
					System.out.println(pobO);
					pobeda = true;
					break;
				} else if (brojacXa == M) {
					System.out.println(pobX);
					pobeda = true;
					break;
				}

			}

		}
		return pobeda;

	}

	

	public static boolean DijagonalaProveraLevoKaDesnoGore(char[][] matrix, int M) {

		int brojacXa = 0;
		int brojacOksa = 0;
		String pobO = "Pobeda igraca O";
		String pobX = "Pobeda igraca X";

		boolean pobeda = false;

		for (int k = 0; k < matrix.length; k++) {

			int i = k;
			int j = 0;

			while (i >= 0) {

				if (matrix[i][j] == 'X') {
					brojacXa++;
					brojacOksa = 0;
				}
				if (matrix[i][j] == 'O') {
					brojacOksa++;
					brojacXa = 0;
				}
				if (matrix[i][j] == ' ') {
					brojacXa = 0;
					brojacOksa = 0;
				}
				if (brojacOksa == M) {
					System.out.println(pobO);
					pobeda = true;
					break;
				} else if (brojacXa == M) {
					System.out.println(pobX);
					pobeda = true;
					break;
				}

				i--;
				j++;
			}

		}

		for (int k = 1; k < matrix.length; k++) {
			int i = matrix.length - 1;
			int j = k;
			while (j < matrix.length) {
				if (matrix[i][j] == 'X') {
					brojacXa++;
					brojacOksa = 0;
				}
				if (matrix[i][j] == 'O') {
					brojacOksa++;
					brojacXa = 0;
				}
				if (matrix[i][j] == ' ') {
					brojacXa = 0;
					brojacOksa = 0;
				}
				if (brojacOksa == M) {
					System.out.println(pobO);
					pobeda = true;
					break;
				} else if (brojacXa == M) {
					System.out.println(pobX);
					pobeda = true;
					break;
				}
				i--;
				j++;

			}

		}
		return pobeda;

	}

	

	public static boolean DijagonalaProveraLevoKaDesnoDole(char[][] matrix, int M) {

		int brojacXa = 0;
		int brojacOksa = 0;
		String pobO = "Pobeda igraca O";
		String pobX = "Pobeda igraca X";

		boolean pobeda = false;

		for (int k = matrix.length - 1; k >= 0; k--) {
			int i = 0;
			int j = k;
			while (j < matrix.length) {
				if (matrix[i][j] == 'X') {
					brojacXa++;
					brojacOksa = 0;
				}
				if (matrix[i][j] == 'O') {
					brojacOksa++;
					brojacXa = 0;
				}
				if (matrix[i][j] == ' ') {
					brojacXa = 0;
					brojacOksa = 0;
				}
				if (brojacOksa == M) {
					System.out.println(pobO);
					pobeda = true;
					break;
				} else if (brojacXa == M) {
					System.out.println(pobX);
					pobeda = true;
					break;
				}
				i++;
				j++;

			}
		}

		for (int k = 1; k < matrix.length; k++) {
			int i = k;
			int j = 0;
			while (i < matrix.length) {
				if (matrix[i][j] == 'X') {
					brojacXa++;
					brojacOksa = 0;
				}
				if (matrix[i][j] == 'O') {
					brojacOksa++;
					brojacXa = 0;
				}
				if (matrix[i][j] == ' ') {
					brojacXa = 0;
					brojacOksa = 0;
				}
				if (brojacOksa == M) {
					System.out.println(pobO);
					pobeda = true;
					break;
				} else if (brojacXa == M) {
					System.out.println(pobX);
					pobeda = true;
					break;
				}
				i++;
				j++;

			}
		}

		return pobeda;

	}

	public static String ProveraPobednika(char[][] matrix, int M) {
		String krajIgre="";

		if (ProveraHorizontala(matrix, M) || ProveraVertikala(matrix, M) || DijagonalaProveraLevoKaDesnoDole(matrix, M)
				|| DijagonalaProveraLevoKaDesnoGore(matrix, M)) {
			krajIgre = "Igra je zavrsena";
		} else {
			krajIgre = "Nema pobednika";
		}

		return krajIgre;

	}

	public static void main(String[] args) {
		try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\Veljko\\Desktop\\xOks\\iksoks-3.txt"))) {
			String[] nums = r.readLine().split(" ");
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);

			char matrix[][] = new char[N][N];

			for (int i = 0; i < matrix.length; i++) {
				String line = r.readLine();
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}

			print(matrix);
			ProveraPobednika(matrix, M);
		
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}