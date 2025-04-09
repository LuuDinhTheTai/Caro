package com.utc.btl.util;

import com.badlogic.gdx.Gdx;
import com.utc.btl.exception.GameException;
import com.utc.btl.exception.ExceptionType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.utc.btl.constant.Constants.ERROR;
import static com.utc.btl.constant.Constants.INFO;

/**
 * Lấy kết nối đến cơ sở dữ liệu dựa trên cấu hình có trong file database.properties.
 *
 * @return Connection kết nối đến cơ sở dữ liệu
 * @throws IOException nếu gặp lỗi khi đọc file cấu hình
 * @throws ClassNotFoundException nếu driver không được tìm thấy
 * @throws SQLException nếu xảy ra lỗi kết nối đến cơ sở dữ liệu
 */
public class DatabaseUtil {

    public static Connection getConnection() {
        Gdx.app.log(INFO, "Get database connection");

        try {
            Properties prop = new Properties();
            prop.load(Gdx.files.internal("database.properties").read());

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            return DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            Gdx.app.error(ERROR, "Can not read file database properties");
            e.printStackTrace();
            throw new GameException(ExceptionType.SYSTEM_ERROR);
        } catch (ClassNotFoundException e) {
            Gdx.app.error(ERROR, "Can not find database driver");
            e.printStackTrace();
            throw new GameException(ExceptionType.SYSTEM_ERROR);
        } catch (SQLException e) {
            Gdx.app.error(ERROR, "Can not get database connection");
            e.printStackTrace();
            throw new GameException(ExceptionType.SYSTEM_ERROR);
        }
    }
}
