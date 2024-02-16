public class Knight extends Piece{
    private boolean pinned;

    public Knight(String name, String position, boolean isWhite) {
        super(name, position, isWhite);
        this.pinned = false;
    }
    /**
     * THIS METHOD CHECKS IF THE KNIGHT CAN MOVE TO THE PROVIDED POSITION
     *
     * @param moveto the position where the knight is requested to be moved to
     * @var xN the horizontal axis the knight currently is
     * @var yN the vertical axis the knight currently is
     * @var xTG the vertical axis the knight is requested to be moved to
     * @var yTG the horizontal axis the knight is requested to be moved to
     */
    public boolean move (String moveto, Piece[][] board){
        int xN, yN, xTG, yTG;
        xN = this.getXAxis();
        yN = this.getYAxis();
        xTG = moveto.charAt(0);
        yTG = moveto.charAt(1) - 48;
        if((xTG>104||xTG<97)||(yTG<1||yTG>8)){
            return false;
        }
        else if (isPinned()){
            return false;
        }
        else {
            if((Math.abs(xTG-xN)==1)&&(Math.abs(yTG-yN)==2)&&(board[xTG-97][yTG-1]==null||board[xTG-97][yTG-1].isWhite()!=this.isWhite())){
                this.setPosition(((char) xTG) + String.valueOf(yN));
                return true;
            }
            else if((Math.abs(xTG-xN)==2)&&(Math.abs(yTG-yN)==1)&&(board[xTG-97][yTG-1]==null||board[xTG-97][yTG-1].isWhite()!=this.isWhite())){
                this.setPosition(((char) xTG) + String.valueOf(yN));
                return true;
            }
        }
        return false;

    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
