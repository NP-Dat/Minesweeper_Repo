package UI.Strategy;

import UI.ButtonPlay;
import java.awt.*;

public class ButtonPlayPaint extends ButtonPaintStrategy {
    private ButtonPlay btn;

    public ButtonPlayPaint(ButtonPlay btnPlay) {
        this.btn = btnPlay;

    }
    @Override
    public void paintStrategy(Graphics g) {
        switch (btn.getNumber()) {

            case -1:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("noUse"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 0:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b0"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 1:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b1"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 2:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b2"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 3:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b3"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 4:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b4"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 5:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b5"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 6:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b6"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 7:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b7"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;

            case 8:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("b8"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case 9:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("flag"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case 10:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("boom"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case 11:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("boomRed"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            case 12:
                g.drawImage(btn.getP().getGame().getGameFrame().getLoadData().getListImage().get("boomX"), 0, 0,
                        btn.getPreferredSize().width, btn.getPreferredSize().height, null);
                break;
            default:
                break;
        }

    }
}
