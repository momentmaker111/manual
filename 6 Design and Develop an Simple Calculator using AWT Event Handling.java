import java.awt.*;
import java.awt.event.*;

public class AWTEventHandling extends Frame implements ActionListener {

    Label label;
    Button button;

    AWTEventHandling() {
        setTitle("AWT Event Handling");

        label = new Label("Click the button");
        label.setBounds(100, 60, 150, 30);

        button = new Button("Click Me");
        button.setBounds(100, 100, 100, 30);

        button.addActionListener(this);

        add(label);
        add(button);

        setSize(300, 200);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Button Clicked!");
    }

    public static void main(String[] args) {
        new AWTEventHandling();
    }
}
