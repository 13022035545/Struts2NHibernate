package com.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class aAction extends ActionSupport {
    int which;
    @Override
    public String execute(){
            if (which == 0) return "0";
            else if (which == 1) return "1";
            else if (which == 2) return "2";
            else if (which == 3) return "3";
            else if (which == 4) {
                ActionContext.getContext().getSession().remove("user");
                return LOGIN;
            }

            return "stay";
    }

    public aAction() {
        ActionContext.getContext().getSession().remove("message");
        ActionContext.getContext().getSession().remove("cPassSuccess");
        ActionContext.getContext().getSession().put("page", 0);
    }

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }
}
