public class Bishop extends Piece {
    public Bishop(String name, String position, boolean isWhite) {
        super(name, position, isWhite);
    }

    /**
     * THIS METHOD CHECKS IF THE BISHOP CAN MOVE TO THE PROVIDED POSITION
     *
     * @param moveto the position where the bishop is requested to be moved to
     * @var xN the horizontal axis the bishop currently is
     * @var yN the vertical axis the bishop currently is
     * @var xTG the vertical axis the bishop is requested to be moved to
     * @var yTG the horizontal axis the bishop is requested to be moved to
     */
    public boolean move(String moveto, Piece[][] board) {
        int xN, yN, xTG, yTG;
        xN = this.getXAxis();
        yN = this.getYAxis();
        xTG = moveto.charAt(0);
        yTG = moveto.charAt(1) - 48;
        if ((xTG > 104 || xTG < 97) || (yTG < 1 || yTG > 8)) {
            return false;
        }
        else {
            int tempX = xN, tempY = yN;
            boolean isBlocked=false; //becomes true if the path to the destination is blocked by another piece
            if(xTG>xN&&yTG>yN){
                while(!((tempX > 104 || tempX < 97) || (tempY < 1 || tempY > 8))){
                    tempX+=1;
                    tempY+=1;
                    if(!isBlocked) {
                        if (tempY == yTG && tempX == xTG && (board[tempX][tempY] == null || board[tempX][tempY].isWhite() != this.isWhite())) {
                            this.setPosition(((char) xTG) + String.valueOf(yN));
                            return true;
                        }
                        else if (tempY == yTG && tempX == xTG){
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX][tempY]!=null){
                        isBlocked=true;
                    }
                }
            }
            else if (xTG>xN&&yTG<yN) {
                while(!((tempX > 104 || tempX < 97) || (tempY < 1 || tempY > 8))){
                    tempX+=1;
                    tempY-=1;
                    if(!isBlocked) {
                        if (tempY == yTG && tempX == xTG && (board[tempX][tempY] == null || board[tempX][tempY].isWhite() != this.isWhite())) {
                            this.setPosition(((char) xTG) + String.valueOf(yN));
                            return true;
                        }
                        else if (tempY == yTG && tempX == xTG){
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX][tempY]!=null){
                        isBlocked=true;
                    }
                }
            }
            else if (xTG<xN&&yTG>yN) {
                while(!((tempX > 104 || tempX < 97) || (tempY < 1 || tempY > 8))){
                    tempX-=1;
                    tempY+=1;
                    if(!isBlocked) {
                        if (tempY == yTG && tempX == xTG && (board[tempX][tempY] == null || board[tempX][tempY].isWhite() != this.isWhite())) {
                            this.setPosition(((char) xTG) + String.valueOf(yN));
                            return true;
                        }
                        else if (tempY == yTG && tempX == xTG){
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX][tempY]!=null){
                        isBlocked=true;
                    }
                }
            }
            else if (xTG<xN&&yTG<yN) {
                while(!((tempX > 104 || tempX < 97) || (tempY < 1 || tempY > 8))){
                    tempX-=1;
                    tempY-=1;
                    if(!isBlocked) {
                        if (tempY == yTG && tempX == xTG && (board[tempX][tempY] == null || board[tempX][tempY].isWhite() != this.isWhite())) {
                            this.setPosition(((char) xTG) + String.valueOf(yN));
                            return true;
                        }
                        else if (tempY == yTG && tempX == xTG){
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                    if(board[tempX][tempY]!=null){
                        isBlocked=true;
                    }
                }
            }
        }
        return false;
    }
}