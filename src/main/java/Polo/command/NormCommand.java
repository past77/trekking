package polo.command;

import org.apache.log4j.Logger;
import polo.entity.*;
import polo.facade.DailyFacade;
import polo.facade.DeflectionFacade;
import polo.facade.FacadeClient;
import polo.repository.AbstaractFuncForRepo;
import polo.service.CoeficientService;
import polo.service.FoodService;
import polo.utils.AppUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class NormCommand extends AbstaractFuncForRepo implements ICommand{
   private ArrayList<ArrayList<Food>> dailyRation = AddToPlate.aList;
    /**
     * Command designed for client`s norm deflection
     */

    private static final Logger LOG = Logger.getLogger(NormCommand.class);

    /**
     * Receive data from "plate" and client`s parameters
     * and calculates norm deflection according to this data
     *
     * @param req request that contains data about client`s
     *            "plate" and parameters
     * @return norm deflection output
     */

    @Override
    public String execute(HttpServletRequest req) {
        ArrayList<Food> listFood = null;
        List<String> norma = null;
        Client client = AppUtils.getClientFromSession(req);

        LOG.info("Calculating eaten nutritive value");

        double calories = 0.0, proteins = 0.0, fats = 0.0, carbohydrates = 0.0, amount = 0.0;
        for (int i = 0; i < dailyRation.size(); i++) {
            listFood = dailyRation.get(i);
            amount = AddToPlate.dailyPlate.get(i);
            for (Food food : listFood) {
                calories += (food.getCalories()* amount);
                proteins += (food.getProtein() * amount);
                fats += (food.getFat() * amount);
                carbohydrates += (food.getCarbohydrates() * amount);
            }
        }
        NutritiveValue eaten = new NutritiveValue(calories, proteins, fats,
                carbohydrates);
        LOG.info("Daily nutritive value is: " + eaten);

        LOG.info("Calculating client`s norm");
        LOG.info("Getting coeficientfrom database");
        double[] coefs = new CoeficientService().getCoeficient(client.getGenderEnum());

        LifeStyle lifeStyle = new FacadeClient().cacheLifeStyle(
                (String) req.getServletContext().getAttribute("lifeStyle"));

        calories = (coefs[0] + coefs[1] * (Double) req.getServletContext().getAttribute("weight") +
                coefs[2] * (Double) req.getServletContext().getAttribute("height") +
                coefs[3] * (Integer) req.getServletContext().getAttribute("age")) * LifeStyle.lifeStyle(lifeStyle);
        proteins = carbohydrates = calories / 4;
        fats = calories / 9;

        NutritiveValue norm = new NutritiveValue(calories, proteins, fats, carbohydrates);

        NutritiveValue deflection = eaten.subtract(norm);

        //write deflection
        DeflectionFacade deflectionFacade = new DeflectionFacade();
        deflectionFacade.writeDeflection(deflection, client.getId());

        norma = new ArrayList<>();
        norma.add(String.format("%.1f",deflection.getCalories()));
        norma.add(String.format("%.1f",deflection.getCalories()));
        norma.add(String.format("%.1f",deflection.getFat()));
        norma.add(String.format("%.1f",deflection.getCarbohydrates()));

        req.setAttribute("norma", norma);
        return "/jsp/client_page.jsp";
    }
}
