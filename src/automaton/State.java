package automaton;

import java.util.HashMap;

public class State {
	private String name;
	private boolean isFinal;
	private HashMap<String, String> transitions;

	public State() {
		this.isFinal = false;
		this.transitions = new HashMap<String, String>();
	}

	// Name
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// isFinal
	public void setIsFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public boolean getIsFinal() {
		return this.isFinal;
	}

	// Transitions
	public void addTransition(char symbol, String toState) {
		String key = "" + symbol + symbol + symbol;
		transitions.put(key, toState);
	}

	// Next State
	public String getNextState(char symbol) {
		String key = "" + symbol + symbol + symbol;
		return this.transitions.get(key);
	}
}