package divyansh.tech.androgit.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped
import divyansh.tech.androgit.features.home.issues.IssuesAdapter
import divyansh.tech.androgit.features.home.issues.IssuesItemFragment

/*
* Module container for the dependencies of the fragment
* */
@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

//    @Provides
//    @FragmentScoped
//    fun provideIssuesItemFragment(): IssuesItemFragment = IssuesItemFragment()

    @Provides
    @FragmentScoped
    fun provideIssuesAdapter(
        @ActivityContext context: Context
    ): IssuesAdapter = IssuesAdapter(
        context as FragmentActivity
    )

}