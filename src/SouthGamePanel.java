import javax.swing.*;
import java.awt.*;

class SouthGamePanel extends JPanel {

        private final JLabel scorelabel;
        private final JLabel lives;

        public SouthGamePanel() {
                setBackground(Color.WHITE);
                setLayout(new GridLayout(0, 2));

                scorelabel = new JLabel();
                scorelabel.setForeground(Color.BLACK);
                setScoreLabel(0);
                scorelabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
                scorelabel.setPreferredSize(new Dimension(100, 30));
                add(scorelabel);

                lives = new JLabel("", SwingConstants.RIGHT);
                lives.setForeground(Color.BLACK);
                setLivesLabel(3);
                lives.setFont(new Font("Monospaced", Font.PLAIN, 18));
                lives.setPreferredSize(new Dimension(100, 30));
                add(lives);

        }

        public void setScoreLabel(int score){
                scorelabel.setText(" Score: "+ score);
        }

        public void setLivesLabel(int live){
                lives.setText("Lives: "+ live+" ");
        }
}