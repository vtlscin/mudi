package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{

	@Cacheable("pedidos")
	List<Pedido> findByStatus(StatusPedido statusPedido, Pageable page);
	
	@Query("select p from Pedido p where p.status = :statusPedido")
	List<Pedido> findByStatusApi(StatusPedido statusPedido, Pageable page);
	
	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :statusPedido")
	List<Pedido> findByStatusAndUsuario(StatusPedido statusPedido, String username);
	
	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findByUsuario(String username);
}
