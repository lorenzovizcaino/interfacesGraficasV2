package escribiendomarco;

import java.awt.*;

public class LetrasEnLocal {
    public static void main(String[] args) {
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] misFuentes=graphicsEnvironment.getAvailableFontFamilyNames();
        for (String s:misFuentes) {
            System.out.println(s);

        }
    }
}
