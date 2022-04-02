package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Vuelo;

public interface IVueloRepo {
	
	void insertar(Vuelo vuelo);

	void actualizar(Vuelo vuelo);

	Vuelo buscarPorID(Integer id);

	void borrarPorId(Integer id);

	List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fecha);

	Vuelo buscarPorNumero(String numero);

}
