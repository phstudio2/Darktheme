package com.phstudio.darktheme.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.phstudio.darktheme.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tv_developer_name = view.findViewById<TextView>(R.id.tv_developer_name)
        val tv_application_development =
            view.findViewById<TextView>(R.id.tv_application_development)
        val tv_about = view.findViewById<TextView>(R.id.tv_about)
        val tv_contact = view.findViewById<TextView>(R.id.tv_contact)
        val tv_report_bug = view.findViewById<TextView>(R.id.tv_report_bug)
        val tv_share = view.findViewById<TextView>(R.id.tv_share)
        val tv_apps = view.findViewById<TextView>(R.id.tv_apps)
        val tv_privacy = view.findViewById<TextView>(R.id.tv_privacy)
        val tv_terms = view.findViewById<TextView>(R.id.tv_terms)

        tv_developer_name.setOnClickListener {
            Toast.makeText(context, getString(R.string.developer_name), Toast.LENGTH_SHORT).show()
        }

        tv_application_development.setOnClickListener {
            Toast.makeText(context, getString(R.string.app_version), Toast.LENGTH_SHORT).show()
        }

        tv_about.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.about))
            )
            startActivity(browserIntent)
        }

        tv_contact.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.contact))
            )
            startActivity(browserIntent)
        }

        tv_report_bug.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.report))
            )
            startActivity(browserIntent)
        }

        tv_share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.share_mail))
            intent.putExtra(Intent.EXTRA_TEXT, (resources.getString(R.string.email_text) +"\n"+resources.getString(R.string.email_text2)+"\n"+resources.getString(R.string.email_text3)))
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, resources.getString(R.string.select_email)))
        }

        tv_apps.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.googleplay))
            )
            startActivity(browserIntent)
        }

        tv_privacy.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.privacy))
            )
            startActivity(browserIntent)
        }

        tv_terms.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.terms))
            )
            startActivity(browserIntent)
        }
    }
}