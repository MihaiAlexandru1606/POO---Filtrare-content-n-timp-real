package observer;

import java.util.TreeMap;

/**
 * clasa care implementeaza observatorul cu filtrul "nil"
 *  atributele clasei sunt:
 * - stock: pentru stocare informatilor despre un stock 
 * - subject: subiectul pe care il "urmareste" observatorul( cazul nostru feed) 
 * - obs_id: id-ul observatorului 
 * - initializat: este folosita pentru a face distinctie intre feed-urile 
 * care exista inainte de crearea observatorului
 * 
 * @author mihai
 *
 */
public class ObserverNil extends Observer {

	public ObserverNil(Subject subject, Integer obs_id) {
		this.stocks = new TreeMap<String, InfoStock>();
		this.obs_id = obs_id;
		this.subject = subject;
		this.subject.addObserver(this, obs_id);
		this.initializat = true;
	}

	/**
	 * metoda aduaga/modifaca informatile despre un stock
	 */
	@Override
	public void update(String name, String value) {

		if (!this.initializat) {
			// pentru fee-urile anterioare creari observatorului
			// se creaza un nou InfoStock cu numarul de schimbari = 0
			InfoStock newStock = new InfoStock(0, value);
			this.stocks.put(name, newStock);
		} else {
			// pentru feed-urile dupa crearea observatorului
			InfoStock stock = this.stocks.get(name);

			if (stock == null) {
				// daca acel stock nu exista
				// se creaza un nou InfoStock cu numarul de schimbari = 1
				InfoStock newStock = new InfoStock(1, value);
				this.stocks.put(name, newStock);
			} else {
				// daca exista respectivul stock
				// se actializeaza valuarea si se incrementeza numarul de schimbari
				stock.setNumberChanges(1 + stock.getNumberChanges());
				stock.setValue(value);
			}
		}

	}

}
