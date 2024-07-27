package com.phstudio.darktheme.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.phstudio.darktheme.R

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvDeveloper = view.findViewById<TextView>(R.id.tvDeveloper)
        val tvApplicationDevelopment =
            view.findViewById<TextView>(R.id.tvApplicationDevelopment)
        val ibWebsite = view.findViewById<ImageButton>(R.id.ibWebsite)
        val tvWebsite = view.findViewById<TextView>(R.id.tvWebsite)
        val ibGitHub = view.findViewById<ImageButton>(R.id.ibGitHub)
        val tvGitHub = view.findViewById<TextView>(R.id.tvGitHub)
        val tvBug = view.findViewById<TextView>(R.id.tvBug)
        val tvTelegram = view.findViewById<TextView>(R.id.tvTelegram)
        val tvPrivacy = view.findViewById<TextView>(R.id.tvPrivacy)

        setClickListener(tvDeveloper, R.string.developer_name)
        setClickListener(tvApplicationDevelopment, R.string.app_version)
        setUrlClickListener(ibWebsite, R.string.about)
        setUrlClickListener(tvWebsite, R.string.about)
        setUrlClickListener(ibGitHub, R.string.github)
        setUrlClickListener(tvGitHub, R.string.github)
        setUrlClickListener(tvBug, R.string.report)
        setUrlClickListener(tvBug, R.string.report)
        setUrlClickListener(tvTelegram, R.string.telegram)
        setUrlClickListener(tvPrivacy, R.string.privacy)
    }

    private fun setClickListener(view: View, stringResourceId: Int) {
        view.setOnClickListener {
            Toast.makeText(context, getString(stringResourceId), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUrlClickListener(view: View, stringResourceId: Int) {
        view.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(stringResourceId)))
            startActivity(browserIntent)
        }
    }
}
