package racingcar.models;

import racingcar.utils.RandomNumber;

public class Car {

	private static final int FORWARD_STANDARD = 4;
	private static final int INITIAL_POSITION = 0;

	private final RandomNumber randomNumber;
	private final String name;
	private int position;

	public Car(final RandomNumber randomNumber, final String name) {
		this.randomNumber = randomNumber;
		this.name = name;
		position = INITIAL_POSITION;
	}

	public void goForward() {
		if (randomNumber.getRandomNumber() >= FORWARD_STANDARD) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
