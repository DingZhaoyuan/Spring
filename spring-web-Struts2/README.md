1. 在 WEB 环境下使用 Spring

①. 需要额外加入的 jar 包:

spring-web-4.0.0.RELEASE.jar
spring-webmvc-4.0.0.RELEASE.jar

②. Spring 的配置文件, 和非 WEB 环境没有什么不同

③. 需要在 web.xml 文件中加入如下配置:

<!-- 配置 Spring 配置文件的名称和位置 -->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>

<!-- 启动 IOC 容器的 ServletContextListener -->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

2.Spring整合Structs2

1).整合目标：使IOC容器来管理Structs2的Action！

2).如何整合
①正常加入Structs2
②在Spring的IOC中配置Structs2的action
注意：在IOC容器中配置Structs2的Action时，需要配置scope属性，其值必须为prototype
<bean id="personAction" class="com.spring.struts2.action.PersonAction"
scope="prototype">
    <property name="personService" ref="personService"></property>
</bean>
③配置Structs2的配置文件: Action节点的 class 需要指向 IOC 容器中该 bean 的 id
<action name="person-save" class="personAction">
      <result>/success.jsp</result>
</action>
④加入struts2-spring-plugin-2.3.15.3.jar

3). 整合原理: 通过添加 struts2-spring-plugin-2.3.15.3.jar 以后, Struts2 会先从 IOC 容器中
获取 Action 的实例.
if (appContext.containsBean(beanName)) {
    o = appContext.getBean(beanName);
} else {
    Class beanClazz = getClassInstance(beanName);
    o = buildBean(beanClazz, extraContext);
}

