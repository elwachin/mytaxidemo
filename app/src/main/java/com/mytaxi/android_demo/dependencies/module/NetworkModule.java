package com.mytaxi.android_demo.dependencies.module;

import com.mytaxi.android_demo.utils.network.HttpClient;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    HttpClient provideHttpClient() {
        return new HttpClient();
    }

}
