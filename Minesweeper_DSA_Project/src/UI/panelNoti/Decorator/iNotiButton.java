package UI.panelNoti.Decorator;

import UI.panelNoti.PanelNotification;

import javax.swing.*;

public abstract class iNotiButton extends JButton {

    protected PanelNotification p;
    public abstract PanelNotification getPanelNoti();

    public abstract void setPanelNoti(PanelNotification p);
}
