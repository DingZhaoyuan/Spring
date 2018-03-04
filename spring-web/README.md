1.Spring在Web应用中使用

1).需要加入额外的jar包
spring-web-4.0.0.RELEASE.jar
spring-webmvc-4.0.0.RELEASE.jar

2).Spring的配置文件是相同的

3).创建IOC容器
①非web应用在main方法中创建
②web应用在被服务器加载时创建IOC容器
在ServletContextListener.contextInitialized()方法中创建IOC容器
③web应用其他组件访问IOC容器
在ServletContextListener.contextInitialized()方法中创建IOC容器后，
可以把它放在ServletContext(即application域)的一个属性中
④实际上spring的配置文件的名字和位置也是可以配置的，将其配置到当前web应用的初始化参数中较为合适。
