class 344ReverseString {
    public String reverseString(String s) {
        StringBuilder out = new StringBuilder();
        for ( int i = 0; i < s.length(); i++ )
            out.append(s.charAt(s.length() - i - 1));
        return out.toString();
    }
}