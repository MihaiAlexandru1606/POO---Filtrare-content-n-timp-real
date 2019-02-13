package observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * clasa care implementeaza Subject, clasa tine o evidenta a observatorilor
 *  si a feed-udurilor, de aceaia este folosita pentru printrarea si
 *  dezatasarea unui observator
 * cum nu avem nevoie de mai mult de o instanata a acestei clase 
 *  s-a folosit Singleton
 * atributele clasei sunt:
 * - feeds: ultimele valori pentru un stock, folosit la initierea unui nou observator
 * - observers : un hash care contine observatori care "urmaresc" feed-ul, 
 * 		ei sunt  stocati dupa id
 * @author mihai
 *
 */
public class Feed implements Subject {

	private static Feed instance = null;
	private HashMap<String, String> feeds;
	private HashMap<Integer, Observer> observers;

	private Feed() {
		this.observers = new HashMap<Integer, Observer>();
		this.feeds = new HashMap<String, String>();
	}

	public static Feed getInstance() {
		if(instance == null) {
			instance = new Feed();
		}
		
		return instance;
	}
	
	/**
	 * metoda care adauga un nou feed la feeds, si  anunta observatori ca
	 *  subiectul si-a schimbat starea
	 * @param name numele stock-ului
	 * @param value valoarea stock-ului
	 */
	public void setState(String name, String value) {
		this.feeds.put(name, value);
		if( !this.observers.isEmpty() )
			notifyAllObservers(name, value);

	}

	/**
	 * metoda care notifica toti cand subiectul isi schimba starea, 
	 * cand primeste un nou feed
	 */
	@Override
	public void notifyAllObservers(String name, String value) {
		Set<Entry<Integer, Observer>> entrySet = this.observers.entrySet();

		for (Map.Entry<Integer, Observer> entry : entrySet) {
			entry.getValue().update(name, value);
		}
	}

	/**
	 * metoda care adauga un observator si il notifica despre 
	 * 	feed-urile anterioare
	 */
	@Override
	public void addObserver(Observer observer, Integer obs_id) {
		this.observers.put(obs_id, observer);
		
		Set<Entry<String, String>> entrySet = this.feeds.entrySet();

		for (Map.Entry<String, String> entry : entrySet) {
			observer.update(entry.getKey(), entry.getValue());
		}

	}

	/**
	 * metoda dezataseaza observatorul cu id-ul obs_id
	 */
	@Override
	public void deleteObserver(Integer obs_id) {
		this.observers.remove(obs_id);

	}

	/**
	 * metoda apeleaza metoda print a observatorului cu id-ul obs_id
	 * @param obs_id id-ul pentru care s-a apelat comanda print
	 */
	public void printObserver(Integer obs_id) {
		this.observers.get(obs_id).print(obs_id);
	}

}
