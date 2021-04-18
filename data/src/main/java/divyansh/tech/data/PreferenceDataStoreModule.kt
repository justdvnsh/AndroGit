package divyansh.tech.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import divyansh.tech.data.persistence.DataStoreManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferenceDataStoreModule {

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStoreManager =
        DataStoreManager(context)
}