import java.util.Random;

class helpingTheMartians {
    public static void main(String[] args) {

    }

    static Boolean contains(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return true;
            }
        }
        return false;
    }

    static int[] cargoScatter(int[] previousMarks) {
        int[] cargoMarks = new int[]{7, 7, 7};
        Random scatter = new Random();
        for (int i = 0; i < 3; i++) {
            while (true) {
                int mark = scatter.nextInt(7);
                if (!contains(previousMarks, mark) && (!contains(cargoMarks, mark))) {
                    cargoMarks[i] = mark;
                    break;
                }
            }
        }
        return cargoMarks;
    }
}
