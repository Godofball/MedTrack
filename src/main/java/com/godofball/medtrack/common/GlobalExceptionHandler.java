package com.godofball.medtrack.common;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.DataTruncation;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.info("异常信息：{}",ex.getMessage());
        if (ex.getMessage().contains("Duplicate entry")){
            String[] s = ex.getMessage().split(" ");
            return Result.error(s[2]+"已存在");
        }
        return Result.error("操作失败");
    }

    @ExceptionHandler({SQLException.class})
    public Result<String> exceptionHandler(SQLException ex){
        log.info("exception:{}",ex.getMessage());
        return Result.error("操作失败");
    }
}
