package ec.edu.uce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Avion;
import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Vuelo;

@SpringBootTest
@Transactional
@Rollback(true)
class ServiceImplTest {
	@Autowired
	private IAvionService avionService;
	@Autowired
	private IVueloService vueloService;

	@Autowired
	private IClienteService clienteService;

	@Test
	void testInsertarAvionVuelo() {
		Vuelo v = new Vuelo();
		v.setAsientosDisponibles(900);
		v.setAsientosOcupados(1100);
		v.setCategoria("E");
		v.setDestino("Quito");
		v.setEstado("D");
		v.setFechaVuelo(LocalDateTime.of(2022, 4, 20, 0, 0));
		v.setNumero("899");
		v.setOrigen("Guayaquil");

		Avion a = new Avion();
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		vuelos.add(v);

		a.setCapacidadAsientos(2000);
		a.setNombre("MDE8");
		a.setVuelos(vuelos);

		v.setAvion(a);

		this.vueloService.insertar(v);

		this.avionService.insertar(a);

		assertEquals(this.avionService.buscarPorID(a.getId()), a);
		assertEquals(this.vueloService.buscarPorNumero("899").getCategoria(), "E");

	}

	@Test
	void testInsertarCliente() {

		Cliente c = new Cliente();
		c.setApellido("Moncayo");
		c.setCedula("154102");
		c.setNombre("Joss");

		this.clienteService.insertar(c);

		assertEquals(this.clienteService.buscarPorID(c.getId()).getCedula(), "154102");

	}

}
