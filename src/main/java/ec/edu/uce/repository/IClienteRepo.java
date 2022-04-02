package ec.edu.uce.repository;

import ec.edu.uce.modelo.Cliente;

public interface IClienteRepo {
	void insertar(Cliente cliente);

	void actualizar(Cliente cliente);

	Cliente buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
