package polo.service;


import polo.dto.ClientDTO;
import polo.entity.Client;
import polo.entity.GenderEnum;
import polo.entity.LifeStyle;
import polo.repository.ClientRepository;
import polo.repository.IRepository;
import polo.repository.specification.ClientLogin;
import polo.repository.specification.ClientName;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ClientService {

    private static final Logger LOG = Logger.getLogger(ClientService.class);

    public Client getLoginData(String username, String password) {
        ClientRepository clientRepository = new ClientRepository();

        Client client = null;

        try (ResultSet clientRes = clientRepository.specificReadQuery(
                new ClientLogin(username, password))) {

            while (clientRes.next()) {
                client = new Client();
                client.setId(clientRes.getInt(1));
                client.setName(clientRes.getString(2));
                client.setPassword(clientRes.getString(3));
                client.setRoleEnum(clientRes.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

    public Client getRawData(int id) {
        ClientRepository clientRepository = new ClientRepository();
        Client client = new Client();

        try {
            ResultSet clientRes = clientRepository.read(id);
            while (clientRes.next()) {
                client.setImg(clientRes.getString(1));
                client.setName(clientRes.getString(2));
                client.setBirthDate(clientRes.getDate(3).toLocalDate());
                client.setGenderEnum(GenderEnum.valueOf(clientRes.getString(4)));
                client.setHeight(clientRes.getDouble(5));
                client.setWeight(clientRes.getDouble(6));
                client.setLifeStyle(LifeStyle.valueOf(clientRes.getString(7)));
              // LifeStyle lf = LifeStyle.valueOf(clientRes.getString(7));
                //client.setLifeStyle(LifeStyle.lifeStyle(lf));
            }
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addClient(ClientDTO client) {
        Object[] args = new Object[7];

        args[0] = client.getName();
        args[1] = client.getPassword();
        args[2] = client.getDate();
        args[3] = client.getGender();
        args[4] = client.getHeight();
        args[5] = client.getWeight();
        args[6] = client.getLifeStyle();

        IRepository clientRepo = new ClientRepository();
        try {
            clientRepo.create(args);
            LOG.info("Created new client " + client.getName());
        } catch (SQLException e) {
            LOG.error("Fail to create new client " + client.getName() +
                    " " + e);
        }
    }

    public int updateClientData(Client client) {
        ClientRepository clientRepository = new ClientRepository();
        Object[] args = new Object[7];

        args[0] = client.getName();
        args[1] = client.getGenderEnum();
        args[2] = client.getHeight();
        args[3] = client.getWeight();
        args[4] = client.getLifeStyle();
        args[5] = client.getImg();
        args[6] = client.getId();


        try {
            int rows = clientRepository.update(args);
            LOG.info("Client #" + client.getId() + " updated successfully");
        } catch (SQLException e) {
            LOG.error("Failed to update client #" + client.getId() + "\n" + e);
            e.printStackTrace();
        }

        return 0;
    }


    public String getName(int id) {
        ClientRepository repo = new ClientRepository();

        String name = null;
        try (ResultSet result = repo.specificReadQuery(
                new ClientName(id))) {
            while (result.next()) {
                name = result.getString(1);
            }
            LOG.info("Read client`s name successfully");
        } catch (SQLException e) {
            LOG.error("Failed to read client`s name:" + e);
        }

        return name;
    }

}
