package com.adams.cursomc.domain;

import com.adams.cursomc.domain.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class PagamentoComBoleto extends Pagamento {
  private static final long serialVersionUID = 1L;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataVencimento;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataPagamento;

  public PagamentoComBoleto(
      Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
    super(id, estado, pedido);
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
  }
}
