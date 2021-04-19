package divyansh.tech.androgit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import divyansh.tech.androgit.features.home.feed.FeedFragment
import divyansh.tech.androgit.features.home.issues.IssuesFragment
import divyansh.tech.androgit.features.home.profile.ProfileFragment
import divyansh.tech.androgit.features.home.pull_requests.PullRequestsFragment
import javax.inject.Singleton

/*
* Fragment Module, which provides all the fragments as dependencies
* */
@Module
@InstallIn(ActivityComponent::class)
class FragmentModule {

    /*
    * Provides Feed Fragment
    * @returns FeedFragment()
    * */
    @Provides
    @ActivityScoped
    fun provideFeedFragment(): FeedFragment = FeedFragment()

    /*
    * Provides Issues Fragment
    * @returns IssuesFragment()
    * */
    @Provides
    @ActivityScoped
    fun provideIssuesFragment(): IssuesFragment = IssuesFragment()

    /*
    * Provides PR Fragment
    * @returns PRFragment()
    * */
    @Provides
    @ActivityScoped
    fun providePRFragment(): PullRequestsFragment = PullRequestsFragment()

    /*
    * Provides Profile Fragment
    * @returns ProfileFragment()
    * */
    @Provides
    @ActivityScoped
    fun provideProfileFragment(): ProfileFragment = ProfileFragment()
}