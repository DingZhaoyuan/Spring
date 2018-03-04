package com.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.BookShopDao;
import com.spring.hibernate.service.BookShopService;
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	
	//用户购买书籍
	/** Spring Hibernate事物的流程
	 * 1.在方法开始之前
	 * ①获取Sesion
	 * ②把Session和当前线程绑定，可以使用sessionFactory.getCurrentSession()获取Session
	 * ③开启事务
	 * 
	 * 2.方法正常结束，没有出现异常
	 *①提交事务
	 *②当前线程与绑定的Session解绑
	 *③关闭Sesion
	 *
	 * 3.方法出现异常
	 *①回滚事务
	 *②当前线程与绑定的Session解绑
	 *③关闭Sesion
	 * 
	 */
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}
}
