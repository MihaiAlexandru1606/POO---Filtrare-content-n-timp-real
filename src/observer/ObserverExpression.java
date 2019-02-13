package observer;

import java.util.TreeMap;

import expression.*;

/**
 * implenetrare observatorului care foloseste filtru cu expresie 
 * atributele clasei sunt : 
 * - stock: pentru stocare informatilor despre un stock 
 * - subject: subiectul pe care il "urmareste" observatorul( cazul nostru feed) 
 * - obs_id: id-ul observatorului 
 * - initializat: este folosita pentru a face distinctie intre feed-urile 
 * - tree: arborele de expresii, creat pentru un filtru
 * - evaluators: evalueaza daca un feed este valid
 * @author mihai
 *
 */
public class ObserverExpression extends Observer {

	private ExpressionTree tree;
	private ExpressionEvaluators evaluators;
	
	public ObserverExpression() {
		super();
	}

	public ObserverExpression(String[] infixExpression, Subject subject, Integer obs_id) {
		this.stocks = new TreeMap<String, InfoStock>();
		this.tree = new ExpressionTree(infixExpression);
		this.evaluators = ExpressionEvaluators.getInstance();
		this.obs_id = obs_id;
		this.subject = subject;
		this.subject.addObserver(this, obs_id);
		this.initializat = true;

	}

	/**
	 *  metoda aduaga/modifaca informatile despre un stock, in functie de cum
	 *  este evalua, daca feed trece de filtru sau nu
	 */
	@Override
	public void update(String name, String value) {
		// setarea numelui feed-ului si valuarea pentru a fi evaluat
		this.tree.setName(name);
		this.tree.setValue(value);

		if (this.tree.getRoot().accept(this.evaluators)) {
		// daca este valid
			
			if (!this.initializat) {
				// pentru fee-urile anterioare creari observatorului
				// se creaza un nou InfoStock cu numarul de schimbari = 0
				// in mod implicit cand se creaza un InfoStock, valuarea pentru
				// lastValueIsValid este true
				InfoStock newStock = new InfoStock(0, value);
				this.stocks.put(name, newStock);
				
			} else {
				// pentru feed-urile dupa crearea observatorului
				InfoStock stock = this.stocks.get(name);

				if (stock == null) {
					// daca acel stock nu exista
					// se creaza un nou InfoStock cu numarul de schimbari = 1
					// in mod implicit cand se creaza un InfoStock, valuarea pentru
					// lastValueIsValid este true
					InfoStock newStock = new InfoStock(1, value);
					this.stocks.put(name, newStock);
					
				} else {
					// daca exista respectivul stock
					// se actializeaza valuarea si se incrementeza numarul de schimbari
					// si se seteaza ca ultima valuare respecta filtrul
					stock.setNumberChanges(1 + stock.getNumberChanges());
					stock.setValue(value);
					stock.setLastValueIsValid(true);
				}
			}

		} else {
			// daca nu respecta filtrul
			InfoStock stock = this.stocks.get(name);
			
			if (stock != null) {
				// daca exista respectivul stock
				// se actializeaza valuarea si se incrementeza numarul de schimbari
				// si se seteaza ca ultima valuare nu respecta filtrul
				stock.setNumberChanges(1 + stock.getNumberChanges());
				stock.setLastValueIsValid(false);
				
			} else {

				if (this.initializat) {
					// se creaza un nou InfoStock cu numarul de schimbari = 1
					// si se seteaza ca valuare nu este valida
					InfoStock newStock = new InfoStock(1, value);
					newStock.setLastValueIsValid(false);
					this.stocks.put(name, newStock);
					
				} else {
					// pentru fee-urile anterioare creari observatorului
					// se creaza un nou InfoStock cu numarul de schimbari = 0
					// si se seteaza ca valuare nu este valida
					InfoStock newStock = new InfoStock(0, value);
					newStock.setLastValueIsValid(false);
					this.stocks.put(name, newStock);
				}
			}
		}
	}

}
