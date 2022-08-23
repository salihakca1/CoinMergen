package com.salihakca2.coinmergen.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.salihakca2.coinmergen.R
import com.salihakca2.coinmergen.databinding.FragmentMainBinding
import com.salihakca2.coinmergen.ui.adapter.CoinAdapter
import com.salihakca2.coinmergen.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var design: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false)

        viewModel.coinlist.observe(viewLifecycleOwner){
            val adapter = CoinAdapter(requireContext(),it)
            design.coinAdapter = adapter
        }
        fetchAllCoins()
        return design.root
    }
    fun fetchAllCoins(){
        CoroutineScope(Dispatchers.IO).launch {
            val job2 : Deferred<Unit> = async {
                viewModel.downloadCoins()
            }
            job2.await()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempviewModel: MainViewModel by viewModels()
        viewModel = tempviewModel
    }

}