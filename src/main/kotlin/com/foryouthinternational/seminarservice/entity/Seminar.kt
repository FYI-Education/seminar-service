package com.foryouthinternational.seminarservice.entity

import jakarta.persistence.*

@Entity
@Table(name = "mst_seminar")
class Seminar(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,
    val description: String,

) : BaseEntity()