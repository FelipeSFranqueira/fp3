package com.fp3.haras.utils;

public enum Colors {
    WHITEBG(new int[] {255, 255, 255}),
    PRIMARYBG(new int[] {244, 244, 244}),
    SECONDARYBG(new int[] {234, 234, 234}),
    SECONDARYBGHOVER(new int[] {200, 200, 200}),
    ACCENTBLUE(new int[] {0, 120, 212});
    
    private int[] rgb;
    
    Colors(int[] rgb) {
        this.rgb = rgb;
    }
    
    public int[] getColor() {
        return rgb;
    }
}
