/*
 * public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i)
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
}
I go through the pattern letters and words in parallel and compare the indexes where they last appeared.

Edit 1: Originally I compared the first indexes where they appeared, using putIfAbsent instead of put. That was based on mathsam's solution for the old Isomorphic Strings problem. But then czonzhu's answer below made me realize that put works as well and why.

Edit 2: Switched from

    for (int i=0; i<words.length; ++i)
        if (!Objects.equals(index.put(pattern.charAt(i), i),
                            index.put(words[i], i)))
            return false;
to the current version with i being an Integer object, which allows to compare with just != because there's no autoboxing-same-value-to-different-objects-problem anymore. Thanks to lap_218 for somewhat pointing that out in the comments.
*/
class 290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split("\\s+");
        String[] a = new String[128];
        Map<String, Integer> map = new HashMap<>();
        int n = s.length;
        if ( n != pattern.length() ) return false;
        for ( int i = 0; i < n; i++ ) {
            int tmp = (int)pattern.charAt(i);
            if ( a[tmp] == null ) {
                a[tmp] = s[i];
                if ( map.containsKey(s[i]) ) return false;
                map.put(s[i], tmp);
                continue;
            }
            if ( !s[i].equals(a[tmp]) ) return false;
        }
        return true;
    }
}