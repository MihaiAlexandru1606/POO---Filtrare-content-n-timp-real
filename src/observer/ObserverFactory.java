package observer;

/**
 * clasa care creaza un obiecat de tip Observer
 * cum nu avem nevoie de mai mult de o instanata a acestei clase 
 * 	s-a folosit Singleton
 * @author mihai
 *
 */
public class ObserverFactory {

	private static ObserverFactory instance = null;

	private ObserverFactory() {
	}

	public static ObserverFactory getInstance() {
		if (instance == null) {
			instance = new ObserverFactory();
		}

		return instance;
	}
	
	/**
	 * metoda care creaza un nou obiect de tipul Observer
	 * @param typeObserver strinigul care indica tipul observatorului:"nil" sau
	 * 		"expression"
	 * @param subject "subiectul" obervatorului, in acest program va fi feed
	 * @param obs_id id-ul observatorului creat
	 * @param infixExpression  folosita pentru crearea arborelui, pentru 
	 * 		observatorul care foloseste arborele de expresii pentru filtrare 
	 * @return un nou obiect de tip Observer
	 */
	public Observer getObserverFactory(String typeObserver, 
			Subject subject, Integer obs_id, String[] infixExpression) {
		
		if( typeObserver.equals("nil") ) {
			return new ObserverNil( subject, obs_id);
		}else if( typeObserver.equals("expression") ) {
			return new ObserverExpression(infixExpression, subject, obs_id);
		}
		
		return null;// nu se intampla in program
	}

}
