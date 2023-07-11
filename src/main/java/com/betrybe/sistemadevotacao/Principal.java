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
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao(null, null, null);
    cadastroPessoasCandidata(gerenciamentoVotacao);
  }

  /**
   * Handles the registration of candidate persons.
   *
   * @param instancia The instance of GerenciamentoVotacao.
   */
  public static void cadastroPessoasCandidata(GerenciamentoVotacao instancia) {

    try (Scanner scanMenu = new Scanner(System.in)) {
      for (int i = 0; i <= 20; ++i) {
        System.out.println("Cadastrar pessoa candidata?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("Entre com o número correspondente à opção desejada:");
        String menuOptionCadidataString = scanMenu.next();
        int menuOptionCadidataInt = Integer.parseInt(menuOptionCadidataString);

        if (menuOptionCadidataInt == 2) {
          cadastroPessoasEleitoras(instancia);
          return;
        }
        if (menuOptionCadidataInt == 1) {
          System.out.println("Entre com o nome da pessoa candidata:");
          scanMenu.nextLine();
          String nameCandidata = scanMenu.nextLine();

          System.out.println("Entre com o número da pessoa candidata:");
          String numeroCandidataString = scanMenu.nextLine();
          int numeroCandidataInt = Integer.parseInt(numeroCandidataString);

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
  public static void cadastroPessoasEleitoras(GerenciamentoVotacao instancia) {
    try (Scanner scanMenu = new Scanner(System.in)) {
      for (int i = 0; i <= 20; ++i) {
        System.out.println("Cadastrar pessoa eleitora?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("Entre com o número correspondente à opção desejada:");
        String menuOptionEleitoraString = scanMenu.next();
        int menuOptionEleitoraInt = Integer.parseInt(menuOptionEleitoraString);

        if (menuOptionEleitoraInt == 2) {
          votacao(instancia);
          return;
        }
        if (menuOptionEleitoraInt == 1) {
          System.out.println("Entre com o nome da pessoa eleitora:");
          scanMenu.nextLine();
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
  public static void votacao(GerenciamentoVotacao instancia) {
    try (Scanner scanMenu = new Scanner(System.in)) {
      for (int i = 0; i <= 20; ++i) {
        System.out.println("Entre com o número correspondente à opção desejada:");
        System.out.println("1 - Votar");
        System.out.println("2 - Resultado Parcial");
        System.out.println("3 - Finalizar Votação");
        String menuOptionVotacaoString = scanMenu.next();
        int menuOptionVotacaoInt = Integer.parseInt(menuOptionVotacaoString);

        if (menuOptionVotacaoInt == 1) {
          System.out.println("Entre com o cpf da pessoa eleitora:");
          scanMenu.nextLine();
          String cpfEleitora = scanMenu.nextLine();

          System.out.println("Entre com o número da pessoa candidata:");
          String numeroEleitoraString = scanMenu.nextLine();
          int numeroEleitoraInt = Integer.parseInt(numeroEleitoraString);

          instancia.votar(cpfEleitora, numeroEleitoraInt);
        }
        if (menuOptionVotacaoInt == 2) {
          instancia.mostrarResultado();
        }

        if (menuOptionVotacaoInt == 3) {
          return;
        }
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

}
