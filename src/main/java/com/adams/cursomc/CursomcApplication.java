package com.adams.cursomc;

import com.adams.cursomc.domain.Categoria;
import com.adams.cursomc.domain.Cidade;
import com.adams.cursomc.domain.Estado;
import com.adams.cursomc.domain.Produto;
import com.adams.cursomc.repositories.CategoriaRepository;
import com.adams.cursomc.repositories.CidadeRepository;
import com.adams.cursomc.repositories.EstadoRepository;
import com.adams.cursomc.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class CursomcApplication implements CommandLineRunner {

  private final CategoriaRepository categoriaRepository;
  private final ProdutoRepository produtoRepository;
  private final CidadeRepository cidadeRepository;
  private final EstadoRepository estadoRepository;

  public static void main(String[] args) {
    SpringApplication.run(CursomcApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {

    // Categoria
    final Categoria cat1 = Categoria.builder().nome("Informática").build();
    final Categoria cat2 = Categoria.builder().nome("Escritório").build();

    // Produto
    final Produto prod1 = Produto.builder().nome("Computador").preco(2000.0).build();
    final Produto prod2 = Produto.builder().nome("Impressora").preco(200.0).build();
    final Produto prod3 = Produto.builder().nome("Mouse").preco(80.0).build();

    cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
    cat2.getProdutos().addAll(Arrays.asList(prod2));

    prod1.getCategorias().addAll(Arrays.asList(cat1));
    prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
    prod3.getCategorias().addAll(Arrays.asList(cat1));

    categoriaRepository.save(Arrays.asList(cat1, cat2));
    produtoRepository.save(Arrays.asList(prod1, prod2, prod3));

    // Estado
    final Estado est1 = Estado.builder().nome("Paraná").build();
    final Estado est2 = Estado.builder().nome("São Paulo").build();

    // Cidade
    final Cidade cid1 = Cidade.builder().nome("Curitiba").estado(est1).build();
    final Cidade cid2 = Cidade.builder().nome("São Paulo").estado(est2).build();
    final Cidade cid3 = Cidade.builder().nome("Campinas").estado(est2).build();

    est1.getCidades().addAll(Arrays.asList(cid1));
    est2.getCidades().addAll(Arrays.asList(cid2, cid3));

    estadoRepository.save(Arrays.asList(est1, est2));
    cidadeRepository.save(Arrays.asList(cid1, cid2, cid3));
  }
}
