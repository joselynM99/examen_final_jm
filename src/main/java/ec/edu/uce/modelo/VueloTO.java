package ec.edu.uce.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class VueloTO {

	private String origen;
	private String destino;

	public VueloTO() {

	}

	/**
	 * @param origen
	 * @param destino
	 * @param fechaVuelo
	 */
	public VueloTO(String origen, String destino, LocalDateTime fechaVuelo) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.fechaVuelo = fechaVuelo;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fechaVuelo;

	// Metodos set y get
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

}
