package app;

import automaton.Automaton;

public class App {
	public static void main(String[] args) {
		System.out.println("Start");

		Automaton automaton = new Automaton();
		// -- (a|b)ba* --
		// automaton.setAlphabet("ab");
		// automaton.addState("A1", false);
		// automaton.addState("A2", false);
		// automaton.addState("A3", false);
		// automaton.addState("A4", true);
		// automaton.setFirstState("A1");
		// automaton.addTransition("A1", 'a', "A2");
		// automaton.addTransition("A1", 'b', "A3");
		// automaton.addTransition("A2", 'b', "A4");
		// automaton.addTransition("A3", 'b', "A4");
		// automaton.addTransition("A4", 'a', "A4");

		// -- Cadenas que se penultima letra sea la "a"
		automaton.setAlphabet("ab");
		automaton.addState("A1", false);
		automaton.addState("A2", false);
		automaton.addState("A3", false);
		automaton.addState("A4", true);
		automaton.addState("A5", true);
		automaton.addTransition("A1", 'a', "A2");
		automaton.addTransition("A1", 'b', "A3");
		automaton.addTransition("A2", 'a', "A4");
		automaton.addTransition("A2", 'b', "A5");
		automaton.addTransition("A3", 'a', "A2");
		automaton.addTransition("A3", 'b', "A3");
		automaton.addTransition("A4", 'a', "A4");
		automaton.addTransition("A4", 'b', "A5");
		automaton.addTransition("A5", 'a', "A2");
		automaton.addTransition("A5", 'b', "A3");

		String[] strs = {"abaa", "baaa", "bbaab", "a", "ba", "abbbaaaba"};
		for (String s : strs) {
			System.out.println("String to evaluate: " + s);
			if (automaton.evaluateString(s))
				System.out.println(s + " is ok");
			else
				System.out.println(s + " is not ok");
			System.out.println();
		}
	}
}
