package UI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import UI.panelNoti.ButtonSmile;
import UI.panelNoti.Decorator.HistoryDecorator;
import UI.panelNoti.Decorator.PanelDecor;
import UI.panelNoti.Decorator.SmileDecorator;
import UI.panelNoti.Decorator.iNotiButton;
import UI.panelNoti.PanelNotification;
import control.World;
import control.iSubject;
import history.HistoryStack;

public class GamePanel extends JPanel implements MouseListener, iSubject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelNotification p1;
	private PanelPlayer p2;

	private GameFrame gameFrame;

	private World world;

	private HistoryStack historyStack;

	private int w;
	private int h;
	private int boom;

	public GamePanel(int w, int h, int boom, GameFrame gameFrame) {

		this.gameFrame = gameFrame;

		this.boom = boom;
		this.w = w;
		this.h = h;

		world = new World(w, h, boom, this);

		historyStack = new HistoryStack();

		setLayout(new BorderLayout(20, 20));

		add(p1 = new HistoryDecorator(new SmileDecorator(new PanelNotification(this))), BorderLayout.NORTH);
		add(p2 = new PanelPlayer(this), BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(iNotiButton button: PanelDecor.getListButton()) {
			if (button instanceof ButtonSmile) {
				ButtonSmile bSmile = (ButtonSmile) button;
				bSmile.setStage(ButtonSmile.wow);
				bSmile.repaint();
			}
		}
		ButtonPlay[][] arrayButton = p2.getArrayButton();
		ButtonSmile bSmile = null;
		for(iNotiButton button: PanelDecor.getListButton()) {
			if (button instanceof ButtonSmile) {
				bSmile = (ButtonSmile) button;
			}
		}
		for (int i = 0; i < arrayButton.length; i++) {
			for (int j = 0; j < arrayButton[i].length; j++) {
				if (e.getButton() == 1 && e.getSource() == arrayButton[i][j] && !world.getArrayFlag()[i][j]) {

					if (!getP1().getTime().isRunning()) {
						getP1().getTime().start();
					}

					world.getArrayInteraction()[i][j] = 1;        // which button have a number and be opened will be marked 1

					if (!world.open(i, j)) {

						if (world.isComplete()) {

							getP1().getTime().stop();
							bSmile.setStage(ButtonSmile.lose);
							bSmile.repaint();

							int option = JOptionPane.showConfirmDialog(this, "You lost, play again?", "Notification",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								gameFrame.setVisible(false);
								new GameFrame(w, h, boom);
							} else {
								world.fullTrue();
							}
						}
						else if (world.isEnd()) {

							getP1().getTime().stop();
							bSmile.setStage(ButtonSmile.win);
							bSmile.repaint();

							int option = JOptionPane.showConfirmDialog(this, "You win, play again ?", "Notification",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								gameFrame.setVisible(false);
								new GameFrame(w, h, boom);
							}
						}
					}
				} else if (e.getButton() == 3 && e.getSource() == arrayButton[i][j]) {
					world.putFlag(i, j);
				}
//				if (e.getClickCount() == 2 && e.getSource() == arrayButton[i][j] && world.getArrayBoolean()[i][j]) {
//					if (!world.clickDouble(i, j)) {
//
//						int option = JOptionPane.showConfirmDialog(this, "You lost, play again?", "Notification",
//								JOptionPane.YES_NO_OPTION);
//
//						if (option == JOptionPane.YES_OPTION) {
//							gameFrame.setVisible(false);
//							new GameFrame(w, h, boom);
//						} else {
//							world.fullTrue();
//						}
//					}
//				}
			}
		}

		notifyHistory();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(iNotiButton button: PanelDecor.getListButton()) {
			if (button instanceof ButtonSmile) {
				ButtonSmile bSmile = (ButtonSmile) button;
				bSmile.setStage(ButtonSmile.now);
				bSmile.repaint();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public int getBoom() {
		return boom;
	}

	public void setBoom(int boom) {
		this.boom = boom;
	}

	public PanelNotification getP1() {
		return p1;
	}

	public void setP1(PanelNotification p1) {
		this.p1 = p1;
	}

	public PanelPlayer getP2() {
		return p2;
	}

	public void setP2(PanelPlayer p2) {
		this.p2 = p2;
	}

	public HistoryStack getHistoryStack() {
		return historyStack;
	}

	@Override
	public void notifyHistory() {
		historyStack.update(world.getArrayInteraction());
	}
}
