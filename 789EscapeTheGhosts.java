class 789EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        if ( ghosts.length > 100 ) return false;
        int[] pos = {0, 0};
        int you = move ( pos, target);
        for ( int i = 0; i < ghosts.length; i++ ) {
            if ( move(ghosts[i], target) <= you )
                return false;
        }
        return true;
    }
    public int move ( int[] pos, int[] target ) {
        return Math.abs(target[0] - pos[0]) + Math.abs(target[1] - pos[1]);
    }
}