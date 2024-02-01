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

    public boolean isWhite() {
        return isWhite;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
