package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.repository.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	public void insertar(Cliente cliente) {
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.clienteRepo.actualizar(cliente);
	}

	@Override
	public Cliente buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarPorID(id);
	}

	@Override
	public void borrarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepo.borrarPorId(id);
	}

}
