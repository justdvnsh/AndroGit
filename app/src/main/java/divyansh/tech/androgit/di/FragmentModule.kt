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

@Module
@InstallIn(ActivityComponent::class)
class FragmentModule {

    @Provides
    @ActivityScoped
    fun provideFeedFragment(): FeedFragment = FeedFragment()

    @Provides
    @ActivityScoped
    fun provideIssuesFragment(): IssuesFragment = IssuesFragment()

    @Provides
    @ActivityScoped
    fun providePRFragment(): PullRequestsFragment = PullRequestsFragment()

    @Provides
    @ActivityScoped
    fun provideProfileFragment(): ProfileFragment = ProfileFragment()
}