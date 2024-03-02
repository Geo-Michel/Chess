public class Rook extends Piece {
    private boolean moved;

    public Rook(String name, String position, boolean isWhite) {
        super(name, position, isWhite);
        this.moved = false;
    }
    /**
     * THIS METHOD CHECKS IF THE ROOK CAN MOVE TO THE PROVIDED POSITION
     *
     * @param moveto the position where the rook is requested to be moved to
     * var xN the horizontal axis the rook currently is
     * var yN the vertical axis the rook currently is
     * var xTG the vertical axis the rook is requested to be moved to
     * var yTG the horizontal axis the rook is requested to be moved to
     */

    public boolean move(String moveto, Piece[][] board){
        int xN, yN, xTG, yTG;
        xN = this.getXAxis();
        yN = this.getYAxis();
        xTG = moveto.charAt(0);
        yTG = moveto.charAt(1) - 48;
        if((xTG>104||xTG<97)||(yTG<1||yTG>8)){
            return false;
        } else if (this.isPinned()) {//TODO: CHANGE THIS EVERYWHERE CAUSE IF IT IS PINNED IT CAN'T MOVE EVEN TO CAPTURE THE PINNING PIECE
            return false;
        }
        else {
            int tempX,tempY;
            tempX=xN;
            tempY=yN;
            boolean isBlocked=false;    //becomes true if the path to the destination is blocked by another piece
            if(xTG==xN&&yTG>yN) {//moving rook upwards
                while (!(tempY < 1 || tempY > 8)) {
                    tempY+=1;
                    if(!isBlocked) {
                        if ((tempY == yTG) && ((board[xTG - 97][yTG - 1] == null) || board[xTG - 97][yTG - 1].isWhite() != this.isWhite())) {
                            this.setMoved();
                            this.setPosition(((char) xTG) + String.valueOf(yTG));
                            return true;
                        }
                        else if(tempY==yTG){
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX-97][tempY-1]!=null){
                        isBlocked=true;
                    }
                }
            }
            else if(xTG==xN&&yTG<yN) {//moving rook downwards
                while (!(tempY < 1 || tempY > 8)) {
                    tempY-=1;
                    if(!isBlocked) {
                        if ((tempY == yTG) && ((board[xTG - 97][yTG - 1] == null) || board[xTG - 97][yTG - 1].isWhite() != this.isWhite())) {
                            this.setMoved();
                            this.setPosition(((char) xTG) + String.valueOf(yTG));
                            return true;
                        }
                        else if(tempY==yTG){
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX-97][tempY-1]!=null){
                        isBlocked=true;
                    }
                }
            }
            else if(xTG>xN&&yTG==yN) {//moving rook to the right
                while (!(tempX < 97 || tempX > 104)) {
                    tempX+=1;
                    if(!isBlocked) {
                        if ((tempX == xTG) && ((board[xTG - 97][yTG - 1] == null) || board[xTG - 97][yTG - 1].isWhite() != this.isWhite())) {
                            this.setMoved();
                            this.setPosition(((char) xTG) + String.valueOf(yTG));
                            return true;
                        } else if (xTG==tempX) {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX-97][tempY-1]!=null){
                        isBlocked=true;
                    }
                }
            }
            else if(xTG<xN&&yTG==yN) {//moving rook to the left
                while (!(tempX < 97 || tempX > 104)) {
                    tempX-=1;
                    if(!isBlocked) {
                        if ((tempX == xTG) && ((board[xTG - 97][yTG - 1] == null) || board[xTG - 97][yTG - 1].isWhite() != this.isWhite())) {
                            this.setMoved();
                            this.setPosition(((char) xTG) + String.valueOf(yTG));
                            return true;
                        } else if (xTG==tempX) {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX-97][tempY-1]!=null){
                        isBlocked=true;
                    }
                }
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
