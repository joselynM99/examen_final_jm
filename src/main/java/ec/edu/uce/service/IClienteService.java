package ec.edu.uce.service;

import ec.edu.uce.modelo.Cliente;

public interface IClienteService {
	void insertar(Cliente cliente);

	void actualizar(Cliente cliente);

	Cliente buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
