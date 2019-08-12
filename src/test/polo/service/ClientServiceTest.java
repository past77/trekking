package polo.service;

import org.junit.Before;
import org.junit.Test;
import polo.dto.ClientDTO;
import polo.entity.Client;
import polo.entity.GenderEnum;
import polo.entity.LifeStyle;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ClientServiceTest {
    private String username, password;
    private ClientService clientService;
    private Client client;
    private int id;

    @Before
    public void setUp() throws Exception {
        id = 10;
        username = "Sasha";
        password = "1111";
        client = new Client();
        clientService = new ClientService();
    }

    @Test
    public void shouldReturnTrueClientOnGetRawData() {
        client = clientService.getRawData(id);
        assertEquals(username, client.getName());
    }

    @Test
    public void shouldReturnNullOnLogin() {
        Client client = clientService.getLoginData(username, password);
        assertNull(client);
    }

    @Test
    public void shouldAddClient() {
        ClientDTO client = new ClientDTO();
        client.setImg("sample img");
        client.setName("Boris");
        client.setDate(LocalDate.of(1970, 1, 1));
        client.setGender(GenderEnum.M.name());
        client.setHeight(173.3);
        client.setWeight(64.5);
        client.setLifeStyle(LifeStyle.H.name());

        int rows = clientService.addClient(client);

        assertEquals(0, rows);
    }
}