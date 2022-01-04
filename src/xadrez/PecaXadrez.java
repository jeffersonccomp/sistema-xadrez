package xadrez;


import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{
    
    private Color color;

    public PecaXadrez(Color color, Tabuleiro tabuleiro) {
        super(tabuleiro);
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    protected boolean isThereOpponentPiece(tabuleiro.Position p2){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(p2);
        return p != null && p.getColor() !=color;

    }

}
