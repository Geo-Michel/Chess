public class Piece {
    private String name;
    private String position;
    private boolean isWhite;

    public Piece(String name, String position, boolean isWhite) {
        this.name = name;
        this.position = position;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
    public int getXAxis(){
        return position.charAt(0);
    }

    public int getYAxis(){
        return position.charAt(1)-48;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
