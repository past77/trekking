package polo.command;


import polo.dto.ClientStatisticsDTO;
import polo.facade.FacadeClient;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetClientsStatisticTable implements ICommand {
    /**
     * Command to generate information about client's history
     * what food have been eaten and amount
     */

    /**
     * Provides output of clients statistics 5 records
     * per page
     * @param req request where data for output is storred
     * @return doctor page url for redirect
     */
    @Override
    public String execute(HttpServletRequest req) {
        FacadeClient clientFacade = new FacadeClient();

        List<ClientStatisticsDTO> clientStat = clientFacade.getClientStatistics();

        int page = 1;
        String pageStr;
        if ((pageStr = req.getParameter("page")) != null) {
            page = Integer.parseInt(pageStr.trim());
        }

        int fromIndex = (page - 1) * 15;
        int toIndex = fromIndex + 14;
        req.setAttribute("clientStat", clientStat.subList(fromIndex, toIndex));

        List<Integer> links = IntStream.rangeClosed(1, clientStat.size() / 15)
                .boxed().collect(Collectors.toList());
        req.setAttribute("links", links);


        return "jsp/stat_page.jsp";
    }
}
