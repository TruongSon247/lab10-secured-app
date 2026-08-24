package vn.edu.eaut.lab10.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import vn.edu.eaut.lab10.model.SinhVien;
import vn.edu.eaut.lab10.service.SinhVienService;

@WebServlet("/sinh-vien")
public class SinhVienController extends HttpServlet {
    private final SinhVienService service = new SinhVienService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("new".equals(action)) { req.setAttribute("sinhVien", new SinhVien()); forwardForm(req, resp); return; }
        if ("edit".equals(action)) { req.setAttribute("sinhVien", service.findById(id(req))); forwardForm(req, resp); return; }
        if ("delete".equals(action)) { service.delete(id(req)); resp.sendRedirect(req.getContextPath()+"/sinh-vien"); return; }
        String keyword=req.getParameter("keyword"); req.setAttribute("dsSinhVien", keyword==null||keyword.isBlank()?service.findAll():service.search(keyword));
        req.getRequestDispatcher("/views/sinhvien/list.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException {
        SinhVien v=new SinhVien(); String value=req.getParameter("id"); if(value!=null&&!value.isBlank()) v.setId(Integer.valueOf(value));
        v.setMaSinhVien(req.getParameter("maSinhVien")); v.setHoTen(req.getParameter("hoTen")); v.setEmail(req.getParameter("email")); v.setLop(req.getParameter("lop"));
        String date=req.getParameter("ngaySinh"); if(date!=null&&!date.isBlank()) v.setNgaySinh(LocalDate.parse(date));
        if(v.getId()==null) service.save(v); else service.update(v); resp.sendRedirect(req.getContextPath()+"/sinh-vien");
    }
    private void forwardForm(HttpServletRequest r,HttpServletResponse p)throws ServletException,IOException{r.getRequestDispatcher("/views/sinhvien/form.jsp").forward(r,p);}
    private Integer id(HttpServletRequest r){return Integer.valueOf(r.getParameter("id"));}
}
