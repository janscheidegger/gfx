package ch.bfh.scheidegger.gfx.objects;

import java.awt.*;

public class SimpleHermite extends GfxObject {

    final Point start;
    final Point end;
    final Vector2D startVector;
    final Vector2D endVector;

    public SimpleHermite(Point start, Point end, Vector2D startVector, Vector2D endVector) {
        this.start = start;
        this.end = end;
        this.startVector = startVector;
        this.endVector = endVector;
    }


    @Override
    public void render(Graphics g) {
        Point first = start.mulitply(1);

        for(float t = 0.01f; t <= 1; t += 0.01f) {
            Point next = start.mulitply((float) (Math.pow(t, 3) * 2 - Math.pow(t, 2) * 3 + 1))
                              .add(end.mulitply((float) (-2 * Math.pow(t, 3) + 3 * Math.pow(t, 2))))
                              .move(startVector.scalar((float) (Math.pow(t, 3) - 2 * Math.pow(t, 2) + t)))
                              .move(endVector.scalar((float) (Math.pow(t, 3) - Math.pow(t, 2))));
            new Line(first, next, Color.black).render(g);
            first = next;
            renderVectors(g);
        }

    }

    private void renderVectors(Graphics g) {
        new Line(start, start.move(startVector), Color.green).render(g);
        new Line(end, end.move(endVector), Color.green).render(g);
    }
}
