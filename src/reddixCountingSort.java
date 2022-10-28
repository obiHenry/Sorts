public class reddixCountingSort {

    public static  void  main(String[] args){
        int[] redixArray = {4567, 2345, 3456,8345, 2347,7834, 5786};

        redixSort(redixArray, 10, 4);

        for (int i = 0; i < redixArray.length; i++) {
            System.out.println(redixArray[i]);
        }
    }

    public static void redixSort(int[] input, int  redix, int width){
        for (int i = 0; i < width; i++) {
            redixSingleSort(input, i, redix);
        }
    }

    public static void redixSingleSort(int[] input, int position, int redix){
        int numItem = input.length;

        int[] countArray = new int[redix];

        for (int value: input
             ) {
            countArray[getDigit(position,value, redix)]++;
        }
        
        // Adjust the count array 
        for (int j = 1; j < redix ; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItem];
        for (int tempIndex = numItem - 1; tempIndex >= 0 ; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], redix)]] =
                    input[tempIndex];
            
        }

        for (int tempIndex = 0; tempIndex < numItem; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }


    public static int getDigit(int position, int value, int redix){
        return value/ (int) Math.pow(redix, position) % redix;
    }
}
