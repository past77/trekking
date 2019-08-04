package polo.facade;

;

import polo.entity.DeflectionRecord;
import polo.entity.NutritiveValue;
import polo.service.DeflectionService;

import java.time.LocalDate;

public class DeflectionFacade {
    public void writeDeflection(NutritiveValue deflection, int clientId) {
        DeflectionRecord deflectionRecord =
                new DeflectionRecord(clientId, LocalDate.now(), deflection);

        DeflectionService deflectionService = new DeflectionService();
        deflectionService.writeDeflection(deflectionRecord);
    }
}
