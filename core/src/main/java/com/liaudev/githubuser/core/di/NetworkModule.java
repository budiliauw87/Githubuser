package com.liaudev.githubuser.core.di;

import android.content.Context;

import com.datatheorem.android.trustkit.TrustKit;
import com.liaudev.githubuser.core.data.remote.network.ApiRequest;

import javax.net.ssl.SSLSocketFactory;

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
public class NetworkModule {


    @Provides
    static ApiRequest provideApiService(@ApplicationContext Context context) {
        TrustKit.initializeWithNetworkSecurityConfiguration(context);
        SSLSocketFactory sslSocketFactory =  TrustKit.getInstance().getSSLSocketFactory("github.com");
        return new ApiRequest(context,sslSocketFactory);
    }

}
