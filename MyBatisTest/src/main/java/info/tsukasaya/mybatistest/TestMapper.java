package info.tsukasaya.mybatistest;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
    @Select("SELECT 名称 FROM M_祝祭日 WHERE 年月日 = #{ymd}")
    String selectHoliday(String ymd);
}
