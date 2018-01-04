package com.adams.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

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

  private Date instante;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
  private Pagamento pagamento;

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID")
  @JsonManagedReference
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "ENDERECO_ENTREGA_ID")
  private Endereco enderecoDeEntrega;
}
