data class Likes(
    var countLike: Int, // число лайков
    val canLike: Boolean,// возможность "лайкать"
)

data class Comment(
    var countComment: Int, // количество комментарий
    val canCommentPost: Boolean, // возможность комментирования
    val canCommentOpen: Boolean, // возможность просмотра
    val textComment: String, //текст комментария
)



data class Message (
    val text: String,
    var readMessage: Boolean = false
)

data class Chat (
    val messages: MutableList <Message> = mutableListOf())
