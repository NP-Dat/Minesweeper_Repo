package UI.Strategy;

import UI.panelNoti.ButtonSmile;

import java.awt.*;

public class ButtonSmilePaint extends ButtonPaintStrategy {
    private ButtonSmile btn;

    public ButtonSmilePaint(ButtonSmile btnSmile) {
        this.btn = btnSmile;
    }

    @Override
    public void paintStrategy(Graphics g) {
        switch (btn.getStage()) {
            case ButtonSmile.win:
                g.drawImage(btn.getPanelNoti().getGame().getGameFrame().getLoadData().getListImage().get("smileWin"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case ButtonSmile.lose:
                g.drawImage(btn.getPanelNoti().getGame().getGameFrame().getLoadData().getListImage().get("smileLose"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case ButtonSmile.press:
                g.drawImage(btn.getPanelNoti().getGame().getGameFrame().getLoadData().getListImage().get("smilePress"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case ButtonSmile.wow:
                g.drawImage(btn.getPanelNoti().getGame().getGameFrame().getLoadData().getListImage().get("smilePressPlay"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case ButtonSmile.now:
                g.drawImage(btn.getPanelNoti().getGame().getGameFrame().getLoadData().getListImage().get("smile"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            default:
                break;
        }
    }



}
