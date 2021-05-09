package divyansh.tech.androgit.features.home.pull_requests.epoxy

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import divyansh.tech.androgit.BR
import divyansh.tech.androgit.R
import divyansh.tech.data.models.pullRequests.Item

@EpoxyModelClass(layout = R.layout.recycler_item_pr)
abstract class EpoxyPrModel: DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var items: Item

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        binding.setVariable(BR.items, items)
    }
}