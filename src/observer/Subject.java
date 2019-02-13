package observer;

/**
 * interfata pentru Subject din Design Pattern Observer 
 * @author mihai
 *
 */
public interface Subject {
	
	/**
	 * metoda care notifica toti observatori care urmaresc feed-ul
	 * @param name numele stock-ului
	 * @param value valoarea stock-ului
	 */
	public abstract void notifyAllObservers(String name, String value);
	
	/**
	 * metoda care aduga un observator, la feed
	 * @param observer obiectul de tip Observer creat
	 * @param obs_id id-ul repectivului observator
	 */
	public abstract void addObserver(Observer observer, Integer obs_id);
	
	/**
	 * metoda care dezataseaza/elimina un observator de la feed
	 * @param obs_id id-ul observatorului ce urmeaza sa fie dezatasat
	 */
	public abstract void deleteObserver(Integer obs_id);

}
