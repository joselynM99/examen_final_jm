package ec.edu.uce.service;

import ec.edu.uce.modelo.Avion;

public interface IAvionService {
	
	void insertar(Avion avion);

	void actualizar(Avion avion);

	Avion buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
