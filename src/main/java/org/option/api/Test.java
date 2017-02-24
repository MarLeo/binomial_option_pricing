package org.option.api;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.option.api.enums.ExerciseType;
import org.option.api.enums.OptionType;
import org.option.api.model.European;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by marti on 23/02/2017.
 */
public class Test {
    private static final Logger LOGGER = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        LOGGER.info ( String.format ( "Lauching %s at %s", Test.class.getSimpleName (), new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" ).format ( Calendar.getInstance ().getTime () ) ) );

        Date start = new Date();
        Date startTime = new Date ();
        European european = new European(100.0, 90.0, 1.10, 0.90, 4.0, 200, OptionType.CALL, ExerciseType.EUROPEAN);
        Double premiun = european.getPrice();
        Date end = new Date ();
        //System.out.println ( "Job ended: " + end );
        System.out.println(european.getExercise() + " " + european.getType() + ": " + premiun);
        System.out.println("Steps: " + european.getSteps());
        System.out.println ( "Elapsed Time: " + (end.getTime () - start.getTime ()) / 1000 + " seconds" );





    }




}
