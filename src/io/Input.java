package io;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import exception.ParserException;

/**
 * functia care realizeaza pasarea unei linii citite
 * argumentele clasei:
 * - regex : expresia regulata folosita pentru pasare
 * - pattern : pattern-ul folosit pentru pasarea
 * - command: comanda obitnuta in urma pasari
 * - expression : expresia obtinuta dupa pasare
 * - feed : feed-ul obtinut dupa pasare
 * - obs_id : id-ul observatorului pentru care se efectueza comenzile(ex: print)
 * @author mihai
 *
 */
public class Input {

	private String regex = "begin|feed|create_obs|print|delete_obs|end|\\&&|[a-zA-Z][a-zA-Z0-9_. -]*|[0-9]+|\\|\\||\\)|\\(";
	private final Pattern pattern = Pattern.compile("^(" + regex + ")");
	private String command;
	private String[] expression;
	private String feed;
	private Integer obs_id;
	private BufferedReader buffer;

	public Input() {
		this.buffer = new BufferedReader(new InputStreamReader(System.in), 2048);

	}

	/**
	 * 
	 * @return comanda , examplu: feed print, begin etc.
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * 
	 * @return expresia dupa "tokenizare", 
	 * exemplu pentru create_obs 1 (eq name WQQ), vectorul de stringuri va fi :
	 * { "(" , "eq name WQQQ", ")" }
	 */
	public String[] getExpression() {
		return expression;
	}

	/**
	 * 
	 * @return valuarea pentru un feed, pentru feed Q 12, se va returna "Q 12"
	 */
	public String getFeed() {
		return feed;
	}

	/**
	 * 
	 * @return id-ul observatorului 
	 */
	public Integer getObs_id() {
		return obs_id;
	}

	/**
	 * metoda realizeaza pasarea/tokenizarea unei lini citite
	 * pentru acesata s-a folosit expresi regulate
	 * @param line stringul ce urmeaza sa fie tokenizat
	 * @throws ParserException exceptia aruncata daca se primeste o linie incorecta 
	 */
	public void parser(String line) throws ParserException {
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			this.command = matcher.group().trim();

			if (this.command.equals("begin")) {
				return;

			} else if (this.command.equals("end")) {
				return;

			} else if (this.command.equals("print")) {
				line = matcher.replaceFirst("").trim();
				matcher = pattern.matcher(line);
				matcher.find();
				this.obs_id = Integer.parseInt(matcher.group().trim());

			} else if (this.command.equals("delete_obs")) {
				line = matcher.replaceFirst("").trim();
				matcher = pattern.matcher(line);
				matcher.find();
				this.obs_id = Integer.parseInt(matcher.group().trim());

			} else if (this.command.equals("feed")) {
				line = matcher.replaceFirst("").trim();
				matcher = pattern.matcher(line);
				matcher.find();
				this.feed = matcher.group().trim();

			} else if (this.command.equals("create_obs")) {
				line = matcher.replaceFirst("").trim();
				matcher = pattern.matcher(line);
				matcher.find();
				this.obs_id = Integer.parseInt(matcher.group().trim());

				line = matcher.replaceFirst("").trim();
				List<String> token = new ArrayList<String>();
				while (!line.equals("")) {
					matcher = pattern.matcher(line);

					if (matcher.find()) {
						token.add(matcher.group().trim());
					} else
						throw new ParserException("Illegal input: " + line);

					line = matcher.replaceFirst("").trim();
				}

				this.expression = new String[token.size()];
				token.toArray(this.expression);
				token.clear();
			}else {
				throw new ParserException("Illegal input: " + line);
			}
			
		} else {
			throw new ParserException("Illegal input: " + line);
		}
	}
	
	public void read() {
		try {
			String line = this.buffer.readLine();
			
			try {
				this.parser(line);
			} catch (ParserException e) {
				System.out.println(e.getMessage() );
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			this.buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
