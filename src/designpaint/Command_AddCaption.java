package designpaint;

import java.util.concurrent.atomic.AtomicReference;
import designpaint.ShapeDecorator.Location;

public class Command_AddCaption extends Command {
    private final AtomicReference<Composite> groupRef;
    private final CaptionDecorator caption;

    public Command_AddCaption(Component father, Location location, String text) {
        this.groupRef = father.getGroup();
        this.caption = new CaptionDecorator(father, location, text);
    }

    @Override
    public void execute() {
        groupRef.get().add(caption);
    }

    @Override
    public void undo() {
        groupRef.get().remove(caption);
    }
}
