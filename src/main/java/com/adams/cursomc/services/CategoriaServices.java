package com.adams.cursomc.services;

import com.adams.cursomc.domain.Categoria;
import com.adams.cursomc.repositories.CategoriaRepository;
import com.adams.cursomc.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoriaServices {

  private final CategoriaRepository repository;

  public Categoria buscar(Integer id) {
    final Categoria cat = repository.findOne(id);
    if (Objects.isNull(cat)) {
      throw new ObjectNotFoundException(
          "Objeto não encontrando! Id: " + id + ", tipo: " + Categoria.class.getName());
    }
    return cat;
  }
}
