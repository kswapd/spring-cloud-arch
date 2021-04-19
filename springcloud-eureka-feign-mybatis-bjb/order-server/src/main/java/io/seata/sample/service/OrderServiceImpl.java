package io.seata.sample.service;

import io.seata.sample.dao.OrderDao;
import io.seata.sample.entity.Order;
import io.seata.sample.feign.AccountApi;
import io.seata.sample.feign.StorageApi;
//import io.seata.spring.annotation.GlobalTransactional;
import io.seata.spring.annotation.GlobalTransactional;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author IT云清
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService{

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageApi storageApi;
    @Autowired
    private AccountApi accountApi;

    /**
     * 创建订单
     * @param order
     * @return
     * 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
    @Override
   //@GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        LOGGER.info("------->交易开始");
        //本地方法
        orderDao.create(order);

        //远程方法 扣减库存
        LOGGER.info("------->扣减库存开始order中");
        storageApi.decrease(order.getProductId(),order.getCount());
        LOGGER.info("------->扣减库存结束order中");
        //远程方法 扣减账户余额

        LOGGER.info("------->扣减账户开始order中");
        accountApi.decrease(order.getUserId(),order.getMoney());
        LOGGER.info("------->扣减账户结束order中");

        LOGGER.info("------->交易结束");
    }


    public void testnm(Order order) {
        LOGGER.info("------->Test开始");
            System.out.println("MySQL JDBC Example.");
            Connection conn = null;
//        String url = "jdbc:mysql://localhost:3306/poc_oms_930?autoReconnect=true&useSSL=false&serverTimezone=GMT%2B8&queryInterceptors=brave.mysql8.TracingQueryInterceptor&zipkinServiceName=nanDatabase";
            String url = "jdbc:mysql://10.7.84.168:3306/poc_oms_930?autoReconnect=true&serverTimezone=GMT%2B8&useSSL=false&statementInterceptors=brave.mysql.TracingStatementInterceptor&zipkinServiceName=nanDatabase";
//        String url = "jdbc:mysql://localhost:3306/poc_oms_930?autoReconnect=true&serverTimezone=GMT%2B8&useSSL=false&statementInterceptors=com.github.kristofa.brave.mysql.MySQLStatementInterceptor&zipkinServiceName=nanmiaoDatabase";
//        String driver = "com.mysql.cj.jdbc.Driver";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "123456";
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, userName, password);
                stmt = conn.createStatement();
                String sql = "select * from sys_user";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("user_id");
                    String name = rs.getString("username");
                    System.out.println("id = " + id + ", name = " + name);
                }
                // 关闭资源
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { } // ignore
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { } // ignore
                }
            }

        LOGGER.info("------->Test结束");
    }

    /**
     * 修改订单状态
     */
    @Override
    public void update(Long userId,BigDecimal money,Integer status) {
        LOGGER.info("修改订单状态，入参为：userId={},money={},status={}",userId,money,status);
        orderDao.update(userId,money,status);
    }
}
