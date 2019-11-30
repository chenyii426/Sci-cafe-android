package com.cs4540.sci_cafe.activities


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.cs4540.sci_cafe.databinding.FragmentHomePageBinding
import com.cs4540.sci_cafe.R
import com.cs4540.sci_cafe.adapter.EventAdapter
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.cs4540.sci_cafe.api.ApiService
import com.cs4540.sci_cafe.api.AuthenticationInterceptor
import com.cs4540.sci_cafe.api.EventService
import com.cs4540.sci_cafe.api.NewsService

import com.cs4540.sci_cafe.models.News
import com.cs4540.sci_cafe.models.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * A simple [Fragment] subclass.
 */
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private var topNews:MutableList<News> =  mutableListOf<News>()
    private var events:MutableList<Event> = mutableListOf<Event>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate<FragmentHomePageBinding>(inflater,
            R.layout.fragment_home_page,container,false)
        loadAllNews()
        loadAllEvents()
        return binding.root
    }

    fun loadAllEvents() {
        val eventService:EventService = ApiService.apiService.create(EventService::class.java)
        val observable = eventService.getAllEvents()
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {e:List<Event>?->
                events.clear()
                for (i in events) {
                    Log.v("url",i.imageUrl)
                }
                if (e!!.size > 5) {
                    for(i in 0..5) {
                        events.add(e[i])
                    }
                } else {
                    events.addAll(e!!)
                }
                val adapter = EventAdapter(e!!)
                binding.eventList.adapter = adapter
                adapter.notifyDataSetChanged()
            },{ error ->
                Log.v("Retrofit",error.message)
            })

    }

    private fun loadEvents(eventList:List<Event>) {
        events = ArrayList<Event>(eventList)
        val adapter = EventAdapter(events)
        binding.eventList.adapter = adapter
    }

    fun loadAllNews() {
        val newsService:NewsService = ApiService.apiService.create(NewsService::class.java)
        val observable = newsService.getAllTopNews()
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({t: List<News>? ->
                topNews.clear()
                topNews.addAll(t!!)
                val imageList = ArrayList<SlideModel>()
                for(news in topNews) {
                    imageList.add(SlideModel(news.imageUrl,news.title,true))
                }
                val imageSlider = binding.imageSlider
                imageSlider.setImageList(imageList)
                imageSlider.setItemClickListener(object : ItemClickListener {
                    override fun onItemSelected(position: Int) {
                        // You can listen here
                    }
                })
            },{ error ->
                Log.v("Retrofit","Loading news failed")
            })

    }

}
