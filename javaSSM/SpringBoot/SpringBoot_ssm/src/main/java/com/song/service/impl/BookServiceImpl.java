package com.song.service.impl;

import com.song.controller.Code;
import com.song.dao.BookDao;
import com.song.domain.Book;
import com.song.exceptio.BusinessException;
import com.song.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {

        return bookDao.save(book)>0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.save(book)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        //模拟业务异常，包装成自定义异常
        if(id == 1){
            throw new BusinessException(Code.BUSINESS_ERR,"请不要使用你的技术挑战我的耐性!");
        }
        //模拟系统异常，将可能出现的异常进行包装，转换成自定义异常
        //try{
        //    int i = 1/0;
        //}catch (Exception e){
        //    throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"服务器访问超时，请重试!",e);
        //}
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
