package divyansh.tech.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import divyansh.tech.data.annotations.WithInterceptor
import divyansh.tech.data.api.*
import divyansh.tech.utility.C
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
* Module container, which contains the dependencies for Retrofit and Realm
* */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /*
    * Provides retrofit instance for the app with the interceptor
    * @return Retrofit instance
    * */
    @Provides
    @Singleton
    fun providesRetrofit(
        interceptorClass: InterceptorClass
    ): Retrofit = Retrofit.Builder()
        .client(
            OkHttpClient.Builder().addInterceptor(interceptorClass).build()
        )
        .baseUrl(C.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /*
    * Provides the Authentication Service interface
    * @param retrofit -> Retrofit instance
    * @returns AuthenticationService instance
    * */
    @Provides
    @Singleton
    fun provideAuthenticationService(
        retrofit: Retrofit
    ): AuthenticationService =
        retrofit.create(AuthenticationService::class.java)

    /*
    * Provides the profile service interface
    * @param retrofit -> Retrofit instance
    * @returns ProfileService instance
    * */
    @Provides
    @Singleton
    fun provideProfileService(
        retrofit: Retrofit
    ): ProfileService =
        retrofit.create(ProfileService::class.java)

    /*
    * Provides the feed service interface
    * @param retrofit -> Retrofit instance
    * @returns FeedService instance
    * */
    @Provides
    @Singleton
    fun providesFeedService(
        retrofit: Retrofit
    ): FeedService =
        retrofit.create(FeedService::class.java)

    /*
    * Provides the issue service interface
    * @param retrofit -> Retrofit instance
    * @returns IssueService instance
    * */
    @Provides
    @Singleton
    fun provideIssueService(
        retrofit: Retrofit
    ): IssueService =
        retrofit.create(IssueService::class.java)

    /*
    * Provides the pr service
    * @param retrofit -> Retrofit instance
    * @returns PullRequestService instance
    * */
    @Provides
    @Singleton
    fun providePrService(
        retrofit: Retrofit
    ): PullRequestsService =
        retrofit.create(PullRequestsService::class.java)
}