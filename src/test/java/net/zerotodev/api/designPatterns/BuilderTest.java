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
import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
public class BuilderTest {
    @Test @DisplayName("Builder Pattern Example")
    void main(){
        MobileBuilder builder = new MobileBuilder();
        Mobile myMobile = builder.with(myBuilder -> {
            myBuilder.ram = 4;
            myBuilder.battery = 4000;
            myBuilder.processor = "A12 Bionic";
        }).createMobile();
        assertThat(myMobile.getRam(), is(4));
        assertThat(myMobile.getBattery(), is(4000));
        assertThat(myMobile.getProcessor(), is(equalTo("A12 Bionic")));
    }
    @Data @AllArgsConstructor
    class Mobile{
        private final int ram;
        private final int storage;
        private final int battery;
        private final int camera;
        private final String processor;
        private final double screenSize;


        public Mobile(MobileBuilder builder) {
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.battery = builder.battery;
            this.camera = builder.camera;
            this.processor = builder.processor;
            this.screenSize = builder.screenSize;
        }

    }

    @Data class MobileBuilder{
        private int ram;
        private int storage;
        private int battery;
        private int camera;
        private String processor;
        private double screenSize;

        public MobileBuilder with(Consumer<MobileBuilder> builderField) {
            builderField.accept(this);
            return this;
        }
        public Mobile createMobile(){return new Mobile(this);}
    }
}

