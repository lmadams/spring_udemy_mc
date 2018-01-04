package com.adams.cursomc.resources;

import com.adams.cursomc.domain.Pedido;
import com.adams.cursomc.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidoResource {

  private final PedidoService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity find(@PathVariable Integer id) {
    final Pedido pedito = service.buscar(id);
    return ResponseEntity.ok(pedito);
  }
}
