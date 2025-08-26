package com.example.ch04;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Đặt kiểu nội dung phản hồi
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy dữ liệu từ biểu mẫu
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String source = request.getParameter("source");
        String announcements = request.getParameter("announcements");
        String emailOK = request.getParameter("emailOK");
        String contactMethod = request.getParameter("contactMethod");

        // Gửi phản hồi HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Kết quả Khảo sát</title></head>");
        out.println("<body>");
        out.println("<h2>Kết quả Khảo sát</h2>");
        out.println("<p><strong>Họ:</strong> " + (firstName != null ? firstName : "Chưa cung cấp") + "</p>");
        out.println("<p><strong>Tên:</strong> " + (lastName != null ? lastName : "Chưa cung cấp") + "</p>");
        out.println("<p><strong>Email:</strong> " + (email != null ? email : "Chưa cung cấp") + "</p>");
        out.println("<p><strong>Ngày sinh:</strong> " + (dob != null ? dob : "Chưa cung cấp") + "</p>");
        out.println("<p><strong>Nguồn:</strong> " + (source != null ? source : "Chưa cung cấp") + "</p>");
        out.println("<p><strong>Thông báo:</strong> " + (announcements != null ? "Có" : "Không") + "</p>");
        out.println("<p><strong>Thông báo qua email:</strong> " + (emailOK != null ? "Có" : "Không") + "</p>");
        out.println("<p><strong>Phương thức liên hệ:</strong> " + (contactMethod != null ? contactMethod : "Chưa cung cấp") + "</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}