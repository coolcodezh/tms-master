package vip.coolcode;

import java.sql.*;

public class TestTransaction {

    public static Connection getConnection() {
        String username="root",password="123456";
        String url = "jdbc:mysql://localhost:3306/tms?serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }

    public static void updateHero() {
        Connection cn = getConnection();
        PreparedStatement pstmt;
        Savepoint sp1 = null;
        try {
            //设置事务为非自动提交
            cn.setAutoCommit(false);
            //cn.setTransactionIsolation(Connection.TRANSACTION_NONE);
            cn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);


            String sql = "update hero set name='吕布' where id = 1";
            pstmt = cn.prepareStatement(sql);
            pstmt.executeUpdate();

            cn.commit();//提交事务

        } catch (SQLException e) {
            try {
                cn.rollback(sp1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }


    public static void insertHero() {
        Connection cn = getConnection();
        PreparedStatement pstmt;
        Savepoint sp1 = null;
        try {
            //设置事务为非自动提交
            cn.setAutoCommit(false);
            //cn.setTransactionIsolation(Connection.TRANSACTION_NONE);
            cn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            String sql = "insert into hero(name) values('刘备')";
            pstmt = cn.prepareStatement(sql);

            pstmt.executeUpdate();

            /*sp1 = cn.setSavepoint();

            String sql2 = "insert into hero(name) values('吕布')";
            pstmt = cn.prepareStatement(sql);
            pstmt.executeUpdate();*/

            updateHero();

            //cn.commit();//提交事务
            cn.rollback();

        } catch (SQLException e) {
            try {
                cn.rollback(sp1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        insertHero();
    }

}
