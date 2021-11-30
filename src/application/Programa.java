package application;

import tabuleiro.*;
import xadrez.PartidaXadrez;

public class Programa {
    public static void main(String[] args) throws Exception {
        
        PartidaXadrez partida = new PartidaXadrez();
        UI.printBoard(partida.getPecas());


    }
}
