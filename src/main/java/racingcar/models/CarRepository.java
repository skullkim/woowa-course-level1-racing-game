package racingcar.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.RacingGameMessage;

public class CarRepository {

	private final List<Car> cars;

	public CarRepository(final String names) {
		cars = new ArrayList<>();
		createCarList(splitNames(names));
	}

	private void createCarList(List<String> names) {
		names.forEach((name) -> cars.add(new Car(name)));
	}

	private List<String> splitNames(final String names) {
		return Arrays.stream(names.split(RacingGameMessage.CAR_NAME_DISTRIBUTOR))
			.collect(Collectors.toList());
	}

	public List<Car> getWinners() {
		final int farthestPosition = findFarthestPosition();
		return cars.stream()
			.filter((car) -> farthestPosition == car.getPosition())
			.collect(Collectors.toList());
	}

	private int findFarthestPosition() {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getPosition))
			.collect(Collectors.toList())
			.get(cars.size() - 1)
			.getPosition();
	}

	public void startThisTurn() {
		cars.forEach(Car::goForward);
	}

	public List<Car> getThisTurnResult() {
		return cars;
	}
}
