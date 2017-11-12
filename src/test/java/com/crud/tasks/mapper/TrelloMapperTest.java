package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TrelloMapperTest {

    @Test
    public void testMapToBoards() throws Exception {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("11", "test list name", false));
        trelloBoardDto.add(new TrelloBoardDto("1", "test board name", trelloListDtos));

        TrelloMapper trelloMapper = new TrelloMapper();

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDto);
        String trelloBoardsId = trelloBoards.get(0).getId();
        boolean listsBoardIsClosed = trelloBoards.get(0).getLists().get(0).isClosed();

        //Then
        assertEquals(trelloBoardsId, "1");
        assertFalse(listsBoardIsClosed);
        assertEquals(trelloBoards.size(), 1);
    }

    @Test
    public void testMapToBoardsDto() throws Exception {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("11", "test list name", false));
        trelloBoard.add(new TrelloBoard("1", "test board name", trelloLists));

        TrelloMapper trelloMapper = new TrelloMapper();

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoard);
        String trelloBoardsName = trelloBoardDtos.get(0).getName();

        //Then
        assertEquals(trelloBoardsName, "test board name");
        assertEquals(trelloBoardDtos.size(), 1);

    }

    @Test
    public void testMapToList() throws Exception {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("11", "test list name", false));

        TrelloMapper trelloMapper = new TrelloMapper();

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);
        boolean isClosed = trelloLists.get(0).isClosed();

        //Then
        assertEquals(trelloLists.size(), 1);
        assertFalse(isClosed);
    }

    @Test
    public void testMapToListDto() throws Exception {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("11", "test list name", false));

        TrelloMapper trelloMapper = new TrelloMapper();

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        String listId = trelloListDtos.get(0).getId();

        //Then
        assertEquals(trelloListDtos.size(), 1);
        assertEquals(listId, "11");

    }

    @Test
    public void testMapToCardDto() throws Exception {
        //Given
        TrelloCard trelloCard = new TrelloCard("test name", "test description", "test pos", "1");
        TrelloMapper trelloMapper = new TrelloMapper();

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCardDto.getDescription(), "test description");


    }

    @Test
    public void testMapToCard() throws Exception {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test name", "test description", "test pos", "1");
        TrelloMapper trelloMapper = new TrelloMapper();

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCard.getListId(), "1");

    }

}