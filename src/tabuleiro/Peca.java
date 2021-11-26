package tabuleiro;

public class Peca {
    
    protected Position position;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        position = null;
        this.tabuleiro = tabuleiro;
    }
    protected Tabuleiro getTabuleiro(){

        return tabuleiro;
    }
}
