package designpaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class SelectStrategy extends Strategy {

    private static final SelectStrategy INSTANCE = new SelectStrategy();

    /* A private Constructor prevents any other
    * class from instantiating.
     */
    private SelectStrategy() {
    }

    /* Static 'instance' method */
    public static SelectStrategy getInstance() {
        return INSTANCE;
    }

    /* Other methods protected by singleton-ness */
    /**
     * Draws the shape at its coordinates.
     *
     * @param graphics Graphics generator
     * @param shape Shape to use strategy on.
     */
    @Override
    public void draw(Graphics graphics, Shape shape) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(Color.red);
        double thickness = 2;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke((float) thickness));

        g2.drawRect(shape.coordinateX, shape.coordinateY, Math.abs(shape.width), Math.abs(shape.height));
        g2.setStroke(oldStroke);
    }

    /**
     * Generates a String representation of this Shape, that can be saved to a
     * file.
     *
     * @param shape Shape to use strategy on.
     * @return String representation of this Shape
     */
    @Override
    public String toString(Shape shape) {
        return "select " + shape.coordinateX + " " + shape.coordinateY + " " + (shape.coordinateX + shape.width) + " " + (shape.coordinateY + shape.height);
    }

}
