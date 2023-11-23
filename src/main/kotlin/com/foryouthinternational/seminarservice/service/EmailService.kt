package com.foryouthinternational.seminarservice.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class EmailService(private val emailSender: JavaMailSender) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    suspend fun sendEmail(to: String, subject: String, text: String) {
        withContext(Dispatchers.IO) {
            try {
                val message = emailSender.createMimeMessage()
                val helper = MimeMessageHelper(message, true)
                helper.setTo(to)
                helper.setSubject(subject)
                helper.setText(text, true)

                emailSender.send(message)
                logger.info("Email sent successfully to $to")
            } catch (e: Exception) {
                logger.error("Error sending email to $to", e)
            }
        }
    }
}