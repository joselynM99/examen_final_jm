package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CompraPasaje;

@Service
public class GestorEmpleadoImpl implements IGestorEmpleados{
	
	@Autowired
	private ICompraPasajeService compraPasajeService;

	@Override
	public void realizarChekIn(String numeroCompra) {
		CompraPasaje c = this.compraPasajeService.buscarCompraPorNumero(numeroCompra);
		c.setEstado("I");
		
		this.compraPasajeService.actualizar(c);
	}

}
