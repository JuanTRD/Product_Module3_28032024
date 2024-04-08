package Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUser {
    public static boolean checkUser(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session != null){
            return session.getAttribute("idUser") != null;
        }
        return false;
    }
}
