package vn.edu.eaut.lab10.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.edu.eaut.lab10.model.SanPham;
import vn.edu.eaut.lab10.service.SanPhamService;

@WebServlet("/san-pham")
public class SanPhamController extends HttpServlet {
    private final SanPhamService service=new SanPhamService();
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String action=req.getParameter("action");if("new".equals(action)){req.setAttribute("sanPham",new SanPham());req.getRequestDispatcher("/views/sanpham/form.jsp").forward(req,resp);return;}
        if("edit".equals(action)){req.setAttribute("sanPham",service.findById(id(req)));req.getRequestDispatcher("/views/sanpham/form.jsp").forward(req,resp);return;}
        if("delete".equals(action)){service.delete(id(req));resp.sendRedirect(req.getContextPath()+"/san-pham");return;}
        String k=req.getParameter("keyword");req.setAttribute("items",k==null||k.isBlank()?service.findAll():service.search(k));req.getRequestDispatcher("/views/sanpham/list.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{SanPham s=new SanPham();String v=req.getParameter("id");if(v!=null&&!v.isBlank())s.setId(Integer.valueOf(v));s.setMaSanPham(req.getParameter("maSanPham"));s.setTenSanPham(req.getParameter("tenSanPham"));s.setGia(Double.valueOf(req.getParameter("gia")));s.setSoLuongTon(Integer.valueOf(req.getParameter("soLuongTon")));if(s.getId()==null)service.save(s);else service.update(s);resp.sendRedirect(req.getContextPath()+"/san-pham");}
    private Integer id(HttpServletRequest r){return Integer.valueOf(r.getParameter("id"));}
}
