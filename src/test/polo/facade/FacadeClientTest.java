package polo.facade;

import org.junit.Before;
import org.junit.Test;
import polo.dto.ClientDTO;
import polo.entity.GenderEnum;
import polo.entity.LifeStyle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FacadeClientTest {

    private int id;
    private ClientDTO client;
    private FacadeClient clientFacade;
    private String name;

    @Before
    public void setUp() throws Exception {
        id = 2;
        name = "Sasha";
        client = new ClientDTO();
        clientFacade = new FacadeClient();
    }

    @Test
    public void shouldReturnTrueClient() {
        client = clientFacade.getData(id);
        assertEquals(name, client.getName());
    }

    @Test
    public void shouldUpdateClientData() {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setName("Boris");
        clientDTO.setGender("W");
        clientDTO.setHeight(123.3);
        clientDTO.setWeight(23.3);
        clientDTO.setLifeStyle("E");
        clientDTO.setId(8);

        int rows = clientFacade.updateClientData(clientDTO);

        assertNotEquals(0, rows);
    }
}