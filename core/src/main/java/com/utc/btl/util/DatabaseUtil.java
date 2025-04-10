package com.utc.btl.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.utc.btl.exception.GameException;
import com.utc.btl.exception.ExceptionType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.utc.btl.constant.Constants.*;

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
        Gdx.app.debug(DEBUG, "Get database connection");

        try {
            Properties prop = new Properties();
            prop.load(Gdx.files.internal("database.properties").read());

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            return DriverManager.getConnection(url, user, password);

        } catch (IOException | ClassNotFoundException | SQLException | GdxRuntimeException e) {
            throw new GameException(ExceptionType.SYSTEM_ERROR, e);
        }
    }
}
