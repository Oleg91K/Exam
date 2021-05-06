package exam;

import java.time.LocalDate;

public class Utils {
    public static boolean dateReg(LocalDate endRegDate) {
        LocalDate todayDate = LocalDate.now();
        if (todayDate.getYear() > endRegDate.getYear())
            return false;
        else
             if(todayDate.getYear() < endRegDate.getYear())
                 return true;
             else
                 if (todayDate.getMonthValue() > endRegDate.getMonthValue())
                        return false;
                 else
                     if(todayDate.getMonthValue() < endRegDate.getMonthValue())
                        return true;
                     else
                         if (todayDate.getDayOfMonth() > endRegDate.getDayOfMonth())
                             return false;
                         else
                            if(todayDate.getDayOfMonth() < endRegDate.getDayOfMonth())
                                 return true;
                            else return true;

    }
}
