package test;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        char[] namec = name.toCharArray();
        char[] typedc = typed.toCharArray();
        int index = 0;
        if (typedc[0] != namec[index]) {
            return false;
        }
        for (int i = 1; i < typedc.length; i++) {
            if (typedc[i] == namec[index + 1]) {
                index++;
                if (index == namec.length - 1) {
                    return true;
                }
                continue;
            } else if (typedc[i] == namec[index]) {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LongPressedName lpn = new LongPressedName();
        System.out.println(lpn.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(lpn.isLongPressedName("leelee", "lleeelee"));
        System.out.println(lpn.isLongPressedName("laiden", "laiden"));
    }
}
