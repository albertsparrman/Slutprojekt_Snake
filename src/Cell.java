import java.awt.*;

enum CellType {
    NONE,
    SNAKE,
    FRUIT
}

class Cell {
    private CellType cellType;
    private java.awt.Rectangle rectangle = new java.awt.Rectangle();

    public Cell() {this.cellType = CellType.NONE;}

    public Cell(int type){
        setCellType(type);
    }

    public void setCellType(int i){
        switch (i) {
            case 0:
                this.cellType = CellType.NONE;
                break;
            case 1:
                this.cellType = CellType.SNAKE;
                break;
            case 2:
                this.cellType = CellType.FRUIT;
                break;
        }
    }

    public int getCellType() {
        switch (cellType) {
            default: return 0;
            case SNAKE: return 1;
            case FRUIT: return 2;
        }
    }

    public boolean isSnake(){
        return cellType.equals(CellType.SNAKE);
    }

    public boolean isFruit(){
        return cellType.equals(CellType.FRUIT);
    }
    public boolean isNone(){
        return cellType.equals(CellType.NONE);
    }

    public void setCircle(double x, double y, double w, double h){
        rectangle.setFrame(x, y, w, h);
    }

    public Rectangle getCircle(){return rectangle;}
}
