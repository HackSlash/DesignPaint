package designpaint;

import java.util.concurrent.atomic.AtomicReference;
import designpaint.ShapeDecorator.Location;

public class Command_AddCaption extends Command {
    private final AtomicReference<Composite> groupRef;
    private final CaptionDecorator caption;
    private final AtomicReference<Component> object;

    public Command_AddCaption(Component father, Location location, AtomicReference<Component> object, String text) {
        this.groupRef = father.getGroup();
        this.caption = new CaptionDecorator(father, location, text);
        this.object = object;
    }

    @Override
    public void execute() {
        groupRef.get().add(caption);
        object.set(caption);
    }

    @Override
    public void undo() {
        groupRef.get().remove(caption);
    }
}
