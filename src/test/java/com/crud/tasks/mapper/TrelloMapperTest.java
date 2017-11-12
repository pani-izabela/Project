package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
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
    }

    @Test
    public void testMapToList() throws Exception {
    }

    @Test
    public void testMapToListDto() throws Exception {
    }

    @Test
    public void testMapToCardDto() throws Exception {
    }

    @Test
    public void testMapToCard() throws Exception {
    }

}