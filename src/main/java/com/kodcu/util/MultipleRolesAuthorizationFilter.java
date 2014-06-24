package com.kodcu.util;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

/**
 *
 * @author hakdogan
 */

public class MultipleRolesAuthorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response,
                                   Object mappedValue) throws IOException {

        final Subject subject = getSubject(request, response);
        final String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }

        for (String roleName : rolesArray) {
            if (subject.hasRole(roleName)) {
                return true;
            }
        }

        return false;
    }
}