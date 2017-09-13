import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.awt.Label.CENTER;


/**
 * Created by Bartek on 2017-09-06.
 */
public class GUI extends JFrame {

    public GUI() {
        iniGUI();

        setTitle("Wyświetlacz czasu");
        setSize(300, 200);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JLabel jLabel1 = new JLabel();
    BorderLayout borderLayout = new BorderLayout();
    Font font = new Font("", Font.BOLD, 16);
    Container container = this.getContentPane();

    public void iniGUI() {
        container.add(jLabel1, borderLayout.CENTER);
        jLabel1.setFont(font);
        Runnable timeDisplay = new Runnable() {

            public void run() {
                while (true) {
                    jLabel1.setText(LocalTime.now().toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(timeDisplay);
    }
}
