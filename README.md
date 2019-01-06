# my-SpringBoot-Project-One
使用idea 搭建一个 SpringBoot + Mybatis + logback 的maven 项目（One）

~~~
Spring-boot
1.	含义：简化Spring应用开发，一个快速开发框架
2.	官网：https://spring.io/projects/spring-boot
3.	作用：
(1)	解决J2EE笨重的开发，繁多的配置，低下的开发效率，复杂的部署流程，第三方技术集成难度大
(2)	Spring全家桶  时代
(3)	Spring boot =》J2EE一站式解决方案
(4)	Spring cloud =》分布式整体解决方案
4.	三大特性==》
(1)	组件自动装配：Web MVC，Web Flux，JDBC
(2)	嵌入式Web容器：tomcat，jetty，Undertow
(3)	生产准备特性：指标，健康检查，外部化配置
5.	优点：
(1)	快速构建独立运行的Spring项目
(2)	无须依赖外部Servlet容器，应用无需打成WAR包；项目可以打成jar包独自运行
(3)	提供 一系列 starter pom 来简化 Maven 的依赖加载；
(4)	大量的自动配置，对主流开发框架的无配置集成；
(5)	无须配置XML，开箱即用，简化开发，同时也可以修改默认值来满足特定的需求；
(6)	Spring Boot 并不是对 Spring 功能上的增强，而是提供了一种快速使用 Spring 的方式；
(7)	极大提高了开发、部署效率
(8)	与云计算的天然集成 
6.	@SpringBootApplication 用于标识 一个引导类，说明 当前是一个 SpringBoot项目
7.	SpringBoot与SpringMVC的关系
(1)	SpringBoot的WEB组件集成SpringMVC框架
(2)	
8.	springboot原理分析
(1)	通过Maven父子依赖关系
(2)	从spring3.0以后提供注解，springMVC内置注解加载整个springMVC容器
(3)	使用Java代码编写SpringMVC配置初始化
(4)	再使用java语言创建tomcat容器，加载class文件
9.	微服务：解析==》架构风格（服务微化）
10.	在maven的conf的setting.xml配置文件添加以下配置的profiles标签
	<profile>
				<id>jdk-1.8</id>
				<activation>
					<activeByDefault>true</activeByDefault>
					<jdk>1.8</jdk>
				</activation>
				<properties>
					<maven.compiler.source>1.8</maven.compiler.source>
					<maven.compiler.target>1.8</maven.compiler.target>
					<maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
				</properties>
		</profile>
11.	导入的jar包
12.	开发步骤
(1)	创建一个maven工程==》不勾选任何工程
(2)	导入依赖的spring-boot的jar包
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.6.RELEASE</version>
    <type>pom</type>
</dependency>

<!--
 https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web 
-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>2.0.6.RELEASE</version>
</dependency>
(3)	编写主程序，启动spring-boot应用
(4)	@SpringBootApplication 来标注一个主程序，说明这是一个spring boot应用
(5)	编写相关的service，controller等逻辑代码
(6)	主程序：启动
(7)	简化部署
<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
  </build>
打包成：项目名.jar
在doc命名：java -jar  项目名.jar
13.	快速创建spring-boot项目==》步骤
(1)	File ==》 News ==》New Project ==》Spring Initialzer
14.	前端控制器上的@Controller和@ResponseBody  ==》可以用@RestController
15.	EnableAutoConfiguration
(1)	注解启动类
(2)	作用：扫包范围  默认在当前类里面
(3)	缺点：只扫当前类，别的类扫不到
16.	配置文件
(1)	resources文件夹目录结构
①	Static：保存所有的静态资源==》js，css，images
②	Templates：保存所有的模板页面；（spring-boot内置默认不支持JSP页面，要想支持就一定是war包，然后导入相应的pom依赖）；
1)	模板引擎：
a.	Freemarker
b.	Velocity
c.	thymeleaf	
③	Apllcation.properties：Spring-boot应用的配置文件
(2)	Spring-boot全局配置文件
	Application.properties
	编写格式
	实体类.属性值 =value
	实体类.集合=value,value,.......
	Application.yml ==》标记语言
	解析：以数据为中心，配置数据的时候具有面向对象的特征，比json，xml等				更适合做配置文件
	作用：修改SpringBoot自动配置的默认值
	yml基本语法
	K+:+空格+v+空格+：表示一堆键值对
	案例：
	Server：
	Port：6060
	Path：/项目名或者前端控制器的@RequestMapper的value				值
	类属性值
	实体类：
	属性值：value
	Map: {key:value}
	list:
	- value
	- value
	对象
	属性值: value
	在实体类上加注解@ ConfigurationProperties（prefix = ‘实体类’） ==》				把实体类的属性值绑定yml上的值
	把@ ConfigurationProperties（prefix = ‘实体类’）组件加到容器中					@Component（在实体类上加）
17.	Spring-boot单元测试类解析
(1)	@RunWith(SpringRunner.class) ==》spring的驱动器
(2)	@SpringBootTest==》Springboot单元测试
18.	@Value和@ConfigurationProperties的区别
 
19.	@ ConfigurationProperties（prefix = ‘实体类’）==》扫描所有配置文件
20.	@PropertySource：加载指定的指定单个配置文件
	解析：@PropertySource(value={“classpath”：xxx.properties})
21.	@ImportResource(location:”xxx.xml”)：导入Spring的配置文件(applicationContext.xml) 
	不推荐使用，使用全注解方式配置
	推荐使用配置类的方式来添加组件
22.	配置文件占位符 ==》properties配置文件上使用
(1)	随机数
${random.value}
(2)	占位符获取之前所配置的值，如果没有可以值，可使用指定的默认值
${实体类.属性值}value
${实体类.属性值:默认值}value
23.	Profile
(1)	含义：是Spring对不同环境提供不同配置功能的支持，可以通过激活指定的环境
(2)	作用：开发、测试等多环境
(3)	用法
	Properties格式的配置文件
	Application.properties ==》默认配置文件
	比如里面的内容是
	Server.port=6060
	#激活开发环境
	Spring-profiles.active=dev
	#激活生产环境 ==》一样的用法
	Application-dev.properties ==》开发环境
	比如里面的内容是
	Server.port=5050
	Application-pro.properties==》生成环境
	比如里面的内容是
	Server.port=3030
	yml格式的配置文件
	应该这样写
#默认端口号环境
Server：
	Port：8080
#激活对应的端口号，比如激活开发环境
Spring：
	Profiles：
		Active：dev
---
#开发环境
Server：
	Port：6060
Spring：
	Profiles：dev
---
#测试环境
Server：
	Port：3030
Spring：
	Profiles：prod
	命令行方式
	方式1：Edit==》Program arguments
	--spring.profiles.active=dev 或者prod
	方式2：Edit==》VM options
	--Dspring.profies.active=dev 或者prod
	注意：建议把配置application.properties文件放在resources/config下，优先					级最高
24.	自动配置原理
	SpringBoot启动的时候加载主配置类，开启了自动配置功能==》									@EnableAutoConfiguration
	@EnableAutoConfiguration作用：
	利用EnableAutoConfigurationImportSelector给容器中导入一些组件
	可查看SelectImports()方法的内容
List<String> configuration=getCandidateConfigration(annontationMetatada,attribute)；
获取候选的配置
	SpringFactoriesLoader.loadFactoryNames()：扫描所有jar包类路径下 				META-INF/spring.factories，把扫描到文件内容包装成properties对象
	从properties中获取到EnableAutoConfiguration.class类(类名)对应的值，			然后把他们添加到容器中
	总概括一句话：将类路径下META-INF/spring.factories里面的所有					EnableAutoConfiguration的值加入到容器中。
25.	SpringBoot的SpringMVC自动配置原理
(1)	SpringBoot自动配置了ContentNegotiatingViewResolver 和 BeanNameViewResolver这个两个beans
(2)	这连个Beans主要是作为视图解析器==》视图解析器的作用就是根据方法的返回值获取视图对象view，从而确定如何渲染
(3)	通过ContentNegotiatingViewResolver : 组合所有的视图解析器
(4)	自动注册 Converter , GenericConverter ,Formatter这三个Beans
(5)	对 HttpMessageConverters 的支持
(6)	自动注册 MessageCodesResolver
(7)	自动注册 ConfigurableWebBindingInitializer 。
26.	Webjars：以jar包的方式引入静态资源
	网站：https://www.webjars.org/
	访问以下maven
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>3.3.1-1</version>
</dependency>
	静态资源文件夹==》都放在resources文件里
	“classpath：/META-INF/resources”，
	“classpath：/resources”，
	“classpath：/static”，
	“classpath：/public/”
	“/：当前项目的根路径”

27.	模板引擎
(1)	JSP
(2)	Velocity
(3)	Freemaker
(4)	Thymeleaf==》推荐使用
①	使用步骤
1)	导入jar包
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
2)	使用
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {

private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;
//把html页面放在classpath:/templates/下，就会自动渲染
public static final String DEFAULT_PREFIX = "classpath:/templates/";
//去除后缀
public static final String DEFAULT_SUFFIX = ".html";

语法：
在html页面的<html>标签里导入命名空间
xmlns:th="http://www.thymeleaf.org"==》作为自动提示功能
语法请查看API文档

28.	国家化==》<中文  转  英文>
(1)	文件命名：i18n
	国际化配置文件：页面名.properties
	中文：页面名_zh_CN.properties
	英文：页面名_en_US.properties
(2)	步骤：
①	编写国际化配置文件，抽取页面显示的
②	使用ResourceBundleMessageSource管理国际化资源文件
Spring-boot已自动配置好管理国际化资源文件的组件
@Configuration
@ConditionalOnMissingBean(value = MessageSource.class, search = SearchStrategy.CURRENT)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@Conditional(ResourceBundleCondition.class)
@EnableConfigurationProperties
public class MessageSourceAutoConfiguration {

	private static final Resource[] NO_RESOURCES = {};

	@Bean
	@ConfigurationProperties(prefix = "spring.messages")
	public MessageSourceProperties messageSourceProperties() {
		return new MessageSourceProperties();
	}

	@Bean
	public MessageSource messageSource() {
		MessageSourceProperties properties = messageSourceProperties();
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		if (StringUtils.hasText(properties.getBasename())) {
		//设置国际化资源文件的基础名（去掉语言国家代码的）	messageSource.setBasenames(StringUtils.commaDelimitedListToStringArray(
					StringUtils.trimAllWhitespace(properties.getBasename())));
		}
③	在页面使用fmt：message去除国际化内容

国际化原理：国际化Locale<区域信息对象>；LocalResolver<获取区域信息对象>
	源码解析：
	@Bean
		@ConditionalOnMissingBean
		@ConditionalOnProperty(prefix = "spring.mvc", name = "locale")
		public LocaleResolver localeResolver() {
			if (this.mvcProperties
					.getLocaleResolver() == 						WebMvcProperties.LocaleResolver.FIXED) {
				return new FixedLocaleResolver(this.mvcProperties.getLocale());
			}
			AcceptHeaderLocaleResolver localeResolver = new 			AcceptHeaderLocaleResolver();
			localeResolver.setDefaultLocale(this.mvcProperties.getLocale());
			return localeResolver;
		}
默认的就是根据请求头带来的的区域信息获取Locale进行国际化
④	点击链接切换国际化
1)	IDEA小功能：页面修改完成后ctrl+F9，重新编译
29.	防止重复提交最好的办法：重定向
30.	公共部分抽取
(1)	转义行内写法：[[~{ }]]
(2)	不转义行内写法：[(~{ })]
31.	错误处理机制
(1)	原理
	参考ErrorMvcAutoConfiguration；错误处理的自动配置
	看一下ErrorPageCustomizer错误页面定制器
	当应用出现了4xx或5xx之类的错误 ,ErrorPageCustomizer就会被激活,它				主要用于定制错误 处理的响应规则，就会发送一个/error请求,它会交给 					BasicErrorController进行处理
	BasicErrorController 就会接收 /error 请求处理。
	BasicErrorController 会接收一个/error请求, 两个 方法处理,第1个					erroHtml响应html数据, 还有一个error用来响应json数据 的, 使用了 				ErrorViewResolver (DefaultErrorViewResolver)组件进行封装视图
	DefaultErrorViewResolver 去解析具体响应的错误页面。
	DefaultErrorAttributes 错误页面可获取到的数据信息
	通过 BasicErrorController 的方法中响应的 module 可定位到响应哪些数				据，从而引出 ErrorAttributes 的实现类 DefaultErrorAttributes , 						DefaultErrorAttributes 中绑定的所有值都可在页面获取到。
32.	配置嵌入式Servlet容器
(1)	SpringBoot默认是用嵌入式的Servlet容器==》tomcat
(2)	注册Servlet、Filter、Listener
①	ServletRegistrationBean ：注册自定义Servlet
②	FilterRegistrationBean ：注册自定义Filter
③	ServletListenerRegistrationBean ：注册自定义Listener
(3)	其他的Servlet容器
①	Jetty（用于长连接，比如聊天功能）
②	Undertow（不支持JSP）
(4)	优缺点：
①	优点：简单，便捷
②	缺点：默认不支持JSP，优化定制比较复杂
		
	------------------------------------------------------------------------------------------------------

(5)	Spring-Boot与关系型数据库的关系==》JDBC，MyBatis，Spring-Data，JPA
①	导入的配置解析：
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
       				</dependency>
②	自动配置原理参考：Ctrl+N查看DataSourceConfiguration的类
33.	缓存==》JSR107缓存机制
(1)	Xxx
①	CachingProvider：缓存提供者，管理和控制多个缓存CacheManger管理器
②	CacheManger：缓存管理器管理很多缓存Cache
③	Cache：缓存
④	Entry：缓存的记录
⑤	Expiry：有效期
(2)	导包：
<!-- https://mvnrepository.com/artifact/javax.cache/cache-api -->
<dependency>
    <groupId>javax.cache</groupId>
    <artifactId>cache-api</artifactId>
    <version>1.1.0</version>
</dependency>
(3)	缺点：使用复杂
34.	Spring缓存抽象
(1)	步骤
①	开启缓存：@EnableCaching
②	然后在对应的方法上加上@Cacheable==》用于查询
1)	属性
a.	cacheNames/value：指定缓存的名字
b.	Key=”#id”==》参数的值
a)	或者：#root.methodName+’[’+#id+’]’
c.	Condition：指定符合条件的情况下才缓存
d.	CacheManger：缓存管理器管理很多缓存Cache
e.	Unless：否定缓存
f.	Sync：是否使用异步模式
③	在配置类上写对应的方法并加入到组件上
(2)	原理：
简单来说：@Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，如果没有就运行方法，并将结果放入到缓存。以后再来调用就可以直接使用缓存中数据
(3)	@CachePut：既调用方法，又更新缓存数据==》用于修改
(4)	@CacheEvict：缓存清除==》用于删除
①	属性：allEntries=true；清空缓存中所有数据
(5)	@Caching：定义复杂的缓存规则
(6)	@CacheConfig：抽取缓存的公共配置

35.	消息服务
(1)	常见规范
①	JMS：java消息服务
②	AMQP：高级队列消息协议
(2)	概念
①	消息代理：消息中间件的服务器
②	目的地
1)	目的地==》两种形式
a.	队列==》点对点消息通信
b.	主题==》发布<public>，订阅<subscribe>消息通信
36.	检索：ElasticSearch==》全文搜索
(1)	下载docker pull elasticsearch
(2)	底层代码用Java编写
(3)	启动：docker run -e ES_JAVA_OPTS=”-Xms256m  -Xmx256m”-d -p 9200:9200 -p 9300:9300 --name 别名  镜像ID
①	 解析：在启动检索的时候把内存控制在256兆之间
(4)	网页访问：IP地址：9200
(5)	官方文档：https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html
(6)	spring默认支持两种技术来和ES交互
①	Jest==》默认不生效：导入io.sarchbox.client.JestClient包
<!-- https://mvnrepository.com/artifact/io.searchbox/jest -->
<dependency>
    <groupId>io.searchbox</groupId>
    <artifactId>jest</artifactId>
    <version>5.3.3</version>
</dependency>
②	SpringData ElasticSearch
37.	热部署原理：使用类加载器<classloader>，重新读取字节码文件到jvm内存
(1)	优点：
①	提高运行效率，不需要启动服务器
(2)	缺点：
①	如果项目大的情况下会非常卡--比较占内存
38.	性能优化
(1)	
39.		定时任务
(1)	异步任务
①	在service层的实现方法里给方法加上@Async
1)	解析：告诉spring这是一个异步方法，这个方法开辟单独线程进行执行
②	在程序入口加上：@EnableAsync 开启异步注解功能
③	原理：底层使用多线程技术，使用AOP技术在运行时，创建一个单独线程进行执行
(2)	定时任务
①	@Scheduled：设置定时
②	Enable@Scheduling：开启基于注解的定时任务
(3)	邮件发送
①	依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
docker run --name zk -p 2181:2181  some-zookeeper --restart always -d zookeeper
40.	Dubbo和SpringCloud区别
(1)	Dubbo
①	一个分布式服务框架
②	主要解决服务远程调用问题，所谓RPC
(2)	SpringCloud
①	一个分布式的整体解决方案
1)	比如：
a.	配置管理
b.	服务发现
c.	熔断
d.	路由
e.	微代理
f.	控制总线
g.	一次性token
h.	全局锁
i.	分布式session
j.	集群状态
②	常用的5大组件
1)	服务发现：Netflix Eureka
2)	客户端负载均衡：Netflix Ribbon
3)	断路器：Netflix Hystrix
4)	服务网关：Netflix Zuul
5)	分布式配置：Spring Cloud Config
41.	监控和管理断点
(1)	Autoconfig：所有自动配置信息
(2)	Auditevents：审计事件
(3)	Beans：所有Bean的信息
(4)	Configprops：所有状态信息
(5)	Dump：线程状态信息
(6)	Env：当前环境信息
(7)	Health：应用健康状态
(8)	Info：当前应用信息
(9)	Metircs：应用的各项指标
(10)	Mappings：@RequestMapping映射路径
(11)	Shutdown：关闭当前应用
(12)	Trace：追踪信息
42.	监控
(1)	Actuator：监控应用，没有界面，启动时返回json格式
①	打开：http://127.0.0.1:8080/actuator/beans  ==》查看spring的beans
②	打开：http://127.0.0.1:8080/actuator/health ==》监控是否健康
③	
(2)	AdminUI：底层是Actuator监控应用，实现可视化界面
①	打开：http://localhost:8080/#/applications


43.	Spring WebFlux
(1)	优势：
①	支持非常高的并发量
(2)	controller类里
①	Flux<T>用于Get请求
②	Mono<T>用于POST请求或者PUT，DELETE
44.	SpringBoot整合MyBatis事务的传播行为：==》共七个
(1)	分别是：
①	Propagation.REQUIRED ==》如果存在一个事务，则支持当前的事务。如果没有则开启一个新的事务
②	Propagation.SUPPORTS==》如果存在一个事务，则支持当前的事务。如果没有则开启，则非事务的执行
③	Propagation.MANDATORY==》如果存在一个事务，则支持当前的事务。如果没有则开启，就抛出异常
④	Propagation.REQUIRES_NEW==》总是开启一个新的事务，如果一个事务已存在，则将这个事务挂起
⑤	Propagation.NOT_SUPPORTED==》总是非事务地执行，并挂起任何存在的事务
⑥	Propagation.NEVER==》总是非事务地执行，如果存在一个活动事务，就抛出异常
⑦	Propagation.NESTED==》如果一个活动的事务存在，则运行在一个嵌套的事务中，如果没有活动的事务，就按Propagation.REQUIRED属性执行
(2)	步骤：
①	在service层加注解@Transactional
②	在启动类上加：@EnableTransactionManagement
③	导入lohback.xml文件，配置<logger name=”priv.linyu.项目名.service.impl”level=”TRACEA”>
④	导入依赖：logback-core
(3)	@Transactional(readOnly = true) ==》只读事务==》 查询功能
(4)	@Transactional(propagation = Propagation.REQUIRED)==》事务策略 ==》修改功能
(5)	


~~~
