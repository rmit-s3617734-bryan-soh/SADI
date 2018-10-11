package model;

import model.interfaces.DicePair;

public class DicePairImpl implements DicePair {

	private final int dice1;
	private final int dice2;
	private final int numFaces;

	public DicePairImpl(int dice1, int dice2, int numFaces) {
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.numFaces = numFaces;
	}

	@Override
	public int getDice1() {

		return dice1;
	}

	@Override
	public int getDice2() {

		return dice2;
	}

	@Override
	public int getNumFaces() {

		return numFaces;
	}

	@Override
	public String toString() {
		int total = getDice1() + getDice2();
		String s = String.format("Dice 1: %d, Dice 2: %d .. Total= %d\n", getDice1(), getDice2(), total);

		return s;
	}

}
