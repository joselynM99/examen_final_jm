package ec.edu.uce.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="avion")
public class Avion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avion")
	@SequenceGenerator(name = "seq_avion", sequenceName = "seq_avion", allocationSize = 1)
	@Column(name = "avio_id")
	private Integer id;
	
	@Column(name = "avio_nombre")
	private String nombre;
	
	@Column(name = "avio_capacidadAsientos")
	private Integer capacidadAsientos;
	
	@OneToMany(mappedBy = "avion", cascade = CascadeType.ALL) // sale del atributo de DetalleFactura
	private List<Vuelo> vuelos;
	
	//Metodos set y get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidadAsientos() {
		return capacidadAsientos;
	}

	public void setCapacidadAsientos(Integer capacidadAsientos) {
		this.capacidadAsientos = capacidadAsientos;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	

}
