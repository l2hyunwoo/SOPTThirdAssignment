package com.example.soptthirdseminar.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soptthirdseminar.recyclerview.InstaAdapter
import com.example.soptthirdseminar.data.InstaData
import com.example.soptthirdseminar.recyclerview.ListItemDecoration
import com.example.soptthirdseminar.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas = mutableListOf<InstaData>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_home.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        rv_home.addItemDecoration(
            ListItemDecoration(
                12
            )
        )
        instaAdapter =
            InstaAdapter(view.context)
        rv_home.adapter = instaAdapter
        loadDatas()
    }

    private fun loadDatas(){
        datas.apply{
            add(
                InstaData(
                    userName = "이현우",
                    img_profile = "https://cdn.pixabay.com/photo/2017/03/27/12/59/adult-2178560_960_720.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2016/11/19/14/00/code-1839406__340.jpg"
                )
            )
            add(
                InstaData(
                    userName = "최호준",
                    img_profile = "https://image.shutterstock.com/image-photo/halfturned-side-profile-close-view-260nw-790169857.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2015/12/04/14/05/code-1076536__340.jpg"
                )
            )
            add(
                InstaData(
                    userName = "이정민",
                    img_profile = "https://cdn.pixabay.com/photo/2018/02/20/20/52/people-3168830__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2016/02/19/11/19/computer-1209641__340.jpg"
                )
            )
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }

}
