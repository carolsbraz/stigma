package com.projeto.appstigma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager.widget.PagerAdapter
import com.example.stigma.R
import com.projeto.appstigma.Activities.Passo3Activity

class CustomPagerAdapter(private val mContext: Context) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val modelObjects: Model = Model.values()[position]
        val inflater: LayoutInflater = LayoutInflater.from(mContext)
        val layout: ViewGroup =
            inflater.inflate(modelObjects.layoutResId, container, false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int {
        return Model.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


    override fun getPageTitle(position: Int): CharSequence? {
        val customPagerEnum: Model = Model.values()[position]
        return mContext.getString(customPagerEnum.titleResId)
    }


}


