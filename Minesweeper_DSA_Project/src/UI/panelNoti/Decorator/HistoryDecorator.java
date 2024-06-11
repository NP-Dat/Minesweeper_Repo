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
    ButtonHistory bHistory;

    public HistoryDecorator(PanelNotification panelNotification){
        super(panelNotification.getGame());
        bHistory = new ButtonHistory(this);
        PanelDecor.addButton(this, bHistory);

        for(iNotiButton button: PanelDecor.getListButton()){
            p13.add(button);
        }



    }
}
