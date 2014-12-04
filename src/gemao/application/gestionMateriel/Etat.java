package gemao.application.gestionMateriel;

public class Etat {
	private final long idEtat;
	private String libelleEtat;
	public Etat(long idEtat, String libelleEtat) {
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}
	public String getLibelleEtat() {
		return libelleEtat;
	}
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	public long getIdEtat() {
		return idEtat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEtat ^ (idEtat >>> 32));
		result = prime * result
				+ ((libelleEtat == null) ? 0 : libelleEtat.hashCode());
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
		Etat other = (Etat) obj;
		if (idEtat != other.idEtat)
			return false;
		if (libelleEtat == null) {
			if (other.libelleEtat != null)
				return false;
		} else if (!libelleEtat.equals(other.libelleEtat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Etat [idEtat=" + idEtat + ", libelleEtat=" + libelleEtat + "]";
	}
	
	
}
