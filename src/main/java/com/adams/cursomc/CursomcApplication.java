package com.adams.cursomc;

import com.adams.cursomc.domain.Categoria;
import com.adams.cursomc.domain.Cidade;
import com.adams.cursomc.domain.Cliente;
import com.adams.cursomc.domain.Endereco;
import com.adams.cursomc.domain.Estado;
import com.adams.cursomc.domain.ItemPedido;
import com.adams.cursomc.domain.Pagamento;
import com.adams.cursomc.domain.PagamentoComBoleto;
import com.adams.cursomc.domain.PagamentoComCartao;
import com.adams.cursomc.domain.Pedido;
import com.adams.cursomc.domain.Produto;
import com.adams.cursomc.domain.enuns.EstadoPagamento;
import com.adams.cursomc.domain.enuns.TipoCliente;
import com.adams.cursomc.repositories.CategoriaRepository;
import com.adams.cursomc.repositories.CidadeRepository;
import com.adams.cursomc.repositories.ClienteRepository;
import com.adams.cursomc.repositories.EnderecoRepository;
import com.adams.cursomc.repositories.EstadoRepository;
import com.adams.cursomc.repositories.ItemPedidoRepository;
import com.adams.cursomc.repositories.PagamentoRepository;
import com.adams.cursomc.repositories.PedidoRepository;
import com.adams.cursomc.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
@RequiredArgsConstructor
public class CursomcApplication implements CommandLineRunner {

  private final CategoriaRepository categoriaRepository;
  private final ProdutoRepository produtoRepository;
  private final CidadeRepository cidadeRepository;
  private final EstadoRepository estadoRepository;
  private final ClienteRepository clienteRepository;
  private final EnderecoRepository enderecoRepository;
  private final PedidoRepository pedidoRepository;
  private final PagamentoRepository pagamentoRepository;
  private final ItemPedidoRepository itemPedidoRepository;

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
    cat2.getProdutos().addAll(Collections.singletonList(prod2));

    prod1.getCategorias().addAll(Collections.singletonList(cat1));
    prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
    prod3.getCategorias().addAll(Collections.singletonList(cat1));

    categoriaRepository.save(Arrays.asList(cat1, cat2));
    produtoRepository.save(Arrays.asList(prod1, prod2, prod3));

    // Estado
    final Estado est1 = Estado.builder().nome("Paraná").build();
    final Estado est2 = Estado.builder().nome("São Paulo").build();

    // Cidade
    final Cidade cid1 = Cidade.builder().nome("Curitiba").estado(est1).build();
    final Cidade cid2 = Cidade.builder().nome("São Paulo").estado(est2).build();
    final Cidade cid3 = Cidade.builder().nome("Campinas").estado(est2).build();

    est1.getCidades().addAll(Collections.singletonList(cid1));
    est2.getCidades().addAll(Arrays.asList(cid2, cid3));

    estadoRepository.save(Arrays.asList(est1, est2));
    cidadeRepository.save(Arrays.asList(cid1, cid2, cid3));

    // Cliente
    final Cliente clie1 =
        Cliente.builder()
            .nome("Maria Silva")
            .email("maria@gmail.com")
            .cpfOuCnpj("123123123123")
            .tipo(TipoCliente.PESSOA_FISICA)
            .build();

    // Telefones
    clie1.getTelefones().addAll(Arrays.asList("123123123123", "312321321321"));

    // Endereco
    final Endereco e1 =
        Endereco.builder()
            .logradouro("Rua Flores")
            .numero("300")
            .complemento("Apto 303")
            .bairro("Jardim")
            .cep("123123123")
            .cliente(clie1)
            .cidade(cid1)
            .build();

    final Endereco e2 =
        Endereco.builder()
            .logradouro("Avenida Matos")
            .numero("105")
            .complemento("Sala 800")
            .bairro("Centro")
            .cep("31231231233")
            .cliente(clie1)
            .cidade(cid2)
            .build();

    clie1.getEnderecos().addAll(Arrays.asList(e1, e2));

    clienteRepository.save(Collections.singletonList(clie1));
    enderecoRepository.save(Arrays.asList(e1, e2));

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    // Pedido
    final Pedido pedido1 =
        Pedido.builder()
            .instante(sdf.parse("30/09/2017 10:32"))
            .cliente(clie1)
            .enderecoDeEntrega(e1)
            .build();

    final Pedido pedido2 =
        Pedido.builder()
            .instante(sdf.parse("10/10/2017 10:32"))
            .cliente(clie1)
            .enderecoDeEntrega(e2)
            .build();

    final Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
    pedido1.setPagamento(pag1);

    final Pagamento pag2 =
        new PagamentoComBoleto(
            null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
    pedido2.setPagamento(pag2);

    clie1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

    pedidoRepository.save(Arrays.asList(pedido1, pedido2));
    pagamentoRepository.save(Arrays.asList(pag1, pag2));

    // Itens de pedido
    final ItemPedido ip1 = new ItemPedido(pedido1, prod1, 0.0, 1, 2000.0);
    final ItemPedido ip2 = new ItemPedido(pedido1, prod3, 0.0, 2, 80.0);
    final ItemPedido ip3 = new ItemPedido(pedido2, prod2, 100.0, 1, 800.0);

    pedido1.setItens(new HashSet<>(Arrays.asList(ip1, ip2)));
    pedido2.setItens(new HashSet<>(Collections.singletonList(ip3)));

    prod1.setItens(new HashSet<>(Collections.singletonList(ip1)));
    prod2.setItens(new HashSet<>(Collections.singletonList(ip3)));
    prod3.setItens(new HashSet<>(Collections.singletonList(ip2)));

    itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
  }
}
