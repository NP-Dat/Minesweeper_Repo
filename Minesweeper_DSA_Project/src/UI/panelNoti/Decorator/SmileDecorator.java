package UI.panelNoti.Decorator;


import UI.panelNoti.ButtonSmile;
import UI.panelNoti.PanelNotification;



public class SmileDecorator extends PanelDecor {
    ButtonSmile bt;

    public SmileDecorator(PanelNotification panelNotification){
        super(panelNotification.getGame());

        bt = new ButtonSmile(this);
        PanelDecor.addButton(this, bt );

        for(iNotiButton button: PanelDecor.getListButton()){
            p13.add(button);
        }



    }



}
