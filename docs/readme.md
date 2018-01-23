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
* BeanUtils.copyProperties(productInfo, productInfoVO); 复制时，字段名要保持一致
```java
@JsonProperty("id")
private String productId;
```
* OrderMasterDao里的方法名容易写错，注意字段。
* 价格一定要从数据库获取，而不是从前端传过来
* 数据库对集合进行操作，最好加事务
* BeanUtils.copyProperties注意先拷贝再设置值，不然会被覆盖
* JsonSerializer的使用,进行字段的值转换
* @JsonInclude(JsonInclude.Include.NON_NULL)不返回null,也可以application.yml全局配置
```xml
  jackson:
    default-property-inclusion: non_null
```
* 集合如果设置初始值List=new ArrayList则返回[],String =""

* 异常捕捉
```java
@ControllerAdvice
public class SellExceptionHandler {
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }
}
```
* webstock 的客户端和服务端的应用
* Apache ab 进行并发测试
* freemarker 语法的使用 ,list, if ,else
* Data source rejected establishment of connection,  message from server: "Too many connections"
* Build=>Build Project可以在修改后不用重启项目即可完成刷新Freemarker模板,html
* 分布式 图片上传最好搭建一个文件服务器，或者使用第三方CDN存储

* AOP检验每次请求