package com.adams.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pedido implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date instante;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
  private Pagamento pagamento;

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "ENDERECO_ENTREGA_ID")
  private Endereco enderecoDeEntrega;

  @Builder.Default
  @OneToMany(mappedBy = "id.pedido")
  @JsonIgnore
  private Set<ItemPedido> itens = new HashSet<>();

  @Override
  public String toString() {
    return "Pedido{"
        + "id="
        + id
        + ", instante="
        + instante
        + ", pagamento="
        + pagamento
        + ", cliente="
        + cliente
        + ", enderecoDeEntrega="
        + enderecoDeEntrega
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Pedido pedido = (Pedido) o;
    return Objects.equals(id, pedido.id)
        && Objects.equals(instante, pedido.instante)
        && Objects.equals(pagamento, pedido.pagamento)
        && Objects.equals(cliente, pedido.cliente)
        && Objects.equals(enderecoDeEntrega, pedido.enderecoDeEntrega);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), id, instante, pagamento, cliente, enderecoDeEntrega);
  }
}
