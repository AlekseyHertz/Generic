import org.junit.Assert.*
import org.junit.Test
import org.junit.Before

class WallServiceTest {

    @Before
    fun refresh() {
        WallService.clear()
        WallService.addPosts(
            Post(
                id = 0,
                ownerId = 0,
                fromId = 0,
                date = 0,
                text = "",
                commentCount = Comment(
                    0,
                    true,
                    true,
                    ""
                ),
                likesCount = Likes(
                    5,
                    true
                )
            )
        )
        WallService.addComment(
            Post(
                id = 0,
                ownerId = 0,
                fromId = 0,
                date = 0,
                text = "",
                commentCount = Comment(
                    0,
                    true,
                    true,
                    ""
                ),
                likesCount = Likes(
                    5,
                    true
                )
            )
        )
    }

    @Test
    fun addPosts() {

        val newPost = Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            date = 0,
            text = "",
            commentCount = Comment(
                0,
                true,
                true,
                ""
            ),
            likesCount = Likes(
                5,
                true
            )
        )
        val result = newPost.id

        assertEquals(0, result)
    }

    @Test
    fun upDateIsTrue() {

        val newPost = Post(
            0,
            0,
            0,
            0,
            "",
            Comment(
                0,
                true,
                true,
                ""
            ),
            Likes(
                5,
                true
            )
        )
        val result = WallService.upDate(newPost)

        assertTrue(result)
    }

    @Test
    fun upDateIsFalse() {

        val newPost = Post(
            1,
            0,
            0,
            0,
            "",
            Comment(
                0,
                true,
                true,
                ""
            ),
            Likes(
                5,
                true
            )
        )
        val result = WallService.upDate(newPost)

        assertFalse(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.createComment(
            1000,
            comment = Comment(
                1,
                true,
                true,
                "cool"
            )
        )
    }

    @Test
    fun shouldNotThrow() {
        WallService.createComment(
            0,
            comment = Comment(
                0,
                true,
                true,
                "cool"
            )
        )
    }
}