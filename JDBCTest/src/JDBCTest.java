
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            //SQLServerTest test = new SQLServerTest();
            PostgreSQLTest test = new PostgreSQLTest();
            test.exec();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
