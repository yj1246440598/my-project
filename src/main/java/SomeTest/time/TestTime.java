package SomeTest.time;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.zone.ZoneRules;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class TestTime {
    static {
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
//                    System.out.println("exit");
                })
        );
    }

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        ZoneId of = ZoneId.of("America/Argentina/Buenos_Aires");
        System.out.println(of);
        System.out.println(TimeZone.getDefault().getID());
        System.out.println(zoneId.getDisplayName(TextStyle.FULL_STANDALONE, Locale.CHINA));
        System.out.println(of.getDisplayName(TextStyle.FULL_STANDALONE, Locale.CHINA));
        ZoneId of1 = ZoneId.of("+8");
        System.out.println(of1);
        ZoneId r = of.normalized();
        System.out.println(r);
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(r);
        OffsetDateTime offsetDateTime = now.atOffset(zonedDateTime.getOffset());
        System.out.println(now);
        System.out.println(zonedDateTime);
        System.out.println(offsetDateTime);
        System.out.println("==========================");

        ZoneOffset of2 = ZoneOffset.of("+9");
        System.out.println(of2);
        ZoneOffset zoneOffset = ZoneOffset.ofHours(10);
        System.out.println(zoneOffset);
        int totalSeconds = zoneOffset.getTotalSeconds();
        System.out.println(totalSeconds);
        String displayName = zoneOffset.getDisplayName(TextStyle.NARROW, Locale.CHINA);
        System.out.println(displayName);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        System.out.println(zonedDateTime1);


        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDate.of(2024, 10, 15), LocalTime.of(15, 20, 49), ZoneId.of("America/Argentina/Buenos_Aires"));
        System.out.println(zonedDateTime2);
        String format = zonedDateTime2.format(DateTimeFormatter.ISO_TIME);
        System.out.println(format);


        Clock clock = Clock.systemUTC();
        System.out.println(clock);
        System.out.println(clock.millis());
        System.out.println(clock.instant());
        System.out.println(clock.getZone());
        Clock system = Clock.system(ZoneId.of("America/Argentina/Buenos_Aires"));
        System.out.println(system);
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println(clock1);
        Clock fixed = Clock.fixed(Instant.now(), ZoneId.of("America/Argentina/Buenos_Aires"));
        System.out.println(fixed);
        Clock clock2 = Clock.tickMinutes(ZoneId.of("America/Argentina/Buenos_Aires"));
        System.out.println(clock2);

        Duration duration = Duration.ofHours(1);
        System.out.println(duration);
        long seconds = duration.getSeconds();
        System.out.println(seconds);
        Duration duration1 = duration.plusDays(2);
        System.out.println(duration1);
        boolean zero = duration1.isZero();
        System.out.println(zero);

        Period period = Period.ofDays(12);
        System.out.println(period.toString());
        Period of3 = Period.of(2024, 11, 2);
        System.out.println(of3);

        Month of4 = Month.of(12);
        System.out.println(of4);

        YearMonth of5 = YearMonth.of(2024, of4);
        System.out.println(of5);

        DayOfWeek of6 = DayOfWeek.of(4);
        System.out.println(of6);

        OffsetTime now1 = OffsetTime.now(ZoneId.systemDefault());
        System.out.println(now1);

        ZoneRules of7 = ZoneRules.of(ZoneOffset.UTC);
        System.out.println(of7);

        Period of8 = Period.of(1999, 3, 29);
        Period between = Period.between(LocalDate.of(1999, 3, 29), LocalDate.now());
        System.out.println(of8);
        System.out.println(between.getYears() + "年" + between.getMonths() + "月" + between.getDays() + "日");

        System.out.println(12);
        String displayName1 = Locale.CHINA.getDisplayName();
        System.out.println(displayName1);
        System.out.println(Locale.getDefault());

        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i = 0; i < availableLocales.length; i++) {
            System.out.println(availableLocales[i].getDisplayName());
        }

        Timestamp timestamp = Timestamp.from(Instant.now(Clock.system(ZoneId.of("Asia/Aden"))));
        System.out.println(timestamp.getTime());

        ZonedDateTime of9 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Aden"));
        System.out.println(of9);

        ZonedDateTime parse = ZonedDateTime.parse("2024-11-26T10:17:16.517+03:00[Asia/Shanghai]");
        System.out.println(parse.getZone());
        System.out.println(parse.getOffset());
        System.out.println(parse.getMonth());
        ZonedDateTime zonedDateTime3 = parse.plusHours(1);
        System.out.println(zonedDateTime3);

        System.out.println(-Integer.MAX_VALUE);
        System.out.println(~-Integer.MAX_VALUE);
        // 0 111 1111 1111 1111 1111 1111 1111 1111
        // 0 000 0000 0000 0000 0000 0000 0000 0000
        // 0 000 0000 0000 0000 0000 0000 0000 0001
        // 0 000 0000 0000 0000 0000 0000 0011 0011

        // 0 000 0000 0000 0000 0000 0000 0011 0100
        // 0 111 1111 1111 1111 1111 1111 1100 1011

        // 0 111 1111 1111 1111 1111 1111 1100 1101
        // 0 000 0000 0000 0000 0000 0000 0011 0011

        System.out.println(-(Integer.MAX_VALUE + 50));
        System.out.println(-Integer.MAX_VALUE - 1);

        System.out.println(100120+95700+6000*2+8000);
        System.out.println(100120+95700+6000+9500*5);


//        byte b = Byte.MAX_VALUE;
//        for (int i = 0; i < 200; i++) {
//            System.out.println((byte) (b+i));
//        }
        int x = Integer.MAX_VALUE;
//        for (int i = 0; i < 200; i++) {
//            System.out.println((int)-(x+i));
//        }
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-x-1);
    }
}
