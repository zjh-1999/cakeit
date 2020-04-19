package io.cakeit.listener;

import java.util.Enumeration;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import io.cakeit.entity.Menu;
import io.cakeit.util.DB;

@WebListener
public class MyRequstListener implements ServletRequestListener, ServletRequestAttributeListener {

	public MyRequstListener() {

	}

	public void requestDestroyed(ServletRequestEvent arg0) {

	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {

	}

	public void requestInitialized(ServletRequestEvent arg0) {

	}

	public void attributeAdded(ServletRequestAttributeEvent event) {
		Enumeration<String> keys = event.getServletRequest().getAttributeNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			if (key.equals("menu")) {
				new DB().updateMenuViewTime((Menu) event.getServletRequest().getAttribute("menu"));
			}
		}

	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {

	}

}
