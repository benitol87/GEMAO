package gemao.IHM;

public interface IStartingScreen {
	/**
	 * M�thode permettant de r�cup�rer le login saisi au moment de la connexion
	 * @return un objet String contenant le login
	 */
	String getLogin();
	
	/**
	 * M�thode permettant de r�cup�rer le lot de passe saisi au moment de la connexion
	 * @return un objet String contenant le mot de passe
	 */
	String getPasswd();
	
	/**
	 * M�thode qui ferme la fen�tre de connexion
	 */
	void close();
}
