package UI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonSmileDecor extends PanelDecor {
    private GamePanel game;
    private ButtonSmile bt;

    public ButtonSmileDecor(GamePanel game) {
        this.game = game;
    }

    @Override
    public void addMouseListener(MouseListener l) {
        bt.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                bt.setStage(ButtonSmile.now);
                bt.repaint();

                int option = JOptionPane.showConfirmDialog(null, "Do you want to play new game?", "Notification",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    getGame().getGameFrame().setVisible(false);
                    new GameFrame(game.getW(), game.getH(), game.getBoom());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (getGame().getWorld().isEnd() || getGame().getWorld().isComplete()) {
                    getGame().getGameFrame().setVisible(false);
                    new GameFrame(game.getW(), game.getH(), game.getBoom());
                } else {
                    bt.setStage(ButtonSmile.press);
                    bt.repaint();
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

    private GamePanel getGame() {
        return this.game;
    }
}
