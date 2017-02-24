package org.option.api.option;

import org.option.api.enums.ExerciseType;
import org.option.api.enums.OptionType;

/**
 * Created by marti on 23/02/2017.
 */
public abstract class Option {
    private Double spot;
    private Double strike;
    private Double up;
    private Double down;
    private Double rate;
    private Double prob_up;
    private Double prob_down;
    private Integer steps;
    private OptionType type;
    private ExerciseType exercise;
    private Double[][] stock_price;
    private Double[][] pay_off;

    public Option(Double spot, Double strike, Double up, Double down, Double rate, Integer steps, OptionType type, ExerciseType exercise) {
        this.spot = spot;
        this.strike = strike;
        this.up = up;
        this.down = down;
        this.rate =  1 + (rate/100)/12;
        this.steps = steps;
        this.type = type;
        this.exercise = exercise;
        this.prob_up = (this.rate - this.down) / (this.up - this.down);
        this.prob_down = 1 - this.prob_up;
        stock_price = new Double[this.steps + 1][this.steps + 1];
        pay_off = new Double[this.steps + 1][this.steps + 1];
    }


    public Double getSpot() {
        return spot;
    }

    public void setSpot(Double spot) {
        this.spot = spot;
    }

    public Double getStrike() {
        return strike;
    }

    public void setStrike(Double strike) {
        this.strike = strike;
    }

    public Double getUp() {
        return up;
    }

    public void setUp(Double up) {
        this.up = up;
    }

    public Double getDown() {
        return down;
    }

    public void setDown(Double down) {
        this.down = down;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getProb_up() {
        return prob_up;
    }

    public void setProb_up(Double prob_up) {
        this.prob_up = prob_up;
    }

    public Double getProb_down() {
        return prob_down;
    }

    public void setProb_down(Double prob_down) {
        this.prob_down = prob_down;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public String getType() {
        return type.getType();
    }

    public void setType(OptionType type) {
        this.type = type;
    }

    public String getExercise() {
        return exercise.getExercise();
    }

    public void setExercise(ExerciseType exercise) {
        this.exercise = exercise;
    }

    public Double[][] getStock_price() {
/*
        for (int i = 0; i <= steps; i++) {
            for (int j = 0; j <= i; j++) {
                stock_price[i][j] = spot * Math.pow(up, i - j) * Math.pow(down, j);
            }
        }
        return stock_price;
    }
       */
        for (int j = 0; j <= steps; j ++) {
            for (int i = 0; i <= j; i++){
                stock_price[i][j] = spot * Math.pow(up, j-i) * Math.pow(down, i);
            }
        }
        return stock_price;
    }


    public void setStock_price(Double[][] stock_price) {
        this.stock_price = stock_price;
    }

    public Double[][] getPay_off() {
        for (int i = 0; i <= steps; i++) {
            if(type.equals(OptionType.CALL)) {
                pay_off[i][steps] = Math.max(this.getStock_price()[i][steps] - strike, 0.0);
            }
            else pay_off[i][steps] = Math.max(strike - this.getStock_price()[i][steps], 0.0);
        }
        return pay_off;
    }

    public Double getPremiun() {
        return pay_off[0][0];
    }

    public void setPay_off(Double[][] pay_off) {
        this.pay_off = pay_off;
    }
}
