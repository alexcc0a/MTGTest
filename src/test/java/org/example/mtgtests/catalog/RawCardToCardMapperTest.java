package org.example.mtgtests.catalog;

import org.example.mtgtests.catalog.mappers.RawCardToCardMapper;
import org.example.mtgtests.catalog.models.Card;
import org.example.mtgtests.catalog.models.Color;
import org.example.mtgtests.client.models.RawCard;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RawCardToCardMapperTest {

    private final RawCardToCardMapper mapper = new RawCardToCardMapper();

    @Test
    void convert_ShouldMapNameCorrectly() {
        RawCard rawCard = mock(RawCard.class);
        when(rawCard.name()).thenReturn("Black Lotus");
        when(rawCard.colorIdentity()).thenReturn(Set.of());
        when(rawCard.cmc()).thenReturn(0.0);

        Card card = mapper.convert(rawCard);

        assertNotNull(card);
        assertEquals("Black Lotus", card.name());
    }

    @Test
    void convert_ShouldMapColorIdentityCorrectly() {
        RawCard rawCard = mock(RawCard.class);
        when(rawCard.name()).thenReturn("Island");
        when(rawCard.colorIdentity()).thenReturn(Set.of("U"));
        when(rawCard.cmc()).thenReturn(0.0);

        Card card = mapper.convert(rawCard);

        assertNotNull(card);
        assertEquals(Set.of(Color.parse("U")), card.colorIdentity());
    }

    @Test
    void convert_ShouldMapConvertedManaCostCorrectly() {
        RawCard rawCard = mock(RawCard.class);
        when(rawCard.name()).thenReturn("Lightning Bolt");
        when(rawCard.colorIdentity()).thenReturn(Set.of("R"));
        when(rawCard.cmc()).thenReturn(1.0);

        Card card = mapper.convert(rawCard);

        assertNotNull(card);
        assertEquals(1, card.convertedManaCost());
    }
}
