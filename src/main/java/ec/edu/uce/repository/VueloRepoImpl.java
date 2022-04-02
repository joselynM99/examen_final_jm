package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Vuelo;

@Transactional
@Repository
public class VueloRepoImpl implements IVueloRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vuelo vuelo) {
		this.entityManager.persist(vuelo);
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		this.entityManager.merge(vuelo);
	}

	@Override
	public Vuelo buscarPorID(Integer id) {
		return this.entityManager.find(Vuelo.class, id);
	}

	@Override
	public void borrarPorId(Integer id) {
		Vuelo v = this.buscarPorID(id);
		this.entityManager.remove(v);
	}

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fecha) {

		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v WHERE v.origen =: origen AND v.destino=:destino AND v.fecha =:fecha",
				Vuelo.class);

		myQuery.setParameter("origen", origen);
		myQuery.setParameter("destino", destino);
		myQuery.setParameter("fecha", fecha);

		return myQuery.getResultList();
	}

	@Override
	public Vuelo buscarPorNumero(String numero) {
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery("SELECT v FROM Vuelo v WHERE v.numero =:numero",
				Vuelo.class);

		myQuery.setParameter("numero", numero);

		return myQuery.getSingleResult();
	}

}
