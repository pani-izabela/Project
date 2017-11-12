package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTest {

    //@InjectMocks
    //private TrelloValidator trelloValidator;

    @Test
    public void testValidateCard() throws Exception {
        /*TrelloCard trelloCard = new TrelloCard("test name", "test description", "test pos", "1");

        TrelloValidator trelloValidator = new TrelloValidator();

        trelloValidator.validateCard(trelloCard);

        verify(trelloValidator, times(1)).validateCard(trelloCard);*/
    }

    @Test
    public void testValidateTrelloBoards() throws Exception {
        /*Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("11", "test list name", false));
        trelloBoards.add(new TrelloBoard("1", "test board name", trelloLists));

        TrelloValidator trelloValidator = new TrelloValidator();

        //When
        List<TrelloBoard> trelloBoardsTest = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(trelloBoardsTest.get(0).getId(), "1");*/
    }

}