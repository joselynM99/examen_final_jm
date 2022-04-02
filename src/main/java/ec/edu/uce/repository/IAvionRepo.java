package ec.edu.uce.repository;

import ec.edu.uce.modelo.Avion;

public interface IAvionRepo {
	
	void insertar(Avion avion);

	void actualizar(Avion avion);

	Avion buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
