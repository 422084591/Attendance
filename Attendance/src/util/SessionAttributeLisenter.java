package util;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import model.Admin;

/**
 * Application Lifecycle Listener implementation class SessionAttributeLisenter
 *
 */
@WebListener
public class SessionAttributeLisenter implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAttributeLisenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	if(se.getName().equals("User")) {//监听session中是否存在着key为User的session，如果存在就取出来，不存在就存进去一个
    		Admin admin=(Admin)se.getValue();
    		if(SessionManger.sessionMap.containsKey(admin.getUsername())) {
    			HttpSession httpSession=SessionManger.sessionMap.get(admin.getUsername());
    			httpSession.removeAttribute("User");
    			SessionManger.sessionMap.remove(admin.getUsername());
    		}
    		SessionManger.sessionMap.put(admin.getUsername(),se.getSession());
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
