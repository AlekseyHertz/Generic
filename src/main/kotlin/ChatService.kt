class ChatNotFoundException : RuntimeException()
class MessageNotFoundException : RuntimeException()

object ChatService {
    private val chats = mutableMapOf<Int, Chat>()
    private val messages = mutableMapOf<Int, Message>()

    fun getUnreadChatsCount() =
        chats.values.count { chat -> chat.messages.any { message -> !message.readMessage } }

    fun getMessages(userId: Int, count: Int): List<Message> {
        val chat = chats[userId] ?: throw ChatNotFoundException()
        return chat.messages.takeLast(count).onEach { it.readMessage = true }
    }

    fun getLastMessages() =
        chats.values.map { chat -> chat.messages.lastOrNull()?.text ?: "Bro, you haven't any messages" }

    fun addMessage(userId: Int, message: Message) {
        chats.getOrPut(userId) { Chat() }.messages.add(message)
    }
    /*    if (chats.containsKey(userId)) {
            chats[userId]?.messages?.add(message)
        } else {
            val chat = Chat()
            chat.messages.add(message)
            chats[userId] = chat
        }
    }
    */

    fun deleteMessage(userId: Int, message: Message) {
        messages.remove(userId)
    }

    fun createChats(userId: Int): List <Chat> {
        chats.getOrPut(userId) {Chat()}.messages.add(message, text)
    }

    fun deleteChat(userId: Int, chat: Chat) {
        chats.remove(userId)
    }
}