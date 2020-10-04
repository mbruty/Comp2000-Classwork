package net.bruty.arrays;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching {

    public static List<StringMeeting> match(
            List<StringMeeting> calendar1,
            StringMeeting bounds1,
            List<StringMeeting> calendar2,
            StringMeeting bounds2,
            int duration
    ) {
        List<IntMeeting> updated1 = updateCalendar(calendar1, bounds1);
        List<IntMeeting> updated2 = updateCalendar(calendar2, bounds2);
        List<IntMeeting> merged = mergeCalendars(updated1, updated2);
        List<IntMeeting> flattened = flattenCalendar(merged);
        return getMatching(flattened, duration);
    }

    public static List<IntMeeting> updateCalendar(List<StringMeeting> calendar, StringMeeting bounds){
        List<StringMeeting> updated = new ArrayList<>();
        // Create a meeting from the start of the day to the start of the bounds
        // This acts as a blocker so that a meeting cannot be started outside of the bounds
        updated.add(new StringMeeting("0:00", bounds.start));
        updated.addAll(calendar);
        // End of day blocker
        updated.add(new StringMeeting(bounds.end, "23:59"));

        // Convert the list to a new one, but in int's
        List<IntMeeting> calendarInInt = new ArrayList<>();
        for(StringMeeting i: updated){
            calendarInInt.add(
                    new IntMeeting(
                            timeToMins(i.start),
                            timeToMins(i.end)
                    )
            );
        }
        return calendarInInt;
    }

    private static int timeToMins (String time){
        int delimiterPos = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimiterPos));
        int mins = Integer.parseInt(time.substring(delimiterPos + 1));
        // Convert the hours in to minutes
        return hours * 60 + mins;
    }

    // Merge-sort-like merge of arrays
    private static List<IntMeeting> mergeCalendars(List<IntMeeting> calendar1, List<IntMeeting> calendar2) {
        List<IntMeeting> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < calendar1.size() && j < calendar2.size()) {
            IntMeeting meeting1 = calendar1.get(i);
            IntMeeting meeting2 = calendar2.get(j);
            if(meeting1.start < meeting2.start){
                merged.add(meeting1);
                i++;
            }
            else{
                merged.add(meeting2);
                j++;
            }
        }
        while(i < calendar1.size()){
            merged.add(calendar1.get(i));
            i++;
        }
        while(j < calendar2.size()){
            merged.add(calendar2.get(j));
            j++;
        }
        return merged;
    }

    private static List<IntMeeting> flattenCalendar(List<IntMeeting> calendar){
        List<IntMeeting> flattened = new ArrayList<>();
        flattened.add(calendar.get(0));
        for(int i = 1; i < calendar.size(); i++){
            IntMeeting current = calendar.get(i);
            IntMeeting previous = flattened.get(flattened.size() - 1);
            // Meetings overlap
            if(previous.end >= current.start){
                IntMeeting newPrevious = new IntMeeting(previous.start, Math.max(previous.end, current.end));
                flattened.set(flattened.size() - 1, newPrevious);
            }
            else{
                flattened.add(new IntMeeting(current.start, current.end));
            }
        }
        return flattened;
    }

    private static List<StringMeeting> getMatching(List<IntMeeting> calendar, int duration){
        List<IntMeeting> matching = new ArrayList<>();
        for(int i = 1; i < calendar.size(); i++){
            int start = calendar.get(i - 1).end;
            int end = calendar.get(i).start;
            int availabilityDuration = end - start;
            if(availabilityDuration >= duration){
                matching.add(new IntMeeting(start, end));
            }
        }
        List<StringMeeting> matchingString = new ArrayList<>();
        for(IntMeeting meeting: matching){
            matchingString.add(
                    new StringMeeting(
                            minsToTime(meeting.start),
                            minsToTime(meeting.end)
                    )
            );
        }
        return matchingString;
    }

    private static String minsToTime(int mins){
        int hours = mins / 60;
        int minutes = mins % 60;
        String hoursStr = Integer.toString(hours);
        String minutesStr = minutes < 10 ? "0" + minutes : Integer.toString(minutes);
        return hoursStr + ":" + minutesStr;
    }
}
