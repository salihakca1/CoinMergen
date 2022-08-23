package com.salihakca2.coinmergen.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.salihakca2.coinmergen.R
import com.salihakca2.coinmergen.data.entity.CoinModelDetail
import com.salihakca2.coinmergen.databinding.FragmentDetailBinding
import com.salihakca2.coinmergen.ui.adapter.MembersAdapter
import com.salihakca2.coinmergen.ui.adapter.TagsAdapter
import com.salihakca2.coinmergen.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var design: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container,false)

        val bundle: DetailFragmentArgs by navArgs()
        val getCoin = bundle.coin

        design.getCoinObject = getCoin

        viewModel.getObserverLiveData().observe(requireActivity(), object : Observer<CoinModelDetail> {
            override fun onChanged(t: CoinModelDetail?) {
                if (t != null){
                    design.textViewDetailDescription.text = t.description

                    val tagsAdapter = TagsAdapter(requireContext(), t.tags)
                    design.tagsAdapter = tagsAdapter

                    val membersAdapter = MembersAdapter(requireContext(),t.team)
                    design.membersAdapter = membersAdapter
                    //design.membersAdapter = membersAdapter
                }
            }
        })
        fetchLoad(getCoin.id)
        return design.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun fetchLoad(coinId: String){
        CoroutineScope(Dispatchers.IO).launch {
            val job1 : Deferred<Unit> = async {
                viewModel.loadCoinById(coinId)
            }
            job1.await()
        }
    }

}