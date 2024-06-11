package UI.panelNoti.Decorator;

import UI.GameFrame;
import UI.GamePanel;
import UI.panelNoti.ButtonSmile;
import UI.panelNoti.PanelNotification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.event.MouseEvent;

public class SmileDecorator extends PanelDecor {
    ButtonSmile bt;

    public SmileDecorator(PanelNotification panelNotification){
        super(panelNotification.getGame());
//        bHistory = panelNotification.getBHistory();
        bt = new ButtonSmile(this);
        PanelDecor.addButton(this, bt );

        for(iNotiButton button: PanelDecor.getListButton()){
            p13.add(button);
        }

//        bt.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                bt.setStage(ButtonSmile.now);
//                bt.repaint();
//
//                int option = JOptionPane.showConfirmDialog(null, "Do you want to play new game?", "Notification",
//                        JOptionPane.YES_NO_OPTION);
//                if (option == JOptionPane.YES_OPTION) {
//                    getGame().getGameFrame().setVisible(false);
//                    new GameFrame(game.getW(), game.getH(), game.getBoom());
//                }
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                if (getGame().getWorld().isEnd() || getGame().getWorld().isComplete()) {
//                    getGame().getGameFrame().setVisible(false);
//                    new GameFrame(game.getW(), game.getH(), game.getBoom());
//                } else {
//                    bt.setStage(ButtonSmile.press);
//                    bt.repaint();
//                }
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//            }
//        });

    }



}
