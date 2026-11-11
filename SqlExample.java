import java.sql.*;
import jakarta.servlet.http.HttpServletRequest;

class SqlExample {
    void search(HttpServletRequest req, Connection con) throws SQLException {
        String email = req.getParameter("email");
        String sql = "SELECT * FROM users WHERE email = '"
                + email + "'";
        Statement stmt = con.createStatement();
        stmt.executeQuery(sql);
    }
}
