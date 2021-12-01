package io.simplify.infra.adapter

import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class MessageResource(val messageService: MessageService) {
    @GetMapping
    fun allMessages(): List<Message> = messageService.findMessages()

    @PostMapping
    fun createMessage(@RequestBody message: Message) {
        messageService.post(message)
    }
}

@Table("MESSAGES")
data class Message(@Id val id: String?, val text: String)

interface MessageRepository : CrudRepository<Message, String> {

    @Query("select * from messages")
    fun findMessages(): List<Message>
}

@Service
class MessageService(val messageRepository: MessageRepository) {

    fun findMessages(): List<Message> = messageRepository.findMessages()

    fun post(message: Message) {
        messageRepository.save(message)
    }
}


