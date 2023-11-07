package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int lim) {
        return apartments.stream()
                .sorted(Comparator.comparingDouble(appartment -> appartment.getArea()))
                .limit(lim)
                .map(apartment -> apartment.toString())
                .collect(Collectors.toList());
    }
}
// END
