package gemao.IHM;

public interface IStartingScreen {
	/**
	 * Méthode permettant de récupérer le login saisi au moment de la connexion
	 * @return un objet String contenant le login
	 */
	String getLogin();
	
	/**
	 * Méthode permettant de récupérer le lot de passe saisi au moment de la connexion
	 * @return un objet String contenant le mot de passe
	 */
	String getPasswd();
	
	/**
	 * Méthode qui ferme la fenêtre de connexion
	 */
	void close();
}
