package com.foryouthinternational.seminarservice.service

import com.foryouthinternational.seminarservice.dto.ParticipantDto
import com.foryouthinternational.seminarservice.entity.Participant
import com.foryouthinternational.seminarservice.mapper.ParticipantMapper
import com.foryouthinternational.seminarservice.repository.ParticipantRepository
import com.foryouthinternational.seminarservice.util.AppConstants
import com.foryouthinternational.seminarservice.util.ErrorMessages
import com.foryouthinternational.seminarservice.util.SuccessMessages
import jakarta.persistence.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ParticipantServiceImpl(
    private val participantRepository: ParticipantRepository,
    private val participantMapper: ParticipantMapper
) : ParticipantService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var emailService: EmailService

    override fun findAllBySeminarId(seminarId: Long): List<Participant> =
        participantRepository.findAllBySeminarId(seminarId)

    override fun save(dto: ParticipantDto): Participant {
        val participant = participantMapper.toEntity(dto)
        val savedParticipant = participantRepository.save(participant)

        logger.info(
            String.format(SuccessMessages.SAVED_SUCCESS_TEMPLATE, AppConstants.PARTICIPANT, savedParticipant.id)
        )
        return savedParticipant
    }

    override fun findById(id: Long): Participant =
        participantRepository.findById(id).orElseThrow {
            EntityNotFoundException(
                String.format(ErrorMessages.ENTITY_NOT_FOUND_TEMPLATE, AppConstants.PARTICIPANT, id)
            )
        }

    override fun findAll(): List<Participant> {
        TODO("Not yet implemented")
    }

    override fun update(dto: ParticipantDto): Participant {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    fun sendNotifRegistry(participant: ParticipantDto){
        val recipientEmail = participant.email
        val emailSubject = "Registration Successful"
        val emailContent = "<p>Hello, "+ participant.name +"</p>" +

        "<p>Thank you for registering. Below are the details you provided:</p>" +

        "<ul>" +
        "<li><strong>Email:</strong> "+ participant.email +"</li> "+
        "<li><strong>Phone Number:</strong> "+ participant.phoneNumber +"</li> "  +
        "<li><strong>Address:</strong> "+ participant.address +"</li> "  +
        "<li><strong>Company Name:</strong> "+ participant.companyName +"</li> "  +
        "<li><strong>Business Category Owned:</strong> "+ participant.businessCategoryOwned +"</li> "  +
        "<li><strong>Products Owned:</strong> "+ participant.productOwned +"</li> "  +
        "</ul> "  +

        "<p>If you have any further questions or need assistance, feel free to reach out to us.</p> "  +

        "<p>Best regards,<br> "  +
        "FYI</p>"
        emailService.sendNotification(recipientEmail, emailSubject, emailContent)
    }

}