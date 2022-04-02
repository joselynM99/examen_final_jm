package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Vuelo;
import ec.edu.uce.repository.IVueloRepo;

@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepo vueloRepo;

	@Override
	public void insertar(Vuelo vuelo) {
		this.vueloRepo.insertar(vuelo);
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.vueloRepo.actualizar(vuelo);
	}

	@Override
	public Vuelo buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarPorID(id);
	}

	@Override
	public void borrarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.vueloRepo.borrarPorId(id);
	}

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fecha) {
		return this.vueloRepo.buscarVuelosDisponibles(origen, destino, fecha);
	}

	@Override
	public Vuelo buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarPorNumero(numero);
	}

}
