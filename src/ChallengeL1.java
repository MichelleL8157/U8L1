import java.util.Arrays;

public class ChallengeL1 {
    public static void main(String[] args) {
        String[][] originalSeats = {{"Moiz", "Angie", "Taran", "Kelvin", "Kyler", "David", "WenHao Huang", "Nicole", "Jennifer", "Michelle", null, null},
                {"Beckett", "Raymond", "Lucy", "Apramjot", "Justin Lema", "Sam", "Tristan", "Pradeep", "Mohammad", "Haley", null, "Rely"},
                {"Cheng Han", "Qihan", "Kevin", "Ryan", "Justin Liu", "Jeffrey", "Danny", "Elliot", "Benson", "Fiona", "Neil", "Kaitlyn"}};
        String[][] newSeats = new String[originalSeats.length][originalSeats[0].length];
        boolean redo = true;
        while (redo) {
            for (int row = 0; row != newSeats.length; row++) { //meant for 2nd+ trial when list needs to be reset
                for (int seat = 0; seat != newSeats[row].length; seat++) {
                    newSeats[row][seat] = null;
                }
            }
            for (int row = 0; row != originalSeats.length; row++) {
                for (int seat = 0; seat != originalSeats[row].length; seat++) {
                    String name = originalSeats[row][seat];
                    int newSeat = (int) (Math.random() * 12);
                    int newRow = (int) (Math.random() * 3);
                    while (newSeats[newRow][newSeat] != null || (newRow * 12) + newSeat == (row * 12) + seat) { //redo seat if the new seat is not empty or same as old seat
                        newSeat = (int) (Math.random() * 12);
                        newRow = (int) (Math.random() * 3);
                    }
                    newSeats[newRow][newSeat] = name;
                }
            }
            redo = false;
            for (int row = 0; row != newSeats.length; row++) {
                for (int check = 0; check != newSeats[0].length; check++) {
                    if (check == 0) { //check if right of 1st person is empty
                        if (newSeats[row][1] == null) {
                            redo = true;
                            break;
                        }
                    } else if (check == newSeats[0].length - 1) { //check if left of last person is empty
                        if (newSeats[row][newSeats[0].length - 2] == null) {
                            redo = true;
                            break;
                        }
                    } else { //checks center seat is left and right are empty
                        if (newSeats[row][check + 1] == null && newSeats[row][check - 1] == null) {
                            redo = true;
                            break;
                        }
                    }
                }
            }
        }
        for (String[] row: newSeats) { //Prints the 2d array
            System.out.println(Arrays.toString(row));
        }
    }
}
