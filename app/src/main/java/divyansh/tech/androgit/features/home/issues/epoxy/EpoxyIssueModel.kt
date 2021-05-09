package divyansh.tech.androgit.features.home.issues.epoxy

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import divyansh.tech.androgit.BR
import divyansh.tech.androgit.R
import divyansh.tech.data.models.issues.Issue

@EpoxyModelClass(layout = R.layout.recycler_item_issues)
abstract class EpoxyIssueModel: DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var issues: Issue

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.issues, issues)
    }
}