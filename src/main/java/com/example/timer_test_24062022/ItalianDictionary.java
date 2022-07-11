package com.example.timer_test_24062022;

public class ItalianDictionary {

    private static ItalianDictionary instance = null;
    public static ItalianDictionary getInstance(){
        if (instance==null)
            instance = new ItalianDictionary();
        return instance;

    }


    /* ID */
    final String LANGUAGE_ID = "ITALIAN";


    /* activities */
    final String POMODORO = "Pomodoro";
    final String SHORT_BREAK = "Pausa Breve";
    final String LONG_BREAK = "Pausa Lunga";


    /* Alert */
    final String ASK_FOR_CONFIRM = "Sei sicuro di voler interrompere l'attività corrente?";
    final String CONFIRMATION = "Conferma";

    /* Buttons */
    final String START = "AVVIA";
    final String PAUSE = "PAUSA";

    /* Labels */
    final String TIME_TO_FOCUS = "E' ora di concentrarsi!";
    final String TIME_TO_BREAK = "E' tempo di prendersi una pausa!";

    /* Preference */
    final String PREFERENCES = "Preferenze";
    final String AUDIO = "Audio";
    final String SET_AUDIO = "Seleziona";
    final String FUNCTIONALS = "Avvia automaticamente";
    final String AUTORUN_POMODORO = "Pomodori";
    final String AUTORUN_BREAKS = "Pause";
    final String LANGUAGE = "Lingua";



    /* Report */
    final String REPORT = "Dati";
    final String REPORT_SECTION_TITLE = "Tempo di concentrazione e pausa";
    final String YOU_HAVE_FOCUSED_FOR = "Sei rimasto concentrato per";
    final String YOU_HAVE_RELAXED_FOR = "Ti sei riposato per";

    /* Measurement units */
    final String SECOND = "secondo";
    final String SECONDS = "secondi";

    final String MINUTE = "minuto";
    final String MINUTES = "minuti";

    final String HOUR = "ora";
    final String HOURS = "ore";

    /* Default */
    final String DEFAULT_STRING = "Predefinito";

    /* Audio */
    final String BELL_STRING = "Campanella";
    final String BIRD_STRING = "Uccellino";
    final String DIGITAL_STRING = "Digitale";

}
