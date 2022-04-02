package ec.edu.uce.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.modelo.Vuelo;
import ec.edu.uce.modelo.VueloTO;
import ec.edu.uce.service.IGestorClienteService;

@Controller
@RequestMapping("/clientes/")
public class GestorClienteController {

	@Autowired
	private IGestorClienteService gestorClienteService;

	Function<VueloTO, Vuelo> vuelo = vueloR -> {
		Vuelo v = new Vuelo();
		v.setOrigen(v.getOrigen());
		v.setDestino(v.getDestino());
		v.setFechaVuelo(v.getFechaVuelo());
		return v;
	};

	@GetMapping("buscarVuelos")
	public String obtenerPaginaIngresoDatosBusqueda(Vuelo vuelo) {

		return "vuelosDatos";
	}

	@GetMapping("vuelosDisponibles")
	public String obtenerVuelosDisponivles(VueloTO vuelo, Model modelo) {

		List<Vuelo> vuelos = this.gestorClienteService.buscarVuelosDisponibles(vuelo.getOrigen(), vuelo.getDestino(),
				vuelo.getFechaVuelo());
		modelo.addAttribute("vuelos", vuelos);
		return "vuelosDisponibles";
	}

}
