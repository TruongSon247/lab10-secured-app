package vn.edu.eaut.lab10.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.edu.eaut.lab10.model.Sach;
import vn.edu.eaut.lab10.service.SachService;

@WebServlet("/sach")
public class SachController extends HttpServlet {
    private final SachService service=new SachService();
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String action=req.getParameter("action"); if("new".equals(action)){req.setAttribute("sach",new Sach());req.getRequestDispatcher("/views/sach/form.jsp").forward(req,resp);return;}
        if("edit".equals(action)){req.setAttribute("sach",service.findById(id(req)));req.getRequestDispatcher("/views/sach/form.jsp").forward(req,resp);return;}
        if("delete".equals(action)){service.delete(id(req));resp.sendRedirect(req.getContextPath()+"/sach");return;}
        String k=req.getParameter("keyword");req.setAttribute("items",k==null||k.isBlank()?service.findAll():service.search(k));req.getRequestDispatcher("/views/sach/list.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{Sach s=new Sach();String v=req.getParameter("id");if(v!=null&&!v.isBlank())s.setId(Integer.valueOf(v));s.setMaSach(req.getParameter("maSach"));s.setTenSach(req.getParameter("tenSach"));s.setTacGia(req.getParameter("tacGia"));s.setTheLoai(req.getParameter("theLoai"));s.setSoLuong(Integer.valueOf(req.getParameter("soLuong")));if(s.getId()==null)service.save(s);else service.update(s);resp.sendRedirect(req.getContextPath()+"/sach");}
    private Integer id(HttpServletRequest r){return Integer.valueOf(r.getParameter("id"));}
}
