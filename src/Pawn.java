public class Pawn extends Piece{
    private boolean moved;

    public Pawn(String name, String position, boolean isWhite) {
        super(name, position, isWhite);
        this.moved=false;
    }
    /**THIS METHOD CHECKS IF THE PAWN CAN MOVE TO THE PROVIDED POSITION
    * @param moveto the position where the pawn is requested to be moved to
     * @var xN the horizontal axis the pawn currently is
     * @var yN the vertical axis the pawn currently is
     * @var xTG the vertical axis the pawn is requested to be moved to
     * @var yTG the horizontal axis the pawn is requested to be moved to
     */
    public boolean move (String moveto, Piece [][] board){
        int xN,yN,xTG,yTG;
        xN=this.getXAxis();
        yN=this.getYAxis();
        xTG=moveto.charAt(0);
        yTG=moveto.charAt(1)-48;
        if((xTG>104||xTG<97)||(yTG<1||yTG>8)){
            return false;
        }
        else if(xTG<xN-1||xTG>xN+1){
            return false;
        }
        else if (this.isPinned()){
            return false;
        }
        else { //TODO Think what happens when the pawn is promoted to another piece (probably will be handled in the board class)
            if(xTG==xN) {
                if (yTG == yN + 1 && (board[xTG - 97][yTG - 1] == null) && (!this.isPinned())) {
                    this.setMoved();
                    this.setPosition(((char) xTG) + String.valueOf(yTG));
                    return true;
                } else if (!this.isMoved()) {
                    if ((yTG == yN + 2) && (board[xTG - 97][yTG - 1] == null && board[xTG - 97][yTG - 2] == null) && (!this.isPinned())) {
                        this.setMoved();
                        this.setPosition(((char) xTG) + String.valueOf(yTG));
                        return true;
                    }
                }
            }
            else if ((xTG==xN+1)&&(yTG==yN+1)&&(board[xTG-97][yTG-1].isWhite()!=this.isWhite())&&(!this.isPinned())) {
                this.setMoved();
                this.setPosition(((char)xTG)+String.valueOf(yTG));
                return true;
            } else if ((xTG==xN-1)&&(yTG==yN+1)&&(board[xTG-97][yTG-1].isWhite()!=this.isWhite())&&(!this.isPinned())) {
                this.setMoved();
                this.setPosition(((char)xTG)+String.valueOf(yTG));
                return true;
            }
        }
        return false;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved() {
        this.moved = true;
    }
}
