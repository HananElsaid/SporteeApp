package iti.intak41.sportee.datasource.repo

import iti.intak41.sportee.datasource.model.Sports
import iti.intak41.sportee.datasource.model.SportsResponse
import iti.intak41.sportee.datasource.remote.SportsService
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when`
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class SportsListRepoTest {
    lateinit var repo: SportsListRepo

    @Mock
    lateinit var sportsService: SportsService

    @Before
    fun setUp() {
        repo = SportsListRepo(sportsService)
    }

    @Test
    fun getSportsList_() {
        val srtThumb = "https://www.thesportsdb.com//images//sports//soccer.jpg"
        val strSportThumbGreen =
            "https://www.thesportsdb.com//images//sports//motorsport_green2.jpg"
        val strSportDescription =
            "Association football, more commonly known as football or soccer, is a team sport played between two teams of eleven players with a spherical ball. It is played by 250 million players in over 200 countries and dependencies, making it the world's most popular sport. The game is played on a rectangular field with a goal at each end. The object of the game is to score by getting the ball into the opposing goal.\r\n\r\nPlayers are not allowed to touch the ball with their hands or arms while it is in play, unless they are goalkeepers (and then only when within their penalty area). Other players mainly use their feet to strike or pass the ball, but may also use any part of their body except the hands and the arms. The team that scores the most goals by the end of the match wins. If the score is level at the end of the game, either a draw is declared or the game goes into extra time or a penalty shootout depending on the format of the competition. The Laws of the Game were originally codified in England by The Football Association in 1863. Association football is governed internationally by the International Federation of Association Football (FIFA; French: Fédération Internationale de Football Association), which organises World Cups for both men and women every four years."


        val sportsList = mutableListOf<Sports>()
        sportsList.add(
            Sports(102, "Soccer", "TeamvsTeam", srtThumb, strSportThumbGreen, strSportDescription)
        )
        val respo = SportsResponse(sportsList)

        runBlocking {
            `when`(sportsService.getSports()).thenReturn(Response.success(respo))
            val sportsList1 = repo.getSportsList()
            if (sportsList1.isSuccessful) {
                val body = sportsList1.body()?.sports
                assertEquals(sportsList[0], body?.get(0))
            }
            //assertNotNull(sportsList1)
        }


    }
}