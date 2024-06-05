package UI.panelNoti.Decorator;

import UI.GamePanel;
import UI.panelNoti.ButtonSmile;
import UI.panelNoti.PanelNotification;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class PanelDecor extends PanelNotification {
    private static ArrayList<iNotiButton> listButton = new ArrayList<iNotiButton>();

    public PanelDecor(GamePanel game) {
        super(game);
    }

    public static void addButton(PanelNotification p, iNotiButton b){
        listButton.add(b);
        for (iNotiButton button : listButton) {
            button.setPanelNoti(p);
        }
    }

    public static ArrayList<iNotiButton> getListButton() {
        return listButton;
    }

    public static void clearListButton(){
        listButton.clear();
    }

}
