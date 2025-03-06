package org.example.mtgtests.catalog;

import org.example.mtgtests.catalog.models.Card;
import org.example.mtgtests.catalog.models.Color;
import org.example.mtgtests.catalog.mtg.MTGCardCatalog;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CardMatcherTest {

    @Test
    public void testNameContainsFilter() {
        CardCriteria criteria = mock(CardCriteria.class);
        when(criteria.nameContains()).thenReturn(Optional.of("Dragon"));
        when(criteria.colorIdentity()).thenReturn(Optional.empty());

        Card card = mock(Card.class);
        when(card.name()).thenReturn("Fire Dragon");

        MTGCardCatalog.CardMatcher matcher = new MTGCardCatalog.CardMatcher(criteria);

        boolean result = matcher.test(card);

        assertTrue(result, "Card name should match the 'nameContains' filter.");
    }

    @Test
    public void testColorIdentityFilter() {
        CardCriteria criteria = mock(CardCriteria.class);
        Set<Color> colors = Set.of(Color.RED, Color.GREEN);
        when(criteria.nameContains()).thenReturn(Optional.empty());
        when(criteria.colorIdentity()).thenReturn(Optional.of(colors));

        Card card = mock(Card.class);
        when(card.colorIdentity()).thenReturn(Set.of(Color.RED, Color.GREEN));

        MTGCardCatalog.CardMatcher matcher = new MTGCardCatalog.CardMatcher(criteria);

        boolean result = matcher.test(card);

        assertTrue(result, "Card should match the 'colorIdentity' filter.");
    }

    @Test
    public void testExclusiveMatchTrue() {
        CardCriteria criteria = mock(CardCriteria.class);
        Set<Color> colors = Set.of(Color.RED);
        when(criteria.nameContains()).thenReturn(Optional.of("Dragon"));
        when(criteria.colorIdentity()).thenReturn(Optional.of(colors));

        when(criteria.exclusiveMatch()).thenReturn(true);

        Card card = mock(Card.class);
        when(card.name()).thenReturn("Fire Dragon");
        when(card.colorIdentity()).thenReturn(Set.of(Color.RED));

        MTGCardCatalog.CardMatcher matcher = new MTGCardCatalog.CardMatcher(criteria);

        boolean result = matcher.test(card);

        assertTrue(result, "Card should match both 'nameContains' and 'colorIdentity' filters with exclusiveMatch true.");
    }

    @Test
    public void testExclusiveMatchFalse() {
        CardCriteria criteria = mock(CardCriteria.class);
        Set<Color> colors = Set.of(Color.RED);
        when(criteria.nameContains()).thenReturn(Optional.of("Dragon"));
        when(criteria.colorIdentity()).thenReturn(Optional.of(colors));

        when(criteria.exclusiveMatch()).thenReturn(false);

        Card card = mock(Card.class);
        when(card.name()).thenReturn("Fire Dragon");
        when(card.colorIdentity()).thenReturn(Set.of(Color.RED));

        MTGCardCatalog.CardMatcher matcher = new MTGCardCatalog.CardMatcher(criteria);

        boolean result = matcher.test(card);

        assertTrue(result, "Card should match either 'nameContains' or 'colorIdentity' filter with exclusiveMatch false.");
    }
}