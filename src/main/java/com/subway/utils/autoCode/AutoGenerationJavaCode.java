package com.subway.utils.autoCode;

import com.subway.template.TemplateService;
import com.subway.utils.PropertyUtil;
import com.subway.utils.ReflectUtil;
import com.subway.utils.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 自动生成代码
 */
@Slf4j
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
    private String packageName;
    private static String[][] fileNameArray = new String[7][2];


    private static List<com.subway.template.Template> templateList = new ArrayList();

    static {


        templateList.add(new com.subway.template.Template("Template.ftl", ".java", "E:\\dev\\gscms\\src\\main\\java\\com\\subway\\"));
        templateList.add(new com.subway.template.Template("serviceTemplate.ftl", "Service.java", "E:\\dev\\gscms\\src\\main\\java\\com\\subway\\"));
        templateList.add(new com.subway.template.Template("searchServiceTemplate.ftl", "SearchService.java", "E:\\dev\\gscms\\src\\main\\java\\com\\subway\\"));
        templateList.add(new com.subway.template.Template("repositoryTemplate.ftl", "Repository.java", "E:\\dev\\gscms\\src\\main\\java\\com\\subway\\"));
        templateList.add(new com.subway.template.Template("controllerTemplate.ftl", "Controller.java", "E:\\dev\\gscms\\src\\main\\java\\com\\subway\\"));
        templateList.add(new com.subway.template.Template("jsTemplate.ftl", ".js", "E:\\dev\\gscms\\src\\main\\webapp\\js\\app\\"));
        templateList.add(new com.subway.template.Template("listTemplate.ftl", "list.jsp", "E:\\dev\\gscms\\src\\main\\webapp\\WEB-INF\\pages\\"));
        templateList.add(new com.subway.template.Template("tableListTemplate.ftl", "tableList.jsp", "E:\\dev\\gscms\\src\\main\\webapp\\WEB-INF\\pages\\"));

    }


    /**
     * @param tableName
     * @param templateDir
     * @param autoGeneratedFile
     */
    public AutoGenerationJavaCode(String tableName, String packageName, String comment, String templateDir, String autoGeneratedFile) {
        this.url = PropertyUtil.getProperty("db.url");
        this.name = PropertyUtil.getProperty("db.username");
        this.passWord = PropertyUtil.getProperty("db.password");
        this.driver = PropertyUtil.getProperty("db.driver");
        this.sql = "select * from " + tableName;
        this.tableName = tableName;
        this.comment = comment;
        this.templateDir = templateDir;
        this.autoGeneratedFile = autoGeneratedFile;
        this.packageName = packageName;
    }


    /**
     * @throws IOException
     * @throws TemplateException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void genCode() throws IOException, TemplateException, ClassNotFoundException,
            SQLException {
        Configuration cfg = new Configuration(new Version("2.3.27-incubating"));
        cfg.setDefaultEncoding("GBK");
        String className = dealTableName();
        String fileName = dealClassName(className);
        Map<String, Object> columnMap = getColumn();
        //设置模板文件路径
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        Map<String, Object> rootMap = new HashMap<>();

        List<String> columns = ReflectUtil.getFields(packageName);


        rootMap.put("comment", comment);
        rootMap.put("tableName", tableName);
        rootMap.put("className", className);
        rootMap.put("columnMap", columnMap);
        rootMap.put("columns", columns);


        for (com.subway.template.Template template : templateList) {
            Template temp = cfg.getTemplate(template.getTemplateName(), "UTF-8");

            String path = template.getFileUrl() + "\\" + className + "\\";
            File dir = new File(path);
            //检查目录是否存在，不存在则创建
            if (!dir.exists()) {
                dir.mkdir();
            }
            String filePath = "";
            if (template.getFileName().endsWith(".java")) {
                filePath = template.getFileUrl() + "/" + className + "/" + StringUtils.upperCaseFirstOne(className) + template.getFileName();
            } else if (template.getFileName().endsWith(".js")) {
                filePath = template.getFileUrl() + "/" + className + "/" + className + template.getFileName();
            } else if (template.getFileName().equals("list.jsp")) {
                filePath = template.getFileUrl() + "/" + className + "/" + "list.jsp";
            } else if (template.getFileName().equals("tableList.jsp")) {
                filePath = template.getFileUrl() + "/" + className + "/" + "tableList.jsp";
            }
            File docFile = new File(filePath);

            if (!docFile.exists()) {
                Writer docOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
                temp.process(rootMap, docOut);
                log.info("文件" + docFile + "不存在，已经重新生成");
            }


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
        Map<String, Object> columnMap = new HashMap<>();
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
