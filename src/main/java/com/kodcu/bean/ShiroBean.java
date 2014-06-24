package com.kodcu.bean;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by hakdogan on 24/06/14.
 */

@ManagedBean
@RequestScoped
public class ShiroBean {

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

    public void loginUser(){

        try{

            Subject currentUser         = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, new Sha256Hash(password).toHex());

            token.setRememberMe(rememberMe);
            currentUser.login(token);

        } catch (UnknownAccountException uae ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", "Your username wrong"));

        } catch (IncorrectCredentialsException ice ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", "Password is incorrect"));

        } catch (LockedAccountException lae ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", "This username is locked"));

        } catch(AuthenticationException aex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", aex.toString()));
        }

    }

    public void authorizedUserControl(){

        if(null != SecurityUtils.getSubject().getPrincipal()){

            NavigationHandler nh =  FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/member/index.xhtml?faces-redirect=true");

        }
    }
}
