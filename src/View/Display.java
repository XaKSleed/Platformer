package View;

import javax.swing.*;
import java.awt.*;

public class Display {
    public Display(){}
    public static JFrame createFrame(){
        JFrame frame = new JFrame("Knight's Escape");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        return(frame);
    }
}
