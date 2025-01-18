package com.mahnoosh.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        "your_db_name"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideYourDao(db: UserDatabase) = db.userDao()
}