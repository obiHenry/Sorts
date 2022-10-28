public class mergeSort {

    public static void main (String[] args){

        int[] intArray = {22, 42, 34, 55, -34, 30, -12};


        mergeSortt(intArray,0,intArray.length);


        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }


    }
//    {22, 42, 34, 55, -34, 30, -12};
    public static void mergeSortt(int[] input, int start, int end ){
        if (end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        mergeSortt(input, start, mid);
        mergeSortt(input, mid, end);
        merge(input, start, mid, end);
    }

    public  static  void merge(int[] input, int start, int mid, int end){
        if (input[mid - 1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end){
            temp[tempIndex++] = input[i] <= input[j]? input[i++]: input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input,start, tempIndex);
    }
}
