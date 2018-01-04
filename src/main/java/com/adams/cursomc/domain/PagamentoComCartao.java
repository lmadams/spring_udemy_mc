package com.adams.cursomc.domain;

import com.adams.cursomc.domain.enuns.EstadoPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Data
@Entity
public class PagamentoComCartao extends Pagamento {
  private static final long serialVersionUID = 1L;

  private Integer numeroDeParcelas;

  public PagamentoComCartao(
      Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
    super(id, estado, pedido);
    this.numeroDeParcelas = numeroDeParcelas;
  }
}
