package com.adams.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String logradouro;

  private String numero;

  private String complemento;

  private String bairro;

  private String cep;

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID")
  @JsonBackReference
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "CIDADE_ID")
  private Cidade cidade;
}
