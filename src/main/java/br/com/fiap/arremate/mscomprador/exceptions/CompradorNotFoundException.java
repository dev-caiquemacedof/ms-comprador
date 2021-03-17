package br.com.fiap.arremate.mscomprador.exceptions;

public class CompradorNotFoundException extends RuntimeException {

  public CompradorNotFoundException() {
    super("Não foi possível encontrar um comprador ");
  }
}