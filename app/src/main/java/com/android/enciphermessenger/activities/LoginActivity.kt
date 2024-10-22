package com.android.enciphermessenger.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.android.enciphermessenger.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etPhoneNumber.addTextChangedListener {
            btnNext.isEnabled = !(it.isNullOrEmpty() || it.length < 10)
        }

        btnNext.setOnClickListener {
            isValidPhoneNumber()
        }

    }

    private fun isValidPhoneNumber() {
        countryCode = ccp.selectedCountryCodeWithPlus
        phoneNumber = countryCode + etPhoneNumber.text.toString()

        if (validatePhoneNumber(etPhoneNumber.text.toString())) {
            notifyUser(
                "We will be verifying the phone number:$phoneNumber\n" +
                        "Is this phone number OK?"
            )
        } else {
            toast("Please enter a valid number to continue!")
        }
    }

    private fun notifyUser(message: String) {
        builder = MaterialAlertDialogBuilder(this).apply {
            setMessage(message)
            setPositiveButton("Ok") { _, _ ->
                goToLoginActivity()
            }

            setNegativeButton("Edit") { dialog, _ ->
                dialog.dismiss()
            }

            setCancelable(false)
            create()
            show()
        }
    }

    private fun validatePhoneNumber(phone: String): Boolean {
        if (phone.isEmpty()) {
            return false
        }
        return true
    }

    private fun goToLoginActivity() {
        startActivity(
            Intent(this, VerifyPhoneActivity::class.java).putExtra(
                PHONE_NUMBER, phoneNumber)
        )
        finish()
    }

    private lateinit var phoneNumber: String
    private lateinit var countryCode: String
    private lateinit var builder: MaterialAlertDialogBuilder


}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}