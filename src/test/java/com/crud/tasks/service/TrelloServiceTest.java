package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {
    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Test
    public void testFetchTrelloBoards() throws Exception {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloLists.add(new TrelloList("11", "test list name", false));
        trelloBoards.add(new TrelloBoard("1", "test board name", trelloLists));
        trelloListDtos.add(new TrelloListDto("11", "test list name", false));
        trelloBoardDtos.add(new TrelloBoardDto("1", "test boardDTO name", trelloListDtos));

        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardDtos);
        when(adminConfig.getAdminMail()).thenReturn("przykladowy.email.admina@gmail.com");

        //When
        List<TrelloBoardDto> trelloBoardDtosTest = trelloService.fetchTrelloBoards();
        String name = trelloBoardDtosTest.get(0).getName();
        String adminEmail = adminConfig.getAdminMail();

        //Then
        assertEquals(name, "test boardDTO name");
        assertEquals(adminEmail, "przykladowy.email.admina@gmail.com");
    }

    @Test
    public void testCreateTrelloCard() throws Exception {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test name", "test description", "test pos", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "test name createdTrelloCardDto", "http://testy.com");

        when(trelloService.createTrelloCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto ctcd = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertEquals(ctcd.getName(), "test name createdTrelloCardDto");

    }

}