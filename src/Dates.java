import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Dates {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
//        System.out.println("Data e hora atual: " + c.getTime());
//        System.out.println("Ano: " + c.get(Calendar.YEAR));
//        System.out.println("Mes: " + c.get(Calendar.MONTH));
//        System.out.println("Date: " + c.get(Calendar.DATE));
//        System.out.println("Dia do mes: " + c.get(Calendar.DAY_OF_MONTH));
//        System.out.println("Dia da semana: " + c.get(Calendar.DAY_OF_WEEK));
//
//        System.out.println("Dia do ano: " + c.get(Calendar.DAY_OF_YEAR));
//        System.out.println("Dia da semana no mes: " + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//
//        System.out.println("Zone offset: " + c.get(Calendar.ZONE_OFFSET));
//        System.out.println("Semana no mes: " + c.get(Calendar.WEEK_OF_MONTH));
//        System.out.println("Semana no ano: " + c.get(Calendar.WEEK_OF_YEAR));
//
//        System.out.println("am pm: " + c.get(Calendar.AM_PM));
//        System.out.println("am: " + c.get(Calendar.AM));
//        System.out.println("pm: " + c.get(Calendar.PM));
//        System.out.println("april: " + c.get(Calendar.APRIL));


//        SetNewCalendarTime(c,1990, 16 );
//        msgBoasVindas(c,"Washington");
//        formatDate(c, 1990, 16);
//        convertDate(c);
//        toLocaleDate(c);
//        calcDaysBetweenDates(c);
//        playgrounding();

        converterIdadeDeAnosParaDias(25);
    }

    private static void converterIdadeDeAnosParaDias(int anosDeIdade) {
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime nascimento = hoje.minusYears(anosDeIdade);

        long daysBetween = ChronoUnit.DAYS.between(nascimento, hoje);
        System.out.println(daysBetween);
    }

    private static void playgrounding() {
//        LocalDateTime creation = LocalDateTime.MIN;

        LocalDateTime creation = LocalDateTime.now();
        System.out.println(creation.getChronology());
        System.out.println(creation.getYear());
        System.out.println(creation.getDayOfYear());
        System.out.println(creation.toLocalDate());
        System.out.println(creation.minusYears(2000));


        LocalDate dateBefore = LocalDate.of(2022, 2, 21);
        LocalDate dateAfter = LocalDate.of(2022, 4, 25);

        dateBefore.getYear();

    }

    private static void calcDaysBetweenDates(Calendar c) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date dateBefore;
        Date dateAfter;

        try {
            dateBefore = sdf.parse("04/21/1966");
            dateAfter = sdf.parse("04/25/2022");

            long dateBeforeInMs = dateBefore.getTime();
            long dateAfterInMs = dateAfter.getTime();

            long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);
            long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
            long teste = TimeUnit.MILLISECONDS.toDays(timeDiff);

            System.out.println(" The number of days between dates: " + daysDiff);
            System.out.println(" The number of days between dates: " + teste);


        } catch (Exception e) {
            System.out.println("Deu ruim");
        }
    }

    private static void toLocaleDate(Calendar c) {
        Date data = c.getTime();

        Locale brasil = new Locale("pt", "BR"); //Retorna do país e a língua
        Locale azerbaijão = new Locale("az", "AZ"); //Retorna do país e a língua
        Locale eua = Locale.US;
        Locale italia = Locale.ITALIAN;
        Locale alemanha = Locale.GERMAN;

        //https://docs.oracle.com/cd/E13214_01/wli/docs92/xref/xqisocodes.html

        DateFormat toPortuguese = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println("Data e hora brasileira: " + toPortuguese.format(data));

        DateFormat toEnglish = DateFormat.getDateInstance(DateFormat.FULL, eua);
        System.out.println("Data e hora americana: " + toEnglish.format(data));

        DateFormat toItalian = DateFormat.getDateInstance(DateFormat.FULL, italia);
        System.out.println("Data e hora italiana: " + toItalian.format(data));

        DateFormat toGermany = DateFormat.getDateInstance(DateFormat.FULL, alemanha);
        System.out.println("Data e hora alemã: " + toGermany.format(data));

        DateFormat toAzerbaijani = DateFormat.getDateInstance(DateFormat.FULL, azerbaijão);
        System.out.println("Data e hora Azerbaijã: " + toAzerbaijani.format(data));

    }

    private static void convertDate(Calendar c) {
        Date data = c.getTime();
        DateFormat f = DateFormat.getDateInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy :hh:mm:ss");
        System.out.println("Data formatada: " + sdf.format(data));

    }

    private static void formatDate(Calendar c, int year, int day) {
        c.set(year, Calendar.NOVEMBER, day);
        Date data = c.getTime();
        System.out.println("Data atual sem formatação: " + data);

        //Formata a data
        DateFormat formataData = DateFormat.getDateInstance();
        System.out.println("Data atual com formatação: " + formataData.format(data));

        //Formata Hora
        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("Hora formatada: " + hora.format(data));

        //Formata Data e Hora
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println(dtHora.format(data));

        // Data to full
        DateFormat full = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("to full: " + full.format(data));

        // Data to long
        DateFormat toLong = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("to Long: " + toLong.format(data));

        // Data to mid
        DateFormat toMid = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("to medium: " + toMid.format(data));

        // Data to short
        DateFormat toShort = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("to short: " + toShort.format(data));


    }

    private static void SetNewCalendarTime(Calendar c, int year, int day) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.NOVEMBER);
        c.set(Calendar.DAY_OF_MONTH, day);

        System.out.println("Data/Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
    }

    private static void msgBoasVindas(Calendar c, String name) {
        int hora = c.get(Calendar.HOUR_OF_DAY);

        if (hora > 6 && hora < 12) {
            System.out.println("Bom Dia " + name);
        } else if (hora > 12 && hora < 18) {
            System.out.println("Boa Tarde " + name);
        } else {
            System.out.println("Boa Noite " + name);
        }

    }
}
