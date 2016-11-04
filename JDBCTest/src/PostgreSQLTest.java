
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQLTest {

    public void exec() throws ClassNotFoundException, SQLException {
        String nengappi = "2016/08/11";
        //ドライバのロード(要：postgresql-?.?.????.jar・・・
        //参考：https://jdbc.postgresql.org/download.html)
        Class.forName("org.postgresql.Driver");
        //データベース接続
        final String url = "jdbc:postgresql://localhost/yosimuradb";
        final String user = "yosimura";
        final String password = "tksypass";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            //プリペアードステートメント
            String sql = "SELECT 名称 FROM M_祝祭日 WHERE 年月日 = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nengappi);
                //クエリの発行
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String name = rs.getString(1);
                        System.out.printf("%sは祝祭日の%sです%n", nengappi, name);
                    } else {
                        System.out.printf("%sは祝祭日ではないっぽい%n", nengappi);
                    }
                }
            }
        }
    }
}
