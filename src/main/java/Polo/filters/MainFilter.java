package polo.filters;

import polo.entity.Client;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public abstract class MainFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        Client user = null;

        if(session != null) {
            user = ((Client) req.getSession().getAttribute("client"));
            System.out.println("user: " + user);
        }

        if(isn_tAllowed(req, user)) {
            resp.sendRedirect("/");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    abstract boolean isn_tAllowed(HttpServletRequest req, Client user);

    @Override
    public void destroy() {

    }
}
