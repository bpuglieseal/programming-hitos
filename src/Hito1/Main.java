package Hito1;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class Main extends JFrame {
    Main () {
        this.setTitle("Try Yourself!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(700, 500));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        // PAGE START
        JPanel pageStartPanel = new JPanel();
        pageStartPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        pageStartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JCheckBox katniss = new JCheckBox("Katniss");
        JCheckBox peeta = new JCheckBox("Peeta");
        pageStartPanel.add(katniss);
        pageStartPanel.add(peeta);
        this.add(pageStartPanel, BorderLayout.PAGE_START);

        // CENTER
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2));
        ImageIcon img = new ImageIcon(String.valueOf(Paths.get("src/Hito1/image.jpg").toAbsolutePath()));

        centerPanel.add(new JLabel(img));
        centerPanel.add(new JLabel(img));
        centerPanel.add(new JLabel(img));
        centerPanel.add(new JLabel(img));

        this.add(centerPanel, BorderLayout.CENTER);

        // LINE END
        JPanel lineEndPanel = new JPanel();
        lineEndPanel.setLayout(new BoxLayout(lineEndPanel, BoxLayout.Y_AXIS));
        ButtonGroup buttonGroup = new ButtonGroup();
        String[] options = {"OPT 1", "OPT 2", "OPT 3"};

        lineEndPanel.add(Box.createVerticalGlue());
        for (int i = 0; i < options.length; i++) {
            JRadioButton radio = new JRadioButton(options[i]);
            radio.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonGroup.add(radio);
            lineEndPanel.add(radio);
            if (i == 0) radio.setSelected(true);
        }
        lineEndPanel.add(Box.createVerticalGlue());

        lineEndPanel.setPreferredSize(new Dimension(250, this.getSize().height));
        this.add(lineEndPanel, BorderLayout.LINE_END);

        // PAGE END
        JPanel pageEndPanel = new JPanel();
        pageEndPanel.setLayout(new BoxLayout(pageEndPanel, BoxLayout.X_AXIS));

        pageEndPanel.add(new JButton("But 1"));
        pageEndPanel.add(new JButton("But 2"));
        pageEndPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(pageEndPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args)  {
        SwingUtilities.invokeLater(Main::new);
    }
}
