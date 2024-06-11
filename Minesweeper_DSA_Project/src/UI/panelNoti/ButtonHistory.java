package UI.panelNoti;

import UI.panelNoti.Decorator.iNotiButton;
import UI.panelNoti.PanelNotification;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonHistory extends iNotiButton{

    public ButtonHistory(PanelNotification p) {
        this.p = p;
        addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (p.getGame().getWorld().isEnd() || p.getGame().getWorld().isComplete()) {
                    int[][] currentHstack = p.game.getHistoryStack().pop();
                    for (int i = 0; i < p.getArrayButtonInWorld().length; i++) {
                        for (int j = 0; j < p.getArrayButtonInWorld()[i].length; j++) {
                            p.getArrayButtonInWorld()[i][j].setNumber(-1);
                            p.getArrayButtonInWorld()[i][j].repaint();
                            p.game.getWorld().getArrayBoolean()[i][j] = false;
                        }
                    }

                    for (int i = 0; i < p.getArrayButtonInWorld().length; i++) {
                        for (int j = 0; j < p.getArrayButtonInWorld()[i].length; j++) {
                            if(currentHstack[i][j] == 1){
                                p.game.getWorld().openWithoutCondition(i,j);
                            }
                            else if(currentHstack[i][j] == 3){
                                p.game.getWorld().putFlagWithoutCondition(i,j);
                            }
                            else{

                            }
                        }
                    }




                }
            }
        });
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
