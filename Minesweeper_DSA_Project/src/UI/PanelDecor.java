package UI;

import javax.swing.JPanel;
import java.awt.event.MouseListener;

public abstract class PanelDecor extends JPanel {

    public PanelDecor() {
        super();
    }

    // Abstract method to be implemented by subclasses
    public abstract void addMouseListener(MouseListener l);
}

