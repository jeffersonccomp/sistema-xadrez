package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import tabuleiro.*;
import xadrez.ChessException;
import xadrez.ChessPosition;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Programa {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        PartidaXadrez partida = new PartidaXadrez();
        while(true){
            try{
                System.out.println();
                UI.limpaTela();
                UI.printBoard(partida.getPecas());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = partida.possibleMoves(source);
                UI.limpaTela();
                UI.printBoard(partida.getPecas(), possibleMoves);

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                PecaXadrez capturedPiece = partida.performChessMove(source, target);
            
            }catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        
        }
           
    }

}

