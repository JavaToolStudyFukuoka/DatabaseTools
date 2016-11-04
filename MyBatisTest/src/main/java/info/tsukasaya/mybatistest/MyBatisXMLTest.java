package info.tsukasaya.mybatistest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisXMLTest {
    public void exec() throws IOException {
        String resource = "info/tsukasaya/mybatistest/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TestParameter param = new TestParameter("2016/05/01", "2016/07/31");
            List<Map<String, Object>> list = session.selectList("mybatistest.selectHoliday", param);
            System.out.printf("祝祭日が%d日ありました%n", list.size());
            list.stream().forEach((map) -> {
                System.out.printf("%sは%sです%n", map.get("年月日"), map.get("名称"));
            });
        }
    }
}
