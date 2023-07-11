package com.betrybe.sistemadevotacao;

/**
 * Represents a candidate person in the voting system. Extends the abstract class Pessoa.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Constructs a PessoaCandidata object with the specified number and name.
   *
   * @param numero The number of the candidate.
   * @param nome The name of the candidate.
   */
  public PessoaCandidata(String nome, int numero) {
    super.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  /**
   * Retrieves the number of the candidate.
   *
   * @return The number of the candidate.
   */
  public int getNumero() {
    return numero;
  }

  /**
   * Retrieves the number of votes received by the candidate.
   *
   * @return The number of votes received by the candidate.
   */
  public int getVotos() {
    return votos;
  }

  /**
   * Sets the number of the candidate.
   *
   * @param numero The number of the candidate.
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Sets the number of votes received by the candidate.
   *
   * @param votos The number of votes received by the candidate.
   */
  public void setVotos(int votos) {
    this.votos = votos;
  }

  /**
   * Increases the number of votes received by the candidate by 1.
   */
  public void receberVoto() {
    this.votos += 1;
  }

}
