private var attachment = emptyArray<Attachment>()

data class Post(
    var id: Int, // индентификатор записи
    val ownerId: Int, // идентификатор владельца стены
    val fromId: Int, // идентификатор владельца
    val date: Int, // дата
    val text: String?, // текст
    val commentCount: Comment?, // количество комментарий
    val likesCount: Likes, // число лайков
)

class videoAttachment( //  класс наследник от Видео
    videoId: Int, //идентификатор видеозаписи
    videoDuration: Int, //длительность видеозаписи
    videoTitle: Int, //название видеозаписи
    videoDate: Int, //дата создания видеозаписи
    videoViews: Int, //количество просмотров видеозаписи)
    val original: Attachment
) : Attachment(type = "video")

class audioAttachment(
    audioId: Int, //идентификатор аудиозаписи
    audioOwnerId: Int, //идентификатор владельца аудиозаписи
    audioArtist: String, //исполнитель аудиозаписи
    audioTitle: String, //название аудиозаписи
    audioDuration: Int, //дилтельность аудиозаписи
    val original: Attachment,
) : Attachment(type = "audio")

class photoAttachment(
    photoId: Int, //идентификатор фото
    photoAlbumId: Int, //идентификатор альбома фото
    photoOwnerId: Int, //идентификатор владельца фото
    photoText: String, //текст описания фото
    photoDate: Int, //дата фото
    val original: Attachment,
) : Attachment(type = "photo")

open class PostNotFoundException(message: String) : RuntimeException(message)

fun main() {
    val post =
        Post(
            0,
            0,
            0,
            0,
            " ",
            commentCount = Comment(
                0,
                true,
                true,
                "awesome"),
            likesCount = Likes(
                0,
                true))
    WallService.addPosts(
        Post(
            7,
            3,
            7,
            19_03_2023,
            " This wall is awsome",
            commentCount = Comment(
                0,
                true,
                true,
                "cool"
            ), likesCount = Likes(
                0,
                true
            )
        )
    )
    WallService.printTextPost(newPost = post)
    WallService.printPost(post)

    val audio = audioAttachment(
        2,
        2,
        "FatboySlim",
        "PushTempo",
        3,
        original = Attachment("audio")
    )

    val newComment = WallService.createComment(
        3,
        comment = Comment(
            2,
            true,
            true,
            "it was awesome"))
}