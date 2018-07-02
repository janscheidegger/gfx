package ch.bfh.scheidegger.gfx.objects;

import java.awt.*;

public class Line extends GfxObject {

    final Point start;
    final Point end;
    final Color color;


    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.start = new Point(x1, y1, color);
        this.end = new Point(x2, y2, color);
        this.color = color;
    }

    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(this.color);
        g.drawLine((int)start.x, (int)start.y, (int)end.x, (int)end.y);
    }
}
