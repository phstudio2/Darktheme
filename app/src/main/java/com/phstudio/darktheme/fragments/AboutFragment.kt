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
        val tvApps = view.findViewById<TextView>(R.id.tvApps)
        val tvBug = view.findViewById<TextView>(R.id.tvBug)
        val tvShare = view.findViewById<TextView>(R.id.tvShare)
        val tvTelegram = view.findViewById<TextView>(R.id.tvTelegram)
        val tvPrivacy = view.findViewById<TextView>(R.id.tvPrivacy)
        val tvTerms = view.findViewById<TextView>(R.id.tvTerms)

        tvDeveloper.setOnClickListener {
            Toast.makeText(context, getString(R.string.developer_name), Toast.LENGTH_SHORT).show()
        }

        tvApplicationDevelopment.setOnClickListener {
            Toast.makeText(context, getString(R.string.app_version), Toast.LENGTH_SHORT).show()
        }

        ibWebsite.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.about))
            )
            startActivity(browserIntent)
        }

        tvWebsite.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.about))
            )
            startActivity(browserIntent)
        }

        ibGitHub.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.github))
            )
            startActivity(browserIntent)
        }

        tvGitHub.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.github))
            )
            startActivity(browserIntent)
        }

        tvApps.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.google_play))
            )
            startActivity(browserIntent)
        }

        tvBug.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.report))
            )
            startActivity(browserIntent)
        }

        tvBug.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.report))
            )
            startActivity(browserIntent)
        }

        tvShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.share_mail))
            intent.putExtra(
                Intent.EXTRA_TEXT,
                (resources.getString(R.string.email_text) + "\n" + resources.getString(R.string.email_text2) + "\n" + resources.getString(
                    R.string.email_text3
                ))
            )
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, resources.getString(R.string.select_email)))
        }

        tvTelegram.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.telegram))
            )
            startActivity(browserIntent)
        }

        tvPrivacy.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.privacy))
            )
            startActivity(browserIntent)
        }

        tvTerms.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.terms))
            )
            startActivity(browserIntent)
        }
    }
}