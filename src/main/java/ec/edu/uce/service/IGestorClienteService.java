package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Vuelo;

public interface IGestorClienteService {

	List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fechaVuelo);
	
	void reservarPasajesAereos(String numeroVuelo, Integer cantidadAsientos, String numeroTarjeta);

}
