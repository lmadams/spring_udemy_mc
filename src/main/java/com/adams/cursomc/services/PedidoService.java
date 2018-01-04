package com.adams.cursomc.services;

import com.adams.cursomc.domain.Pedido;
import com.adams.cursomc.repositories.PedidoRepository;
import com.adams.cursomc.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PedidoService {

  private final PedidoRepository repository;

  public Pedido buscar(Integer id) {
    final Pedido pedito = repository.findOne(id);
    if (Objects.isNull(pedito)) {
      throw new ObjectNotFoundException(
          "Objeto não encontrando! Id: " + id + ", tipo: " + Pedido.class.getName());
    }
    return pedito;
  }
}
