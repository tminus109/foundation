public class SubarrayDivision {
    public static int birthday(int[] chocolate, int birthday, int birthMonth) {
        int output = 0;
        for (int i = 0; i < chocolate.length - (birthMonth - 1); i++) {
            int temp = 0;
            for (int j = i; j < (i + birthMonth); j++) {
                temp += chocolate[j];
            }
            if (temp == birthday) {
                output++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] chocolate0 = {1, 2, 1, 3, 2};
        int birthday0 = 3;
        int birthMonth0 = 2;

        int[] chocolate1 = {1, 1, 1, 1, 1};
        int birthday1 = 3;
        int birthMonth1 = 2;

        int[] chocolate2 = {4};
        int birthday2 = 4;
        int birthMonth2 = 1;

        int[] s = {2, 2, 1, 3, 2};
        int d = 4;
        int m = 2;

        System.out.println(birthday(chocolate0, birthday0, birthMonth0));
        System.out.println(birthday(chocolate1, birthday1, birthMonth1));
        System.out.println(birthday(chocolate2, birthday2, birthMonth2));
        System.out.println(birthday(s, d, m));
    }
}
