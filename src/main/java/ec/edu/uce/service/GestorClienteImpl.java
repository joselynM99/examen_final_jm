package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CompraPasaje;
import ec.edu.uce.modelo.Vuelo;

@Service
public class GestorClienteImpl implements IGestorClienteService {

	private static final Logger LOG = LoggerFactory.getLogger(GestorClienteImpl.class);

	@Autowired
	private IVueloService vueloService;

	@Autowired
	private ICompraPasajeService compraPasajeService;

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fechaVuelo) {

		Stream<Vuelo> vuelos = this.vueloService.buscarVuelosDisponibles(origen, destino, fechaVuelo).parallelStream();
		Stream<Vuelo> vuelosEconomicos = vuelos.filter(v -> v.getCategoria() == "E");
		Stream<Vuelo> vuelosNegocios = vuelos.filter(v -> v.getCategoria() == "N");
		Stream<Vuelo> vuelosTurista = vuelos.filter(v -> v.getCategoria() == "T");

		Stream<Vuelo> vuelosT = Stream.concat(vuelosEconomicos, vuelosNegocios);

		List<Vuelo> todosVuelos = Stream.concat(vuelosT, vuelosTurista).toList();
		return todosVuelos;
	}

	@Override
	public void reservarPasajesAereos(String numeroVuelo, Integer cantidadAsientos, String numeroTarjeta) {

		Vuelo v = this.vueloService.buscarPorNumero(numeroVuelo);

		if (v.getEstado() == "D") {

			LOG.info("Asientos disponibles" + v.getAsientosDisponibles() + " asientos ocupados: "
					+ v.getAsientosOcupados());

			v.setAsientosDisponibles(v.getAsientosDisponibles() - cantidadAsientos);
			v.setAsientosOcupados(v.getAsientosOcupados() + cantidadAsientos);

			if (v.getAsientosDisponibles() <= 0) {
				v.setEstado("ND");

			}
			CompraPasaje c = new CompraPasaje();
			c.setEstado("R");
			c.setCantidadAsientosComprados(cantidadAsientos);
			c.setNumeroTarjeta(numeroTarjeta);
			c.setFechaCompra(LocalDateTime.now());
			c.setVuelo(v);
			List<CompraPasaje> compras = v.getCompras();
			compras.add(c);

			v.setCompras(compras);
			this.compraPasajeService.insertar(c);
			this.vueloService.actualizar(v);

		} else {
			LOG.info("Asientos no disponibles");
		}

	}

}
