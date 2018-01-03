package com.adams.cursomc.services;

import com.adams.cursomc.domain.Cliente;
import com.adams.cursomc.repositories.ClienteRepository;
import com.adams.cursomc.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClienteService {

  private final ClienteRepository repository;

  public Cliente buscar(Integer id) {
    final Cliente cli = repository.findOne(id);
    if (Objects.isNull(cli)) {
      throw new ObjectNotFoundException(
          "Objeto não encontrando! Id: " + id + ", tipo: " + Cliente.class.getName());
    }
    return cli;
  }
}
