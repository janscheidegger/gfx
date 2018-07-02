package ch.bfh.scheidegger.gfx.objects;

import java.awt.*;

public class Point extends GfxObject {
    final float x;
    final float y;
    final Color color;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.color = Color.black;
    }

    public Point(float x, float y,  Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawLine((int)x, (int)y, (int)x, (int)y);
    }

    public Point add(Point point) {
        return new Point(this.x + point.x, this.y+ point.y, this.color);
    }

    public Point mulitply(float multiplier) {
        return new Point(this.x * multiplier, this.y * multiplier, this.color);
    }

    public Point move(Vector2D vector2D) {
        return new Point(this.x + vector2D.x, this.y + vector2D.y);
    }
}
