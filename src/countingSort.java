public class countingSort {

    public static void main (String[] args){
        int[] intArray = {1, 3,5,6, 7, 2,3,1,8};
        countingSort(intArray, 1, 9);
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    public static void countingSort (int[] inputArray, int min, int max){
        int[] countArray = new int[(max -min) + 1];

        for (int i = 0; i <inputArray.length ; i++) {
            countArray[inputArray[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max ; i++) {
            while (countArray[i - min] > 0){
                inputArray[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
