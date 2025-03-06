package Hito2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Paths;

public class Main extends JFrame implements ActionListener {
    private JComboBox filesCombobox;
    private JButton clearButton;
    private JButton closeButton;
    private JTextArea textArea;

    public void initCloseButtonListeners () {
        this.closeButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    public void initClearButtonListeners () {
        this.clearButton.addActionListener(e -> {
            ((JTextField) this.filesCombobox.getEditor().getEditorComponent()).setText("");
        });
    }

    public void initComboboxListeners () {
        this.filesCombobox.addActionListener(this);
    }

    Main () {
        this.filesCombobox = new FilesCombobox();
        this.clearButton = new ClearButton();
        this.closeButton = new CloseButton();

        // Listeners
        this.initCloseButtonListeners();
        this.initClearButtonListeners();
        this.initComboboxListeners();

        this.setTitle("Test Events: Files");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(900, 500));
        this.setMaximumSize(new Dimension(900, 500));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        // Combobox and button (Line Start)
        JPanel lineStartPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lineStartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

        lineStartPanel.add(this.filesCombobox);
        lineStartPanel.add(this.clearButton);

        this.add(lineStartPanel, BorderLayout.LINE_START);

        // Textarea and Button
        JPanel lineEndPanel = new JPanel();
        lineEndPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 15));
        lineEndPanel.setPreferredSize(new Dimension(450, 0));
        lineEndPanel.setLayout(new BorderLayout());

        this.textArea = new JTextArea();
        this.textArea.setPreferredSize(new Dimension(450 - 50, this.getHeight() - 200));
        this.textArea.setBorder(BorderFactory.createLineBorder(new Color(21, 20, 20, 107)));
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(this.textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel lineEndPanelSouthPanel = new JPanel();
        lineEndPanelSouthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lineEndPanelSouthPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        lineEndPanelSouthPanel.add(this.closeButton);

        lineEndPanel.add(scrollPane, BorderLayout.CENTER);
        lineEndPanel.add(lineEndPanelSouthPanel, BorderLayout.PAGE_END);

        this.add(lineEndPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.filesCombobox) {
            String fileName = (String) filesCombobox.getSelectedItem();
            textArea.setText("");

            if (fileName.isEmpty()) {
                JOptionPane.showMessageDialog(null, String.format("El archivo \"%s\" o dato no es valido", fileName), "Warning: File", JOptionPane.WARNING_MESSAGE);
            } else if (e.getSource() == filesCombobox) {
                String filePath = String.valueOf(Paths.get("src/Hito2/" + fileName).toAbsolutePath());
                try {
                    File file = new File(filePath);
                    FileReader fileReader = new FileReader(file);
                    BufferedReader br = new BufferedReader(fileReader);
                    StringBuilder sb = new StringBuilder();

                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        line = br.readLine();
                    }

                    textArea.setText(sb.toString());
                } catch (FileNotFoundException fileNotFoundException) {
                    JOptionPane.showMessageDialog(null, String.format("El archivo \"%s\" no existe", fileName), "Error: File", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }

        }
    }
}
