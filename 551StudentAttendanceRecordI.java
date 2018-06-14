class 551StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int l = s.length(), a = 0, count = 0;
        char last = s.charAt(0), cur;
        if ( last == 'A' ) a++;
        for ( int i = 1; i < l; i++ ) {
            cur = s.charAt(i);
            if ( cur == 'L' && last == 'L' ) count++;
            else count = 0;
            last = cur;
            if ( last == 'A' ) a++;
            if ( a > 1 || count == 2) return false;
        }
        return true;
    }
}