package designpaint;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleStrategy extends Strategy{
    private  static final RectangleStrategy INSTANCE = new RectangleStrategy();

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private RectangleStrategy() {}

   /* Static 'instance' method */
   public static RectangleStrategy getInstance( ) {
      return INSTANCE;
   }

   /* Other methods protected by singleton-ness */
   /**
     * Draws the shape at its coordinates.
     * @param graphics Graphics generator
     * @param shape Shape to use strategy on.
     */
    @Override
    public void draw(Graphics graphics, Shape shape) {
        graphics.setColor(Color.black);
        graphics.drawRect(shape.coordinateX, shape.coordinateY, Math.abs(shape.width), Math.abs(shape.height));
    }
   
   /**
     * Generates a String representation of this Shape, that can be saved to a file.
     * @param shape Shape to use strategy on.
     * @return String representation of this Shape
     */
    @Override
    public String toString(Shape shape) {
        return "rectangle " + shape.coordinateX + " " + shape.coordinateY + " " + (shape.coordinateX + shape.width) + " " + (shape.coordinateY + shape.height);
    }
    
}
