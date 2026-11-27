package com.build.shopping.service.user;

import com.build.shopping.dto.UserDto;
import com.build.shopping.model.User;
import com.build.shopping.request.CreateUserRequest;
import com.build.shopping.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertToUserDto(User user);
    User getAuthenticatedUser();




}
