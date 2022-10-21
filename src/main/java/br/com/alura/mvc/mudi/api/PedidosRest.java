package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	private PedidoRepository pedidoRepository;
	
	public PedidosRest(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOferta(){
		Pageable page = PageRequest.of(0, 5, Sort.by("id").descending()); 
		return pedidoRepository.findByStatusApi(StatusPedido.AGUARDANDO, page);
	}
	
}
