package November;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Challenge242Int {

    /* Recording VHS shows */

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Show> timetable = new ArrayList<Show>();
        while (input.hasNextInt()) {
            timetable.add(new Show(input.nextInt(), input.nextInt()));
        }
        Collections.sort(timetable); //sorts so that the shows that finish first appear first

        int currentTime = timetable.get(0).start;
        int numberOfShows = 0;

        for (Show show: timetable) {
            if (currentTime <= show.start) {
                currentTime = show.end;
                numberOfShows++;
            }
        }
        System.out.println(numberOfShows);
    }

    private static class Show implements Comparable<Show> {
        public int start;
        public int end;

        public Show(int start, int end) {
            this.start = start;
            this.end = end;
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
