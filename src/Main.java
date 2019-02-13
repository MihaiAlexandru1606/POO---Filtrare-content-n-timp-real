import io.Input;
import observer.*;

/**
 * Clasa Main care realizeaza citirea comenzilor, paseaza, si executarea comenzi
 * fiecare comanda este pasata cu ajutorul metodei parser din clasa Input
 * 
 * @author mihai
 *
 */
public class Main {

	public static void main(String[] args) /*throws IOException*/ {

		Input input = new Input();
		Feed feed = Feed.getInstance();

		try {
			
			while (true) {
				input.read();

				if (input.getCommand().equals("begin")) {
					feed = Feed.getInstance();

				} else if (input.getCommand().equals("end")) {
					input.close();
					break;

				} else if (input.getCommand().equals("feed")) {
					String[] token = input.getFeed().split(" ");
					feed.setState(token[0], token[1]);

				} else if (input.getCommand().equals("print")) {
					feed.printObserver(input.getObs_id());

				} else if (input.getCommand().equals("delete_obs")) {

					feed.deleteObserver(input.getObs_id());

				} else if (input.getCommand().equals("create_obs")) {

					if (input.getExpression()[0].equals("nil")) {
						ObserverFactory.getInstance().getObserverFactory("nil", feed, input.getObs_id(),
								input.getExpression());
					} else {
						ObserverFactory.getInstance().getObserverFactory("expression", feed, input.getObs_id(),
								input.getExpression());
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
