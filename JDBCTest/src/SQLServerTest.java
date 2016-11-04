import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerTest {

    public void exec() throws ClassNotFoundException, SQLException {
        String nengappi = "2016/08/11";
        //ドライバのロード(要：sqljdbc4.jar・・・
        //参考：https://msdn.microsoft.com/ja-jp/library/ms378526(v=sql.110).aspx)
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //データベース接続
        final String url = "jdbc:sqlserver://serverName;databaseName=dbName";
        final String user = "user";
        final String password = "pass";
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
