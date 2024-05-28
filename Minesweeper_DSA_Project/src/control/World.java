package control;

import java.util.Random;

import UI.ButtonPlay;
import UI.ButtonSmile;
import UI.GamePanel;
import UI.LableNumber;

public class World {

	private Random rd;

	private ButtonPlay[][] arrayButton;
	private int[][] arrayBomb;// Boom là số -1

	private boolean[][] arrayBoolean;

	private boolean[][] arrayFlag;
	private int flag;

	private boolean isComplete;
	private boolean isEnd;

	private ButtonSmile buttonSmile;
	private LableNumber lbTime, lbBoom;

	private int bomb;

	private GamePanel game;

	public World(int w, int h, int bomb, GamePanel game) {

		this.game = game;
		this.bomb = bomb;

		arrayButton = new ButtonPlay[w][h];
		arrayBomb = new int[w][h];
		arrayBoolean = new boolean[w][h];
		arrayFlag = new boolean[w][h];
		
		rd = new Random();

		createArrayBomb(bomb, w, h);
		fillNumOfBomb();

	}

	public boolean clickDouble(int i, int j) {

		boolean isBombFound = false;

		for (int l = i - 1; l <= i + 1; l++) {
			for (int k = j - 1; k <= j + 1; k++) {
				if (l >= 0 && l <= arrayBomb.length - 1 && k >= 0 && k <= arrayBomb[i].length - 1) {
					if (!arrayFlag[l][k]) {
						if (arrayBomb[l][k] == -1) {
							isBombFound = true;
							arrayButton[l][k].setNumber(12);
							arrayButton[l][k].repaint();
							arrayBoolean[l][k] = true;
						} else if (!arrayBoolean[l][k]) {
							if (arrayBomb[l][k] == 0) {
								open(l, k);
							} else {
								arrayButton[l][k].setNumber(arrayBomb[l][k]);
								arrayButton[l][k].repaint();
								arrayBoolean[l][k] = true;
							}
						}
					}
				}
			}
		}

		if (isBombFound) {
			for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
				for (int k = 0; k < arrayBoolean[i].length; k++) {
					if (arrayBomb[j2][k] == -1 && !arrayBoolean[j2][k]) {
						arrayButton[j2][k].setNumber(10);
						arrayButton[j2][k].repaint();
					}
				}
			}
			return false;
		}

		return true;
	}

	public void putFlag(int i, int j) {
		if (!arrayBoolean[i][j]) {
			if (arrayFlag[i][j]) {
				flag--;
				arrayFlag[i][j] = false;
				arrayButton[i][j].setNumber(-1);
				arrayButton[i][j].repaint();
				game.getP1().updateLbBoom();
			} else if (flag < bomb) {
				flag++;
				arrayFlag[i][j] = true;
				arrayButton[i][j].setNumber(9);
				arrayButton[i][j].repaint();
				game.getP1().updateLbBoom();
			}
		}

	}

	public boolean open(int i, int j) {

		if (!isComplete && !isEnd) {
			if (!arrayBoolean[i][j]) {
				if (arrayBomb[i][j] == 0) {

					arrayBoolean[i][j] = true;
					arrayButton[i][j].setNumber(0);
					arrayButton[i][j].repaint();

					if (checkWin()) {
						isEnd = true;

						return false;
					}

					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if (l >= 0 && l <= arrayBomb.length - 1 && k >= 0 && k <= arrayBomb[i].length - 1) {
								if (!arrayBoolean[l][k]) {
									open(l, k);
								}
							}
						}
					}

					if (checkWin()) {
						isEnd = true;

						return false;
					}

				} else {

					int number = arrayBomb[i][j];

					if (number != -1) {

						arrayBoolean[i][j] = true;

						arrayButton[i][j].setNumber(number);
						arrayButton[i][j].repaint();

						if (checkWin()) {
							isEnd = true;

							return false;
						}

						return true;
					}
				}
			}

			if (arrayBomb[i][j] == -1) {
				arrayButton[i][j].setNumber(11);
				arrayButton[i][j].repaint();
				isComplete = true;

				for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
					for (int k = 0; k < arrayBoolean[i].length; k++) {
						if (arrayBomb[j2][k] == -1 && !arrayBoolean[j2][k]) {
							if (j2 != i || k != j) {
								arrayButton[j2][k].setNumber(10);
								arrayButton[j2][k].repaint();
							}
						}
					}
				}

				return false;
			} else {

				if (checkWin()) {
					isEnd = true;

					return false;
				}

				return true;
			}
		} else

			return false;

	}

	public boolean checkWin() {
		int count = 0;
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if (!arrayBoolean[i][j]) {
					count++;
				}
			}
		}
		if (count == bomb)
			return true;
		else
			return false;
	}

	public void fillNumOfBomb() {
		for (int i = 0; i < arrayBomb.length; i++) {
			for (int j = 0; j < arrayBomb[i].length; j++) {
				if (arrayBomb[i][j] == 0) {
					int count = 0;
					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if (l >= 0 && l <= arrayBomb.length - 1 && k >= 0 && k <= arrayBomb[i].length - 1)
								if (arrayBomb[l][k] == -1) {
									count++;
								}
						}
					}
					arrayBomb[i][j] = count;
				}
			}
		}
	}

	public void createArrayBomb(int bomb, int w, int h) {
		int locationX;
		int locationY;

		int count = 0;
		while (count != bomb) {
			locationX = rd.nextInt(w);
			locationY = rd.nextInt(h);
			if (arrayBomb[locationX][locationY] != -1) {

				arrayBomb[locationX][locationY] = -1;

				count ++;
				
			}
		}

	}

	public void fullTrue() {
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if (!arrayBoolean[i][j]) {
					arrayBoolean[i][j] = true;
				}
			}
		}
	}

	public ButtonPlay[][] getArrayButton() {
		return arrayButton;
	}

	public void setArrayButton(ButtonPlay[][] arrayButton) {
		this.arrayButton = arrayButton;
	}

	public ButtonSmile getButtonSmile() {
		return buttonSmile;
	}

	public void setButtonSmile(ButtonSmile buttonSmile) {
		this.buttonSmile = buttonSmile;
	}

	public LableNumber getLbTime() {
		return lbTime;
	}

	public void setLbTime(LableNumber lbTime) {
		this.lbTime = lbTime;
	}

	public LableNumber getLbBoom() {
		return lbBoom;
	}

	public void setLbBoom(LableNumber lbBoom) {
		this.lbBoom = lbBoom;
	}

	public boolean[][] getArrayBoolean() {
		return arrayBoolean;
	}

	public void setArrayBoolean(boolean[][] arrayBoolean) {
		this.arrayBoolean = arrayBoolean;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean[][] getArrayCamCo() {
		return arrayFlag;
	}

	public void setArrayCamCo(boolean[][] arrayCamCo) {
		this.arrayFlag = arrayCamCo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
