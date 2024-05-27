package com.dmwaresolutions.hiltdependencyinjection

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object AlertSystemModule {
    @Provides
    @Named("houseAlert")
    fun provideHouseAlertSystemInstance(): AlertSystem{
        return HouseAlertSystem()
    }

    @Provides
    @Named("lockAlert")
    fun provideLockAlertSystemInstance(): AlertSystem{
        return LockAlertSystem()
    }
}