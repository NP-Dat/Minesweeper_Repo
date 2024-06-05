package UI.panelNoti.Decorator;

import UI.GamePanel;
import UI.panelNoti.ButtonHistory;
import UI.panelNoti.ButtonSmile;
import UI.panelNoti.PanelNotification;
import history.HistoryStack;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HistoryDecorator extends PanelDecor {

    public HistoryDecorator(PanelNotification panelNotification){
        super(panelNotification.getGame());
        bt = panelNotification.getBt();
        bHistory = new ButtonHistory(this);
        PanelDecor.addButton(this, bHistory);

        for(iNotiButton button: PanelDecor.getListButton()){
            p13.add(button);
        }

        bHistory.addMouseListener(new MouseListener() {

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
                if (getGame().getWorld().isEnd() || getGame().getWorld().isComplete()) {
                    int[][] currentHstack = game.getHistoryStack().pop();
                    for (int i = 0; i < getArrayButtonInWorld().length; i++) {
                        for (int j = 0; j < getArrayButtonInWorld()[i].length; j++) {
                            getArrayButtonInWorld()[i][j].setNumber(-1);
                            getArrayButtonInWorld()[i][j].repaint();
                            game.getWorld().getArrayBoolean()[i][j] = false;
                        }
                    }

                    for (int i = 0; i < getArrayButtonInWorld().length; i++) {
                        for (int j = 0; j < getArrayButtonInWorld()[i].length; j++) {
                            if(currentHstack[i][j] == 1){
                                game.getWorld().openWithoutCondition(i,j);
                            }
                            else if(currentHstack[i][j] == 3){
                                game.getWorld().putFlagWithoutCondition(i,j);
                            }
                            else{

                            }
                        }
                    }




                }
            }
        });

    }
}
