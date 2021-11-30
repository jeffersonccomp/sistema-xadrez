package xadrez.pecas;


import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;


public class King extends PecaXadrez{
    

    public King(Tabuleiro tabuleiro, Color color){
        super(color, tabuleiro);

    }


    @Override
    public String toString() {
        return "K";
    }

}
