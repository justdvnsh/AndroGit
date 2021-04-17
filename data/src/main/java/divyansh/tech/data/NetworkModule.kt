package divyansh.tech.data

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import divyansh.tech.data.api.AuthenticationService
import divyansh.tech.utility.C
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/*
* Module container, which contains the dependencies for Retrofit and Realm
* */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /*
    * Provides retrofit instance for the app
    * @return Retrofit instance
    * */
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(C.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    /*
    * Provides the Authentication Service interface
    * @param retrofit -> Retrofit instance
    * @returns AuthenticationService instance
    * */
    @Provides
    @Singleton
    fun provideAuthenticationService(retrofit: Retrofit): AuthenticationService =
        retrofit.create(AuthenticationService::class.java)
}