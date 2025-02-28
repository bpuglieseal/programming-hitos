package Hito2;

import javax.swing.*;
import java.awt.*;

public class FilesCombobox extends JComboBox {
    FilesCombobox () {
        this.addItem("python.txt");
        this.addItem("c.txt");
        this.addItem("java.txt");
        this.addItem("balda.txt");
        this.setEditable(true);
        this.setPreferredSize(new Dimension(250, 30));
    }
}
