package picsart.stringMethods;

public class StringMethods {
    public static void main(String[] args) {

        char chars[] = {'p', 'i', 'c', 's', 'a', 'r', 't'};
        String charsString = new String(chars);
        System.out.println(charsString);

        String charsString2 = new String(chars, 0, 4);
        System.out.println(charsString2);

        // length()
        System.out.println(charsString.length());

        // charAt()
        System.out.println(charsString.charAt(2));

        // getChars()
        String s = "Investigate String functions - java the complete reference of the ninth edition";
        char[] chars1 = new char[18 - 12];
        s.getChars(12, 18, chars1, 0);
        System.out.println(chars1);

        // getBytes()
        byte[] bytes = charsString.getBytes();
        for (byte bite : bytes) {
            System.out.print(bite + " ");
        }
        System.out.println();

        // toCharArray()
        char[] chars2 = s.toCharArray();
        for (char c : chars2) {
            System.out.print(c + " ");
        }
        System.out.println();

        // equals()
        System.out.println(charsString + " == " + charsString2 + " -> " + charsString.equals(charsString2));

        // equalsIgnoreCase()
        String s1 = "test";
        String s2 = "TesT";
        System.out.println(s1 + " == " + s2 + " -> " + s1.equalsIgnoreCase(s2));

        // regionMatches()
        System.out.println(s1.regionMatches(1, s2, 1, 2));

        // startsWith()
        System.out.println(s1.startsWith("te"));
        System.out.println(s1.startsWith("est", 1));

        // endsWith()
        System.out.println(s2.endsWith("st"));
        System.out.println();

        // compareTo()
        String[] strings = {"test", "Investigate", "function", "String", "hello", "big", "half", "second", "first"};
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if(strings[i].compareToIgnoreCase(strings[j]) < 0) {
                    String temp = strings[j];
                    strings[j] = strings[i];
                    strings[i] = temp;
                }
            }
            System.out.println(strings[i]);
        }
        System.out.println();

        //indexOf() lastIndexOf()
        System.out.println("indexOf('t') " + s.indexOf('t'));
        System.out.println("indexOf('t') " + s.lastIndexOf('t'));
        System.out.println("indexOf('t', 11) " + s.indexOf('t', 11));
        System.out.println("indexOf(the) " + s.indexOf("the"));
        System.out.println();

        // substring()
        System.out.println(s.substring(12));
        System.out.println(s.substring(12, 19));
        System.out.println();

        // concat()
        System.out.println(s1.concat(s2));

        // replace()
        System.out.println(s1.replace('t', 'A'));

        // trim()
        String s4 = "       String functions        ";
        System.out.println(s4.trim());

        // valueOf()
        double d = 5.5;
        String doubleString = String.valueOf(d);
        String charToString = String.valueOf(chars);
        System.out.println(charToString);
        System.out.println(doubleString);

        // toLowerCase() toUpperCase()
        System.out.println(s2.toLowerCase());
        System.out.println(s2.toUpperCase());

        // join()
        String joinedString = String.join("-" , "investigate", "String", "functions");
        System.out.println(joinedString);

        // codePointAt() codePointBefore()
        System.out.println(joinedString.codePointAt(10));
        System.out.println(joinedString.codePointBefore(10));

        // codePointCount()
        System.out.println(joinedString.codePointCount(0, 5));

        // contains()
        System.out.println(joinedString.contains(s1.subSequence(1, 2)));

        // contentEquals()
        System.out.println(joinedString.contentEquals(s1.subSequence(1, 2)));

        // isEmpty()
        System.out.println(s.isEmpty());

        // matches()
        System.out.println(s.matches(s1));

        // offsetByCodePoints()
        System.out.println(s.offsetByCodePoints(0, 2));

        // replaceFirst() replaceAll()
        System.out.println(s.replaceFirst("the", "THE"));
        System.out.println(s.replaceAll("the", "THE"));

        // split()
        String[] split = s1.split("");
        String[] split2 = s2.split("", 3);
        for (String str : split) {
            System.out.print(str + " ");
        }
        for (String str : split2) {
            System.out.print(str + " ");
        }
        System.out.println();

        // subSequence()
        CharSequence charSequence = s.subSequence(0, 18);
        System.out.println(charSequence);

    }
}
