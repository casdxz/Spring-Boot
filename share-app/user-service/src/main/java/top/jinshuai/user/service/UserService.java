package top.jinshuai.user.service;

import top.jinshuai.user.domain.dto.UserDto;
import top.jinshuai.user.domain.entity.User;

/**
 * @description:
 * @author: syhan
 * @create: 2022-09-24
 **/

public interface UserService {
    /**
     * 根据id找user
     * @param id id
     * @return user
     */
    User findById(Integer id);

    /**
     * 登录
     * @param userDto userDto
     * @return user
     */
    User login(UserDto userDto);
}
