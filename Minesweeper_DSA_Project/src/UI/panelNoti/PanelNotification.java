package UI.panelNoti;

import UI.*;
import history.HistoryStack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelNotification extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel p11, p12, p13;

	protected LableNumber lbTime, lbBoom;

	protected GamePanel game;


	protected Timer time;
	protected int nowTime;

	public PanelNotification(GamePanel game) {
		this.game = game;
		setLayout(new BorderLayout());

		setBorder(BorderFactory.createLoweredBevelBorder());

		add(p11 = new JPanel(), BorderLayout.WEST);
		add(p12 = new JPanel(), BorderLayout.EAST);
		add(p13 = new JPanel(), BorderLayout.CENTER);

		p11.add(lbBoom = new LableNumber(this, "000"));
		updateLbBoom();

		p12.add(lbTime = new LableNumber(this, "000"));

		time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nowTime++;
				updateLbTime();
			}
		});

	}

	public void updateLbTime() {
		if (nowTime > 999) {
			lbTime.setNumber("voCuc");
		} else {
			String cTime = String.valueOf(nowTime);
			if (cTime.length() == 1) {
				lbTime.setNumber("00" + cTime);
			} else if (cTime.length() == 2) {
				lbTime.setNumber("0" + cTime);
			} else {
				lbTime.setNumber(cTime);
			}

			lbTime.repaint();
		}
	}

	public void updateLbBoom() {
		String boom = String.valueOf(game.getBoom() - game.getWorld().getFlag());
		if (boom.length() == 1) {
			lbBoom.setNumber("00" + boom);
		} else if (boom.length() == 2) {
			lbBoom.setNumber("0" + boom);
		} else {
			lbBoom.setNumber("0" + boom);
		}
		lbBoom.repaint();
	}

	public GamePanel getGame() {
		return game;
	}

	public void setGame(GamePanel game) {
		this.game = game;
	}

	public Timer getTime() {
		return time;
	}

	public void setTime(Timer time) {
		this.time = time;
	}


	public JPanel getPanel(int a) {
        return switch (a) {
            case 11 -> p11;
            case 12 -> p12;
            case 13 -> p13;
            default -> null;
        };
	}

	public ButtonPlay[][] getArrayButtonInWorld() {
		return game.getWorld().getArrayButton();
	}
}
