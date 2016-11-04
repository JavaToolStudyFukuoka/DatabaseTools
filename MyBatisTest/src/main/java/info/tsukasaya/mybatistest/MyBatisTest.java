package info.tsukasaya.mybatistest;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {
    public void exec() throws IOException {
        String nengappi = "2016/08/11";
        String resource = "info/tsukasaya/mybatistest/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TestMapper mapper = session.getMapper(TestMapper.class);
            String name = mapper.selectHoliday(nengappi);
            if (name != null) {
                System.out.printf("%sは祝祭日の%sです%n", nengappi, name);
            } else {
                System.out.printf("%sは祝祭日ではないっぽい%n", nengappi);
            }
        }
    }
}
