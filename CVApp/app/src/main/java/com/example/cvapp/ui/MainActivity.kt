package com.example.cvapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.challenge.mycvapp.R
import com.example.cvapp.common.Utils
import com.example.cvapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var workAdapter: WorkAdapter

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        initViews()

        viewModel.getMyCV()
        observeLiveData()


    }

    private fun initViews() {
        rv_work.layoutManager = LinearLayoutManager(this)
        workAdapter = WorkAdapter()
        rv_work.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        rv_work.adapter = workAdapter
    }

    private fun observeLiveData() {
        viewModel.getMyCvLiveData().observe(this, Observer { it ->
            it?.let {
                name_text.text = it.basics.name
                address_text.text = Utils.getAddressFromLocation(it.basics.location)
                phone_text.text = it.basics.phone
                institution_text.text = it.education[0].institution
                education_field_text.text = it.education[0].area
                summary_text.text = it.basics.summary

                workAdapter.setItems(it.work)
            }
        })

        viewModel.getLoadingLiveData().observe(this, Observer { isLoading ->
            if (isLoading!!) {
                circular_progress.visibility = View.VISIBLE
                // do not show education label
                education_label.visibility = View.GONE
            } else {
                circular_progress.visibility = View.GONE
                // show education label
                education_label.visibility = View.VISIBLE

            }
        })

        viewModel.getErrorLiveData().observe(this, Observer { isError ->
            if (isError!!) {
                Snackbar.make(parent_view, R.string.error_message, Snackbar.LENGTH_LONG).show()
                education_label.text = ""
            }
        })
    }
}
