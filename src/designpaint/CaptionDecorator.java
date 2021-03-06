package designpaint;

import java.awt.Color;
import java.awt.Graphics;

public class CaptionDecorator extends ShapeDecorator {
    private String text; 
    
    public CaptionDecorator(Component father, Location location) {
        super(father, location);
        this.text = "";
    }
    
    public CaptionDecorator(Component father, Location location, String text) {
        super(father, location);
        this.text = text.trim();
    }

    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawString(text, getCoordX(), getCoordY());
    }
    
    public int getCoordX() {
        int x = father.getX();
        switch(location) {
            case LEFT:
                x -= 8;
                x -= text.length()*5;
                break;
            case RIGHT:
                x += father.getW();
                break;
            case ABOVE:
            case BELOW:
                x += father.getW()/4;
                break;
        } return x;
    }
    
    public int getCoordY() {
        int y = father.getY();
        switch(location) {
            case LEFT:
            case RIGHT:
                y += father.getH()/2;
                break;
            case ABOVE:
                y -= 4;
                break;
            case BELOW:
                y += father.getH();
                y += 10;
                break;
        } return y;
    }

    @Override
    public String toString() {
        return "ornament " + location + " \"" + text + "\"";
    }
    
    @Override
    public void Accept(Visitor v) {
        v.Visit(this);
        if(!(father instanceof Composite)) father.Accept(v);
    }
    
    public String getDecoratorType() {
        return "Caption";
    }
    
}
