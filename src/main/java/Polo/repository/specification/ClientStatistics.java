package polo.repository.specification;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientStatistics implements SQLSpecification {
    ConnectionManager connectionManager;

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        connectionManager = new ConnectorManager();

        return connectionManager.getConnection()
                .prepareStatement("SELECT\n" +
                        "   c.`name`,\n" +
                        "   dh_ave.avg_cal,\n" +
                        "   dh_ave.avg_prot,\n" +
                        "   dh_ave.avg_fat,\n" +
                        "   dh_ave.avg_carb,\n" +
                        "   f.name\n" +
                        "FROM\n" +
                        "   clients AS c \n" +
                        "   left outer join\n" +
                        "      (\n" +
                        "         SELECT\n" +
                        "            dh.client_id,\n" +
                        "            AVG(dh.calories) AS avg_cal,\n" +
                        "            AVG(dh.proteins) AS avg_prot,\n" +
                        "            AVG(dh.fats) AS avg_fat,\n" +
                        "            AVG(dh.carbohydrates) AS avg_carb \n" +
                        "         from\n" +
                        "            deflection_history AS dh \n" +
                        "         group by\n" +
                        "            dh.client_id \n" +
                        "      )\n" +
                        "      AS dh_ave \n" +
                        "      ON dh_ave.client_id = c.id\n" +
                        "   left outer join\n" +
                        "      (\n" +
                        "         select\n" +
                        "            food_sums.client_id,\n" +
                        "            food_sums.food_id \n" +
                        "         from\n" +
                        "            (\n" +
                        "               select\n" +
                        "                  fh.client_id,\n" +
                        "                  fh.food_id,\n" +
                        "                  sum(fh.amount) as f_amount \n" +
                        "               from\n" +
                        "                  food_history fh \n" +
                        "               group by\n" +
                        "                  fh.client_id,\n" +
                        "                  fh.food_id \n" +
                        "            )\n" +
                        "            as food_sums \n" +
                        "         where\n" +
                        "            food_sums.f_amount = \n" +
                        "            (\n" +
                        "               select\n" +
                        "                  max(f_sums.f_amount) \n" +
                        "               from\n" +
                        "                  (\n" +
                        "                     select\n" +
                        "                        fh1.client_id, fh1.food_id, sum(fh1.amount) as f_amount \n" +
                        "                     from food_history fh1 \n" +
                        "                     \n" +
                        "\t\t\t\t\t group by\n" +
                        "                        fh1.client_id,\n" +
                        "                        fh1.food_id \n" +
                        "                  )\n" +
                        "                  as f_sums \n" +
                        "                  where f_sums.client_id = food_sums.client_id \n" +
                        "\t\t\t\t\t\tand f_sums.food_id = food_sums.food_id\n" +
                        "            )\n" +
                        "      ) as max_food on max_food.client_id = c.id \n" +
                        "    INNER JOIN food as f on f.id = max_food.food_id;");
    }
}
