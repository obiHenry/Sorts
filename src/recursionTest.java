public class recursionTest {

    public static void main(String[] args){
        System.out.println(recursion(3));


    }

    public static int recursion(int num){
        if (num == 0){

            return  1;
        }

        return num * recursion(num -1);
    }
}
