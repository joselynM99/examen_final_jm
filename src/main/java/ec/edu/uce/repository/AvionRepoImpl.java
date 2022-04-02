package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Avion;

@Transactional
@Repository
public class AvionRepoImpl implements IAvionRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Avion avion) {
		this.entityManager.persist(avion);
	}

	@Override
	public void actualizar(Avion avion) {
		this.entityManager.merge(avion);
	}

	@Override
	public Avion buscarPorID(Integer id) {
		return this.entityManager.find(Avion.class, id);
	}

	@Override
	public void borrarPorId(Integer id) {
		Avion a = this.buscarPorID(id);
		this.entityManager.remove(a);
	}

}
