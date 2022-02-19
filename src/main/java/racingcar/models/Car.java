package racingcar.models;

import racingcar.utils.RandomNumber;

public class Car {

	private static final int FORWARD_STANDARD = 4;
	private static final int INITIAL_POSITION = 0;

	private final String name;
	private int position;

	public Car(final String name) {
		this.name = name;
		position = INITIAL_POSITION;
	}

	public void startThisTurn() {
		if (shouldGoForward(generateRandomNumber())) {
			goForward();
		}
	}

	protected int generateRandomNumber() {
		return RandomNumber.getRandomNumber();
	}

	private boolean shouldGoForward(final int standard) {
		return standard >= FORWARD_STANDARD;
	}

	private void goForward() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
