package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The entry point of the voting system program.
 */
public class Principal {

  /**
   * The main method that serves as the entry point of the program.
   *
   * @param args The command line arguments passed to the program.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    cadastroPessoasCandidata(gerenciamentoVotacao);
  }

  /**
   * Handles the registration of candidate persons.
   *
   * @param instancia The instance of GerenciamentoVotacao.
   */
  public static void cadastroPessoasCandidata(GerenciamentoVotacao instancia) {

    try (Scanner scanMenu = new Scanner(System.in)) {
      while (true) {
        System.out.println("Cadastrar pessoa candidata?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("Entre com o número correspondente à opção desejada:");
        int menuOptionCadidataInt = Integer.parseInt(scanMenu.nextLine());

        if (menuOptionCadidataInt == 2) {
          cadastroPessoasEleitoras(instancia, scanMenu);
          break;
        }
        if (menuOptionCadidataInt == 1) {
          System.out.println("Entre com o nome da pessoa candidata:");
          String nameCandidata = scanMenu.nextLine();

          System.out.println("Entre com o número da pessoa candidata:");
          int numeroCandidataInt = Integer.parseInt(scanMenu.nextLine());

          instancia.cadastrarPessoaCandidata(nameCandidata, numeroCandidataInt);
        }
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

  /**
   * Handles the registration of eligible voters.
   *
   * @param instancia The instance of GerenciamentoVotacao.
   */
  public static void cadastroPessoasEleitoras(GerenciamentoVotacao instancia, Scanner scanMenu) {
    try {
      while (true) {
        System.out.println("Cadastrar pessoa eleitora?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("Entre com o número correspondente à opção desejada:");
        int menuOptionEleitoraInt = Integer.parseInt(scanMenu.nextLine());

        if (menuOptionEleitoraInt == 2) {
          votacao(instancia, scanMenu);
          break;
        }
        if (menuOptionEleitoraInt == 1) {
          System.out.println("Entre com o nome da pessoa eleitora:");
          String nameEleitora = scanMenu.nextLine();

          System.out.println("Entre com o cpf da pessoa eleitora:");
          String numeroEleitora = scanMenu.nextLine();

          instancia.cadastrarPessoaEleitora(nameEleitora, numeroEleitora);
        }
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

  /**
   * Handles the voting process.
   *
   * @param instancia The instance of GerenciamentoVotacao.
   */
  public static void votacao(GerenciamentoVotacao instancia, Scanner scanMenu) {
    try {
      while (true) {
        System.out.println("Entre com o número correspondente à opção desejada:");
        System.out.println("1 - Votar");
        System.out.println("2 - Resultado Parcial");
        System.out.println("3 - Finalizar Votação");
        int menuOptionVotacaoInt = Integer.parseInt(scanMenu.nextLine());

        if (menuOptionVotacaoInt == 1) {
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpfEleitora = scanMenu.nextLine();

          System.out.println("Entre com o número da pessoa candidata:");
          int numeroEleitoraInt = Integer.parseInt(scanMenu.nextLine());

          instancia.votar(cpfEleitora, numeroEleitoraInt);
        }
        if (menuOptionVotacaoInt == 2) {
          instancia.mostrarResultado();
        }

        if (menuOptionVotacaoInt == 3) {
          instancia.mostrarResultado();
          break;
        }
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

}
