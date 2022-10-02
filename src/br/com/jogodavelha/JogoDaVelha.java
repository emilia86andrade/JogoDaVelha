package br.com.jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[]args){

        System.out.println("------Jogo da Velha------\n");
        System.out.println(" Objetivo: Vence o jogador que conseguir formar primeiro \n uma linha com três " +
                "símbolos iguais, seja ela na horizontal, \n vertical ou diagonal.\n");

        System.out.println("Jogador X digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        String jogador1 = scanner.next();
        System.out.println("Jogador O digite seu nome: ");
        String jogador2 = scanner.next();
        scanner.close();

        System.out.println(jogador1 + " escolha a posição");
}
