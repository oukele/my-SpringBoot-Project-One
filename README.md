# my-SpringBoot-Project-One
使用idea 搭建一个 SpringBoot + Mybatis + logback 的maven 项目（One）

#### SpringBoot
~~~
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

~~~
