import javax.swing.*;
import java.awt.*;

class View extends JComponent {
        private Cell[][] snakeGame;

        public View(){ }

    public static final Color GRASS = new Color(114, 210, 78);
    public static final Color SNAKE = new Color(40, 110, 78);


    public void addKeyArrowListener(int keyCode, String Name, Action action){
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0), Name);
            getActionMap().put(Name, action);
        }

        @Override
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;

            for (int i = 0; i<snakeGame.length; i++){
                for (int j = 0; j < snakeGame[i].length; j++) {
                    if (snakeGame[i][j].isSnake()) {
                        g2d.setColor(View.SNAKE);
                    } else if (snakeGame[i][j].isFruit()) {
                        g2d.setColor(Color.RED);
                    }
                    else{
                        g2d.setColor(View.GRASS);
                    }
                    g2d.fill(snakeGame[i][j].getCircle());
                }
            }

            g2d.setColor(View.SNAKE);
            //+20 is just to put some space from the border
            g2d.drawRect(0+20, 0+20, 400, 400);
        }

        public void setCells(Cell[][] allCells){
            this.snakeGame = allCells;
        }

        public Cell[][] getCells(){return snakeGame;}

}
