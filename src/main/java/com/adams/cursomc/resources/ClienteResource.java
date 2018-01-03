package com.adams.cursomc.resources;

import com.adams.cursomc.domain.Cliente;
import com.adams.cursomc.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteResource {

  private final ClienteService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity find(@PathVariable Integer id) {
    final Cliente cliente = service.buscar(id);
    return ResponseEntity.ok(cliente);
  }
}
