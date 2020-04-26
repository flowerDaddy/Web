package cn.llj.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JdbcUtils {
    /*
    * 使用druid技术获取数据源
    * */
    private static DataSource ds=null;
    static{
        //1.加载配置文件
        Properties pro=null;
        try {
             pro = new Properties();
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  DataSource getDataSource(){
        return ds;
    }
}
