package com.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.BookShopDao;
import com.spring.hibernate.service.BookShopService;
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	
	//�û������鼮
	/** Spring Hibernate���������
	 * 1.�ڷ�����ʼ֮ǰ
	 * �ٻ�ȡSesion
	 * �ڰ�Session�͵�ǰ�̰߳󶨣�����ʹ��sessionFactory.getCurrentSession()��ȡSession
	 * �ۿ�������
	 * 
	 * 2.��������������û�г����쳣
	 *���ύ����
	 *�ڵ�ǰ�߳���󶨵�Session���
	 *�۹ر�Sesion
	 *
	 * 3.���������쳣
	 *�ٻع�����
	 *�ڵ�ǰ�߳���󶨵�Session���
	 *�۹ر�Sesion
	 * 
	 */
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}
}
