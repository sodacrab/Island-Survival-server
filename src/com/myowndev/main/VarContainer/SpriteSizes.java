package com.myowndev.main.VarContainer;

enum SpriteSizes {

    // TODO: create getter of sizes from files

    //PLAYER (15, 15),
    //RAINDROP (12, 19),
    BANANA (21, 21),
    SHIP (18, 22),
    LIGHTNING (14, 20),
    SUN (20, 20),
    MOON (20, 20);

    private final int w;
    private final int h;

    SpriteSizes(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public int getW() { return w; }
    public int getH() { return h; }

}
