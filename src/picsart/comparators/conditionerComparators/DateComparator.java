package picsart.comparators.conditionerComparators;

import picsart.model.conditioner.Conditioner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Conditioner> {
    private boolean isReversed;

    public DateComparator() {
        isReversed = false;
    }

    public DateComparator(boolean isReversed) {
        this.isReversed = isReversed;
    }

    @Override
    public int compare(Conditioner o1, Conditioner o2) {
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(o1.getDate());
            date2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(o2.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!isReversed) {
            if (date1.compareTo(date2) > 0) {
                return 1;
            } else if (date1.compareTo(date2) < 0) {
                return -1;
            }
            return 0;
        }
        if (isReversed) {
            if (date1.compareTo(date2) > 0) {
                return -1;
            } else if (date1.compareTo(date2) < 0) {
                return 1;
            }
        }
        return 0;
    }
}
