import java.util.ArrayList;

public class board {
    private Piece [][]board=new Piece[8][8];

    public board(){
        int i,y;
        for(i=0;i<8;i++){
            board[i][1]=new Pawn("p",(char)(97+i)+"2",true);
            board[i][6]=new Pawn("p",(char)(97+i)+"7",false);
        }
        board[0][0]=new Rook("r","a1",true);
        board[7][0]=new Rook("r","h1",true);
        board[0][7]=new Rook("r","a8",false);
        board[7][7]=new Rook("r","h8",false);
        board[1][0]=new Knight("n","b1",true);
        board[6][0]=new Knight("n","g1",true);
        board[1][7]=new Knight("n","b8",false);
        board[6][7]=new Knight("n","g8",false);
        board[2][0]=new Bishop("b","c1",true);
        board[5][0]=new Bishop("b","f1",true);
        board[2][7]=new Bishop("b","c8",false);
        board[5][7]=new Bishop("b","f8",false);
        board[3][0]=new Queen("q","d1",true);
        board[3][7]=new Queen("q","d8",false);
        board[4][0]=new King("k","e1",true);
        board[4][7]=new King("k","e8",false);
        for(i=2;i<6;i++){
            for(y=0;y<7;y++) {
                board[i][y]=null;
            }
        }
    }

}
