package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles;
    Profile profile1 = new Profile(new Address("Tokyo", "qwe", 1, 12));
    Profile profile2 = new Profile(new Address("NY", "asd", 3, 123));
    Profile profile3 = new Profile(new Address("Moscow", "zxc", 41, 142));
    Profile profile4 = new Profile(new Address("Tokyo", "qwe", 1, 12));
    Profile profile5 = new Profile(new Address("SPB", "asdzxc", 51, 512));
    Profile profile6 = new Profile(new Address("Tokyo", "qwe", 1, 12));
    Profile profile7 = new Profile(new Address("London", "zxcasd", 76, 142));
    Profile profile8 = new Profile(new Address("SPB", "asdzxc", 51, 512));
    Profile profile9 = new Profile(new Address("Berlin", "ertqwe", 45, 87));

    @Before
    public void Set() {
        profiles = List.of(profile1, profile2, profile3, profile4,
                profile5, profile6, profile7, profile8, profile9);
    }

    @Test
    public void sort() {
        List<Address> expected = List.of(new Address("Berlin", "ertqwe", 45, 87),
                new Address("London", "zxcasd", 76, 142),
                new Address("Moscow", "zxc", 41, 142),
                new Address("NY", "asd", 3, 123),
                new Address("SPB", "asdzxc", 51, 512),
                new Address("Tokyo", "qwe", 1, 12));
        List<Address> rsl = Profiles.collect(profiles);
        assertThat(rsl, is(expected));
    }

    @Test
    public void sortInvalid() {
        List<Address> expected = List.of(new Address("Berlin", "ertqwe", 45, 87));
        List<Address> rsl = Profiles.collect(profiles);
        assertNotSame(rsl, is(expected));
    }
}