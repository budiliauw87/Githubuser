package com.liaudev.githubuser.core.domain.usecase;

import androidx.lifecycle.LiveData;
import androidx.paging.Pager;

import com.liaudev.githubuser.core.data.local.entity.UserEntity;
import com.liaudev.githubuser.core.domain.model.User;

/**
 * Created by Budiliauw87 on 2022-08-21.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
public interface UserUseCase {
    Pager<String, User> getUsers(String query, int method);
    Pager<Integer, UserEntity> getFavorite();
    LiveData<User> getFavoriteById(String id);
    void setFavorite(User user);
    void deleteFavorite(String id);
}
