package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CompraPasaje;
import ec.edu.uce.modelo.Vuelo;

@Transactional
@Repository
public class CompraPasajeRepoImpl implements ICompraPasajeRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CompraPasaje compra) {
		this.entityManager.persist(compra);
	}

	@Override
	public void actualizar(CompraPasaje compra) {
		this.entityManager.merge(compra);
	}

	@Override
	public CompraPasaje buscarPorID(Integer id) {
		return this.entityManager.find(CompraPasaje.class, id);
	}

	@Override
	public void borrarPorId(Integer id) {
		CompraPasaje cp = this.buscarPorID(id);
		this.entityManager.remove(cp);
	}

	@Override
	public CompraPasaje buscarCompraPorNumero(String numero) {

		TypedQuery<CompraPasaje> myQuery = this.entityManager
				.createQuery("SELECT c FROM CompraPasaje c WHERE c.numero =:numero", CompraPasaje.class);

		myQuery.setParameter("numero", numero);

		return myQuery.getSingleResult();

	}

}
