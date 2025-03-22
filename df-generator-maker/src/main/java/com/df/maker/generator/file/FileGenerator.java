package com.df.maker.generator.file;

import com.df.maker.model.DataModel;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class FileGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        // 整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        // 输入路径
//        String inputPath = new File(projectPath, "df-generator-demo-projects/acm-template").getAbsolutePath();
        String inputPath = new File("/Users/df/workspace/Java/df-generator/df-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成动态文件
//        String inputDynamicFilePath = projectPath + File.separator + "df-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String inputDynamicFilePath = projectPath + File.separator + "target/classes/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/df/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("DFshmily");
        dataModel.setLoop(true);
        dataModel.setOutputText("求和结果：");
        doGenerate(dataModel);
    }
}

