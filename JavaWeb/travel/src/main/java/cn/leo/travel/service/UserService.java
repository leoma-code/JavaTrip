package cn.leo.travel.service;

import cn.leo.travel.domain.User;

/**
 * Created by Leo on 2020/1/15.
 * Description :
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean register(User user);
}
