package Hito2;

import javax.swing.*;
import java.awt.*;

public class BaseButton extends JButton {
    BaseButton (String text) {
        this.setText(text);
        this.setMargin(new Insets(4, 14, 4, 14));
    }
}
