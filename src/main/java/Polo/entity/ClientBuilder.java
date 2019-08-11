package polo.entity;

import polo.dto.ClientDTO;

import java.time.LocalDate;

public class ClientBuilder {
    private ClientDTO clientUnit;

    public void reset() {
        clientUnit = new ClientDTO();
    }

    public void setName(String name) {
        clientUnit.setName(name);
    }

    public void setPassword(String password) {
        clientUnit.setPassword(password);
    }

    public void setBirthDate(LocalDate date) {
        clientUnit.setDate(date);
    }

    public void setGenderEnum(String gender) {
        clientUnit.setGender(gender);
    }

    public void setHeight(double height) {
        clientUnit.setHeight(height);
    }

    public void setWeight(double weight) {
        clientUnit.setWeight(weight);
    }

    public void setLifeStyle(String lifeStyle) {
        clientUnit.setLifeStyle(lifeStyle);
    }

    public ClientDTO getResult() {
        return clientUnit;
    }
}
