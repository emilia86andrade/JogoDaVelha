package br.com.jogodavelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {

        System.out.println("------Jogo da Velha------\n");
        System.out.println(" Objetivo: Vence o jogador que conseguir formar primeiro \n uma linha com três " +
                "símbolos iguais, seja ela na horizontal, \n vertical ou diagonal.\n");
        System.out.println(" Regra: Jogador, durante a sua vez, escolha apenas uma posição \n que está escrita " +
                "na tela.\n");

        System.out.println("Jogador X digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        String jogador1 = scanner.next();
        System.out.println("Jogador O digite seu nome: ");
        String jogador2 = scanner.next();

        int vitoriasJogador1 = 0;
        int vitoriasJogador2 = 0;
        char[][] tabuleiro = new char[3][3];

        int continuaJogando = 1;
        //loop para jogar novamente
        while (continuaJogando == 1) {
            boolean testeDeJogada1 = true;
            boolean testeDeJogada2 = true;
            boolean testeDeJogada3 = true;
            boolean testeDeJogada4 = true;
            boolean testeDeJogada5 = true;
            boolean testeDeJogada6 = true;
            boolean testeDeJogada7 = true;
            boolean testeDeJogada8 = true;
            boolean testeDeJogada9 = true;
            int jogadas = 1;
            int vencedor = 0;
            inciaTabuleiro(tabuleiro);
            while (vencedor == 0 && jogadas <= 9) {
                char simbolo;
                int erroJogada;
                do {
                    mostraTabuleiro(tabuleiro);
                    erroJogada = 0;
                    if (numImpar(jogadas)) {
                        simbolo = 'X';
                        System.out.println("\nJogador " + jogador1 + " escolha uma posição de 1 a 9 para marcar o X: ");
                    } else {
                        simbolo = 'O';
                        System.out.println("\nJogador " + jogador2 + " escolha uma posição de 1 a 9 para marcar o O: ");
                    }
                    char jogada = scanner.next().charAt(0);

                    //foi criado um booleano para verificar se a posição já foi selecionada
                    switch (jogada) {
                        case '1':
                            if (testeDeJogada1 == true) {
                                testeDeJogada1 = false;
                                tabuleiro[0][0] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        case '2':
                            if (testeDeJogada2 == true) {
                                testeDeJogada2 = false;
                                tabuleiro[0][1] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        case '3':
                            if (testeDeJogada3 == true) {
                                testeDeJogada3 = false;
                                tabuleiro[0][2] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        case '4':
                            if (testeDeJogada4 == true) {
                                testeDeJogada4 = false;
                                tabuleiro[1][0] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        case '5':
                            if (testeDeJogada5 == true) {
                                testeDeJogada5 = false;
                                tabuleiro[1][1] = simbolo;
                            } else {
                                System.out.println("Essa opção já foi escolhida.");
                                erroJogada = 1;
                            }
                            break;
                        case '6':
                            if (testeDeJogada6 == true) {
                                testeDeJogada6 = false;
                                tabuleiro[1][2] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        case '7':
                            if (testeDeJogada7 == true) {
                                testeDeJogada7 = false;
                                tabuleiro[2][0] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        case '8':
                            if (testeDeJogada8 == true) {
                                testeDeJogada8 = false;
                                tabuleiro[2][1] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        case '9':
                            if (testeDeJogada9 == true) {
                                testeDeJogada9 = false;
                                tabuleiro[2][2] = simbolo;
                            } else {
                                erroJogada = 1;
                                System.out.println("Essa opção já foi escolhida.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida, é necessário digitar de 1 a 9!");
                            erroJogada = 1;
                    }
                } while (erroJogada == 1);

                //condicional para verificar vencedor
                if (jogadas >= 5) {
                    vencedor = verificaVencedor(tabuleiro);
                    if (vencedor == 1) {
                        System.out.printf("Parabéns, %s!!!\n", jogador1);
                        vitoriasJogador1++;
                    } else if (vencedor == 2) {
                        System.out.printf("Parabéns, %s!!!\n", jogador2);
                        vitoriasJogador2++;
                    }
                }

                //condicional para verificar empate
                if (jogadas == 9 && vencedor == 0) {
                    System.out.println("O resultado foi empate!\n");
                }
                jogadas++;
            }

            mostraTabuleiro(tabuleiro);

            System.out.println("\nFim da partida.\n");

            System.out.println("****** PLACAR PARCIAL ******");
            System.out.printf("Jogador X %s - %d vitórias\n", jogador1, vitoriasJogador1);
            System.out.printf("Jogador O %s - %d vitórias\n", jogador2, vitoriasJogador2);

            System.out.println("Deseja jogar novamente ? - Digite 1 para continuar ou 0 para encerrar o jogo");
            try {
                continuaJogando = scanner.nextInt();
                if (continuaJogando != 0 && continuaJogando != 1) {
                    System.out.println("Opção inválida, o jogo será encerrado!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Opção Incorreta! - "+e.getMessage());
                System.out.println("O jogo será encerrado!");
                continuaJogando = 0;
            }
        }
        System.out.println();

        //placar final
        System.out.println("** Fim de jogo **\n");
        System.out.println("****** PLACAR FINAL ******");
        System.out.printf("Jogador X %s - %d vitórias\n", jogador1, vitoriasJogador1);
        System.out.printf("Jogador O %s - %d vitórias\n", jogador2, vitoriasJogador2);
        if (vitoriasJogador1 > vitoriasJogador2) {
            System.out.printf("\nParabéns %s, você venceu!", jogador1);
        } else if (vitoriasJogador1 < vitoriasJogador2) {
            System.out.printf("\nParabéns %s, você venceu!", jogador2);
        } else {
            System.out.println("\nO resultado deu empate!");
        }

        scanner.close();
    }

    //função para desenhar tabuleiro
    public static void mostraTabuleiro(char[][] tabuleiro) {

        System.out.println("\n" + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println("----------");
        System.out.println(tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println("----------");
        System.out.println(tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);

    }

    //função para iniciar tabuleiro atribuindo valores numéricos para a matriz
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

    //função para veirificar se é o jogador X ou O
    public static boolean numImpar(int num) {
        return num % 2 == 1;
    }

    public static int verificaVencedor(char[][] tabuleiro) {

        //verificando linhas
        String linha1 = "" + tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2];
        String linha2 = "" + tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2];
        String linha3 = "" + tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2];

        //verificando colunas
        String coluna1 = "" + tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0];
        String coluna2 = "" + tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1];
        String coluna3 = "" + tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2];

        //verificando diagonais
        String diagonal1 = "" + tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        String diagonal2 = "" + tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];

        //verificação de vencedor ou empate
        if (linha1.equals("XXX") || linha2.equals("XXX") || linha3.equals("XXX") ||
                coluna1.equals("XXX") || coluna2.equals("XXX") || coluna3.equals("XXX") ||
                diagonal1.equals("XXX") || diagonal2.equals("XXX")) {
            System.out.println("\nJogador X VENCEU A RODADA!");
            return 1;
        }

        if (linha1.equals("OOO") || linha2.equals("OOO") || linha3.equals("OOO") ||
                coluna1.equals("OOO") || coluna2.equals("OOO") || coluna3.equals("OOO") ||
                diagonal1.equals("OOO") || diagonal2.equals("OOO")) {
            System.out.println("\nJogador O VENCEU A RODADA!");
            return 2;
        }
        return 0;
    }
}

