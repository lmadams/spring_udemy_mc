package com.adams.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Data
@Entity
public class ItemPedido implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonIgnore @EmbeddedId private ItemPedidoPK id = new ItemPedidoPK();

  private Double desconto;

  private Integer quantidade;

  private Double preco;

  public ItemPedido(
      Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
    id.setPedido(pedido);
    id.setProduto(produto);
    this.desconto = desconto;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  public Pedido getPedido() {
    return id.getPedido();
  }

  @JsonIgnore
  public Produto getProduto() {
    return id.getProduto();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    ItemPedido that = (ItemPedido) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), id);
  }

  @Override
  public String toString() {
    return "ItemPedido{"
        + "desconto="
        + desconto
        + ", quantidade="
        + quantidade
        + ", preco="
        + preco
        + '}';
  }
}
