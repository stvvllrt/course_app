package ru.stvvllrt.course_app.domain.appdetails

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAppDetailsUseCaseTest {

    private val repository = mockk<AppDetailsRepository>()
    private val useCase = GetAppDetailsUseCase(repository)

    @Test
    fun invoke_returns_app_details_from_repository() {
        runBlocking {
            val appDetails = AppDetails(
                id = "1", name = "App", developer = "Dev", category = "Cat",
                ageRating = 3, size = 10f, iconUrl = "url", screenshotUrlList = null,
                description = "Desc", isInWishlist = false
            )
            coEvery { repository.getAppDetails("1") } returns appDetails

            val result = useCase("1")

            assertEquals(appDetails, result)
            coVerify(exactly = 1) { repository.getAppDetails("1") }
        }
    }

    @Test
    fun observeAppDetails_returns_flow_from_repository() {
        runBlocking {
            val appDetails = AppDetails(
                id = "1", name = "App", developer = "Dev", category = "Cat",
                ageRating = 3, size = 10f, iconUrl = "url", screenshotUrlList = null,
                description = "Desc", isInWishlist = false
            )
            val flow = flowOf(appDetails)
            every { repository.observeAppDetails("1") } returns flow

            val result = useCase.observeAppDetails("1")

            result.collect {
                assertEquals(appDetails, it)
            }
            coVerify(exactly = 1) { repository.observeAppDetails("1") }
        }
    }

    @Test
    fun toggleWishlist_calls_repository() {
        runBlocking {
            coEvery { repository.toggleWishlist("1") } returns Unit

            useCase.toggleWishlist("1")

            coVerify(exactly = 1) { repository.toggleWishlist("1") }
        }
    }

    @Test
    fun invoke_handles_repository_exceptions() {
        runBlocking {
            coEvery { repository.getAppDetails(any()) } throws RuntimeException("Error")

            try {
                useCase("1")
            } catch (e: Exception) {
                assertEquals("Error", e.message)
            }
        }
    }

    @Test
    fun toggleWishlist_handles_repository_exceptions() {
        runBlocking {
            coEvery { repository.toggleWishlist(any()) } throws IllegalStateException("Failed")

            try {
                useCase.toggleWishlist("1")
            } catch (e: Exception) {
                assertEquals("Failed", e.message)
            }
        }
    }
}
