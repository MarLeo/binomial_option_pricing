package org.option.api.model;

import org.option.api.enums.ExerciseType;
import org.option.api.enums.OptionType;
import org.option.api.option.Option;

/**
 * Created by marti on 24/02/2017.
 */
public class European extends Option {

    private Double[][] pay_off;

    public European(Double spot, Double strike, Double up, Double down, Double rate, Integer steps, OptionType type, ExerciseType exercise) {
        super(spot, strike, up, down, rate, steps, type, exercise);
    }


    public Double getPrice() {
        pay_off = new Double[getSteps()][getSteps()];
        pay_off = getPay_off();
        for (int j = getSteps() - 1; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                //pay_off[i][j] = (1/getRate()) * (getProb_up() * pay_off[i + 1][j + 1] + getProb_down() * pay_off[i][j + 1]);
                pay_off[i][j] = (1/getRate()) * (getProb_up() * pay_off[i][j + 1] + getProb_down() * pay_off[i + 1][j + 1]);
            }
        }
        setPay_off(pay_off);
        return getPremiun();
    }






}
