package com.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.UserServiceImpl;

public class LoginAction extends ActionSupport {

    private String username;
    private String password;
    private UserService userService = new UserServiceImpl();
    private String s_password;

    public String loginExecute() {

        /*if (username == null || password == null || password.equals("") || username.equals("")) {
            addFieldError("loginError","账户或密码错误");
            return LOGIN;
        }*/
        User user = null;
        if((user = userService.login(username, password)) != null){
            ActionContext.getContext().getSession().put("user", user);
            return SUCCESS;
        }else{
            addFieldError("loginError","账户或密码错误");
            return INPUT;
        }
    }

    public String signExecute(){
        String message = null;

        /*if (username == null || password == null || password.equals("") || username.equals("")) {
            addFieldError("signError", "注册失败，请重新注册");
            return INPUT;
        }*/

        if (userService.sign(username, password,  s_password)) {
            message = "注册成功,请登录";
            ActionContext.getContext().getSession().put("message", message);
            return SUCCESS;
        }
        else {
            addFieldError("signError", "注册失败，请重新注册");
            return INPUT;
        }
    }

    public void validateLoginExecute(){
        if (username == null || password == null || password.equals("") || username.equals("")) {
            addFieldError("loginError","账户或密码错误");
        }
    }

    public void validateSignExecute(){
        if (username == null || password == null || password.equals("") || username.equals("")
                || s_password == null || s_password.equals("")) {
            addFieldError("signError", "注册失败，请重新注册");
        }
    }

    public LoginAction() {
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

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
}
