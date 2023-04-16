package PPT6;
/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".
Example:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
*/
class JavaProgram6 {
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(int i=0; i<stones.length(); i++){
            for(int j=0; j<jewels.length(); j++){
                if(jewels.charAt(j)==stones.charAt(i)){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
    }
}

