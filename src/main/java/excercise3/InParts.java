package excercise3;

import javax.swing.text.StyledEditorKit;

public class InParts {

    private static String someString = "supercalifragilisticexpialidocious";

    public static void main(String[] args) {
        splitInParts(someString, 3);
    }

    public static String splitInParts(String s, int partLength) {
        String[] changedString = s.split("");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < someString.length()-3; i+=3) {
            int j = i;
            String substring = someString.substring(i, j+3);
            stringBuilder = stringBuilder.append(substring + " ");
        }
        System.out.println(stringBuilder);


        /*StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < changedString.length; i++) {
            StringBuilder append = stringBuilder.append(changedString[i]);
            System.out.println(append);
            if (append.length() == i) {
                stringBuilder.append("#");
            }
        }
*/
//        System.out.println(stringBuilder);
        return "";
    }
}
