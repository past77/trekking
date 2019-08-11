package polo.entity;

public enum GenderEnum {
    M, W;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
