package dw0623;

import java.time.LocalDate;

public class FeeCalculator {
    public static Double calculate(String toolType) {
        // placeholder
        return 0.0;
    }

    public static Integer calculateChargeDays(Integer rentalDays, LocalDate checkoutDate, String toolType) {
        Integer chargeDays = 0;
        Integer dayOfWeek = 0;
        Integer rentalDaysRemaining = rentalDays;
        LocalDate currentDate = checkoutDate;
        Fee fee = FeeDao.getFeeByType(toolType);

        // Find our labor day
        LocalDate septemberFirst = checkoutDate.withMonth(9).withDayOfMonth(1);
        LocalDate laborDay;

        if (septemberFirst.getDayOfWeek().getValue() == 1) {
            laborDay = septemberFirst;
        }
        else {
            // bump to the end of the week + 1 day
            laborDay = septemberFirst.plusDays(8 - septemberFirst.getDayOfWeek().getValue());
        }

        LocalDate julyFourth = checkoutDate.withMonth(7).withDayOfMonth(4);
        LocalDate julyFourthObserved = julyFourth;

        if (julyFourth.getDayOfWeek().getValue() == 6) {
            // observe Saturday on Friday
            julyFourthObserved = julyFourth.minusDays(1);
        }
        else if (julyFourth.getDayOfWeek().getValue() == 7) {
            // observe Sunday on Monday
            julyFourthObserved = julyFourth.plusDays(1);
        }

        while(rentalDaysRemaining > 0) {
            dayOfWeek = currentDate.getDayOfWeek().getValue();

            if (julyFourthObserved.equals(currentDate) && fee.getHolidayCharge()) {
                chargeDays++;
            }
            else if (laborDay.equals(currentDate) && fee.getHolidayCharge()) {
                chargeDays++;
            }
            else if (dayOfWeek <= 5 && fee.getWeekdayCharge()) { // weekday
                chargeDays++;
            }
            else if (dayOfWeek >= 6 && fee.getWeekendCharge()) { // weekend
                chargeDays++;
            }

            currentDate = currentDate.plusDays(1);
            rentalDaysRemaining--;
        }

        return chargeDays;
    }
}