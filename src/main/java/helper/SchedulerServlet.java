package helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SchedulerServlet extends HttpServlet {
    public void init() throws ServletException
    {
        System.out.println("----------");
        System.out.println("---------- Scheduler Initialized successfully ----------");
        System.out.println("----------");
    }
}
