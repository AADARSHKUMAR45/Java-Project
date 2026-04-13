package textfield;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements TextListener, ActionListener {
    Label l1, l2;
    TextField tf;

    MyFrame() {
        super("TextField Demo");

        l1 = new Label("No text are enter");
        l2 = new Label("No enter key are hit");
        tf = new TextField(30);

        tf.addTextListener(this);
        tf.addActionListener(this);

        setLayout(new FlowLayout());

        add(l1);
        add(tf);
        add(l2);
    }

    // Correct method
    public void textValueChanged(TextEvent te) {
        l1.setText(tf.getText());
    }

    // Correct method
    public void actionPerformed(ActionEvent ae) {
        l2.setText(tf.getText());
    }
}

public class TextField1 {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(300, 300);
        f.setVisible(true);
    }
}