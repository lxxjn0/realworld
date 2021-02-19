package me.lxxjn0.realworld.tag.application

import me.lxxjn0.realworld.common.config.Slf4j
import me.lxxjn0.realworld.common.config.Slf4j.Companion.log
import me.lxxjn0.realworld.tag.domain.Tag
import me.lxxjn0.realworld.tag.domain.TagRepository
import org.springframework.stereotype.Service

@Slf4j
@Service
class TagService(
    private val tagRepository: TagRepository,
) {
    fun createAllByNames(tagNames: List<String>): List<Tag> {
        val tags = tagNames.map { tagRepository.findByName(it) ?: tagRepository.save(Tag(it)) }
        log.info("[TagService] 전체 태그 생성 - size : {}, tags : {}", tags.size, tags)

        return tags
    }
}