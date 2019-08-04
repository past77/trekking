package polo.facade;



import polo.dto.ClientDTO;
import polo.dto.ClientStatisticsDTO;
import polo.entity.Client;
import polo.entity.GenderEnum;
import polo.entity.LifeStyle;
import polo.entity.NutritiveValue;
import polo.repository.ClientRepository;
import polo.repository.specification.ClientStatistics;
import polo.service.ClientService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

public class FacadeClient {
    private static final Logger LOG = Logger.getLogger(FacadeClient.class);

    public ClientDTO getData(int id) {
        ClientService clientService = new ClientService();
        Client client = clientService.getRawData(id);

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setImg(client.getImg());
        clientDTO.setName(client.getName());
        clientDTO.setAge(countAge(client.getBirthDate()));
        clientDTO.setGender(identifyGender(client.getGenderEnum()));
        clientDTO.setHeight(client.getHeight());
        clientDTO.setWeight(client.getWeight());
        clientDTO.setLifeStyle(identifyLifeStyle(client.getLifeStyle()));

        return clientDTO;
    }

    public int updateClientData(ClientDTO clientData) {
        Client dataToPass = new Client();

        dataToPass.setName(clientData.getName());
        dataToPass.setGenderEnum(cacheGender(clientData.getGender()));
        dataToPass.setHeight(clientData.getHeight());
        dataToPass.setWeight(clientData.getWeight());
        dataToPass.setLifeStyle(cacheLifeStyle(clientData.getLifeStyle()));
        dataToPass.setId(clientData.getId());

        return new ClientService().updateClientData(dataToPass);
    }

    private String identifyGender(GenderEnum gender) {
        String shortCut = gender.name();

        if (shortCut.equals("M")) {
            return "male";
        } else {
            return "female";
        }
    }

    private GenderEnum cacheGender(String genderName) {
        if (genderName.equals("male")) {
            return GenderEnum.M;
        }
        return GenderEnum.W;
    }

    private int countAge(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    private String identifyLifeStyle(LifeStyle lifeStyle) {
        switch (lifeStyle) {
            case L:
                return "Lite";
            case A:
                return "Average";
            case H:
                return "Hard";
            case E:
                return "Extreme";
            default:
                return "Minimal";
        }
    }

    public LifeStyle cacheLifeStyle(String lifestyleName) {
        switch (lifestyleName) {
            case "Lite":
                return LifeStyle.L;
            case "Average":
                return LifeStyle.A;
            case "Hard":
                return LifeStyle.H;
            case "Extreme":
                return LifeStyle.E;
            default:
                return LifeStyle.M;
        }
    }

    public List<ClientStatisticsDTO> getClientStatistics() {
        ClientRepository repo = new ClientRepository();

        List<ClientStatisticsDTO> clients = null;
        try {
            ResultSet result = repo.specificReadQuery(new ClientStatistics());

            clients = new LinkedList<>();
            while (result.next()) {
                ClientStatisticsDTO client = new ClientStatisticsDTO();
                client.setName(result.getString(1));
                client.setAverageDeflection(new NutritiveValue(
                        result.getDouble(2),
                        result.getDouble(3),
                        result.getDouble(4),
                        result.getDouble(5)
                ));
                client.setFavFood(result.getString(6));

                clients.add(client);
            }

            LOG.info("Read clients statistics successfully");
        } catch (SQLException e) {
            LOG.error("Failed to read clients statistics");
        }
        return clients;
    }
}
