package com.betrybe.sistemadevotacao;

/**
 * Represents an eligible voter in the voting system. Extends the abstract class Pessoa.
 */
public class PessoaEleitora extends Pessoa {

  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    this.cpf = cpf;
    super.nome = nome;
  }

  /**
   * Retrieves the CPF (Cadastro de Pessoas Físicas) of the voter.
   *
   * @return The CPF of the voter.
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Sets the CPF (Cadastro de Pessoas Físicas) of the voter.
   *
   * @param cpf The CPF of the voter.
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
