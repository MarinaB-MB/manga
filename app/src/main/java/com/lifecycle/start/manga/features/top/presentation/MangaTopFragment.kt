package com.lifecycle.start.manga.features.top.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lifecycle.start.manga.R

class MangaTopFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_manga_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // todo
    }

    companion object {
        fun newInstance(): MangaTopFragment {
            return MangaTopFragment()
        }
    }
}