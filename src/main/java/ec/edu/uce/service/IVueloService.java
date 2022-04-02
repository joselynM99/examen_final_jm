package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Vuelo;

public interface IVueloService {

	void insertar(Vuelo vuelo);

	void actualizar(Vuelo vuelo);

	Vuelo buscarPorID(Integer id);

	void borrarPorId(Integer id);

	List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fecha);

	Vuelo buscarPorNumero(String numero);

}
