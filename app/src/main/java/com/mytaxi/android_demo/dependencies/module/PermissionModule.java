package com.mytaxi.android_demo.dependencies.module;

import com.mytaxi.android_demo.utils.PermissionHelper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PermissionModule {

    @Singleton
    @Provides
    PermissionHelper providePermissionHelper() {
        return new PermissionHelper();
    }

}
