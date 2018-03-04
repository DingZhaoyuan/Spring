1. �� WEB ������ʹ�� Spring

��. ��Ҫ�������� jar ��:

spring-web-4.0.0.RELEASE.jar
spring-webmvc-4.0.0.RELEASE.jar

��. Spring �������ļ�, �ͷ� WEB ����û��ʲô��ͬ

��. ��Ҫ�� web.xml �ļ��м�����������:

<!-- ���� Spring �����ļ������ƺ�λ�� -->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>

<!-- ���� IOC ������ ServletContextListener -->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

2.Spring����Structs2

1).����Ŀ�꣺ʹIOC����������Structs2��Action��

2).�������
����������Structs2
����Spring��IOC������Structs2��action
ע�⣺��IOC����������Structs2��Actionʱ����Ҫ����scope���ԣ���ֵ����Ϊprototype
<bean id="personAction" class="com.spring.struts2.action.PersonAction"
scope="prototype">
    <property name="personService" ref="personService"></property>
</bean>
������Structs2�������ļ�: Action�ڵ�� class ��Ҫָ�� IOC �����и� bean �� id
<action name="person-save" class="personAction">
      <result>/success.jsp</result>
</action>
�ܼ���struts2-spring-plugin-2.3.15.3.jar

3). ����ԭ��: ͨ����� struts2-spring-plugin-2.3.15.3.jar �Ժ�, Struts2 ���ȴ� IOC ������
��ȡ Action ��ʵ��.
if (appContext.containsBean(beanName)) {
    o = appContext.getBean(beanName);
} else {
    Class beanClazz = getClassInstance(beanName);
    o = buildBean(beanClazz, extraContext);
}

