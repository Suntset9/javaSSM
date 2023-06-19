package com.song.service;

import java.beans.Transient;
import java.io.IOError;
import java.io.IOException;

public interface AccountService {
    //rollback:设置当前事务参与回滚的异常，默认非运行时异常不参与回滚
    //@Transactional(rollbackFor = IOException.class)
    @Transient
    public void transfer(String out, String in, double money) throws IOException;
}
