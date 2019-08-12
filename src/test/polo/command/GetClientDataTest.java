package polo.command;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class GetClientDataTest {
    private HttpServletRequest req;
    private int id;
    private String url;
    private GetClientData generateClientData;

    @Before
    public void setUp() throws Exception {
        req = mock(HttpServletRequest.class);
        id = 2;
        url = "/jsp/client_page.jsp";
        generateClientData = new GetClientData();
    }

    @Test
    public void shouldReturnTrueUrl() {
        String testUrl = generateClientData.execute(req);
        assertEquals(url, testUrl);
    }

}