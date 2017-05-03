package designpaint;

import java.awt.Graphics;

public abstract class Strategy {
    public static Strategy getInstance(){return null;};
    public abstract void draw(Graphics graphics, Shape shape);
    public abstract String toString(Shape shape);
    public abstract String getName();
}
