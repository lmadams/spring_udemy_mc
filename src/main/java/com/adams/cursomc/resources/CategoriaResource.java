package com.adams.cursomc.resources;

import com.adams.cursomc.domain.Categoria;
import com.adams.cursomc.services.CategoriaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
@RequiredArgsConstructor
public class CategoriaResource {

  private final CategoriaServices service;

  @GetMapping(value = "/{id}")
  public ResponseEntity find(@PathVariable Integer id) {
    final Categoria categoria = service.buscar(id);
    return ResponseEntity.ok(categoria);
  }
}
