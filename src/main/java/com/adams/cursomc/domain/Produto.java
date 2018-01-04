package com.adams.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Produto implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  private Double preco;

  @Builder.Default
  @ManyToMany
  @JsonIgnore
  @JoinTable(
    name = "PRODUTO_CATEGORIA",
    joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id")
  )
  private List<Categoria> categorias = new ArrayList<>();

  @Builder.Default
  @OneToMany(mappedBy = "id.produto")
  @JsonIgnore
  private Set<ItemPedido> itens = new HashSet<>();

  @JsonIgnore
  public List<Pedido> getPedidos() {
    List<Pedido> lista = new ArrayList<>();
    for (ItemPedido itemPedido : this.itens) {
      lista.add(itemPedido.getPedido());
    }
    return lista;
  }

  @Override
  public String toString() {
    return "Produto{" + "id=" + id + ", nome='" + nome + '\'' + ", preco=" + preco + '}';
  }
}
