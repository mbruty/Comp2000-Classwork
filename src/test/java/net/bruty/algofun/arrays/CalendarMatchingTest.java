package net.bruty.algofun.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalendarMatchingTest {

    @Test
    void match() {
        List<StringMeeting> personOne = new ArrayList<>();
        personOne.add(new StringMeeting("9:00", "10:30"));
        personOne.add(new StringMeeting("12:00", "13:00"));
        personOne.add(new StringMeeting("16:00", "18:00"));
        StringMeeting boundsOne = new StringMeeting("9:00", "20:00");

        List<StringMeeting> personTwo = new ArrayList<>();
        personTwo.add(new StringMeeting("10:00", "11:30"));
        personTwo.add(new StringMeeting("12:30", "14:30"));
        personTwo.add(new StringMeeting("14:30", "15:00"));
        personTwo.add(new StringMeeting("16:00", "17:00"));
        StringMeeting boundsTwo = new StringMeeting("10:00", "18:30");


        String[][] expected = new String[3][];
        expected[0] = new String[]{"11:30", "12:00"};
        expected[1] = new String[]{"15:00", "16:00"};
        expected[2] = new String[]{"18:00", "18:30"};

        assertArrayEquals(expected, CalendarMatching.match(personOne, boundsOne, personTwo, boundsTwo, 30));

    }
}