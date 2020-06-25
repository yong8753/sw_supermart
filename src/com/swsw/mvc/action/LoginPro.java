package com.swsw.mvc.action;
import javax.servlet.http.*;
import com.swsw.mvc.action.CommandAction;

public class LoginPro implements CommandAction{
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    

        return "/supermarket/Login.html";
    }
}