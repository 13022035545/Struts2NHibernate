package interceptor;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

public class CheckLoginInterceptor implements com.opensymphony.xwork2.interceptor.Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        if (ActionContext.getContext().getSession().get("user") == null) {
            ActionContext.getContext().getSession().put("message", "你还没登录，请登录");
            return "login";
        }
        else {
            String result = actionInvocation.invoke();
            return result;
        }

    }
}
