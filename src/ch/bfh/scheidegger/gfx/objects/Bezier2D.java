package ch.bfh.scheidegger.gfx.objects;

import java.awt.*;

public class Bezier2D extends GfxObject {

    final Point start;
    final Point end;
    final Point control1;
    final Color color;


    public Bezier2D(float x1, float y1, float x2, float y2, float c1, float c2, Color color) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.control1 = new Point(c1, c2);
        this.color = color;
    }


    @Override
    public void render(Graphics g) {
        Point lastPoint = (start.mulitply(1)
                                .add(control1.mulitply(0))).mulitply(1)
                                                           .add((control1.mulitply(1)
                                                                         .add(end.mulitply(0))).mulitply(0));
        for (float t = 0.01f; t <= 1; t += 0.01f) {


            Point p = (start.mulitply(1 - t)
                            .add(control1.mulitply(t))).mulitply(1 - t)
                                                       .add((control1.mulitply(1 - t)
                                                                     .add(end.mulitply(t))).mulitply(t));
            Line l = new Line(lastPoint, p, Color.BLACK);
            l.render(g);
            lastPoint = p;
        }
        renderHelplines(g);
    }

    private void renderHelplines(Graphics g) {
        new Line(start, control1, Color.green).render(g);
        new Line(end, control1, Color.green).render(g);
    }
}
