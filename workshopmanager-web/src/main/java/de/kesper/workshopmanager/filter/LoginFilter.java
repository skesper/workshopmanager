/*
 *  15.09.2014 (C) Stephan Kesper
 */
package de.kesper.workshopmanager.filter;

import de.kesper.workshopmanager.beans.SessionBean;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kesper
 */
public class LoginFilter implements Filter {
    
    private static final Logger log = Logger.getLogger("LoginFilter");
    
    @Inject
    private SessionBean sessionBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        
        if (sessionBean.isAuthenticated()) {
            chain.doFilter(request, response);
            return;
        }
        log.log(Level.INFO, "Denied request for {0}", httpRequest.getSession().getId());
        ((HttpServletResponse)response).sendRedirect("/workshopmanager-web/index.xhtml");
    }

    @Override
    public void destroy() {
        
    }
    
}
