package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Represents the voting management system. Implements the GerenciamentoVotacaoInterface.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private ArrayList<String> cpfsComputados = new ArrayList<>();

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
    this.pessoasCandidatas = pessoasCandidatas;
    this.pessoasEleitoras = pessoasEleitoras;
    this.cpfsComputados = cpfsComputados;
  }

  /**
   * Registers a candidate person in the voting system.
   *
   * @param nome The name of the candidate.
   * @param numero The number of the candidate.
   */
  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(numero, nome);
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
    for (PessoaEleitora eleitora : pessoasEleitoras) {
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
    // TODO Auto-generated method stub
  }

  /**
   * Displays the voting results.
   */
  @Override
  public void mostrarResultado() {
    // TODO Auto-generated method stub
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
