package keem.practice.develop.kotlincallapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail, container, false)

        val view:View = inflater.inflate(R.layout.fragment_detail, container, false)

        setview(view)
        return view
    }

    private fun setview(view:View){


        //RecievValue Here
        var _content:String? = null
        var _title:String? = null
        var _pathPic:String? = null

        // Gets the data from the passed bundle
        val bundle = arguments
        _title = bundle?.getString("title")
        _content = bundle?.getString("content")
        _pathPic = bundle?.getString("pic")

        var tvTitle:TextView = view.findViewById(R.id.tvTitle)
        var tvContent:TextView = view.findViewById(R.id.tvContent)
        var ivPic:ImageView = view.findViewById(R.id.ivPic)

        tvTitle!!.text = _title
        tvContent!!.text = _content
        Picasso.get().load(_pathPic).error(R.drawable.ic_launcher_background).into(ivPic)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}