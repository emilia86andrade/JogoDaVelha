package br.com.jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {

        System.out.println("------Jogo da Velha------\n");
        System.out.println(" Objetivo: Vence o jogador que conseguir formar primeiro \n uma linha com três " +
                "símbolos iguais, seja ela na horizontal, \n vertical ou diagonal.\n");

        System.out.println("Jogador X digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        String jogador1 = scanner.next();
        System.out.println("Jogador O digite seu nome: ");
        String jogador2 = scanner.next();

        int vitoriasJogador1 = 0;
        int vitoriasJogador2 = 0;
        char[][] tabuleiro = new char[3][3];

        int continuaJogando = 1;
        while (continuaJogando == 1) {  //loop para jogar novamente

            int jogadas = 1;
            inciaTabuleiro(tabuleiro);

            while (jogadas <= 9) {
                mostraTabuleiro(tabuleiro);

                char simbolo;
                if (numImpar(jogadas)) {
                    simbolo = 'X';
                    System.out.println("\nJogador " + jogador1 + " escolha uma posição de 1 a 9 para marcar o X: ");

                } else {
                    simbolo = 'O';
                    System.out.println("\nJogador " + jogador2 + " escolha uma posição de 1 a 9 para marcar o O: ");
                }
                char jogada = scanner.next().charAt(0);
                //tratar o erro se escolher uma posicao que já foi escolhida ou que não existe

                switch (jogada) {
                    case '1':
                        tabuleiro[0][0] = simbolo;
                        break;
                    case '2':
                        tabuleiro[0][1] = simbolo;
                        break;
                    case '3':
                        tabuleiro[0][2] = simbolo;
                        break;
                    case '4':
                        tabuleiro[1][0] = simbolo;
                        break;
                    case '5':
                        tabuleiro[1][1] = simbolo;
                        break;
                    case '6':
                        tabuleiro[1][2] = simbolo;
                        break;
                    case '7':
                        tabuleiro[2][0] = simbolo;
                        break;
                    case '8':
                        tabuleiro[2][1] = simbolo;
                        break;
                    case '9':
                        tabuleiro[2][2] = simbolo;
                        break;
                    default:
                        break;
                }
                if (jogadas >= 5) {
                    //verifica se alguem ja ganhou
                    //se alguem já ganhou soma a vitoria na variavel, sai do loop e pergunta se que jogar de novo
                }
                if (jogadas == 9) {
                    //deu empate
                    //sai do loop e pergunta se quer jogar de novo

                }
                jogadas++;
            }
            System.out.println("Fim da partida\n");
            mostraTabuleiro(tabuleiro);
            System.out.println("Deseja jogar novamente ? - Digite 1 para continuar ou 0 para encerrar o jogo");
            try {
                continuaJogando = scanner.nextInt();
                if (continuaJogando != 0 && continuaJogando != 1) {
                    System.out.println("Opção inválida, o jogo será encerrado!");
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Opção Incorreta! - " + e.getMessage());
                System.out.println("O jogo será encerrado!");
                continuaJogando = 0;
            }
        }

        System.out.println("\n** Fim de jogo **\n");
        mostraTabuleiro(tabuleiro);
        //mostra o placar final

        scanner.close();

    }

    public static void mostraTabuleiro(char[][] tabuleiro) {

        System.out.println("\n" + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println("----------");
        System.out.println(tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println("----------");
        System.out.println(tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);

    }

    public static void inciaTabuleiro(char[][] tabuleiro) {
        //talvez por looping - decobrir como converte int pra char
        tabuleiro[0][0] = '1';
        tabuleiro[0][1] = '2';
        tabuleiro[0][2] = '3';
        tabuleiro[1][0] = '4';
        tabuleiro[1][1] = '5';
        tabuleiro[1][2] = '6';
        tabuleiro[2][0] = '7';
        tabuleiro[2][1] = '8';
        tabuleiro[2][2] = '9';
    }

    public static boolean numImpar(int num) {
        return num % 2 == 1;
    }
}
