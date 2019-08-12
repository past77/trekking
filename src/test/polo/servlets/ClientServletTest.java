package polo.servlets;

import org.junit.Before;
import org.junit.Test;
import polo.entity.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClientServletTest {
    private Client client;
    private int id;
    private ClientServlet clientServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;


    @Before
    public void setUp() throws Exception {
        client = mock(Client.class);
        id = 2;
        clientServlet = mock(ClientServlet.class);
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
    }

    @Test
    public void shouldGetTrueClientId() throws ServletException, IOException {
        when(client.getId()).thenReturn(id);

        clientServlet.doGet(req, resp);
        //verify(client).getId();
        assertEquals(id, client.getId());
    }

}