import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class NorthGamePanel extends JPanel{

    private final JButton play;
    private final JButton newGame;

    public NorthGamePanel() {
        setBackground(Color.WHITE);


        play = new JButton("Play");
        play.setBackground(Color.WHITE);
        play.setPreferredSize(new Dimension(150, 30));
        add(play);

        newGame = new JButton("Set Highscore");
        newGame.setBackground(Color.WHITE);
        newGame.setPreferredSize(new Dimension(150, 30));
        add(newGame);

    }


    public void addPlayButtonListener(ActionListener playAction){
        play.addActionListener(playAction);
    }

    public void addNewGameButoonListener(ActionListener newGameAction){
        newGame.addActionListener(newGameAction);
    }

    public void updatePanelForPlayMode(boolean isPlaying){
        if(isPlaying){
            newGame.setEnabled(false);
            play.setText("Pause");
        }
        else{
            newGame.setEnabled(true);
            play.setText("Play");
        }
    }

    public void updatePanelForGameOverMode(){
        newGame.setEnabled(true);
        play.setEnabled(false);
    }

    public void updatePanelforGameStartMode(){
        newGame.setEnabled(true);
        play.setEnabled(true);
    }
}