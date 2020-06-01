package util;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class ResponseToJs {

    public  void  response(String msg, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write(String.valueOf(msg));
        out.flush();
    }
}
