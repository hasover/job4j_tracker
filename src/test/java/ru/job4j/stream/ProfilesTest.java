package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void testCollect() {
        Address one = new Address("A", "A", 1, 1);
        Address two = new Address("B", "B", 2, 2);
        Address three = new Address("A", "B", 10, 3);
        List<Profile> profileList = List.of(new Profile(one),
                                            new Profile(two),
                                            new Profile(three));
        List<Address> addresses = Profiles.collect(profileList);
        assertThat(addresses, is(List.of(one, two, three)));
    }

}