package UI.panelNoti;

import UI.GameFrame;
import UI.panelNoti.Decorator.iNotiButton;
import UI.panelNoti.PanelNotification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ButtonSmile extends iNotiButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int win = 0;
	public static final int lose = 1;
	public static final int press = 2;
	public static final int wow = 3;
	public static final int now = 4;

	private int stage;

	public ButtonSmile(PanelNotification p) {
		this.p = p;
		setPreferredSize(new Dimension(50, 50));

		stage = now;

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				setStage(ButtonSmile.now);
				repaint();

				int option = JOptionPane.showConfirmDialog(null, "Do you want to play new game?", "Notification",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					p.getGame().getGameFrame().setVisible(false);
					new GameFrame(p.game.getW(), p.game.getH(), p.game.getBoom());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (p.getGame().getWorld().isEnd() || p.getGame().getWorld().isComplete()) {
					p.getGame().getGameFrame().setVisible(false);
					new GameFrame(p.game.getW(), p.game.getH(), p.game.getBoom());
				} else {
					setStage(ButtonSmile.press);
					repaint();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

	}

	@Override
	public void paint(Graphics g) {
		switch (stage) {
		case win:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smileWin"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case lose:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smileLose"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case press:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smilePress"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case wow:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smilePressPlay"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;
		case now:
			g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get("smile"), 0, 0,
					getPreferredSize().width, getPreferredSize().height, null);
			break;

		default:
			break;
		}

	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	@Override
	public PanelNotification getPanelNoti() {
		return p;
	}

	@Override
	public void setPanelNoti(PanelNotification p) {
		this.p = p;
	}
}
