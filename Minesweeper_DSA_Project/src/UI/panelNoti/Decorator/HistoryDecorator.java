package UI.panelNoti.Decorator;

import UI.panelNoti.ButtonHistory;
import UI.panelNoti.PanelNotification;

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
