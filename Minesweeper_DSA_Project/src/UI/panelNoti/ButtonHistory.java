package UI.panelNoti;

import UI.panelNoti.Decorator.iNotiButton;
import UI.panelNoti.PanelNotification;

import javax.swing.*;

public class ButtonHistory extends iNotiButton{

    public ButtonHistory(PanelNotification p) {
        this.p = p;
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
