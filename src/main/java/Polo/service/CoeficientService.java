package polo.service;


import org.apache.log4j.Logger;
import polo.entity.GenderEnum;
import polo.repository.CoeficientRepository;
import polo.repository.specification.CoeficientMen;
import polo.repository.specification.CoeficientWomen;
import polo.repository.specification.SQLSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoeficientService {
    private static final Logger LOG = Logger.getLogger(CoeficientService.class);

    public double[] getCoeficient(GenderEnum gender) {
        CoeficientRepository coeficientRepository = new CoeficientRepository();
        SQLSpecification genderSpecification;

        if (gender == GenderEnum.M) {
            genderSpecification = new CoeficientMen();
        } else {
            genderSpecification = new CoeficientWomen();
        }

        double[] coeficient = null;
        try (ResultSet resutlSet = coeficientRepository
                .specificReadQuery(genderSpecification)) {

            coeficient = new double[4];
            int ind = 0;
            while (resutlSet.next()) {
                coeficient[ind] = resutlSet.getDouble(1);
                ind++;
            }

            LOG.info("Get coeficient:" + coeficient[0] + " " + coeficient[1] + " "
                    + coeficient[2] + " " + coeficient[3] + " ");
        } catch (SQLException e) {
            LOG.fatal("Failed to get coeficient: " + e);
        }

        return coeficient;
    }
}
