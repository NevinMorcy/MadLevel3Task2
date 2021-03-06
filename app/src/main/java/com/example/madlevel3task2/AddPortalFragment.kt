package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

const val REQ_PORTAL_KEY = "portaltitleandtext"
const val BUNDLE_PORTAL_KEY = "bundle_portal"

class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addportal_button.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal() {
        val portalTitle = addportal_title.text.toString()
        val portalText = addportal_text.text.toString()

//        pass data between these fragment
        if (portalText.isNotBlank() && portalTitle.isNotBlank()) {
            //set the data as fragmentResult, we are listening for REQ_TITLE_KEY en REQ_TEXT_KEY in PortalFragment!
            val portal = Portal(portalTitle, portalText)
            setFragmentResult(REQ_PORTAL_KEY, bundleOf(Pair(BUNDLE_PORTAL_KEY, portal)))

            //"pop" the backstack, this means we destroy
            //this fragment and go back to the PortalsFragment
            findNavController().popBackStack()

        } else {
            Toast.makeText(
                    activity,
                    R.string.not_valid_portal, Toast.LENGTH_SHORT
            ).show()
        }
   }


}


