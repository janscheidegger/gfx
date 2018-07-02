package ch.bfh.scheidegger.gfx;


import ch.bfh.scheidegger.gfx.objects.Bezier2D;
import ch.bfh.scheidegger.gfx.objects.Line;
import ch.bfh.scheidegger.gfx.objects.Point;
import ch.bfh.scheidegger.gfx.objects.SimpleHermite;
import ch.bfh.scheidegger.gfx.objects.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GraphicsEditor {


    public static void main(String[] args) {
        new GraphicsEditor();
    }

    public GraphicsEditor() {
        JFrame graphicsEditor = new JFrame();
        graphicsEditor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final GfxComponent component = new GfxComponent();
        component.setPreferredSize(new Dimension(320, 320));
        graphicsEditor.getContentPane()
                      .add(component, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        JButton newLineButton = new JButton("New Line...");
        JButton newBezier = new JButton("New Bezier...");
        JButton newHermite = new JButton("New Hermite...");
        JButton clearButton = new JButton("Clear...");
        buttonsPanel.add(newLineButton);
        buttonsPanel.add(newBezier);
        buttonsPanel.add(newHermite);
        buttonsPanel.add(clearButton);
        graphicsEditor.getContentPane()
                      .add(buttonsPanel, BorderLayout.SOUTH);
        newLineButton.addActionListener((ActionEvent e) -> component.addGfxObject(new Line(20, 20, 60, 60, Color.BLACK)));
        newBezier.addActionListener((ActionEvent e) -> component.addGfxObject(new Bezier2D(100, 20, 100, 200, 320, 80, Color.BLACK)));
        newHermite.addActionListener((ActionEvent e) -> component.addGfxObject(new SimpleHermite(new Point(100,100), new Point(150,200), new Vector2D(100, 20), new Vector2D(30, 30))));
        clearButton.addActionListener(e -> component.clearAll());
        graphicsEditor.pack();
        graphicsEditor.setVisible(true);
    }

}
