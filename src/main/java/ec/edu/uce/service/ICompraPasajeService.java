package ec.edu.uce.service;

import ec.edu.uce.modelo.CompraPasaje;

public interface ICompraPasajeService {
	
	void insertar(CompraPasaje compra);

	void actualizar(CompraPasaje compra);

	CompraPasaje buscarPorID(Integer id);

	void borrarPorId(Integer id);
	
	CompraPasaje buscarCompraPorNumero(String numero);

}
