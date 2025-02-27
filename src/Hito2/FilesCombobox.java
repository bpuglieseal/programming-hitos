package Hito2;

import javax.swing.*;
import java.awt.*;

public class FilesCombobox extends JComboBox {
    FilesCombobox () {
        this.addItem("python.txt");
        this.addItem("c.txt");
        this.addItem("java.txt");
        this.setPreferredSize(new Dimension(200, 30));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
    }
}
