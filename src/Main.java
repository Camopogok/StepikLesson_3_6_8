import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JFrame frame = new JFrame("Добавление строк");
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JTextField textField = new JTextField();
    JButton button = new JButton("Добавить");
    JTextArea textArea = new JTextArea(15, 26);

    public Main () {
        int width = 340, height = 380;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2 - width/2, dim.height/2 - height/2, width,height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textField.setMaximumSize(new Dimension(290,25));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
            }
        });

        textArea.setEnabled(false);
        textArea.setToolTipText("Введите фразу в поле выше и нажмите кнопку Добавить");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));
        addComponent(textField);
        addComponent(button);
        panel2.add (new JScrollPane(textArea));
        addComponent(panel2);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void addComponent (JComponent c) {
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(c);
        panel.add(Box.createVerticalStrut(10));
    }

    public static void main(String[] args) {
        new Main();
    }
}
