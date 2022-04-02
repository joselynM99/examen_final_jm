package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "vuelo")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vuelo")
	@SequenceGenerator(name = "seq_vuelo", sequenceName = "seq_vuelo", allocationSize = 1)
	@Column(name = "vuel_id")
	private Integer id;

	@Column(name = "vuel_origen")
	private String origen;

	@Column(name = "vuel_destino")
	private String destino;

	@Column(name = "vuel_categoria")
	private String categoria;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "vuel_fechaVuelo")
	private LocalDateTime fechaVuelo;

	@Column(name = "vuel_asientos_disponibles")
	private Integer asientosDisponibles;

	@Column(name = "vuel_asientos_ocupados")
	private Integer asientosOcupados;

	@Column(name = "vuel_valorAsiento")
	private BigDecimal valor_asiento;

	@Column(name = "vuel_estado")
	private String estado;

	@Column(name = "vuel_numero")
	private String numero;

	@ManyToOne
	@JoinColumn(name = "avio_id")
	private Avion avion;

	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL) // sale del atributo de DetalleFactura
	private List<CompraPasaje> compras;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public Integer getAsientosOcupados() {
		return asientosOcupados;
	}

	public void setAsientosOcupados(Integer asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}

	public BigDecimal getValor_asiento() {
		return valor_asiento;
	}

	public void setValor_asiento(BigDecimal valor_asiento) {
		this.valor_asiento = valor_asiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<CompraPasaje> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraPasaje> compras) {
		this.compras = compras;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
