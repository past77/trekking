package polo.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Variation {
    private int id;
    private int clientId;
    private NutritiveValue value;
    private LocalDate date;

    public Variation(int clientId, LocalDate date, NutritiveValue value) {
        this.clientId = clientId;
        this.date = date;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public NutritiveValue getValue() {
        return value;
    }

    public void setValue(NutritiveValue value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variation)) return false;
        Variation that = (Variation) o;
        return getValue().equals(that.getValue()) &&
                getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getDate());
    }
}
