import java.util.Arrays;

public class Challenge {
    public static void main(String[] args) {
        String[][] originalSeats = {{"Moiz", "Angie", "Taran", "Kelvin", "Kyler", "David", "WenHao Huang", "Nicole", "Jennifer", "Michelle", null, null},
                {"Beckett", "Raymond", "Lucy", "Apramjot", "Justin Lema", "Sam", "Tristan", "Pradeep", "Mohammad", "Haley", null, "Rely"},
                {"Cheng Han", ",Qihan", "Kevin", "Ryan", "Justin Liu", "Jeffrey", "Danny", "Elliot", "Benson", "Fiona", "Neil", "Kaitlyn"}};
        String[][] newSeats = new String[originalSeats.length][originalSeats[0].length];
        boolean redo = false;
        for (int row = 0; row != originalSeats.length; row++) {
            for (int seat = 0; seat != originalSeats[0].length; seat++) {
                if (originalSeats[row][seat] != null) {
                    //System.out.println("Testing: " + originalSeats[row][seat]);
                    int originalSeat = seat + (row * 11); //                                                             0
                    int randSeat = (int) (Math.random() * 12) + ((int) (Math.random() * 3)  * 11);//                     12
                    while (originalSeat == randSeat) { //makes sure original seat is not the same as new seat
                        randSeat = (int) (Math.random() * 12) + ((int) (Math.random() * 3)  * 11);
                    }
                    int newSeat = randSeat;//                                                                            12
                    int newRow = 0;
                    while (newSeat > 11) {
                        newSeat = newSeat - 11;
                        newRow++;
                    }
                    if (newSeats[newRow][newSeat] != null) { //makes sure the new seat is empty
                        randSeat = (int) (Math.random() * 12) + ((int) (Math.random() * 3)  * 11);
                        while (originalSeat == randSeat) { //makes sure original seat is not the same as new seat
                            randSeat = (int) (Math.random() * 12) + (row * 11);
                        }
                        newSeat = randSeat;
                        newRow = 0;
                        while (newSeat > 11) {
                            newSeat = newSeat - 11;
                            newRow++;
                        }
                    }
                    newSeats[newRow][newSeat] = originalSeats[row][seat];
                }
            }
            for (int check = 0; check != newSeats[0].length; check++) {
                if (check == 0) { //check if left of 1st person is empty
                    if (newSeats[row][1] == null) {
                        redo = true;
                    }
                }
                else if (check == newSeats[0].length - 1) { //check if right of last person is empty
                    if (newSeats[row][newSeats[0].length - 2] == null) {
                        redo = true;
                    }
                }
                else {
                    if (newSeats[row][check + 1] == null && newSeats[row][check - 1] == null) {
                        redo = true;
                    }
                }
            }
            if (redo) {
                for (int clear = 0; clear != newSeats[0].length; clear++) {
                    newSeats[row][clear] = null;
                }
                row--;
                redo = false;
            }
        }
        for (String[] row: newSeats) {
            System.out.println(Arrays.toString(row));
        }
    }
}
