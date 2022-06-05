import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Builder
@Slf4j
public class CodeGenerator {

    private static final String MAPPER_PACKAGE_NAME = "mapper";
    private static final String SERVICE_PACKAGE_NAME = "repository";
    private static final String SERVICE_IMPL_PACKAGE_NAME = "repository.impl";
    private static final String MODEL_ENTITY_PACKAGE_NAME = "entity";
//    private static final String XML_MAPPER_PACKAGE_NAME = "classpath:mapper";

    private static final String VERSION_COLUMN_NAME = "version";
    private static final String LOGIC_DELETE_COLUMN_NAME = "is_deleted";

    private static final String ENTITY_PREFIX = "";
    private static final String SERVICE_PREFIX = "";
    private static final String SERVICE_IMPL_PREFIX = "";
    private static final String MAPPER_XML_PREFIX = "";
    private static final String MAPPER_CLASS_PREFIX = "";

    private static final String ENTITY_SUFFIX = "";
    private static final String SERVICE_SUFFIX = "Repository";
    private static final String SERVICE_IMPL_SUFFIX = "RepositoryImpl";
    private static final String MAPPER_XML_SUFFIX = "Mapper";
    private static final String MAPPER_CLASS_SUFFIX = "Mapper";

    private String outputDir;
    private String url;
    private String username;
    private String password;
    private String author;
    private String packageName;
    private String modelName;
    private String[] tableNames;
    private String schema;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入项目地址（到java文件夹）:");
        String outputDir = scanner.nextLine();

        CodeGenerator.builder()
                // >>> 通常手工配置项 Start
                .outputDir(outputDir)
                .url("jdbc:mysql://101.34.182.153:3306/idea_hub?useUnicode=true&characterEncoding=UTF-8" +
                        "&serverTimezone=GMT%2b8&useSSL=true&tinyInt1isBit=false")
                .username("root")
                .password("crh123456")
                .author("节操君")
                .packageName("com.junshijun.hub.idea")
                .modelName(null)
                .tableNames(new String[]{
                        "sys_api", "sys_api_permission"
                })
                // <<<< 通常手工配置项 End
                .build()
                .execute();
    }

    public void start() {
        log.info("！！！执行代码自动生成开始！！！");
    }

    /**
     * 执行代码生成
     */
    public void execute() {
        // 执行开始
        this.start();

        // 初始化配置数据源
        new AutoGenerator(dataSourceConfigBuilder())
                // 全局配置
                .global(globalConfigBuilder())
                // 模板配置
                .template(templateConfigBuilder())
                // 包配置
                .packageInfo(packageConfigBuilder())
                // 策略配置
                .strategy(strategyConfigBuilder())
                // 注入配置
                .injection(injectionConfigBuilder())
                // 执行
                .execute(this.templateEngine());
    }

    public DataSourceConfig dataSourceConfigBuilder() {
        return new DataSourceConfig.Builder(url, username, password)
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .dbQuery(new MySqlQuery())
                .schema(schema)
                .build();
    }

    public GlobalConfig globalConfigBuilder() {
        return new GlobalConfig.Builder()
                .outputDir(outputDir)
                .author(author)
                .dateType(DateType.TIME_PACK)
                .build();
    }

    public TemplateConfig templateConfigBuilder() {
        return null;
    }

    public PackageConfig packageConfigBuilder() {
        return new PackageConfig
                .Builder()
                .parent(packageName)
                .moduleName(modelName)
                .entity(MODEL_ENTITY_PACKAGE_NAME)
                .mapper(MAPPER_PACKAGE_NAME)
                .service(SERVICE_PACKAGE_NAME)
                .serviceImpl(SERVICE_IMPL_PACKAGE_NAME)
                .build();
    }

    public StrategyConfig strategyConfigBuilder() {
        // @formatter:off
        return new StrategyConfig
                .Builder()
                .addInclude(tableNames)
                .entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .idType(IdType.ASSIGN_ID)   // ID生成用自带雪花算法
                .enableLombok()// 开启lombok
                .enableChainModel()
                .enableTableFieldAnnotation()
                .versionColumnName(VERSION_COLUMN_NAME)          // 乐观锁列名
                .logicDeleteColumnName(LOGIC_DELETE_COLUMN_NAME)  // 逻辑删除列名
                .addTableFills(
                        new Column("version", FieldFill.INSERT),
                        new Column("is_deleted", FieldFill.INSERT),
                        new Column("created_by", FieldFill.INSERT),
                        new Column("created_time", FieldFill.INSERT),
                        new Column("modified_by", FieldFill.UPDATE),
                        new Column("modified_time", FieldFill.UPDATE)
                )
                .convertFileName(entityName -> ENTITY_PREFIX + entityName + ENTITY_SUFFIX)
                .enableColumnConstant() // 生成常量
                .mapperBuilder()
                .enableBaseResultMap()
                .enableBaseColumnList()
                .convertXmlFileName(entityName -> MAPPER_XML_PREFIX + entityName + MAPPER_XML_SUFFIX)
                .convertMapperFileName(entityName -> MAPPER_CLASS_PREFIX + entityName + MAPPER_CLASS_SUFFIX)
                .serviceBuilder()
                .convertServiceFileName(entityName -> SERVICE_PREFIX + entityName + SERVICE_SUFFIX)
                .convertServiceImplFileName(entityName -> SERVICE_IMPL_PREFIX + entityName + SERVICE_IMPL_SUFFIX)
                .controllerBuilder()
                .enableRestStyle()
                .enableHyphenStyle().build();
        // @formatter:on
    }

    public InjectionConfig injectionConfigBuilder() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            log.info("tableInfo: " + tableInfo.getEntityName() + "objectMap: " + objectMap.size());
        }).build();
    }

    public AbstractTemplateEngine templateEngine() {
        return new FreemarkerTemplateEngine();
    }
}
