package org.graceliying.snippets.effectivejava;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates the use of static factory methods instead of constructors, as per
 * Item 1 of "Effective Java" by Joshua Bloch.
 * <p>
 * Key advantages of using static factory methods:
 * <ul>
 *     <li><b>Better naming flexibility:</b> Unlike constructors, static factory methods can have descriptive names
 *     that convey the purpose or behavior of the method, making code easier to read and understand.</li>
 *     <li><b>Controlled instance creation:</b> Static factory methods can return existing instances
 *     (e.g., cached objects) instead of always creating new ones. This improves performance by avoiding unnecessary
 *     object creation.</li>
 *     <li><b>Enhanced encapsulation:</b> The instantiation logic can be hidden from the client code, allowing
 *     greater flexibility to modify internal implementation without affecting the API.</li>
 *     <li><b>Return subtype instances:</b> Static factory methods are not limited to returning instances of the class
 *     they are defined in. They can return objects of a subtype, enabling polymorphism and flexibility.</li>
 * </ul>
 */
public class StaticFactoryExample {

    /**
     * Represents a color with a name.
     * <p>
     * The {@code Color} class demonstrates the use of static factory methods for object creation.
     * <ul>
     *     <li>The {@link #fromPredefined(String)} method returns predefined colors like "red" or "blue".</li>
     *     <li>The {@link #custom(String)} method allows clients to create colors with custom names.</li>
     *     <li>Instances of the {@code Color} class cannot be created directly using the {@code new} keyword
     *     because the constructor is private. This enforces the use of static factory methods.</li>
     * </ul>
     */
    public static class Color {
        private final String name;

        // Private constructor to restrict instantiation
        private Color(String name) {
            this.name = name;
        }

        // Predefined instances of common colors
        private static final Map<String, Color> predefinedColors;

        static {
            Map<String, Color> map = new HashMap<>();
            map.put("red", new Color("red"));
            map.put("blue", new Color("blue"));
            map.put("green", new Color("green"));
            predefinedColors = Collections.unmodifiableMap(map);
        }

        /**
         * Returns a predefined {@code Color} instance based on the given name.
         * <p>
         * This method demonstrates the use of a static factory method to return
         * a shared, immutable instance of a predefined color.
         * <ul>
         *     <li>If the name matches a predefined color (e.g., "red"), the corresponding {@code Color} instance is returned.</li>
         *     <li>If no match is found, {@code null} is returned.</li>
         * </ul>
         *
         * @param name the name of the color (case-insensitive, e.g., "red", "blue", "green")
         * @return the predefined {@code Color} instance, or {@code null} if no such color exists
         */
        public static Color fromPredefined(String name) {
            return predefinedColors.get(name.toLowerCase());
        }

        /**
         * Creates a new {@code Color} instance with a custom name.
         * <p>
         * This method demonstrates how static factory methods can provide flexibility by allowing
         * creation of objects with custom properties.
         *
         * @param name the name of the custom color
         * @return a new {@code Color} instance with the specified name
         */
        public static Color custom(String name) {
            return new Color(name);
        }

        @Override
        public String toString() {
            return "Color{" +
                "name='" + name + '\'' +
                '}';
        }
    }

    /**
     * The main method demonstrates the use of static factory methods.
     * <p>
     * Examples covered:
     * <ul>
     *     <li>Fetching a predefined color using the {@link Color#fromPredefined(String)} method.</li>
     *     <li>Creating a custom color using the {@link Color#custom(String)} method.</li>
     *     <li>Attempting to fetch a nonexistent predefined color, which returns {@code null}.</li>
     * </ul>
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Using a predefined static factory method
        Color red = Color.fromPredefined("red");
        assert red != null : "Predefined color should not be null";
        System.out.println("Predefined color: " + red);

        // Creating a custom color using a static factory method
        Color magenta = Color.custom("magenta");
        assert magenta != null : "Custom color should not be null";
        System.out.println("Custom color: " + magenta);

        // Trying to fetch a nonexistent predefined color
        Color yellow = Color.fromPredefined("yellow");
        assert yellow == null : "Predefined color should be null if not available";
        System.out.println("Nonexistent predefined color: " + yellow);
    }
}
