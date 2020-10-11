package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    public List<Address> sort(List<Address> addresses) {
        return addresses
                .stream()
                .sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList());
    }

    public List<Address> collectUnique(List<Address> addresses) {
        return sort(addresses).stream().distinct().collect(Collectors.toList());
    }
}
