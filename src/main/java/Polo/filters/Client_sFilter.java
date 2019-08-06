package polo.filters;


import polo.entity.Client;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Client_sFilter extends MainFilter{
    private List<String> notAllowed;

    public void init(FilterConfig filterConfig) throws ServletException {

       notAllowed = new ArrayList();

        notAllowed.add("/login");
        notAllowed.add("/registration");

    }


    @Override
    boolean isn_tAllowed(HttpServletRequest req, Client user) {
//        System.out.println("user: " + user.getRoleEnum());
        return user != null && notAllowed.contains(req.getServletPath());
    }
}
