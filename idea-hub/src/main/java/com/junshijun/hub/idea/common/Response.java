package com.junshijun.hub.idea.common;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Response<T> {

    private Integer code;

    private String msg;

    private T data;

    public static void responseByServlet(ServletResponse servletResponse, Object data) {
        PrintWriter out = null;
        try {
            servletResponse.setCharacterEncoding("UTF-8");
            servletResponse.setContentType("application/json");
            out = servletResponse.getWriter();
            out.println(JSONUtil.toJsonStr(data));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static <T> Response response(Integer code, String msg, T data) {
        return new Response(code, msg, data);
    }

    public static <T> Response success(T data) {
        return response(200, "Success!", data);
    }

    public static Response fail(String msg) {
        return response(500, msg, null);
    }
}
