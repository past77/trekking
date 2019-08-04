package polo.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Client {
    private int id;
    private String name;
    private String password;
    private String img;
    private DailyRation dailyRation;
    private List<Variation> variations;
    private LocalDate birthDate;
    private GenderEnum gender;
    private double height;
    private double weight;
    private LifeStyle lifeStyle;
    private NutritiveValue norm;
    private RoleEnum role;

    public NutritiveValue getNorm() {
        return norm;
    }

    public void setNorm(NutritiveValue norm) {
        this.norm = norm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DailyRation getDailyRation() {
        return dailyRation;
    }

    public void setDailyRation(DailyRation dailyRation) {
        this.dailyRation = dailyRation;
    }

    public List<Variation> getVariation() {
        return variations;
    }

    public void setDeflectionHistory(List<Variation> variations) {
        this.variations = variations;
    }

    public void setLocalDateOfBirth(LocalDate birthLocalDate) {
        this.birthDate = birthLocalDate;
    }

    public GenderEnum getGenderEnum() {
        return gender;
    }

    public void setGenderEnum(GenderEnum gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(LifeStyle lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public RoleEnum getRoleEnum() {
        return role;
    }

    public void setRoleEnum(String string) {
        this.role = RoleEnum.valueOf(string);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Double.compare(client.getHeight(), getHeight()) == 0 &&
                Double.compare(client.getWeight(), getWeight()) == 0 &&
                getName().equals(client.getName()) &&
                getImg().equals(client.getImg()) &&
                getBirthDate().equals(client.getBirthDate()) &&
                getGenderEnum() == client.getGenderEnum() &&
                getLifeStyle() == client.getLifeStyle();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getImg(), getBirthDate(), getGenderEnum(), getHeight(), getWeight(), getLifeStyle());
    }
}
