###新建数据库选择utf-8mb4可以兼容emoji表情字符
### Junit库只能在test下使用

### 常见错误

* Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaAutoConfiguration.class]
有可能数据库连接配置有错误
* @DynamicUpdate 动态更新时间
* @Data 自动生成getter setter toString方法
* @Transactional 在测试环境使用该注解，即表示测试完就回滚了
* ProductServiceImpl 要添加@Service注解
* server:context-path: /sell url的前缀 http://localhost:8080/sell/buyer/product/list