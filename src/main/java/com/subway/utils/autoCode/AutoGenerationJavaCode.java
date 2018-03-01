package com.subway.utils.autoCode;

import com.subway.utils.PropertyUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 自动生成代码
 */
public class AutoGenerationJavaCode {
    private String url;
    private String name;
    private String passWord;
    private String driver;
    private String sql;
    private String tableName;
    private String comment;
    private String templateDir;
    private String autoGeneratedFile;
    private static String[][] fileNameArray = new String[7][2];

    static {
        fileNameArray[0][0] = "Template.ftl";
        fileNameArray[0][1] = ".java";

        fileNameArray[1][0] = "serviceTemplate.ftl";
        fileNameArray[1][1] = "Service.java";

        fileNameArray[2][0] = "searchServiceTemplate.ftl";
        fileNameArray[2][1] = "SearchService.java";

        fileNameArray[3][0] = "repositoryTemplate.ftl";
        fileNameArray[3][1] = "Repository.java";

        fileNameArray[4][0] = "controllerTemplate.ftl";
        fileNameArray[4][1] = "Controller.java";

        fileNameArray[5][0] = "jsTemplate.ftl";
        fileNameArray[5][1] = ".js";


        fileNameArray[6][0] = "listTemplate.ftl";
        fileNameArray[6][1] = "list1.jsp";
    }


    /**
     * @param tableName
     * @param templateDir
     * @param autoGeneratedFile
     */
    public AutoGenerationJavaCode(String tableName, String comment, String templateDir, String autoGeneratedFile) {
        this.url = PropertyUtil.getProperty("db.url");
        this.name = PropertyUtil.getProperty("db.username");
        this.passWord = PropertyUtil.getProperty("db.password");
        this.driver = PropertyUtil.getProperty("db.driver");
        this.sql = "select * from " + tableName;
        this.tableName = tableName;
        this.comment = comment;
        this.templateDir = templateDir;
        this.autoGeneratedFile = autoGeneratedFile;
    }


    /**
     * @throws IOException
     * @throws TemplateException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void autoGenerationJavaCode() throws IOException, TemplateException, ClassNotFoundException,
            SQLException {
        Configuration cfg = new Configuration(new Version("2.3.27-incubating"));
        cfg.setDefaultEncoding("UTF-8");
        String className = dealTableName();
        String fileName = dealClassName(className);
        Map<String, Object> columnMap = getColumn();
        //设置模板文件路径
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        Map<String, Object> rootMap = new HashMap<>();
        rootMap.put("comment", comment);
        rootMap.put("tableName", tableName);
        rootMap.put("className", className);
        rootMap.put("columnMap", columnMap);
        File dir = new File(autoGeneratedFile + "\\");
        //检查目录是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (int i = 0; i < fileNameArray.length; i++) {
            Template temp = cfg.getTemplate(fileNameArray[i][0]);
            temp.setEncoding("UTF-8");
            File docFile = new File(autoGeneratedFile + "\\" + fileName + fileNameArray[i][1]);
            Writer docout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            temp.process(rootMap, docout);
        }
    }

    /**
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    //获取数据库表字段名放入map中
    public Map<String, Object> getColumn() throws ClassNotFoundException, SQLException {
        Connection conn;
        PreparedStatement pStemt = null;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, name, passWord);
        pStemt = conn.prepareStatement(sql);
        ResultSetMetaData rsmd = pStemt.getMetaData();

        Map<String, Object> columnMap = new HashMap<String, Object>();
        int size = rsmd.getColumnCount();
        for (int i = 0; i < size; i++) {
            String columnName = dealColumnName(rsmd, i);
            columnMap.put(columnName, columnName);
        }
        conn.close();
        return columnMap;
    }

    /**
     * @param rsmd
     * @param i
     * @return
     * @throws SQLException
     */
    //将表名转换为DMO的字段名，比如 operate_type 转换后为 operateType
    private String dealColumnName(ResultSetMetaData rsmd, int i) throws SQLException {
        String columnName = rsmd.getColumnName(i + 1).toLowerCase();
        String charAfterLine = String.valueOf(columnName.charAt((columnName.indexOf("_") + 1)));
        String convertedChar = charAfterLine.toUpperCase();
        columnName = columnName.replace("_" + charAfterLine, convertedChar);
        return columnName;
    }

    /**
     * @return 将表名转换为类型类名
     */
    //将表名转换为类型类名 比如 t_operate_log 转换后为 operateLog ,类名首字母应为大写，这里在freemarker的模板里直接转换
    private String dealTableName() {
        String className = tableName.toLowerCase().substring(tableName.indexOf("_") + 1);
        String charAfterLine = String.valueOf(className.charAt((className.indexOf("_") + 1)));
        String convertedChar = charAfterLine.toUpperCase();
        className = className.replace("_" + charAfterLine, convertedChar);
        return className;
    }

    /**
     * @param className
     * @return 将类名转换为文件名
     */
    //将类名转换为文件名，java公共类名与其文件名应该相同，这里将首字母转换为大写 如operateLog 转换后为 OperateLog
    private String dealClassName(String className) {
        String first = className.substring(0, 1).toUpperCase();
        String rest = className.substring(1, className.length());
        String fileName = new StringBuffer(first).append(rest).toString();
        return fileName;
    }

}
