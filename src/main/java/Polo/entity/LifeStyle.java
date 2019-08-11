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

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
