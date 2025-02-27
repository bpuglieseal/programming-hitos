package Hito2;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Main () {
        this.updateGlobalStyles();
        this.setTitle("Test Events: Files");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 700);
        this.setMinimumSize(new Dimension(800, 700));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        // Combobox and button (Line Start)
        JPanel lineStartPanel = new JPanel();
        lineStartPanel.add(new FilesCombobox());
        lineStartPanel.add(new ClearButton());

        this.add(lineStartPanel, BorderLayout.LINE_START);

        // Textarea
        JPanel lineEndPanel = new JPanel();
        JTextArea textArea = new JTextArea(10, 30);

        textArea.setBorder(BorderFactory.createLineBorder(new Color(21, 20, 20, 107)));

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        lineEndPanel.add(scrollPane);

        this.add(lineEndPanel, BorderLayout.CENTER);
    }

    public void updateGlobalStyles () {
        UIManager.put("Combobox.background", Color.BLACK);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
