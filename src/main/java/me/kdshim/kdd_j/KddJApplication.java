package me.kdshim.kdd_j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@EnableJpaAuditing
public class KddJApplication {

    public static void main(String[] args) {
        SpringApplication.run(KddJApplication.class, args);


//서블릿을 통해서 서버를 띄워보는 놈
//        //해당 프로젝트는 undertow 을 사용하고 있기 떄문에 undertow servlet 생성으로 수정
//        ServletWebServerFactory servletWebServerFactory = new UndertowServletWebServerFactory();
//        WebServer webServer = servletWebServerFactory.getWebServer(servletContext -> {
//            //서블릿을 등록하는 과정
//            servletContext.addServlet("hello", new HttpServlet() {
//                @Override
//                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                    //여기서 어떠한 결과를 res 으로 던질 것인지에 대해서 작성해주면됨 > statusCode, header, body
//                    resp.setStatus(200);
//                    resp.setHeader("Content-Type", "text/plain");
//                    resp.getWriter().println("Hello Servlet");
//                }
//            })
//                    //서블릿을 등록하는 과정을 거친 다음, 컨트롤러를 타고 들어온 REQ를 어떤 서블릿에다가 매핑해줄 것인지에 대한 매핑과정이 필요
//                    //이렇게 해두면 /hello 이라는 url 으로부터 오는 req 는 내가 커스텀해서 만든 "hello" 라는 이름의 서블릿에게 라우팅된다
//                    .addMapping("/hello");
//        });
//        webServer.start();
    }

}
