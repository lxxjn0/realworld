package me.lxxjn0.realworld.common.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime
        protected set

    @CreatedDate
    @LastModifiedDate
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime
        protected set
}