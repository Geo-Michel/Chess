public class King extends Piece{
    private boolean moved;
    public King(String name, String position, boolean isWhite) {
        super(name, position, isWhite);
        this.moved=false;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
