package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Represents the voting management system. Implements the GerenciamentoVotacaoInterface.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Constructs a GerenciamentoVotacao object with the specified lists of candidate persons,
   * eligible voters, and computed CPFs.
   *
   * @param pessoasCandidatas The list of candidate persons.
   * @param pessoasEleitoras The list of eligible voters.
   * @param cpfsComputados The list of computed CPFs.
   */
  public GerenciamentoVotacao(ArrayList<PessoaCandidata> pessoasCandidatas,
      ArrayList<PessoaEleitora> pessoasEleitoras, ArrayList<String> cpfsComputados) {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  /**
   * Registers a candidate person in the voting system.
   *
   * @param nome The name of the candidate.
   * @param numero The number of the candidate.
   */
  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidata : this.pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * Registers an eligible voter in the voting system.
   *
   * @param nome The name of the voter.
   * @param cpf The CPF (Cadastro de Pessoas Físicas) of the voter.
   */
  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora eleitora : this.pessoasEleitoras) {
      if (eleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  /**
   * Records a vote in the voting system.
   *
   * @param cpfPessoaEleitora The CPF of the voter.
   * @param numeroPessoaCandidata The number of the candidate.
   */
  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : this.cpfsComputados) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }
    for (PessoaCandidata candidata : this.pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata) {
        candidata.receberVoto();
        this.cpfsComputados.add(cpfPessoaEleitora);
        return;
      }
    }
  }

  /**
   * Displays the voting results.
   */
  @Override
  public void mostrarResultado() {
    int sumAllVotes = 0;

    for (PessoaCandidata candidata : this.pessoasCandidatas) {
      sumAllVotes += candidata.getVotos();

    }
    if (sumAllVotes == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (PessoaCandidata candidata : this.pessoasCandidatas) {
      double numberOfVoteCandidate = ((double) candidata.getVotos() / sumAllVotes) * 100;

      System.out.println("nome: " + candidata.getNome() + " - " + candidata.getVotos() + " votos"
          + " ( " + Math.round(numberOfVoteCandidate) + "%" + " )");
    }
    System.out.println("Total de votos: " + sumAllVotes);
  }

  /**
   * Retrieves the list of candidate persons.
   *
   * @return The list of candidate persons.
   */
  public ArrayList<PessoaCandidata> getPessoasCandidatas() {
    return pessoasCandidatas;
  }

  /**
   * Sets the list of candidate persons.
   *
   * @param pessoasCandidatas The list of candidate persons.
   */
  public void setPessoasCandidatas(ArrayList<PessoaCandidata> pessoasCandidatas) {
    this.pessoasCandidatas = pessoasCandidatas;
  }

  /**
   * Retrieves the list of eligible voters.
   *
   * @return The list of eligible voters.
   */
  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  /**
   * Sets the list of eligible voters.
   *
   * @param pessoasEleitoras The list of eligible voters.
   */
  public void setPessoasEleitoras(ArrayList<PessoaEleitora> pessoasEleitoras) {
    this.pessoasEleitoras = pessoasEleitoras;
  }

  /**
   * Retrieves the list of computed CPFs (Cadastro de Pessoas Físicas).
   *
   * @return The list of computed CPFs.
   */
  public ArrayList<String> getCpfsComputados() {
    return cpfsComputados;
  }

  /**
   * Sets the list of computed CPFs (Cadastro de Pessoas Físicas).
   *
   * @param cpfsComputados The list of computed CPFs.
   */
  public void setCpfsComputados(ArrayList<String> cpfsComputados) {
    this.cpfsComputados = cpfsComputados;
  }

}
