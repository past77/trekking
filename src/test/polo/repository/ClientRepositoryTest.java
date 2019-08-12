package polo.repository;

import org.junit.Before;
import org.junit.Test;
import polo.dto.ClientDTO;
import polo.entity.Client;
import polo.entity.GenderEnum;
import polo.entity.LifeStyle;
import polo.repository.specification.ClientLogin;
import polo.service.ClientService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class ClientRepositoryTest {
    private int id;
    private String userName, password;
    private ClientRepository clientRepository;
    private ResultSet resultSet;
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
        id = 2;
        userName = "Sasha";
        password = "1111";
        clientRepository = new ClientRepository();
        clientService = new ClientService();
    }

    @Test
    public void shouldReturnNotNullOnReadAllInfo() throws SQLException {
        resultSet = clientRepository.read(id);
        assertNotNull(resultSet);
    }

    @Test
    public void shouldReturnZeroLengthOnReadLoginData() {
        int rows = 0;
        try {
            resultSet = clientRepository.specificReadQuery(
                    new ClientLogin(userName, password));
            while (resultSet.next()) {
                rows++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(0, rows);
    }

    @Test
    public void shouldCreateClient() throws SQLException {

        ClientDTO client = new ClientDTO();
        client.setName("Petro");
        client.setPassword("pas");
        client.setDate(LocalDate.of(1970, 1, 1));
        client.setGender(GenderEnum.M.name());
        client.setHeight(173.3);
        client.setWeight(64.5);
        client.setLifeStyle(LifeStyle.H.name());

        ClientService clientService = new ClientService();
        clientService.addClient(client);

        Client readClient = clientService.getLoginData("Petro", "pas");

        assertEquals(readClient.getName(),  "Petro");
    }

}