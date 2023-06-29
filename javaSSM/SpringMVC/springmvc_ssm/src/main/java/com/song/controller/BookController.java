package com.song.controller;

import com.song.domain.Book;
import com.song.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//统一每一个控制器方法返回值
@RestController
// 声明该类为一个控制器，可以处理HTTP请求并返回相应的结果
@RequestMapping("/books")
// 定义请求映射路径，请求路径以/books开头的请求会被该控制器处理
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag =  bookService.save(book);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag =  bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag =  bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book =  bookService.getById(id);
        Integer code = book != null ? Code.GET_OK:Code.GET_ERR;
        String msg =  book != null ? "":"数据查询失败,请重试！";
        return new Result(code,book,msg);
    }
    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg =  bookList != null ? "":"数据查询失败,请重试！";
        return new Result(code,bookList,msg);
    }

    /**
     *  @RequestBody注解只能用于处理POST、PUT等请求方法，因为这些请求方法可以包含请求体。
     *  在方法参数上使用@RequestBody注解时，Spring MVC框架会自动将请求体中的数据转换成方法参数的类型。
     *  通常情况下，Spring MVC会根据请求的Content-Type自动选择适合的转换器来进行转换，比如将JSON数据转换为Java对象。
     *  @RequestBody注解通常与其他注解一起使用，比如@PostMapping、@PutMapping等，用于标识该方法用于处理含有请求体的HTTP请求。
     *
     *总结：@RequestBody注解用于将HTTP请求的请求体内容绑定到方法参数上，方便在方法中进行处理。它是Spring MVC框架中常用的注解之一。
     */

    /**
     * @PathVariable注解可以用于任何请求方法（GET、POST、PUT、DELETE等）。
     * 在方法参数上使用@PathVariable注解时，Spring MVC框架会自动将请求路径中的占位符参数值绑定到方法参数上。
     * 比如/books/1请求会将1绑定到@PathVariable Integer id参数上。
     * @PathVariable注解可以指定占位符的名字，比如@PathVariable("id")。
     * 如果占位符的名字与方法参数的名字不一样，需要使用注解的value属性指定。
     *
     * 总结：@PathVariable注解用于将请求路径中的占位符参数绑定到方法参数上，以便在方法中进行处理。它是Spring MVC框架中常用的注解之一。
     */

    //@PostMapping
    //public boolean save(@RequestBody Book book) {
    //    return bookService.save(book);
    //}
    //@PutMapping
    //public boolean update(@RequestBody Book book) {
    //    return bookService.update(book);
    //}
    //@DeleteMapping("/{id}")
    //public boolean delete(@PathVariable Integer id) {
    //    return bookService.delete(id);
    //}
    //@GetMapping("/{id}")
    //public Book getById(@PathVariable Integer id) {
    //    return bookService.getById(id);
    //}
    //@GetMapping
    //public List<Book> getAll() {
    //    return bookService.getAll();
    //}

}
