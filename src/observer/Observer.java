package observer;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * clasa abstacta pentru pentru observatori
 * @author mihai
 *
 */
public abstract class Observer {
	
	protected Subject subject;
	protected TreeMap<String, InfoStock> stocks;
	protected Integer obs_id;
	protected boolean initializat = false;
	
	
	/**
	 * metoda prin care un observator este notificat daca subiectul isi schima 
	 * 	starea,
	 * @param name numele stock-ului
	 * @param value valoarea stock-ului
	 */
	public abstract void update(String name, String value);

	
	/**
	 * metoda care printeaza informatile filtrate  de observator
	 * @param obs_id id-ul observatorului
	 */
	public void print(Integer obs_id) {
		DecimalFormat df = new DecimalFormat("#.##");

		Set<Entry<String, InfoStock>> entrySet = this.stocks.entrySet();
		for (Map.Entry<String, InfoStock> entry : entrySet) {
			
			if (entry.getValue().isLastValueIsValid()) {

				System.out.println("obs " + this.obs_id + ": " + entry.getKey() + " "
						+ df.format(Double.parseDouble(entry.getValue().getValue())).replace(",", ".") + " "
						+ df.format(entry.getValue().getIncrease()).replace(",", ".") + "% "
						+ +entry.getValue().getNumberChanges());

				// marcarea stock-ului ca fiind printat
				entry.getValue().wasPrint();
			}
		}

	}


}
