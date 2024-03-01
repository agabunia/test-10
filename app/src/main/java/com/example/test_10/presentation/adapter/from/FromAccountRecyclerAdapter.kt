package com.example.test_10.presentation.adapter.from

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_10.databinding.AccountLayoutBinding
import com.example.test_10.presentation.model.from.FromAccount

class FromAccountRecyclerAdapter :
    ListAdapter<FromAccount, FromAccountRecyclerAdapter.FromAccountViewHolder>(FromAccountDiffUtil()) {

    class FromAccountDiffUtil : DiffUtil.ItemCallback<FromAccount>() {
        override fun areItemsTheSame(oldItem: FromAccount, newItem: FromAccount): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FromAccount, newItem: FromAccount): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FromAccountViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return FromAccountViewHolder(AccountLayoutBinding.inflate(inflate, parent, false))
    }

    override fun onBindViewHolder(holder: FromAccountViewHolder, position: Int) {
        holder.bind()
    }

    inner class FromAccountViewHolder(private val binding: AccountLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var account: FromAccount

        fun bind() {
            account = currentList[adapterPosition]

            with(binding) {
                tvFromName.text = account.accountName
                tvFromCash.text = account.balance.toString()
                tvFromCurrency.text = account.currencyType

                tvFromAccount.text = account.accountNumber.substring(
                    account.accountNumber.length - 4,
                    account.accountNumber.length
                )

            }
        }
    }

}
