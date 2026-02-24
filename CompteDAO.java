import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDAO {

    private static final String URL      = "jdbc:postgresql://localhost:5433/banque";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "0000";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Compte> getTousLesComptes() {
        List<Compte> comptes = new ArrayList<>();
        String sql = "SELECT id, proprietaire, solde FROM compte";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Compte c = new Compte(
                    rs.getInt("id"),
                    rs.getString("proprietaire"),
                    rs.getDouble("solde")
                );
                comptes.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }

        return comptes;
    }

    public void afficherTousLesComptes() {
        List<Compte> comptes = getTousLesComptes();
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte trouvé en base.");
        } else {
            comptes.forEach(System.out::println);
        }
    }
}