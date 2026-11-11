import java.sql.*;
import jakarta.servlet.http.HttpServletRequest;

class SqlExample {
    void search(HttpServletRequest req, Connection con) throws SQLException {
        String email = req.getParameter("email");
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                // Lire les lignes du resultat.
            }
        }
    }
}
