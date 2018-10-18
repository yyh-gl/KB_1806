package com.mybossseasonfinal.justthejob.CompanyRegistrationActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.mybossseasonfinal.justthejob.DI.Component.DaggerActivityComponent
import com.mybossseasonfinal.justthejob.DI.Module.ActivityModule
import com.mybossseasonfinal.justthejob.JustTheJobApp
import com.mybossseasonfinal.justthejob.R
import javax.inject.Inject


class CompanyRegistrationActivity : AppCompatActivity(), CompanyRegistrationContract.View {

    private lateinit var companyNameView: TextView

    @Inject
    lateinit var companyRegistrationPresenter: CompanyRegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_registration)

        DaggerActivityComponent.builder()
                .appComponent((applicationContext as JustTheJobApp).getComponent())
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)

        companyNameView = findViewById(R.id.companyNameTextView)

        var companyId: Int = Integer.parseInt(intent.getStringExtra("COMPANY_ID"))
        companyRegistrationPresenter.getCompany(companyId)
    }

    override fun showCompanyName(companyName: String) {
        companyNameView.text = "企業名：${companyName}"
    }

}
