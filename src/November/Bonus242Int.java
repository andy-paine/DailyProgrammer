package November;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Andy on 30/11/2015.
 */
public class Bonus242Int {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Show> timetable = new ArrayList<Show>();
        String mustSee = input.nextLine().trim();

        while (input.hasNextInt()) {
            timetable.add(new Show(input.nextInt(), input.nextInt(), input.nextLine().trim()));
        }
        Collections.sort(timetable); //sorts so that the shows that finish first appear first

        int currentTime = timetable.get(0).start;
        ArrayList<String> recordedShows = new ArrayList<String>();

        for (Show show: timetable) {
            if (show.name.compareTo(mustSee) == 0) {
                if (show.start < currentTime)
                    recordedShows.remove(recordedShows.size()-1);

                recordedShows.add(show.name);
                currentTime = show.end;
            }

            if (currentTime <= show.start) {
                currentTime = show.end;
                recordedShows.add(show.name);
            }
        }

        for (String showName: recordedShows)
            System.out.println(showName);
    }

    private static class Show implements Comparable<Show> {
        public int start;
        public int end;
        public String name;

        public Show(int start, int end, String name) {
            this.start = start;
            this.end = end;
            this.name = name;
        }


        @Override
        public int compareTo(Show o) {
            if (this.end < o.end)
                return -1;
            else
                return 1;
        }
    }
}
