package com.projetweb.cadproduto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetweb.cadproduto.entities.Categoria;
import com.projetweb.cadproduto.entities.Pedido;
import com.projetweb.cadproduto.entities.PedidoItem;
import com.projetweb.cadproduto.entities.Produto;
import com.projetweb.cadproduto.entities.Usuario;
import com.projetweb.cadproduto.entities.enums.PedidoStatus;
import com.projetweb.cadproduto.repositories.CategoriaRepository;
import com.projetweb.cadproduto.repositories.PedidoItemRepository;
import com.projetweb.cadproduto.repositories.PedidoRepository;
import com.projetweb.cadproduto.repositories.ProdutoRepository;
import com.projetweb.cadproduto.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository uR;
	@Autowired
	private PedidoRepository  pR;
	@Autowired
	private CategoriaRepository cR;
	@Autowired
	ProdutoRepository prodR;
	@Autowired
	private PedidoItemRepository piR;
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),PedidoStatus.PAGO, u1); //nos atributos pedidos há o cliente no qual é colocado no construtror para fazer a associacao 
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.ESPERANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ESPERANDO_PAGAMENTO,u1); 
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		cR.saveAll(Arrays.asList(cat1, cat2, cat3));
		uR.saveAll(Arrays.asList(u1,u2));
		pR.saveAll(Arrays.asList(p1,p2,p3));
		prodR.saveAll(Arrays.asList(pr1, pr2, pr3, pr4,pr5));
		
		
		pr1.getCategorias().add(cat2);
		pr2.getCategorias().add(cat1);
		pr2.getCategorias().add(cat3);
		pr3.getCategorias().add(cat3);
		pr4.getCategorias().add(cat3);
		pr5.getCategorias().add(cat2);
		
		prodR.saveAll(Arrays.asList(pr1, pr2, pr3, pr4,pr5));
		
		PedidoItem oi1 = new PedidoItem(p1, pr1, 2, pr1.getPreco());
		PedidoItem oi2 = new PedidoItem(p1, pr3, 1, pr3.getPreco());
		PedidoItem oi3 = new PedidoItem(p2, pr3, 2, pr3.getPreco());
		PedidoItem oi4 = new PedidoItem(p3, pr5, 2, pr5.getPreco());
		
		piR.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
}
