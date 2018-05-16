package com.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.UserServiceImpl;

public class ChangePasswordAction extends ActionSupport {
    private String f_password;
    private String n_password;
    private String s_password;
    private UserService userService = new UserServiceImpl();
    private User user = (User)ActionContext.getContext().getSession().get("user");

    public ChangePasswordAction() {

    }

    @Override
    public void validate() {
        if (f_password == null || f_password.equals("") || !f_password.equals(user.getPassword())) {
            addFieldError("f_passwordError", "旧密码错误不匹配");
            return;
        }
        if (n_password == null || n_password.equals("")){
            addFieldError("n_passwordError", "新密码不能为空");
            return;
        }

        if(f_password.equals(n_password)){
            addFieldError("n_passwordError", "新密码不能与旧密码一致");
            return;
        }
        if (s_password == null || s_password.equals("")) {
            addFieldError("s_passwordError", "确认密码不能为空");
            return;
        }
        if (!s_password.equals(n_password)){
            addFieldError("notSuitError", "新密码与确认密码不一致");
            return;
        }
    }

    @Override
    public String execute() throws Exception {
        User userChange = new User();
        userChange.setUserId(user.getUserId());
        userChange.setUsername(user.getUsername());
        userChange.setPassword(n_password);
        if (userService.changePasswordService(userChange)){
            ActionContext.getContext().getSession().put("cPassSuccess", "修改密码成功");
            ActionContext.getContext().getSession().put("user", userChange);
            return SUCCESS;
        }else{
            ActionContext.getContext().getSession().put("message", "修改密码失败");
            return INPUT;
        }
    }

    public String getF_password() {
        return f_password;
    }

    public void setF_password(String f_password) {
        this.f_password = f_password;
    }

    public String getN_password() {
        return n_password;
    }

    public void setN_password(String n_password) {
        this.n_password = n_password;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_pasword) {
        this.s_password = s_pasword;
    }
}
