package com.foryouthinternational.seminarservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "mst_participant")
class Participant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,
    val email: String,
    val phoneNumber: String,

    @ManyToOne
    @JoinColumn(name = "seminar_id")
    @JsonIgnore
    val seminar: Seminar? = null,

//    @Transient
//    val seminarId: Long? = seminar?.id
) : BaseEntity()