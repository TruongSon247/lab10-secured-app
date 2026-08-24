package vn.edu.eaut.lab10.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import vn.edu.eaut.lab10.model.Role;
import vn.edu.eaut.lab10.model.User;
import vn.edu.eaut.lab10.repository.UserRepository;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepository repo = new UserRepository();
        if (repo.count() == 0) {
            repo.save(new User("admin@eaut.edu.vn", "admin123", "Quản trị viên", Role.ADMIN));
            repo.save(new User("staff@eaut.edu.vn", "staff123", "Nhân viên", Role.STAFF));
            repo.save(new User("user@eaut.edu.vn", "user123", "Người dùng", Role.USER));
            System.out.println(">>> Đã seed dữ liệu tài khoản mẫu ADMIN/STAFF/USER");
        }
    }
}