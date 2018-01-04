package com.adams.cursomc.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ItemPedidoPK implements Serializable {
  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "PEDIDO_ID")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "PRODUTO_ID")
  private Produto produto;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    ItemPedidoPK that = (ItemPedidoPK) o;
    return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), pedido, produto);
  }

  @Override
  public String toString() {
    return "ItemPedidoPK{" + "pedido=" + pedido + ", produto=" + produto + '}';
  }
}
