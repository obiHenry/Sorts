public class radixChallenge {

    public  static  void main(String[] args){
        String[] radixArray = {"bcd", "dbaqc", "abcde", "omad", "bbbbb"};

        radixSort(radixArray, 26, 3);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }

    }

    public static void radixSort(String[] input, int radix, int width){
        for (int i =  width -1; i >= 0  ; i--) {
            radixSingleSort(input, i, radix);
        }
    }


    public static  void radixSingleSort(String[] input, int position, int radix){
        int numItem = input.length;
        int[] countArray = new int[radix];

        for (String value: input
             ) {


            countArray[getLetter(position, value)]++;
        }
        for (int j = 1; j < radix ; j++) {
            countArray[j] += countArray[j -1];
        }

        String [] temp = new String [numItem];
        for (int tempIndex = numItem -1 ; tempIndex >= 0 ; tempIndex--) {


            temp[--countArray[getLetter(position, input[tempIndex])]] = input[tempIndex];

        }
        for (int tempIndex = 0; tempIndex < numItem; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }


        public  static  int getLetter (int position, String value ){
        return  value.charAt(position) - 'a';
}
}
