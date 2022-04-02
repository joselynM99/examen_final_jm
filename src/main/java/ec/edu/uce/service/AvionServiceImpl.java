package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Avion;
import ec.edu.uce.repository.IAvionRepo;

@Service
public class AvionServiceImpl implements IAvionService {

	@Autowired
	private IAvionRepo avionRepo;

	@Override
	public void insertar(Avion avion) {
		this.avionRepo.insertar(avion);
	}

	@Override
	public void actualizar(Avion avion) {
		// TODO Auto-generated method stub
		this.avionRepo.actualizar(avion);
	}

	@Override
	public Avion buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.avionRepo.buscarPorID(id);
	}

	@Override
	public void borrarPorId(Integer id) {
		this.avionRepo.borrarPorId(id);
	}

}
