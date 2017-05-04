package designpaint;

import designpaint.ShapeDecorator.Location;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InputWindow {
    private final JPanel form;
    JTextArea textArea;
    JComboBox comboBox;

    public InputWindow() {
        textArea = new JTextArea();
        form = new JPanel();
        comboBox = new JComboBox(new String[]{"LEFT", "RIGHT", "ABOVE", "BELOW"});
        textArea.setEditable(true);
        textArea.setPreferredSize(new Dimension(100, 20));
        textArea.requestFocusInWindow();
        form.add(textArea);
        form.add(comboBox);
    }
    
    public int show() {
        return JOptionPane.showConfirmDialog(null, form, "Please enter caption options", 2, 3);
    }
    
    public String getText() {
        return textArea.getText();
    }
    
    public Location getLocation() {
        switch((String)comboBox.getSelectedItem()) {
            case "LEFT":
                return Location.LEFT;
            case "RIGHT":
                return Location.RIGHT;
            case "ABOVE":
                return Location.ABOVE;
            case "BELOW":
                return  Location.BELOW;
            default:
                return null;
        }
    }
    
}
