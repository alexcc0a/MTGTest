package org.example.mtgtests.catalog;

import org.example.mtgtests.catalog.models.Color;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class ColorTest {

    @Test
    void parse_shouldReturnCorrectColor_whenValidAbbreviation() {
        assertThat(Color.parse("G")).isEqualTo(Color.GREEN);
        assertThat(Color.parse("R")).isEqualTo(Color.RED);
        assertThat(Color.parse("U")).isEqualTo(Color.BLUE);
        assertThat(Color.parse("W")).isEqualTo(Color.WHITE);
    }

    @Test
    void parse_shouldReturnCorrectColor_whenValidFullName() {
        assertThat(Color.parse("GREEN")).isEqualTo(Color.GREEN);
        assertThat(Color.parse("RED")).isEqualTo(Color.RED);
        assertThat(Color.parse("BLUE")).isEqualTo(Color.BLUE);
        assertThat(Color.parse("WHITE")).isEqualTo(Color.WHITE);
    }

    @Test
    void parse_shouldThrowException_whenInvalidValue() {
        assertThatThrownBy(() -> Color.parse("X"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No Color matching X found.");
    }

    @Test
    void parse_shouldThrowException_whenNull() {
        assertThatThrownBy(() -> Color.parse(null))
                .isInstanceOf(NullPointerException.class);
    }
}
