object WallService {
    private var posts = emptyArray<Post>()
    private var comment = emptyArray<Comment>()
    private var lastId = 0

    fun createComment(postId: Int, comment: Comment) {
        val post = posts.find {it.id == postId }
        if (post != null) {
            addComment(post)
        } else {
            throw PostNotFoundException ("id not find")
        }
    }

    fun clear() {
        posts = emptyArray<Post>()
        comment = emptyArray<Comment>()
        lastId = 0
    }

    fun addPosts(post: Post): Post {
        posts += post.copy(id = lastId++)
        return posts.last()
    }

    fun upDate(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(likesCount = post.likesCount.copy())
                return true
            }
        }
        return false
    }

    fun addComment(post: Post): Comment {
        comment += post.commentCount!!.copy(countComment = lastId++)
        return comment.last()
    }

    fun printTextPost(newPost: Post) {
        for (post in posts)
            println(post.text)
    }

    fun printPost(newPost: Post) {
        for (post in posts)
            println(post)
    }
}