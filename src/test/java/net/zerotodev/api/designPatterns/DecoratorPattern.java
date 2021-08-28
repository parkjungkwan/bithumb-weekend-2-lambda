package net.zerotodev.api.designPatterns;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
public class DecoratorPattern {
    @Test @DisplayName("Decorator Pattern Example")
    void main(){
        Burger myOrder = new BurgerShop(burger -> burger.addCheese())
                .use(new BurgerShop(burger -> burger.addVeggies()).use(new Burger()));
        System.out.println("I eat "+ myOrder);
    }
    class Burger{
        private String burgerType;

        public Burger() {
            this.burgerType = "";
        }
        private Burger(String type){this.burgerType = type;}
        public Burger addVeggies() {
            System.out.println("Adding vegies to the burger");
            return new Burger(this.burgerType += " Veggie");
        }
        public Burger addCheese() {
            System.out.println("Adding cheese to the burger");
            return new Burger(this.burgerType += " Cheese");
        }
        public String toString() {
            return String.format("%s", burgerType + " burger");
        }
    }
    class BurgerShop{
        Function<Burger, Burger> decoration;
        BurgerShop(Function<Burger, Burger> decoration){this.decoration = decoration;}
        Burger use(Burger baseBurger){
            System.out.println("Base Burger : "+ baseBurger);
            return decoration.apply(baseBurger);
        }
    }
}
