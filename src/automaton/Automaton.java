package automaton;

import java.util.HashMap;
import automaton.State;

public class Automaton {
	private HashMap<String, State> states;
	private String alphabet;
	private String firstState;

	public Automaton() {
		this.states = new HashMap<String, State>();
		this.alphabet = null;
		this.firstState = null;
	}

	// States
	public void addState(String name, boolean isFinal) {
		State newState = new State();
		if (this.firstState == null)
			this.firstState = name;
		newState.setIsFinal(isFinal);
		newState.setName(name);
		this.states.put(name, newState);
	}

	public void setFirstState(String name) {
		this.firstState = name;
	}

	// Transitions
	public void addTransition(String state, char symbol, String toState) {
		this.states.get(state).addTransition(symbol, toState);
	}

	// Alphabet
	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	// Evaluate string
	public boolean evaluateString(String str) {
		String current = this.firstState;
		if (this.alphabet == null)
			return false;
		if (this.states.isEmpty())
			return false;
		for (char symbol : str.toCharArray()) {
			System.out.print(current + ", " + symbol + " -> ");
			if (!this.inAlphabet(symbol))
				return false;
			current = this.states.get(current).getNextState(symbol);
			if (current == null) {
				System.out.println("Error");
				return false;
			}
		}
		System.out.println(this.states.get(current).getName());
		if (!this.states.get(current).getIsFinal())
			return false;
		return true;
	}

	private boolean inAlphabet(char symbol) {
		for (char c: this.alphabet.toCharArray()) {
			if (symbol == c)
				return true;
		}
		return false;
	}
}