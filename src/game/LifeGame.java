package game;

import java.util.Scanner;

public class LifeGame {
	private int HEIGHT = 30;
	private int WIDTH = 60;
	private final char Y = '*';// ����Y������״̬
	private final char N = ' ';// ����X��������״̬
	private char[][] cell = new char[HEIGHT][WIDTH];// ����һ��ϸ�������

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public char[][] getCell() {
		return cell;
	}

	public void setCell(char[][] cell) {
		this.cell = cell;
	}

	// ָ����ʼΪ���״̬ϸ��������
	/*public LifeGame() {
		
		//����
		cell[3][4] = cell[3][5] = cell[3][6] = Y;

		cell[20][4] = cell[20][5] = cell[20][6] = Y;

		cell[4][20] = cell[5][20] = cell[6][20] = Y;
		
		//7
		cell[10][4] = cell[10][5] = cell[10][6] = cell[11][6] = cell[12][5] = Y;

		cell[10][40] = cell[10][41] = cell[10][42] = cell[11][42] = cell[12][41] = Y;
		
		//ʮ�ּ�
		cell[15][30] = cell[15][31] = cell[15][32] = cell[14][31] = cell[16][31]= Y;

		cell[14][15] = cell[15][15] = cell[16][15] = cell[15][16] = cell[15][14] = Y;
		
		//������
		
		cell[19][40] = cell[22][40] = cell[20][39] = cell[21][39] = cell[21][41] = cell[20][41] = Y;		
	}*/

	// ����̨���
	private void print() {
		for (int height = 0; height < HEIGHT; height++) {
			for (int width = 0; width < WIDTH; width++) {
				char c = (cell[height][width] == Y) ? Y : N;
				System.out.print(c);
			}
			System.out.println("");
		}
		System.out.println("");
	}

	// �ж�ϸ��״̬
	private int cellState(int y, int x) {
		boolean isEmpty = (y < 0 || y >= HEIGHT || x < 0 || x >= WIDTH || cell[y][x] != Y);
		return isEmpty ? 0 : 1;
	}

	// ��ȡ��Χϸ���������
	private int getNeighbors(int y, int x) {
		int n = 0; // neighbor
		n += cellState(y - 1, x - 1);
		n += cellState(y - 1, x);
		n += cellState(y - 1, x + 1);
		n += cellState(y, x - 1);
		n += cellState(y, x + 1);
		n += cellState(y + 1, x - 1);
		n += cellState(y + 1, x);
		n += cellState(y + 1, x + 1);
		return n;
	}

	// ��һ��״̬
	public void nextCell() {
		char[][] temp = new char[HEIGHT][WIDTH];
		int y = 0;
		for (char[] rowArr : cell) {
			int x = 0;
			for (char colData : rowArr) {
				int neighbor = getNeighbors(y, x);
				if (neighbor == 3) {
					temp[y][x] = Y;
				} else if (neighbor == 2 && colData == Y) {
					temp[y][x] = Y;
				} else {
					temp[y][x] = N;
				}
				x++;
			}
			y++;
		}

		cell = temp;
	}

	public static void main(String[] a) throws InterruptedException {
		LifeGame gam = new LifeGame();
		String end;
		gam.print();
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			Thread.sleep(150);
			gam.nextCell();
			gam.print();
		} while (true);
	}
}