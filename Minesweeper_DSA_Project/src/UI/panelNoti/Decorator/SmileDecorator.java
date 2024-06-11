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



    }



}
