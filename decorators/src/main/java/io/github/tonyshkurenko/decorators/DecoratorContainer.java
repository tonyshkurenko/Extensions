package io.github.tonyshkurenko.decorators;

/**
 * Created by: Anton Shkurenko (anthonyshkurenko)
 * Project: DecoratorTest
 * Date: 8/17/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Base interface for holding decorators
 */
public interface DecoratorContainer {

  void addDecorator(Decorator decorator);
}