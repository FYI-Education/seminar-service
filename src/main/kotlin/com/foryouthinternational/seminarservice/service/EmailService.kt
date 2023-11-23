package com.foryouthinternational.seminarservice.service

import jakarta.mail.MessagingException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class EmailService (private val emailSender: JavaMailSender){

    fun sendNotification(to: String, subject: String, text: String) {
        val message = emailSender.createMimeMessage()
        val helper: MimeMessageHelper

        try {
            helper = MimeMessageHelper(message, true)
            helper.setTo(to)
            helper.setSubject(subject)
            helper.setText(text, true)

            emailSender.send(message)
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }
}