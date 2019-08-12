package polo.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddFoodTest {

    @Test
    public void shouldExecute() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        AddFood addFood = mock(AddFood.class);

        addFood.execute(req);
        verify(addFood).execute(req);
    }

}