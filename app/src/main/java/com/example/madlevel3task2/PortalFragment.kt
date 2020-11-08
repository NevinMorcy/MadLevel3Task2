package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_portal.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalFragment : Fragment() {

    private val items = arrayListOf<Portal>()
    private val PortalAdapter = PortalAdapter(items)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_portal, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeAddPortalResult()

    }


    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvPortal.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvPortal.adapter = PortalAdapter
        rvPortal.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    private fun observeAddPortalResult() {

//        If the request is triggered
//        we can get a bundle via the BUNDLE_REMINDER_KEY.
            setFragmentResultListener(REQ_PORTAL_KEY) { key, bundle ->
                bundle.getParcelable<Portal>(BUNDLE_PORTAL_KEY)?.let {
                    //add it to our portal list
                    items.add(it)
                    //give the adapter a heads up
                    PortalAdapter.notifyDataSetChanged()
                }

            }
        }
    }







