package jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/30 10:23
 * @Description:
 */
public class TestController extends AbstractHandler {
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException, ServletException {
        System.out.println(s);
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);
        PrintWriter out = httpServletResponse.getWriter();
        if (s.equals("/favicon.ico")) {
            System.out.println(1);
            out.println("404");
        } else {
            System.out.println(2);
            out.println("hello jetty");
            if (httpServletRequest.getParameter("name") != null) {
                out.println(httpServletRequest.getParameter("name"));
            }
        }
    }
}
