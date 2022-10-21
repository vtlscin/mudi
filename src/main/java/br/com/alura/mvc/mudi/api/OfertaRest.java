package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRest {
	
	private PedidoRepository pedidoRepository;
	
	public OfertaRest(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		
		Optional<Pedido> retornoConsulta = pedidoRepository.findById(requisicao.getPedidoId());
		if(!retornoConsulta.isPresent()) {
			return null;
		}
		Oferta oferta = requisicao.toOferta();
		
		Pedido pedido = retornoConsulta.get();
		oferta.setPedido(pedido);
		pedido.getOfertas().add(oferta);
		pedidoRepository.save(pedido);
		return oferta;
	}
	
}
