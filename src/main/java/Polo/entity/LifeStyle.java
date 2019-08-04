package polo.entity;

public enum LifeStyle {
    M, L, A, H, E;

    public static float lifeStyle(LifeStyle lf){
        switch (lf){
            case A:
                return 1.55f;
            case E:
                return  1.9f;
            case H:
                return 1.725f;
            case L:
                return 1.35f;
            case M:
                return  1.1f;
            default:
                return 1;
        }
    }
//    private static final float M = 1.1f;
//    private static final float L = 1.35f;
//    private static final float A = 1.55f;
//    private static final float H = 1.725f;
//    private static final float E = 1.9f;
}
