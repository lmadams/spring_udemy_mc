package com.adams.cursomc.domain;

import com.adams.cursomc.domain.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pagamento implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id private Integer id;

  @Enumerated(EnumType.STRING)
  private EstadoPagamento estado;

  @OneToOne
  @JoinColumn(name = "PEDIDO_ID")
  @MapsId
  @JsonIgnore
  private Pedido pedido;
}
