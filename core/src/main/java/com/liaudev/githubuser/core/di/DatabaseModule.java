package com.liaudev.githubuser.core.di;

import android.content.Context;

import androidx.room.Room;

import com.liaudev.githubuser.core.data.local.room.UserDao;
import com.liaudev.githubuser.core.data.local.room.UserDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

/**
 * Created by Budiliauw87 on 2022-08-17.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */

@Module
@InstallIn({SingletonComponent.class})
public class DatabaseModule {

    @Singleton
    @Provides
    static UserDatabase provideDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context.getApplicationContext(),
                UserDatabase.class, "usergithubapp.db").build();
    }

    @Provides
    static UserDao provideUserDao(UserDatabase database){
        return database.userDao();
    }

}
