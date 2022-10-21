package br.com.alura.mvc.mudi.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	private PedidoRepository repository;
	
	public HomeController(PedidoRepository repositor) {
		this.repository = repositor;
	}

	@GetMapping
	public String home(Model model) {
		
		Pageable page = PageRequest.of(0, 5, Sort.by("dataEntrega").descending()); 
		
		Iterable<Pedido> pedidos = repository.findByStatus(StatusPedido.ENTREGUE, page);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
