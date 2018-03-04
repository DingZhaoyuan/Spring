package com.spring.hibernate.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.hibernate.service.BookShopService;
import com.spring.hibernate.service.Cashier;

class SpringHibernateTest {

	ApplicationContext ctx = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopService = (BookShopService) ctx.getBean("bookShopService");
		cashier = (Cashier) ctx.getBean("cashier");
	}

	@Test
	void testDataSource() {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * Hibernate:
		 * 
		 * create table SH_ACCOUNT ( ID integer not null auto_increment, USERNAME
		 * varchar(255), BALANCE integer, primary key (ID) ) engine=InnoDB Hibernate:
		 * 
		 * create table SH_BOOK ( ID integer not null auto_increment, BOOKNAME
		 * varchar(255), ISBN varchar(255), PRICE integer, STOCK integer, primary key
		 * (ID) ) engine=InnoDB com.mchange.v2.c3p0.impl.NewProxyConnection@298d9a05
		 * [wrapping: com.mysql.jdbc.JDBC4Connection@58399d82]
		 */
	}

	@Test
	void testBookShopService() {
		bookShopService.purchase("abc", "1001");
	}

	@Test
	void testCashier() {
		cashier.checkout("abc", Arrays.asList("1001","1002"));
	}
}
