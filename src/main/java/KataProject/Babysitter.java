package KataProject;

public class Babysitter {

    private int regularRate = 12;
    private int bedTimeRate = 8;
    private int midnightRate = 16;


    public int convertTime(int shiftTime) {

        return (shiftTime <= 12 && shiftTime >= 5)
                ? shiftTime - 5
                : shiftTime + 7;
    }


    public boolean arrivalTime(int regularShift) {
        return convertTime(regularShift) < 11;
    }

    public boolean endTime(int start, int ends) {
        return convertTime(ends) > convertTime(start);
    }

    public boolean estimatedBedTime(int regularShift, int bedTime, int ends) {
        return convertTime(bedTime) > convertTime(regularShift) && convertTime(bedTime) < convertTime(ends);
    }

    //midnight will equal out to 7 under the converted times


    public int midnightShiftHours(int ends) {
        return (convertTime(ends) > 7)
                ? convertTime(ends) - 7
                : 0;
    }

    public int regularShiftHours(int regularShift, int bedTime) {
        if (convertTime(bedTime) >= 7) {
            return 7 - convertTime(regularShift);
        } else if (convertTime(bedTime) <= 7) {
            return convertTime(bedTime) - convertTime(regularShift);
        } else {
            return 0;
        }

    }

    public int bedTimeShiftHours(int regularShift, int bedTime) {
        return (convertTime(regularShift) <= 7)
                ? 7 - convertTime(bedTime)
                : 0;
    }

    public int calculatedTotalPay(int start, int bedTime, int midnight) {
        return (regularShiftHours(start, bedTime) * regularRate)
                + (bedTimeShiftHours(start, bedTime) * bedTimeRate)
                + (midnightShiftHours(midnight) * midnightRate);
    }
}
