import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
	private static List<Restaurant> restaurants = new ArrayList<>();

	public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
		Restaurant r1 = new Restaurant(restaurantName, null, null, null);
		for (Restaurant r : restaurants) {
			if (r.getName().equals(restaurantName))
				return r1;
			else
				throw new restaurantNotFoundException(restaurantName);
		}
		return r1;
	}

	public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
		Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
		restaurants.add(newRestaurant);
		return newRestaurant;
	}

	public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
		Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
		restaurants.remove(restaurantToBeRemoved);
		return restaurantToBeRemoved;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	
	
}
