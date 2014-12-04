package gemao.application.gestionMateriel;

public class Marque {
	private final long idMarque;
	private String nomMarque;
	
	public Marque(long idMarque, String nomMarque) {
		this.idMarque = idMarque;
		this.nomMarque = nomMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public long getIdMarque() {
		return idMarque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idMarque ^ (idMarque >>> 32));
		result = prime * result
				+ ((nomMarque == null) ? 0 : nomMarque.hashCode());
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
		Marque other = (Marque) obj;
		if (idMarque != other.idMarque)
			return false;
		if (nomMarque == null) {
			if (other.nomMarque != null)
				return false;
		} else if (!nomMarque.equals(other.nomMarque))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Marque [idMarque=" + idMarque + ", nomMarque=" + nomMarque
				+ "]";
	}
	
	
}
