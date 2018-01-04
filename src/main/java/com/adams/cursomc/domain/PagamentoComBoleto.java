package com.adams.cursomc.domain;

import com.adams.cursomc.domain.enuns.EstadoPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class PagamentoComBoleto extends Pagamento {

  private Date dataVencimento;

  private Date dataPagamento;

  public PagamentoComBoleto(
      Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
    super(id, estado, pedido);
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
  }
}
