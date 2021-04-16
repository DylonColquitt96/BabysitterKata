package KataTest;

import KataProject.Babysitter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BabysitterTest {

    private Babysitter testObject;

    @Before
    public void executeBabySitter() {
        testObject = new Babysitter();
    }

    //converting shift times between 0-11
    @Test
    public void convertTimeOf5PMTo0() {
        assertEquals(0, testObject.convertTime(5));
    }

    @Test
    public void convertTimeOf4AMTo11() {
        assertEquals(11, testObject.convertTime(4));
    }


    //test to show start time is before 4am
    @Test
    public void returnTrueIfConvertedTimeForArrivalIsBefore4AM() {
        assertEquals(true, testObject.arrivalTime(8));
    }

    @Test
    public void returnFalseIfConvertedTimeForArrivalIsAfter4AM() {
        assertEquals(false, testObject.arrivalTime(4));
    }

    //test to show end time is after 5pm
    @Test
    public void returnTrueIfConvertedTimeForEndingShiftIsAfter5PM() {
        assertEquals(true, testObject.midnightShift(7));
    }

    @Test
    public void returnFalseIfConvertedTimeForEndingShiftIsAt5PM() {
        assertEquals(false, testObject.midnightShift(5));
    }

    //Test if bed time is between 5pm and 4 AM
    @Test
    public void returnTrueIfBedTimeIsBetween5PMAnd4AM() {
        assertEquals(true, testObject.estimatedBedTime(5, 9, 4));
    }

    @Test
    public void returnFalseIfBedTimeIsNotBetween8PMAnd2AM() {
        assertEquals(false, testObject.estimatedBedTime(8, 7, 2));
    }

    //Test to calculate midnight rate

    @Test
    public void return3HoursToEqualOutTo3AM() {
        assertEquals(3, testObject.midnightShiftHours(3));
    }

    @Test
    public void return0HoursDueToNotExceedingMidnight() {
        assertEquals(0, testObject.midnightShiftHours(9));
    }

    //Test to calculate regular rate

    @Test
    public void return6RegularShiftHours() {
        assertEquals(6, testObject.regularShiftHours(6, 4));
    }

    @Test
    public void return2RegularShiftHours() {
        assertEquals(2, testObject.regularShiftHours(7, 9));
    }

    //Test to calculate bedtime rate

    @Test
    public void return3BedTimeShiftHours(){
        assertEquals(3, testObject.bedTimeShiftHours(5,9));
    }

    @Test
    public void return0BedTimeShiftHoursDueToExceedingMidnight(){
        assertEquals(0, testObject.bedTimeShiftHours(1,2));
    }

    //Test Calculated Rate of hours


    @Test
    public void calculateTotalPayOfAllThreeShifts(){
        assertEquals(136, testObject.calculatedTotalPay(5,9,4));
    }

    @Test
    public void calculateTotalPayOfRegularAndMidnightshift(){
        assertEquals(52, testObject.calculatedTotalPay(1,2,4));
    }



}
