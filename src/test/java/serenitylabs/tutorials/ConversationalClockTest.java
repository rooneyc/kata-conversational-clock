package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    @TestWith({
            "00:00, it's midnight",
            "01:00, it's one o'clock",
            "02:00, it's two o'clock",
            "03:00, it's three o'clock",
            "04:00, it's four o'clock",
            "05:00, it's five o'clock",
            "06:00, it's six o'clock",
            "07:00, it's seven o'clock",
            "08:00, it's eight o'clock",
            "09:00, it's nine o'clock",
            "10:00, it's ten o'clock",
            "11:00, it's eleven o'clock",
            "12:00, it's noon",
            "13:00, it's one o'clock",
            "14:00, it's two o'clock",
            "15:00, it's three o'clock",
            "16:00, it's four o'clock",
            "17:00, it's five o'clock",
            "18:00, it's six o'clock",
            "19:00, it's seven o'clock",
            "20:00, it's eight o'clock",
            "21:00, it's nine o'clock",
            "22:00, it's ten o'clock",
            "23:00, it's eleven o'clock",
    })
    public void should_tell_the_time_on_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
    }

    @TestWith({
            "08:07, it's seven past eight",
            "17:53, it's fifty three past five",
    })
    public void should_tell_the_time_with_a_minute_precision(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
        System.out.println(clock.currentTime());
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

//        SystemTime systemTime = new SystemTime();

        SystemTime systemTime = mock(SystemTime.class);
        when(systemTime.hour()).thenReturn(time.hour());
        when(systemTime.minute()).thenReturn(time.minute());

        return new ConversationalClock(systemTime);
    }
}
