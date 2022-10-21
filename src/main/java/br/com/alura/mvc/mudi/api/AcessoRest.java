package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.interceptor.InterceptadorAcesso;
import br.com.alura.mvc.mudi.interceptor.InterceptadorAcesso.Acesso;

@RestController
@RequestMapping("/acessos")
public class AcessoRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorAcesso.acessos;
	}

}
