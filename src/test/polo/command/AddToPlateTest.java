package polo.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddToPlateTest {

    @Test
    public void shouldExecute() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        AddToPlate addToPlate = mock(AddToPlate.class);

        addToPlate.execute(req);
        verify(addToPlate).execute(req);
    }
}