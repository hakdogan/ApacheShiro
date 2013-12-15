/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodcu.bean;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author hakdogan
 */

@ManagedBean(name= "loginBean")
@RequestScoped
public class LoginBean {
    
    private String username, password;
    private boolean rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
    
    public String login(){
        
        String returnPage = "/guest/index.xhtml?faces-redirect=true";
        
        Subject currentUser         = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        
        token.setRememberMe(rememberMe);
        
        try{
            
            currentUser.login(token);
            if(currentUser.hasRole("admin"))
                returnPage = "/admin/index.xhtml?faces-redirect=true";
            
        } catch (UnknownAccountException uae ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", "Your username wrong"));
            return null;
        } catch (IncorrectCredentialsException ice ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", "Password is incorrect"));
            return null;
        } catch (LockedAccountException lae ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", "This username is locked"));
            return null;
        } catch(AuthenticationException aex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", aex.toString()));
            return null;
        }
        
        return returnPage;
    }

    public void authorizedUserControl(){


        if(null != SecurityUtils.getSubject().getPrincipal()){

            NavigationHandler nh =  FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/authorized/index.xhtml?faces-redirect=true");

        }
    }
    
}
