package com.adams.cursomc.domain;

import com.adams.cursomc.domain.enuns.TipoCliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cliente implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  private String email;

  private String cpfOuCnpj;

  @Enumerated(value = EnumType.STRING)
  private TipoCliente tipo;

  @Builder.Default
  @OneToMany(mappedBy = "cliente")
  @JsonManagedReference
  private List<Endereco> enderecos = new ArrayList<>();

  @Builder.Default
  @ElementCollection
  @CollectionTable(name = "TELEFONES")
  private Set<String> telefones = new HashSet<>();

  @Builder.Default
  @OneToMany(mappedBy = "cliente")
  @JsonBackReference
  private List<Pedido> pedidos = new ArrayList<>();

  @Override
  public String toString() {
    return "Cliente{"
        + "id="
        + id
        + ", nome='"
        + nome
        + '\''
        + ", email='"
        + email
        + '\''
        + ", cpfOuCnpj='"
        + cpfOuCnpj
        + '\''
        + ", tipo="
        + tipo
        + '}';
  }
}
