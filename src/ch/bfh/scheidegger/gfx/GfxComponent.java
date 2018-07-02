package ch.bfh.scheidegger.gfx;

import ch.bfh.scheidegger.gfx.objects.GfxObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GfxComponent extends JComponent {
    private final ArrayList<GfxObject> elements = new ArrayList<>();

    public void addGfxObject(GfxObject object) {
        elements.add(object);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GfxObject object : elements) {
            object.render(g);
        }
    }

    public void clearAll() {
        elements.clear();
        repaint();

    }
}
