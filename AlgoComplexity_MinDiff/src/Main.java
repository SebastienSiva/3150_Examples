public class Main {

    public static IntAnswer smallestDiff(int[] nums) {
        IntAnswer answer = new IntAnswer();
        int minDiff = Integer.MAX_VALUE;
        //[23, 54, 12, 45, 123]
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                answer.numSteps++;
                if(i != j) {
                    int diff = Math.abs(nums[i] - nums[j]);
                    if(diff < minDiff) {
                        minDiff = diff;
                    }
                }
            }
        }
        answer.value = minDiff;
        return answer;
    }




    /*
    0 1 2 3 4  5   6
    1 1 2 6 24 120 720
     */
    public static IntAnswer factorial(int n) {
        IntAnswer answer = new IntAnswer();
        //some kind of loop
        int p = 1;
        while(n > 1) {
            answer.numSteps++;
            p = p * n;
            n--;
        }
        answer.value = p;
        return answer;
    }

    public static void main(String[] args) {
        for(int i = 5; i <= 50; i++) {
            int[] nums = MyArrayUtil.randomArray(i);
            IntAnswer a = smallestDiff(nums);
            System.out.println(MyArrayUtil.arrayToString(nums) + " has minDiff " + a);
        }



        /*
        System.out.println("Hello 3150 Students!");
        for(int i = 0; i <= 6; i++) {
            IntAnswer a = factorial(i);
            System.out.println(i + " gives result " + a);
        }
         */
    }
}