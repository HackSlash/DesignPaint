package designpaint;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ShapeDecorator implements Component{

    protected enum Location{
        LEFT,
        RIGHT,
        ABOVE,
        BELOW
    }
    
    protected final Component father;
    protected final Location location;
    
    public ShapeDecorator(Component father, Location location) {
        this.father = father;
        this.location = location;
    }

    @Override
    public GroupListItem toListItem(String prefix) {
        return new GroupListItem(new AtomicReference<>(this), prefix+this.getClass().getSimpleName());
    }

    @Override
    public List<GroupListItem> toFlatList(String prefix) {
        List<GroupListItem> ret = new ArrayList<>();
        ret.add(this.toListItem(prefix));
        return ret;
    }

    @Override
    public void resize(int offsetW, int offsetH) {}

    @Override
    public void move(int offsetX, int offsetY) {}

    @Override
    public Component select(int x, int y) {return null;}

    @Override
    public int getSmallestArea(int x, int y) {return 0;}

    @Override
    public void draw(Graphics g) {}

    @Override
    public int getOX() {
        return father.getOX();
    }

    @Override
    public int getOY() {
        return father.getOY();
    }

    @Override
    public int getW() {
        return father.getW();
    }

    @Override
    public int getH() {
        return father.getH();
    }

    @Override
    public int getFarX() {
        return father.getFarX();
    }

    @Override
    public int getX() {
        return father.getX();
    }

    @Override
    public int getY() {
        return father.getY();
    }

    @Override
    public int getFarY() {
        return father.getFarY();
    }

    @Override
    public AtomicReference<Composite> getGroup() {
        return father.getGroup();
    }

    @Override
    public void setGroup(AtomicReference<Composite> composite) {
        father.setGroup(composite);
    }

    @Override
    public void Accept(Visitor v) {
        v.Visit(this);
        v.Visit(father);
    }
    
}
