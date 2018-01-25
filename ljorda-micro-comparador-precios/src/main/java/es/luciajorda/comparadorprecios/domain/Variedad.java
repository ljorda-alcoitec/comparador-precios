package es.luciajorda.comparadorprecios.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Variedad")
public class Variedad {
	
	public Variedad() {}
	
	public Variedad(Long id, Long idProducto, Long idFormato) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.idFormato = idFormato;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_variedad")
	private Long id;
	
	@Column(name="id_producto")
	private Long idProducto;
	
	@Column(name="id_formato")
	private Long idFormato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdFormato() {
		return idFormato;
	}

	public void setIdFormato(Long idFormato) {
		this.idFormato = idFormato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idFormato == null) ? 0 : idFormato.hashCode());
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
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
		Variedad other = (Variedad) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idFormato == null) {
			if (other.idFormato != null)
				return false;
		} else if (!idFormato.equals(other.idFormato))
			return false;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Variedad [id=" + id + ", idProducto=" + idProducto + ", idFormato=" + idFormato + "]";
	}
	
}
