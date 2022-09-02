package de.tilmanschweitzer.adventofcode.registry;

import de.tilmanschweitzer.adventofcode.day.AdventOfCodeDay;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

public class AdventOfCodeRegistry {

    private final Map<AdventOfCodeDay.YearAndDay, AdventOfCodeDay<?, ?>> adventOfCodeDaysByYearAndDay = new HashMap<>();

    public void addDay(final AdventOfCodeDay<?, ?> adventOfCodeDay) {
        adventOfCodeDaysByYearAndDay.put(adventOfCodeDay.getYearAndDay(), adventOfCodeDay);
    }

    public Optional<AdventOfCodeDay<?, ?>> getForYearAndDay(int year, int day) {
        final AdventOfCodeDay.YearAndDay yearAndDay = new AdventOfCodeDay.YearAndDay(year, day);
        return Optional.ofNullable(adventOfCodeDaysByYearAndDay.get(yearAndDay));
    }

    public static AdventOfCodeRegistry createRegistryWithExistingDays() {
        final AdventOfCodeRegistry registry = new AdventOfCodeRegistry();

        final ServiceLoader<AdventOfCodeDay> serviceLoader = ServiceLoader.load(AdventOfCodeDay.class);

        for (AdventOfCodeDay adventOfCodeDay : serviceLoader) {
            registry.addDay(adventOfCodeDay);
        }

        return registry;
    }
}
