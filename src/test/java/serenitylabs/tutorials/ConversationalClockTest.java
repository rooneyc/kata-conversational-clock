package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    @TestWith({
            "01:00, it's one o'clock",
            "02:00, it's two o'clock",
    })
    public void should_tell_the_time_on_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @TestWith({
            "00:00, it's midnight",
            "12:00, it's noon",
    })
    public void should_know_about_noon_and_midnight(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @TestWith({
            "08:07, it's seven minutes past eight",
            "18:28, it's twenty eight minutes past six",

    })
    public void should_tell_the_time_with_a_minute_precision(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @TestWith({
            "18:05, it's five past six",
            "15:10, it's ten past three",
    })
    public void should_tell_the_time_in_multiples_of_five(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @TestWith({
            "08:53, it's seven minutes to nine",
            "17:51, it's nine minutes to six",
            "20:55, it's five to nine"
    })
    public void should_tell_the_time_relative_to_the_hour_that_is_closer(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @TestWith({
            "03:15, it's a quarter past three",
            "14:30, it's half past two",
            "06:45, it's a quarter to seven",
    })
    public void should_know_about_quarter_and_half(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @TestWith({
            "13:58, it's almost two o'clock",
            "14:01, it's just after two o'clock",
    })
    public void if_within_5_minutes_of_hour_should_return_fuzzy_response(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @Test
    public void clock_should_not_be_frozen_in_time() throws Exception {

        //Given
        SystemTime systemTime = mock(SystemTime.class);
        ConversationalClock clock = new ConversationalClock(systemTime);

        //And
        given(systemTime.hour()).willReturn(12);
        given(systemTime.minute()).willReturn(13);
        //Then
        assertThat(clock.currentTime()).isEqualTo("it's thirteen minutes past noon");
        //And
        given(systemTime.hour()).willReturn(12);
        given(systemTime.minute()).willReturn(14);
        //Then
        assertThat(clock.currentTime()).isEqualTo("it's fourteen minutes past noon");
    }

    @Test
    public void should_speak_the_time_at_the_moment_asked_even_if_now_later() throws Exception {

        //Given
        SystemTime systemTime = mock(SystemTime.class);
        ConversationalClock clock = new ConversationalClock(systemTime);

        given(systemTime.hour()).willReturn(12);
        given(systemTime.minute()).willReturn(15, 16);

        //Then
        assertThat(clock.currentTime()).isEqualTo("it's a quarter past noon");
    }

    /**
     * Creates an instance of a ConversationalClock, set to a requiredTime
     *
     * @link https://github.com/piotrturski/zohhak/blob/master/Full-Guide.md
     *
     * @param requiredTime Time in the "HH:mm" format (for example "17:15") coming from the @TestWith
     * @return an instance of a ConversationalClock, set to a requiredTime
     */
    @Coercion
    public ConversationalClock clockSetTo(String requiredTime) {

        HourAndMinute time = new HourAndMinute(requiredTime);

        SystemTime systemTime = mock(SystemTime.class);
        when(systemTime.hour()).thenReturn(time.hour());
        when(systemTime.minute()).thenReturn(time.minute());

        return new ConversationalClock(systemTime);
    }
}
