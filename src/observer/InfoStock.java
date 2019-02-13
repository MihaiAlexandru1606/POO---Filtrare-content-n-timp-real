package observer;

/**
 * clasa in care sunt pastrate informatile depre un stock
 * atributele clasei:
 * - numberChanges: numarul de schimbari mentru un stock
 * - value : ultima valuare pentru un stock
 * - valueBeforePrint: valuarea inainte ultimului print
 * - increase: fluctuatia pentru un stock
 * - lastValueIsValid: daca ultima valuare respecta filtrul
 * @author mihai
 *
 */
public class InfoStock {

	private int numberChanges;
	private String value;
	private String valueBeforePrint;
	private double increase;
	private boolean lastValueIsValid = false;

	public InfoStock(int numberChanges, String value) {
		this.numberChanges = numberChanges;
		this.value = value;
		this.increase = 0;
		this.valueBeforePrint = null;
		this.lastValueIsValid = true;
	}

	/**
	 * 
	 * @return numarul de schimbari
	 */
	public int getNumberChanges() {
		return numberChanges;
	}

	/**
	 * 
	 * @param numberChanges valuare pentru numberChanges
	 */
	public void setNumberChanges(int numberChanges) {
		this.numberChanges = numberChanges;
	}

	/**
	 * 
	 * @return ultima valuare pentru un stock
	 */
	public String getValue() {
		return value;
	}

	/**
	 * setarea ultime valuari pentru un stock
	 * @param value valuare setata
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * se calculeaza daca s-a efectuat un print sau daca a existat schimbari
	 * altfel se returneza 0
	 * @return fluctuatia pentru respectivul stock
	 */
	public double getIncrease() {

		if (this.valueBeforePrint != null && this.numberChanges != 0) {
			this.increase = Double.parseDouble(value) - Double.parseDouble(valueBeforePrint);
			this.increase = this.increase / Double.parseDouble(valueBeforePrint);
			this.increase = this.increase * 100;

			return this.increase;
		}

		return 0;
	}

	/**
	 * 
	 * @return daca ultima valuare este valida
	 */
	public boolean isLastValueIsValid() {
		return lastValueIsValid;
	}

	/**
	 * setarea daca valuarea este valida 
	 * @param lastValueIsValid  valuare pentru lastValueIsValid
	 */
	public void setLastValueIsValid(boolean lastValueIsValid) {
		this.lastValueIsValid = lastValueIsValid;
	}

	/**
	 * metoda care seteaza variabiala valueBeforePrint 
	 * si reseteza numberChanges
	 */
	public void wasPrint() {
		this.valueBeforePrint = this.value;
		this.numberChanges = 0;
	}

}
