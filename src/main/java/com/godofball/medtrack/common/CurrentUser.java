package com.godofball.medtrack.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrentUser {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    public static void setCurrentUser(Long user){
        log.info("设置当前用户：{}",user);
        threadLocal.set(user);
    }

    public static Long getCurrentUser(){
        return threadLocal.get();
    }

    public static void removeCurrentUser(){
        log.info("移除当前用户");
        threadLocal.remove();
    }
}
