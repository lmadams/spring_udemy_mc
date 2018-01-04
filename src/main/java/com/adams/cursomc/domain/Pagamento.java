package com.adams.cursomc.domain;

import com.adams.cursomc.domain.enuns.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento {

  @Id private Integer id;

  @Enumerated(EnumType.STRING)
  private EstadoPagamento estado;

  @OneToOne
  @JoinColumn(name = "PEDIDO_ID")
  @MapsId
  private Pedido pedido;
}
