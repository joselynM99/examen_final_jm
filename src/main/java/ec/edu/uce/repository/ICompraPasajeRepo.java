package ec.edu.uce.repository;

import ec.edu.uce.modelo.CompraPasaje;

public interface ICompraPasajeRepo {
	
	void insertar(CompraPasaje compra);

	void actualizar(CompraPasaje compra);

	CompraPasaje buscarPorID(Integer id);

	void borrarPorId(Integer id);

	CompraPasaje buscarCompraPorNumero(String numero);

}
