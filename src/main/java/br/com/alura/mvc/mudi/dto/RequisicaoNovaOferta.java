package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {

	private Long pedidoId;
	
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$",message = "O campo deve ser no formato .00")
	private String valorOferta;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$",message = "O campo deve ser no formato dd/mm/yyyy")
	private String dataEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(String valorOferta) {
		this.valorOferta = valorOferta;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setId(this.pedidoId);
		oferta.setValorOferta(new BigDecimal(this.valorOferta));
		oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return oferta;
	}
}
