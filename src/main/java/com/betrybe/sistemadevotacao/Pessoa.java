package com.betrybe.sistemadevotacao;

/**
 * Abstract class representing a Person.
 */
public abstract class Pessoa {

  private String nome;

  /**
   * Retrieves the name of the Person.
   *
   * @return The name of the Person.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Sets the name of the Person.
   *
   * @param nome The name of the Person.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }
}
