package polo.utils;

import javax.servlet.http.HttpServletRequest;

class UrlPatternUtils {
    static String getUrlPattern(HttpServletRequest request) {
        String servletPath = request.getServletPath();

        if (servletPath.contains("?")) {
            return servletPath.substring(servletPath.lastIndexOf("/"),
                    servletPath.indexOf("?"));
        }
        if (servletPath.contains("#")) {
            return servletPath.substring(servletPath.lastIndexOf("/"),
                    servletPath.indexOf("#"));
        }

        return servletPath.substring(servletPath.lastIndexOf("/"));
    }
}
