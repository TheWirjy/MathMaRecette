/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mathmarecette;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author veerasam
 */
public class MemoryGame extends JFrame {

    static String files[] = {".\\image\\memory\\0.png", ".\\image\\memory\\1.png",
        ".\\image\\memory\\3.png", ".\\image\\memory\\4.png",
        ".\\image\\memory\\5.png", ".\\image\\memory\\9.png"};

    static String files2[] = {".\\image\\memory\\2.png", ".\\image\\memory\\8.png",
        ".\\image\\memory\\6.png", ".\\image\\memory\\7.png",
        ".\\image\\memory\\11.png", ".\\image\\memory\\10.png"};
    static JButton buttons[];
    ImageIcon closedIcon;
    int numButtons;
    ImageIcon icons[];
    Timer myTimer;

    int numClicks = 0;
    int oddClickIndex = 0;
    int currentIndex = 0;
    int[] famille;
    public MemoryGame() {
        // Set the title.

        setTitle("Memory Game");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new GridLayout(2, files.length));

        closedIcon = new ImageIcon(".\\image\\memory\\carte.png");
        numButtons = files.length * 2;
        buttons = new JButton[numButtons];
        icons = new ImageIcon[numButtons];
        famille = new int[numButtons];
        for (int i = 0, j = 0; i < files.length; i++) {
            icons[j] = new ImageIcon(files[i]);
            famille[i] = i;
            buttons[j] = new JButton("");
            buttons[j].addActionListener(new ImageButtonListener());
            buttons[j].setIcon(closedIcon);
            add(buttons[j++]);
            System.out.println(j + ", " + (j-1));
            icons[j] = new ImageIcon(files2[i]);
            famille[j] = famille[j-1];
            buttons[j] = new JButton("");
            buttons[j].addActionListener(new ImageButtonListener());
            buttons[j].setIcon(closedIcon);
            add(buttons[j++]);
        }

        // randomize icons array
        Random gen = new Random();
        for (int i = 0; i < numButtons; i++) {
            int rand = gen.nextInt(numButtons);
            ImageIcon temp = icons[i];
            icons[i] = icons[rand];
            icons[rand] = temp;

            int tmpi = famille[i];
            famille[i] = famille[rand];
            famille[rand] = tmpi;
        }

        // Pack and display the window.
        pack();
        setVisible(true);

        myTimer = new Timer(1000, new TimerListener());
        // myTimer.start();
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            buttons[currentIndex].setIcon(closedIcon);
            buttons[oddClickIndex].setIcon(closedIcon);
            myTimer.stop();
        }
    }

    private class ImageButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // we are waiting for timer to pop - no user clicks accepted
            if (myTimer.isRunning()) {
				return;
				}

            numClicks++;
            System.out.println(numClicks);

            // which button was clicked?
            for (int i = 0; i < numButtons; i++) {
                if (e.getSource() == buttons[i]) {
                    buttons[i].setIcon(icons[i]);
                    currentIndex = i;
                }
            }

            // check for even click
            if (numClicks % 2 == 0) {
                // check whether same position is clicked twice!
                if (currentIndex == oddClickIndex) {
                    numClicks--;
                    return;
                }
                // are two images matching?
                if (famille[currentIndex] != famille[oddClickIndex]) {
                    // show images for 1 sec, before flipping back
                    myTimer.start();
                }
            } else {
                // we just record index for odd clicks
                oddClickIndex = currentIndex;
            }
        }
    }

    public static void main(String[] args) {
        new MemoryGame();
    }
}