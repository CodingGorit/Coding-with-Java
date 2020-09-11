package cn.gorit.controller.origin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

@Controller
public class OriginAPIController {

    @RequestMapping("/testrequest")
    public void requestOrResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","application/json");
        response.getWriter().println("{'name':'Gorit','age':18}");
    }

    @RequestMapping("/writer")
    public void reader(Writer w) throws IOException {
        w.write("Response By Writer");
    }

//    @RequestMapping("/instream")
//    public void inputstream(OutputStream os ) throws IOException {
//        os.write(new Byte("\"Response By OutPutStream\""));
//    }

    /**
     * WebRequest是Spring Web MVC提供的统一请求访问接口，
     * 不仅仅可以访问请求相关数据（如参数区数据、请求头数据，但访问不到Cookie区数据），
     * 还可以访问会话和上下文中的数据；NativeWebRequest继承了WebRequest，
     * 并提供访问本地Servlet API的方法；
     * @param webRequest
     * @param nativeWebRequest
     * @throws IOException
     */
    @RequestMapping("/webrequest")
    public void webRequest(WebRequest webRequest, NativeWebRequest nativeWebRequest) throws IOException {
        System.out.println(webRequest.getContextPath());
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        HttpSession session = request.getSession();
        session.setAttribute("msg","Hello");
        response.sendRedirect("/main");
    }

    @RequestMapping("/session")
    public String session(HttpSession session) {
        System.out.println(session);
        System.out.println(session.getAttribute("msg"));
        return "success";
    }

}
