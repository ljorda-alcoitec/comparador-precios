package es.luciajorda.comparadorprecios.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Formato")
public class Formato {
	
	public Formato() {}
	
	public Formato(long id, Integer unidades, Double cantidad, String unidad) {
		super();
		this.id = id;
		this.unidades = unidades;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_formato")
	private long id;
	
	@Column(name="unidades")
	private Integer unidades;
	
	@Column(name="cantidad")
	private Double cantidad;
	
	@Column(name="unidad")
	private String unidad;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
		result = prime * result + ((unidades == null) ? 0 : unidades.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formato other = (Formato) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (id != other.id)
			return false;
		if (unidad == null) {
			if (other.unidad != null)
				return false;
		} else if (!unidad.equals(other.unidad))
			return false;
		if (unidades == null) {
			if (other.unidades != null)
				return false;
		} else if (!unidades.equals(other.unidades))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Formato [id=" + id + ", unidades=" + unidades + ", cantidad=" + cantidad + ", unidad=" + unidad + "]";
	}
}
