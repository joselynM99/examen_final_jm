package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CompraPasaje;
import ec.edu.uce.repository.ICompraPasajeRepo;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService {

	@Autowired
	private ICompraPasajeRepo compraPasajeRepo;

	@Override
	public void insertar(CompraPasaje compra) {
		this.compraPasajeRepo.insertar(compra);
	}

	@Override
	public void actualizar(CompraPasaje compra) {
		this.compraPasajeRepo.actualizar(compra);
	}

	@Override
	public CompraPasaje buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepo.buscarPorID(id);
	}

	@Override
	public void borrarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.compraPasajeRepo.borrarPorId(id);
	}

	@Override
	public CompraPasaje buscarCompraPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepo.buscarCompraPorNumero(numero);
	}

}
