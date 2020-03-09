/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t5e3;

import dam107t5e2.*;
import dam107t5e1.*;

/**
 *
 * @author dam107
 */
public class Temperaturas {
    public static float calcularFahrenheit(float temp){
        return ((temp*9f/5f)+32f);
    }
    public static float calcularCelsius(float temp){
    return ((temp-32)*5f/9f);
    }
}
