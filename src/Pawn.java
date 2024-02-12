public class Pawn extends Piece{
    private Piece [][]board=new Piece[8][8];
    private boolean moved;

    public Pawn(String name, String position, boolean isWhite, Piece [][] board) {
        super(name, position, isWhite);
        this.board=board;
        this.moved=false;
    }
    /**THIS METHOD CHECKS IF THE PAWN CAN MOVE TO THE PROVIDED POSITION
    * @param moveto the position to where the pawn is requested to be moved to
     * @var xN the horizontal axis the pawn currently is
     * @var yN the vertical axis the pawn currently is
     * @var xTG the vertical axis the pawn is requested to be moved to
     * @var yTG the horizontal axis the pawn is requested to be moved to
     */
    boolean move (String moveto){
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
        else {
            if(xTG==xN){
                if(((!moved)&&yTG==yN+2)||(yTG==yN+1)){
                    return true;
                }
            }
            else if ((xTG==xN+1)&&(yTG==yN+1)&&(board[xTG-97][yTG-1].isWhite()!=this.isWhite())) {
                return true;
            } else if ((xTG==xN-1)&&(yTG==yN+1)&&(board[xTG-97][yTG-1].isWhite()!=this.isWhite())) {
                return true;
            }
        }
        return false;
    }
}
