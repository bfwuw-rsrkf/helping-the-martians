import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class helpingTheMartians {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] cargoMarks = cargoScatter(null);
        ArrayList<Integer> correctGuesses = new ArrayList<>();
        int incorrectGuesses = 0;

        while (true) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Take your guess, where a cargo might be: ");
                int guess = input.nextInt();

                if (contains(cargoMarks, guess) && !(correctGuesses.contains(guess))) {
                    correctGuesses.add(guess);
                }
            }

            if (correctGuesses.size() < 3) {
                System.out.printf("You have found %d cargos out of 3!\n", correctGuesses.size());
                correctGuesses.clear();
                incorrectGuesses++;
            }
            else {
                break;
            }

            if (incorrectGuesses == 5) {
                System.out.println("Cargos found out that you're trying to find them! They're running away...");
                cargoMarks = cargoScatter(cargoMarks);
                incorrectGuesses = 0;
            }
        }

        System.out.println("You have found all of the cargos! Congratulations!\n" +
            "Their positions are:");
        for (int i = 0; i < 3; i++) {
            System.out.println(correctGuesses.get(i));
        }
        input.close();
    }

    static Boolean contains(int[] arr, int elem) {
        if (arr == null) {
            return false;
        }
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
