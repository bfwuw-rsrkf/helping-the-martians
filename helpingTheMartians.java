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
}
