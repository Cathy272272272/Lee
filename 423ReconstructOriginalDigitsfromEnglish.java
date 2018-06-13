class 423ReconstructOriginalDigitsfromEnglish {
    public String originalDigits(String ss) {
        int n = ss.length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> res = new HashMap<String, Integer>();
        for ( int i = 0; i < n; i++) {
            map.put(ss.substring(i,i+1),map.getOrDefault(ss.substring(i,i+1),0)+1);
        }
        //System.out.println(map);
        if ( map.containsKey("x") ) {
        int x = map.get("x");
        res.put("6", x);
        map.put("s", map.get("s") - x);
        map.put("i", map.get("i") - x);
        }
        if ( map.containsKey("g")) {
        int g = map.get("g");
        res.put("8", g);
        map.put("e", map.get("e") - g);
        map.put("i", map.get("i") - g);
        map.put("h", map.get("h") - g);
        map.put("t", map.get("t") - g);
        }
        if ( map.containsKey("z")) {
        int z = map.get("z");
        res.put("0", z);
        map.put("e", map.get("e") - z);
        map.put("r", map.get("r") - z);
        map.put("o", map.get("o") - z);
        }
        if ( map.containsKey("u")) {
        int u = map.get("u");
        res.put("4", u);
        map.put("f", map.get("f") - u);
        map.put("o", map.get("o") - u);
        map.put("r", map.get("r") - u);
        }
        if ( map.containsKey("h")) {
        int h = map.get("h");
        if ( map.containsKey("t") && map.containsKey("r") && map.containsKey("e")) {
        res.put("3", h);
        map.put("t", map.get("t") - h);
        map.put("r", map.get("r") - h);
        map.put("e", map.get("e") - h);
        }
        }
        if ( map.containsKey("s")) {
        if (map.containsKey("e") && map.containsKey("v") && map.containsKey("n")) { 
        int s = map.get("s");
        res.put("7", s);
        map.put("e", map.get("e") - s);
        map.put("v", map.get("v") - s);
        map.put("n", map.get("n") - s);
        }
        }
        if ( map.containsKey("v")) {
        int v = map.get("v");
        if ( map.containsKey("f") && map.containsKey("v") && map.containsKey("e")) {
        res.put("5", v);
        map.put("f", map.get("f") - v);
        map.put("i", map.get("i") - v);
        map.put("e", map.get("e") - v);
        }
        }
        if ( map.containsKey("i")) {
        int i = map.get("i");
        if ( map.containsKey("n") && map.containsKey("e")) {
        res.put("9", i);
        map.put("n", map.get("n") - i);
        map.put("e", map.get("e") - i);
        }
        }
        if ( map.containsKey("w")) {
        int w = map.get("w");
        res.put("2", w);
        map.put("t", map.get("t") - w);
        map.put("o", map.get("o") - w);
        }
        if ( map.containsKey("o")) {
        if ( map.containsKey("n") && map.containsKey("e")) {
        int o = map.get("o");
        res.put("1", o);
        map.put("n", map.get("n") - o);
        map.put("e", map.get("e") - o);
        }
        }
        StringBuilder out = new StringBuilder();
        for ( String k : res.keySet() ) {
            for ( int j = 0; j < res.get(k); j++ )
                out.append(k);
        }
        return out.toString();
    }
}