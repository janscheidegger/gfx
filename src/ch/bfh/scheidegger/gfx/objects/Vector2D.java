package ch.bfh.scheidegger.gfx.objects;

import java.awt.*;

public class Vector2D extends GfxObject {
    final float x;
    final float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D scalar(float scalar) {
        return new Vector2D(x * scalar, y * scalar);
    }


    @Override
    public void render(Graphics g) {

    }
}
