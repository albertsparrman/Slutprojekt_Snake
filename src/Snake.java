import javax.swing.*;
import java.awt.*;

public class Snake {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame frame = new GameFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(450, 550));
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("Snake Game");
                frame.getContentPane().setBackground(Color.WHITE);
            }
        });
    }

}

class GameFrame extends JFrame {

    private Model snakeModel;
    private Controller snakeController;
    private View snakeGameView;
    private NorthGamePanel northGamePanel;
    private SouthGamePanel southGamePanel;


    public GameFrame() {

        snakeGameView = new View();
        add(snakeGameView, BorderLayout.CENTER);

        snakeModel = new Model();

        northGamePanel = new NorthGamePanel();
        add(northGamePanel, BorderLayout.NORTH);

        southGamePanel = new SouthGamePanel();
        add(southGamePanel, BorderLayout.SOUTH);


        snakeController = new Controller(snakeModel, snakeGameView, northGamePanel, southGamePanel);



    }




}